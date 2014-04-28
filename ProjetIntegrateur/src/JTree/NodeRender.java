
import JTree.MaNode;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class NodeRender extends DefaultTreeCellRenderer {

    private final ImageIcon iconProject = new ImageIcon(getClass().getResource("/hainasoft/codelib/desktop/tree/project.png"));
    private final ImageIcon iconSource = new ImageIcon(getClass().getResource("/hainasoft/codelib/desktop/tree/source.png"));
    private final ImageIcon iconPackage = new ImageIcon(getClass().getResource("/hainasoft/codelib/desktop/tree/package.png"));
    private final ImageIcon iconClass = new ImageIcon(getClass().getResource("/hainasoft/codelib/desktop/tree/class.png"));
    private final ImageIcon iconFolder = new ImageIcon(getClass().getResource("/hainasoft/codelib/desktop/tree/folder.png"));

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        MaNode node = (MaNode) value;

        switch (node.getType()) {
            case MaNode.NODE_PROJECT:
                setIcon(iconProject);
                break;
            case MaNode.NODE_SOURCE:
                setIcon(iconSource);
                break;
            case MaNode.NODE_PACKAGE:
                setIcon(iconPackage);
                break;
            case MaNode.NODE_CLASS:
                setIcon(iconClass);
                break;
            case MaNode.NODE_FOLDER:
                setIcon(iconFolder);
                break;
        }

        return this;
    }
}
