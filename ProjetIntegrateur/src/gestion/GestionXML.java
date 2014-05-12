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
     * @param c I1l à encoder
     * @param endroit Emplacement du fichier à créer
     */
    public void encoder(I1l c, String endroit){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuild = docFactory.newDocumentBuilder();
            
            Document doc = docBuild.newDocument();
            root = doc.createElement("circuit");
            
            root.setAttribute("AMPERE", Double.toString(c.l()));
            root.setAttribute("VOLTAGE", Double.toString(c.il()));
            
            doc.appendChild(root);
            
            setComp(root, c, doc);
            
            Element composante = doc.createElement("COMPOSANTE");
            
            for(I comp : c.lI()) {
                Element elem = doc.createElement(comp.II().toString());
                if(comp.II() == Type.PARALLELE) {
                    setComp(elem, comp, doc);
                    encoderPara((Il)comp, doc, elem);
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
    
    private void encoderPara(Il p, Document doc, Element elem) {
        int x = 1;
        
        Element elemComp = doc.createElement("COMPOSANTE");
        elem.appendChild(elemComp);
        
        for(I comp : p.lI()) {
            encoderSerie((I1)comp, doc, elemComp, x);
            x++;
        }
    }
    
    private void encoderSerie(I1 s, Document doc, Element elem, int branche) {
        Element elemBranche = doc.createElement("BRANCHE");
        elem.appendChild(elemBranche);
        elemBranche.setAttribute("NUMERO", Integer.toString(branche));
        
        setComp(elemBranche, s, doc);
        
        Element elemComp = doc.createElement("COMPOSANTE");
        elemBranche.appendChild(elemComp);
        
        for(I comp : s.lI()) {
            Element elemCompLocal = doc.createElement(comp.II().toString());
            if(comp.II() == Type.PARALLELE) {
                setComp(elemCompLocal, comp, doc);
                encoderPara((Il) comp, doc, elemCompLocal);
            } else {
                setComp(elemCompLocal,comp,doc);
            }
            elemComp.appendChild(elemCompLocal);
        }
    }
    
    private static void setComp(Element elem, I comp, Document doc) {
        elem.appendChild(element("ID", ""+comp.I(), doc));
        elem.appendChild(element("VALEUR", ""+comp.Il(), doc));
    }
    
    private static Element element(String type, String info, Document doc) {
        Element _info = doc.createElement(type);
        _info.appendChild(doc.createTextNode(info));
        return _info;
    }
    
    /**
     * Permet de décoder un fichier XML sous la forme d'un .circuit, représentant un circuit électrique
     * @param endroit Emplacement du fichier à décoder
     * @return I1l
     */
    public I1l decoder(String endroit){
        try {
            I1l c = new I1l();
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(endroit));
            
            Element rootTest = doc.getDocumentElement();
            
            c.li(Double.parseDouble(rootTest.getAttribute("AMPERE")));
            c.l(Double.parseDouble(rootTest.getAttribute("VOLTAGE")));
            
            NodeList elemComp = rootTest.getElementsByTagName("COMPOSANTE");
            
            elemComp.getLength();
            
            Element comp = (Element)elemComp.item(0);
            
            NodeList para = comp.getElementsByTagName("PARALLELE");
            NodeList resis = comp.getElementsByTagName("RESISTANCE");
            
            for(int i = 0; i < para.getLength(); i++) {
                if(para.item(i).getParentNode().equals(comp))
                    c.i(ajouterParallele(((Element)para.item(i))));
            }
            for(int i = 0; i < resis.getLength(); i++) {
                if(resis.item(i).getParentNode().equals(comp))
                    c.i(ajouterComp((Element)resis.item(i)));
            }
            
            
            return c;
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(GestionXML.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private I ajouterComp(Element n) {
        
        I comp;
        
        switch(n.getNodeName()) {
            case "RESISTANCE" :
                double resistanceEqui = Double.parseDouble(getInfo("VALEUR", n));
                int ID = Integer.valueOf(getInfo("ID", n));
                
                comp = new Resistance(resistanceEqui, ID);
                return comp;
            case "BRANCHE" :
                int IDBranche = Integer.valueOf(getInfo("ID", n));
                
                comp = new I1(IDBranche);
                
                NodeList element = n.getElementsByTagName("COMPOSANTE");
                Element elemtemp = (Element) element.item(0);

                NodeList para = elemtemp.getElementsByTagName("PARALLELE");
                NodeList resis = elemtemp.getElementsByTagName("RESISTANCE");
                
                for(int i = 0; i < para.getLength(); i++) {
                    if(para.item(i).getParentNode().equals(elemtemp))
                    ((I1)comp).i(ajouterParallele((Element) element.item(i)));
                }
                for(int i = 0; i < resis.getLength(); i++) {
                    if(resis.item(i).getParentNode().equals(elemtemp))
                    ((I1)comp).i(ajouterComp((Element)resis.item(i)));
                }
                
                return comp;
            default :
                return null;
        }
    }
    
    private I ajouterParallele(Element n) {
        Il para = new Il(Integer.parseInt(((Element)n.getElementsByTagName("ID").item(0)).getFirstChild().getNodeValue()));
        
        NodeList elemTemp = n.getElementsByTagName("COMPOSANTE");
        Element element = (Element)elemTemp.item(0);
        NodeList branches = element.getElementsByTagName("BRANCHE");
        
        for(int i = 0; i < branches.getLength(); i++) {
            if(branches.item(i).getParentNode().equals(element))
            para.i(ajouterComp((Element)branches.item(i)));
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
