package I11l;

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
    public static Il11 build(I1l c) {
        if (c != null) {
            Il11 rootNode = new Il11("Circuit", Il11.Il1, -1);
            ArrayList<I> listeComposante = c.lI();
            for (I comp : listeComposante) {
                rootNode.l(makeNode(comp));
            }
            return rootNode;
        } else {
            return null;
        }
    }

    private static Il11 makeNode(I c) {
        Il1 t = c.II();
        switch (t) {
            case li:
                int image = Il11.Lil;
                Ill resis = (Ill) c;
                if (resis.il()) {
                    image = Il11.Lli;
                }
                return new Il11("Résistance", image, c.I());
            case l:
                Il11 m = new Il11("Parallèle", Il11.Ill, c.I());
                for (I s : c.lI()) {
                    m.l(makeNode(s));
                }
                return m;
            case i:
                Il11 n = new Il11("Branche", Il11.Li, c.I());
                for (I comp : c.lI()) {
                    n.l(makeNode(comp));
                }
                return n;
        }
        return null;
    }
}
