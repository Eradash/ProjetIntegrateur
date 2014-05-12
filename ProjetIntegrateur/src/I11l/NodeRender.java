package I11l;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 * Permet de gérer l'affichage de l'Arbre
 * @author Vincent Poirier (Tiré d'Internet)
 */
public class NodeRender extends DefaultTreeCellRenderer {

    private final ImageIcon iconProject = new ImageIcon("image/BatteryIcon.png"); //Circuit
    private final ImageIcon iconSource = new ImageIcon("image/ParaIcon.png");
    private final ImageIcon iconPackage = null; //Branches
    private final ImageIcon iconClass = new ImageIcon("image/resistanceIcon.png");
    private final ImageIcon iconFolder = new ImageIcon("image/resistanceBurned.png");

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        Il11 node = (Il11) value;

        switch (node.il()) {
            case Il11.Ill:
                setIcon(iconSource);
                break;
            case Il11.Li:
                setIcon(iconPackage);
                break;
            case Il11.Lil:
                setIcon(iconClass);
                break;
            case Il11.Lli:
                setIcon(iconFolder);
                break;
            case Il11.Il1:
                setIcon(iconProject);
                break;
        }

        return this;
    }
}
