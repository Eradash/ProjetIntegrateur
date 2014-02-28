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
import logiqueCircuit.Serie;
import logiqueCircuit.Type;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GestionXML {
    
    private static volatile GestionXML instance = null;
    
    private GestionXML() {
        super();
    }
    
    public void encoder(Circuit c) throws Exception{
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuild = docFactory.newDocumentBuilder();
        
        Document doc = docBuild.newDocument();
        Element root = doc.createElement(c.getNom());
        doc.appendChild(root);
        
        for(Composante comp : c.getComposantes()) {
            Element elem = doc.createElement("Composante:"+comp.getType());
            if(comp.getType() == Type.PARALELLE) {
                encoderPara((Parallele)comp, doc);
            }
            setComp(elem, comp, doc);
            root.appendChild(elem);
        }
        
        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer aTransformer = transFactory.newTransformer();

        Source src = new DOMSource(doc);
        Result dest = new StreamResult(new File(c.getNom()+".xml"));

        aTransformer.transform(src, dest);
    }
    
    private void encoderPara(Parallele p, Document doc) {
        int x = 1;
        
        for(Composante comp : p.getComposantes()) {
            encoderSerie((Serie)comp,doc,x);
            x++;
        }
    }
    
    private void encoderSerie(Serie s, Document doc, int branche) {
        Element elem = doc.createElement("Branche"+branche);
        
        for(Composante comp : s.getComposantes()) {
            if(comp.getType() == Type.PARALELLE) {
                encoderPara((Parallele) comp, doc);
            }
            setComp(elem,comp,doc);
        }
    }
    
    private static void setComp(Element elem, Composante comp, Document doc) {
        elem.appendChild(element("Resistance:", ""+comp.getType(), doc));
        elem.appendChild(element("Voltage:", ""+comp.getType(), doc));
        elem.appendChild(element("Amperage:", ""+comp.getType(), doc));
    }
    
    private static Element element(String type, String info, Document doc) {
        Element _info = doc.createElement(type);
        _info.appendChild(doc.createTextNode(info));
        return _info;
    }
    
    public Circuit decoder() {
        
        
        
        return new Circuit();
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
