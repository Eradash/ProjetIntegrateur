package JTree;

import java.util.ArrayList;
import l.I1l;
import l.I;
import l.Ill;
import l.Il1;

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
        Il1 t = c.II();
        switch (t) {
            case li:
                int image = MaNode.NODE_RESISTANCE;
                Ill resis = (Ill) c;
                if (resis.il()) {
                    image = MaNode.NODE_BURNED;
                }
                return new MaNode("Résistance", image, c.I());
            case l:
                MaNode m = new MaNode("Parallèle", MaNode.NODE_PARALLELE, c.I());
                for (I s : c.lI()) {
                    m.addChild(makeNode(s));
                }
                return m;
            case i:
                MaNode n = new MaNode("Branche", MaNode.NODE_BRANCHE, c.I());
                for (I comp : c.lI()) {
                    n.addChild(makeNode(comp));
                }
                return n;
        }
        return null;
    }
}
