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
import logiqueCircuit.Branche;
import logiqueCircuit.Circuit;
import logiqueCircuit.Composante;
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
        Element root = doc.createElement("Circuit");
        doc.appendChild(root);
        
        for(Composante comp : c.getComposantes()) {
            Element elem = doc.createElement("Composante:"+comp.getType());
            if(comp instanceof Branche) {
                
            }
            setComp(elem, comp, doc);
            root.appendChild(elem);
        }
        
        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer aTransformer = transFactory.newTransformer();

        Source src = new DOMSource(doc);
        Result dest = new StreamResult(new File("Circuit.xml"));

        aTransformer.transform(src, dest);
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
