package JTree;

import java.util.ArrayList;
import logiqueCircuit.Circuit;
import logiqueCircuit.Composante;
import logiqueCircuit.Type;

public class MonTreeBuilder {

    public static MaNode build(Circuit c) {
        if(c != null){
            MaNode rootNode = new MaNode("Circuit", MaNode.NODE_ROOT, -1);
            ArrayList<Composante> listeComposante = c.getComposantes();
            for(Composante comp : listeComposante){
                rootNode.addChild(makeNode(comp));
            }
            return rootNode;
        } else {
            return null;
        }
    }
    
    private static MaNode makeNode(Composante c){
        Type t = c.getType();
        switch (t){
            case RESISTANCE:
                return new MaNode("Résistance", MaNode.NODE_RESISTANCE, c.getNumero());
            case PARALLELE:
                MaNode m = new MaNode("Parallèle", MaNode.NODE_PARALLELE, c.getNumero());
                for(Composante s : c.getComposantes()){
                    m.addChild(makeNode(s));
                }
                return m;
            case SERIE:
                MaNode n = new MaNode("Branche", MaNode.NODE_BRANCHE, c.getNumero());
                for(Composante comp : c.getComposantes()){
                    n.addChild(makeNode(c));
                }
                return n;
        }
        return null;
    }
}
