package JTree;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class NodeRender extends DefaultTreeCellRenderer {

    private final ImageIcon iconProject = new ImageIcon("image/BatteryIcon.png"); //Circuit
    private final ImageIcon iconSource = new ImageIcon("image/ParaIcon.png");
    private final ImageIcon iconPackage = null; //Branches
    private final ImageIcon iconClass = new ImageIcon("image/resistanceIcon.png");
    private final ImageIcon iconFolder = new ImageIcon("image/resistanceBurned.png");

    public NodeRender() {

    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        MaNode node = (MaNode) value;

        switch (node.getType()) {
            case MaNode.NODE_PROJECT:
                setIcon(iconProject);
                break;
            case MaNode.NODE_PARALLELE:
                setIcon(iconSource);
                break;
            case MaNode.NODE_BRANCHE:
                setIcon(iconPackage);
                break;
            case MaNode.NODE_RESISTANCE:
                setIcon(iconClass);
                break;
            case MaNode.NODE_BURNED:
                setIcon(iconFolder);
                break;
            case MaNode.NODE_ROOT:
                setIcon(iconProject);
                break;
        }

        return this;
    }
}
