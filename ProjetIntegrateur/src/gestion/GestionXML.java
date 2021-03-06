package gestion;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import logiqueCircuit.*;
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Permet de gérer la construction et le décodage des fichiers XML selon les spécifications du projet
 */
public class GestionXML {
    
    private Element root;
    
    private static volatile GestionXML instance = null;
    
    private GestionXML() {
        super();
    }
    
    /**
     * Permet de générer un fichier XML représentant un circuit électrique sous la forme d'un fichier .circuit.
     * @param c Circuit à encoder
     * @param endroit Emplacement du fichier à créer
     */
    public void encoder(Circuit c, String endroit){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuild = docFactory.newDocumentBuilder();
            
            Document doc = docBuild.newDocument();
            root = doc.createElement("circuit");
            
            root.setAttribute("AMPERE", Double.toString(c.getAmpere()));
            root.setAttribute("VOLTAGE", Double.toString(c.getVoltage()));
            
            doc.appendChild(root);
            
            setComp(root, c, doc);
            
            Element composante = doc.createElement("COMPOSANTE");
            
            for(Composante comp : c.getComposantes()) {
                Element elem = doc.createElement(comp.getType().toString());
                if(comp.getType() == Type.PARALLELE) {
                    setComp(elem, comp, doc);
                    encoderPara((Parallele)comp, doc, elem);
                } else {
                    setComp(elem, comp, doc);
                }
                
                composante.appendChild(elem);
            }
            
            root.appendChild(composante);
            
            TransformerFactory transFactory = TransformerFactory.newInstance();
            Transformer aTransformer = transFactory.newTransformer();
            
            Source src = new DOMSource(doc);
            Result dest = new StreamResult(new File(endroit + ".circuit"));
            
            aTransformer.transform(src, dest);
        } catch (ParserConfigurationException | TransformerException ex) {
            Logger.getLogger(GestionXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void encoderPara(Parallele p, Document doc, Element elem) {
        int x = 1;
        
        Element elemComp = doc.createElement("COMPOSANTE");
        elem.appendChild(elemComp);
        
        for(Composante comp : p.getComposantes()) {
            encoderSerie((Serie)comp, doc, elemComp, x);
            x++;
        }
    }
    
    private void encoderSerie(Serie s, Document doc, Element elem, int branche) {
        Element elemBranche = doc.createElement("BRANCHE");
        elem.appendChild(elemBranche);
        elemBranche.setAttribute("NUMERO", Integer.toString(branche));
        
        setComp(elemBranche, s, doc);
        
        Element elemComp = doc.createElement("COMPOSANTE");
        elemBranche.appendChild(elemComp);
        
        for(Composante comp : s.getComposantes()) {
            Element elemCompLocal = doc.createElement(comp.getType().toString());
            if(comp.getType() == Type.PARALLELE) {
                setComp(elemCompLocal, comp, doc);
                encoderPara((Parallele) comp, doc, elemCompLocal);
            } else {
                setComp(elemCompLocal,comp,doc);
            }
            elemComp.appendChild(elemCompLocal);
        }
    }
    
    private static void setComp(Element elem, Composante comp, Document doc) {
        elem.appendChild(element("ID", ""+comp.getNumero(), doc));
        elem.appendChild(element("VALEUR", ""+comp.getResistanceEquivalente(), doc));
    }
    
    private static Element element(String type, String info, Document doc) {
        Element _info = doc.createElement(type);
        _info.appendChild(doc.createTextNode(info));
        return _info;
    }
    
    /**
     * Permet de décoder un fichier XML sous la forme d'un .circuit, représentant un circuit électrique
     * @param endroit Emplacement du fichier à décoder
     * @return Circuit
     */
    public Circuit decoder(String endroit){
        try {
            Circuit c = new Circuit();
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(endroit));
            
            Element rootTest = doc.getDocumentElement();
            
            c.setAmpere(Double.parseDouble(rootTest.getAttribute("AMPERE")));
            c.modifier(Double.parseDouble(rootTest.getAttribute("VOLTAGE")));
            
            NodeList elemComp = rootTest.getElementsByTagName("COMPOSANTE");
            
            elemComp.getLength();
            
            Element comp = (Element)elemComp.item(0);
            
            NodeList para = comp.getElementsByTagName("PARALLELE");
            NodeList resis = comp.getElementsByTagName("RESISTANCE");
            
            for(int i = 0; i < para.getLength(); i++) {
                if(para.item(i).getParentNode().equals(comp))
                    c.ajouterComposante(ajouterParallele(((Element)para.item(i))));
            }
            for(int i = 0; i < resis.getLength(); i++) {
                if(resis.item(i).getParentNode().equals(comp))
                    c.ajouterComposante(ajouterComp((Element)resis.item(i)));
            }
            
            
            return c;
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(GestionXML.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private Composante ajouterComp(Element n) {
        
        Composante comp;
        
        switch(n.getNodeName()) {
            case "RESISTANCE" :
                double resistanceEqui = Double.parseDouble(getInfo("VALEUR", n));
                int ID = Integer.valueOf(getInfo("ID", n));
                
                comp = new Resistance(resistanceEqui, ID);
                return comp;
            case "BRANCHE" :
                int IDBranche = Integer.valueOf(getInfo("ID", n));
                
                comp = new Serie(IDBranche);
                
                NodeList element = n.getElementsByTagName("COMPOSANTE");
                Element elemtemp = (Element) element.item(0);

                NodeList para = elemtemp.getElementsByTagName("PARALLELE");
                NodeList resis = elemtemp.getElementsByTagName("RESISTANCE");
                
                for(int i = 0; i < para.getLength(); i++) {
                    if(para.item(i).getParentNode().equals(elemtemp))
                    ((Serie)comp).ajouterComposante(ajouterParallele((Element) element.item(i)));
                }
                for(int i = 0; i < resis.getLength(); i++) {
                    if(resis.item(i).getParentNode().equals(elemtemp))
                    ((Serie)comp).ajouterComposante(ajouterComp((Element)resis.item(i)));
                }
                
                return comp;
            default :
                return null;
        }
    }
    
    private Composante ajouterParallele(Element n) {
        Parallele para = new Parallele(Integer.parseInt(((Element)n.getElementsByTagName("ID").item(0)).getFirstChild().getNodeValue()));
        
        NodeList elemTemp = n.getElementsByTagName("COMPOSANTE");
        Element element = (Element)elemTemp.item(0);
        NodeList branches = element.getElementsByTagName("BRANCHE");
        
        for(int i = 0; i < branches.getLength(); i++) {
            if(branches.item(i).getParentNode().equals(element))
            para.ajouterComposante(ajouterComp((Element)branches.item(i)));
        }
        
        return para;
    }
    
    private String getInfo(String info, Element n) throws DOMException{
        NodeList infoX = n.getElementsByTagName(info);
        
        if(infoX.getLength() != 0) {
            return infoX.item(0).getFirstChild().getNodeValue();
        } else {
            return null;
        }
    }
    
    /**
     *
     * @return
     */
    public static final GestionXML getInstance() {
        if(instance == null) {
            synchronized(GestionXML.class) {
                if(instance == null) {
                    instance = new GestionXML();
                }
            }
        }
        return instance;
    }
}
