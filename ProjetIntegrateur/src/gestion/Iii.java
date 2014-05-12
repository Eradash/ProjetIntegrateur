package gestion;

import l.I;
import l.Il1;
import l.I1l;
import l.Il;
import l.Ill;
import l.I1;
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
import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class Iii {
    
    private Element lI;
    
    private static volatile Iii l = null;
    
    private Iii() {
        super();
    }

    public void l(I1l l, String ll){
        try {
            DocumentBuilderFactory li = DocumentBuilderFactory.newInstance();
            DocumentBuilder il = li.newDocumentBuilder();
            Document I = il.newDocument();
            lI = I.createElement("circuit");
            lI.setAttribute("AMPERE", Double.toString(l.l()));
            lI.setAttribute("VOLTAGE", Double.toString(l.il()));
            I.appendChild(lI);
            il(lI, l, I);
            Element II = I.createElement("COMPOSANTE");
            for(I Il : l.lI()) {
                Element lI = I.createElement(Il.II().toString());
                if(Il.II() == Il1.l) {
                    il(lI, Il, I);
                    il((Il)Il, I, lI);
                } else {
                    il(lI, Il, I);
                }
                II.appendChild(lI);
            }
            lI.appendChild(II);
            TransformerFactory l1 = TransformerFactory.newInstance();
            Transformer I1 = l1.newTransformer();
            Source Ii = new DOMSource(I);
            Result iI = new StreamResult(new File(ll + ".circuit"));
            I1.transform(Ii, iI);
        } catch (ParserConfigurationException | TransformerException Ii) {
            Logger.getLogger(Iii.class.getName()).log(Level.SEVERE, null, Ii);
        }
    }
    
    private void il(Il i, Document l, Element ll) {
        int Il = 1;
        Element il = l.createElement("COMPOSANTE");
        ll.appendChild(il);
        for(I li : i.lI()) {
            il((I1)li, l, il, Il);
            Il++;
        }
    }
    
    private void il(I1 i, Document l, Element ll, int il) {
        Element li = l.createElement("BRANCHE");
        ll.appendChild(li);
        li.setAttribute("NUMERO", Integer.toString(il));
        il(li, i, l);
        Element iI = l.createElement("COMPOSANTE");
        li.appendChild(iI);
        for(I Il : i.lI()) {
            Element l1 = l.createElement(Il.II().toString());
            if(Il.II() == Il1.l) {
                il(l1, Il, l);
                il((Il) Il, l, l1);
            } else {
                il(l1,Il,l);
            }
            iI.appendChild(l1);
        }
    }
    
    private static void il(Element il, I i, Document ll) {
        il.appendChild(il("ID", ""+i.I(), ll));
        il.appendChild(il("VALEUR", ""+i.Il(), ll));
    }
    
    private static Element il(String i, String l, Document ll) {
        Element il = ll.createElement(i);
        il.appendChild(ll.createTextNode(l));
        return il;
    }

    public I1l l(String I1){
        try {
            I1l li = new I1l();
            DocumentBuilderFactory Ii = DocumentBuilderFactory.newInstance();
            DocumentBuilder iI = Ii.newDocumentBuilder();
            Document ii = iI.parse(new InputSource(I1));
            Element ll = ii.getDocumentElement();
            li.li(Double.parseDouble(ll.getAttribute("AMPERE")));
            li.l(Double.parseDouble(ll.getAttribute("VOLTAGE")));
            NodeList il = ll.getElementsByTagName("COMPOSANTE");
            il.getLength();
            Element Il = (Element)il.item(0);
            NodeList l1 = Il.getElementsByTagName("PARALLELE");
            NodeList i1 = Il.getElementsByTagName("RESISTANCE");
            for(int j = 0; j < l1.getLength(); j++) {
                if(l1.item(j).getParentNode().equals(Il))
                    li.i(l(((Element)l1.item(j))));
            }
            for(int ij = 0; ij < i1.getLength(); ij++) {
                if(i1.item(ij).getParentNode().equals(Il))
                    li.i(il((Element)i1.item(ij)));
            }
            return li;
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Iii.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private I il(Element ll) {
        I il;
        switch(ll.getNodeName()) {
            case "RESISTANCE" :
                double li = Double.parseDouble(l("VALEUR", ll));
                int I = Integer.valueOf(l("ID", ll));
                
                il = new Ill(li, I);
                return il;
            case "BRANCHE" :
                int Il = Integer.valueOf(l("ID", ll));
                il = new I1(Il);
                NodeList I1 = ll.getElementsByTagName("COMPOSANTE");
                Element i1 = (Element) I1.item(0);
                NodeList ij = i1.getElementsByTagName("PARALLELE");
                NodeList Ij = i1.getElementsByTagName("RESISTANCE");
                for(int i = 0; i < ij.getLength(); i++) {
                    if(ij.item(i).getParentNode().equals(i1))
                    ((I1)il).i(l((Element) I1.item(i)));
                }
                for(int i = 0; i < Ij.getLength(); i++) {
                    if(Ij.item(i).getParentNode().equals(i1))
                    ((I1)il).i(il((Element)Ij.item(i)));
                }
                return il;
            default :
                return null;
        }
    }
    
    private I l(Element l) {
        Il il = new Il(Integer.parseInt(((Element)l.getElementsByTagName("ID").item(0)).getFirstChild().getNodeValue()));
        NodeList ll = l.getElementsByTagName("COMPOSANTE");
        Element li = (Element)ll.item(0);
        NodeList Il = li.getElementsByTagName("BRANCHE");
        for(int i = 0; i < Il.getLength(); i++) {
            if(Il.item(i).getParentNode().equals(li))
            il.i(il((Element)Il.item(i)));
        }
        return il;
    }
    
    private String l(String i, Element l) throws DOMException{
        NodeList ll = l.getElementsByTagName(i);
        if(ll.getLength() != 0) {
            return ll.item(0).getFirstChild().getNodeValue();
        } else {
            return null;
        }
    }
    
    public static final Iii ll() {
        if(l == null) {
            synchronized(Iii.class) {
                if(l == null) {
                    l = new Iii();
                }
            }
        }
        return l;
    }
}
