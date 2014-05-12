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
     * @param c I11 à encoder
     * @param endroit Emplacement du fichier à créer
     */
    public void encoder(I11 c, String endroit){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuild = docFactory.newDocumentBuilder();
            
            Document doc = docBuild.newDocument();
            root = doc.createElement("circuit");
            
            root.setAttribute("AMPERE", Double.toString(c.II1()));
            root.setAttribute("VOLTAGE", Double.toString(c.I1I()));
            
            doc.appendChild(root);
            
            setComp(root, c, doc);
            
            Element composante = doc.createElement("COMPOSANTE");
            
            for(I comp : c.III()) {
                Element elem = doc.createElement(comp.I1().toString());
                if(comp.I1() == I1I.II1) {
                    setComp(elem, comp, doc);
                    encoderPara((III)comp, doc, elem);
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
    
    private void encoderPara(III p, Document doc, Element elem) {
        int x = 1;
        
        Element elemComp = doc.createElement("COMPOSANTE");
        elem.appendChild(elemComp);
        
        for(I comp : p.III()) {
            encoderSerie((II)comp, doc, elemComp, x);
            x++;
        }
    }
    
    private void encoderSerie(II s, Document doc, Element elem, int branche) {
        Element elemBranche = doc.createElement("BRANCHE");
        elem.appendChild(elemBranche);
        elemBranche.setAttribute("NUMERO", Integer.toString(branche));
        
        setComp(elemBranche, s, doc);
        
        Element elemComp = doc.createElement("COMPOSANTE");
        elemBranche.appendChild(elemComp);
        
        for(I comp : s.III()) {
            Element elemCompLocal = doc.createElement(comp.I1().toString());
            if(comp.I1() == I1I.II1) {
                setComp(elemCompLocal, comp, doc);
                encoderPara((III) comp, doc, elemCompLocal);
            } else {
                setComp(elemCompLocal,comp,doc);
            }
            elemComp.appendChild(elemCompLocal);
        }
    }
    
    private static void setComp(Element elem, I comp, Document doc) {
        elem.appendChild(element("ID", ""+comp.I(), doc));
        elem.appendChild(element("VALEUR", ""+comp.II(), doc));
    }
    
    private static Element element(String type, String info, Document doc) {
        Element _info = doc.createElement(type);
        _info.appendChild(doc.createTextNode(info));
        return _info;
    }
    
    /**
     * Permet de décoder un fichier XML sous la forme d'un .circuit, représentant un circuit électrique
     * @param endroit Emplacement du fichier à décoder
     * @return I11
     */
    public I11 decoder(String endroit){
        try {
            I11 c = new I11();
            
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(endroit));
            
            Element rootTest = doc.getDocumentElement();
            
            c.I1(Double.parseDouble(rootTest.getAttribute("AMPERE")));
            c.I(Double.parseDouble(rootTest.getAttribute("VOLTAGE")));
            
            NodeList elemComp = rootTest.getElementsByTagName("COMPOSANTE");
            
            elemComp.getLength();
            
            Element comp = (Element)elemComp.item(0);
            
            NodeList para = comp.getElementsByTagName("PARALLELE");
            NodeList resis = comp.getElementsByTagName("RESISTANCE");
            
            for(int i = 0; i < para.getLength(); i++) {
                if(para.item(i).getParentNode().equals(comp))
                    c.I(ajouterParallele(((Element)para.item(i))));
            }
            for(int i = 0; i < resis.getLength(); i++) {
                if(resis.item(i).getParentNode().equals(comp))
                    c.I(ajouterComp((Element)resis.item(i)));
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
                
                comp = new II1(resistanceEqui, ID);
                return comp;
            case "BRANCHE" :
                int IDBranche = Integer.valueOf(getInfo("ID", n));
                
                comp = new II(IDBranche);
                
                NodeList element = n.getElementsByTagName("COMPOSANTE");
                Element elemtemp = (Element) element.item(0);

                NodeList para = elemtemp.getElementsByTagName("PARALLELE");
                NodeList resis = elemtemp.getElementsByTagName("RESISTANCE");
                
                for(int i = 0; i < para.getLength(); i++) {
                    if(para.item(i).getParentNode().equals(elemtemp))
                    ((II)comp).I(ajouterParallele((Element) element.item(i)));
                }
                for(int i = 0; i < resis.getLength(); i++) {
                    if(resis.item(i).getParentNode().equals(elemtemp))
                    ((II)comp).I(ajouterComp((Element)resis.item(i)));
                }
                
                return comp;
            default :
                return null;
        }
    }
    
    private I ajouterParallele(Element n) {
        III para = new III(Integer.parseInt(((Element)n.getElementsByTagName("ID").item(0)).getFirstChild().getNodeValue()));
        
        NodeList elemTemp = n.getElementsByTagName("COMPOSANTE");
        Element element = (Element)elemTemp.item(0);
        NodeList branches = element.getElementsByTagName("BRANCHE");
        
        for(int i = 0; i < branches.getLength(); i++) {
            if(branches.item(i).getParentNode().equals(element))
            para.I(ajouterComp((Element)branches.item(i)));
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
