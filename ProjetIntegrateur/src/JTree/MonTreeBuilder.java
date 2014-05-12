package JTree;

import java.util.ArrayList;
import logiqueCircuit.I1l;
import logiqueCircuit.I;
import logiqueCircuit.Resistance;
import logiqueCircuit.Type;

/**
 * Permet de construire l'Arbre d'affichage
 * @author Vincent Poirier (Tiré d'Internet)
 */
public class MonTreeBuilder {

    /**
     * Permet de constuire l'arbre en foncion du I1l envoyé
     * @param c I1l à représenter en arbre
     * @return Node root de l'arbre créé
     */
    public static MaNode build(I1l c) {
        if (c != null) {
            MaNode rootNode = new MaNode("Circuit", MaNode.NODE_ROOT, -1);
            ArrayList<I> listeComposante = c.lI();
            for (I comp : listeComposante) {
                rootNode.addChild(makeNode(comp));
            }
            return rootNode;
        } else {
            return null;
        }
    }

    private static MaNode makeNode(I c) {
        Type t = c.II();
        switch (t) {
            case RESISTANCE:
                int image = MaNode.NODE_RESISTANCE;
                Resistance resis = (Resistance) c;
                if (resis.isBurned()) {
                    image = MaNode.NODE_BURNED;
                }
                return new MaNode("Résistance", image, c.I());
            case PARALLELE:
                MaNode m = new MaNode("Parallèle", MaNode.NODE_PARALLELE, c.I());
                for (I s : c.lI()) {
                    m.addChild(makeNode(s));
                }
                return m;
            case SERIE:
                MaNode n = new MaNode("Branche", MaNode.NODE_BRANCHE, c.I());
                for (I comp : c.lI()) {
                    n.addChild(makeNode(comp));
                }
                return n;
        }
        return null;
    }
}
