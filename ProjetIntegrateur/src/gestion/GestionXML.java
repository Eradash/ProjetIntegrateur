package gestion;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import logiqueCircuit.Circuit;
import logiqueCircuit.Composante;
import logiqueCircuit.Parallele;
import logiqueCircuit.Resistance;
import logiqueCircuit.Serie;
import logiqueCircuit.Type;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


public class GestionXML {
    
    private Element root;
    private Circuit c;
    
    private static volatile GestionXML instance = null;
    
    private GestionXML() {
        super();
    }
    
    public void encoder(Circuit c) throws Exception{
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuild = docFactory.newDocumentBuilder();
        
        Document doc = docBuild.newDocument();
        root = doc.createElement(c.getNom());
        doc.appendChild(root);
        
        setComp(root, c, doc);
        
        for(Composante comp : c.getComposantes()) {
            Element elem = doc.createElement(comp.getType().toString());
            if(comp.getType() == Type.PARALLELE) {
                setComp(elem, comp, doc);
                encoderPara((Parallele)comp, doc, elem);
            } else
                setComp(elem, comp, doc);
            
            root.appendChild(elem);
        }
        
        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer aTransformer = transFactory.newTransformer();

        Source src = new DOMSource(doc);
        Result dest = new StreamResult(new File(c.getNom()+".xml"));

        aTransformer.transform(src, dest);
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
                setComp(elemComp, comp, doc);
                encoderPara((Parallele) comp, doc, elemCompLocal);
            } else {
                setComp(elemComp,comp,doc);
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
    
    public Circuit decoder(String nomCircuit) throws Exception{
        
        c = new Circuit();
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(nomCircuit+".xml"));
        
        Element rootTest = doc.getDocumentElement();
        
        c.setAmpere(Double.parseDouble(rootTest.getAttribute("AMPERE")));
        c.setVoltage(Double.parseDouble(rootTest.getAttribute("VOLTAGE")));
        
        NodeList elemComp = rootTest.getElementsByTagName("COMPOSANTE");
        Element comp = (Element)elemComp.item(0);
        
        NodeList para = comp.getElementsByTagName("PARALLELE");
        NodeList resis = comp.getElementsByTagName("RESISTANCE");
        
        for(int i = 0; i < para.getLength(); i++) {
            c.ajouterComposante(ajouterParallele(((Element)para.item(i))));
        }
        for(int i = 0; i < resis.getLength(); i++) {
            c.ajouterComposante(ajouterComp((Element)resis.item(i)));
        }
        

        return c;
    }
    
    private Composante ajouterComp(Element n) {
        
        Composante comp = null;
        
        switch(n.getNodeName()) {
            case "RESISTANCE" :
                int resistanceEqui = Integer.valueOf(getInfo("VALEUR", n));
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
                    ((Serie)comp).ajouterComposante(ajouterParallele((Element) element.item(i)));
                }
                for(int i = 0; i < resis.getLength(); i++) {
                    ((Serie)comp).ajouterComposante(comp);
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
