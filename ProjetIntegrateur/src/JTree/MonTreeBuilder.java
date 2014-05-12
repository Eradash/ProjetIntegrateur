package JTree;

import java.util.ArrayList;
import logiqueCircuit.I11;
import logiqueCircuit.I;
import logiqueCircuit.II1;
import logiqueCircuit.I1I;

/**
 * Permet de construire l'Arbre d'affichage
 * @author Vincent Poirier (Tiré d'Internet)
 */
public class MonTreeBuilder {

    /**
     * Permet de constuire l'arbre en foncion du I11 envoyé
     * @param c I11 à représenter en arbre
     * @return Node root de l'arbre créé
     */
    public static MaNode build(I11 c) {
        if (c != null) {
            MaNode rootNode = new MaNode("Circuit", MaNode.NODE_ROOT, -1);
            ArrayList<I> listeComposante = c.III();
            for (I comp : listeComposante) {
                rootNode.addChild(makeNode(comp));
            }
            return rootNode;
        } else {
            return null;
        }
    }

    private static MaNode makeNode(I c) {
        I1I t = c.I1();
        switch (t) {
            case I11:
                int image = MaNode.NODE_RESISTANCE;
                II1 resis = (II1) c;
                if (resis.II1()) {
                    image = MaNode.NODE_BURNED;
                }
                return new MaNode("Résistance", image, c.I());
            case II1:
                MaNode m = new MaNode("Parallèle", MaNode.NODE_PARALLELE, c.I());
                for (I s : c.III()) {
                    m.addChild(makeNode(s));
                }
                return m;
            case III:
                MaNode n = new MaNode("Branche", MaNode.NODE_BRANCHE, c.I());
                for (I comp : c.III()) {
                    n.addChild(makeNode(comp));
                }
                return n;
        }
        return null;
    }
}
