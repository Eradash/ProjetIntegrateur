package I11l;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

public class IlIl extends DefaultTreeCellRenderer {

    private final ImageIcon lI = new ImageIcon("image/BatteryIcon.png"); //Circuit
    private final ImageIcon ll = new ImageIcon("image/ParaIcon.png");
    private final ImageIcon li = null; //Branches
    private final ImageIcon l = new ImageIcon("image/resistanceIcon.png");
    private final ImageIcon l1 = new ImageIcon("image/resistanceBurned.png");

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        Il11 i = (Il11) value;
        switch (i.il()) {
            case Il11.Ill:
                setIcon(ll);
                break;
            case Il11.Li:
                setIcon(li);
                break;
            case Il11.Lil:
                setIcon(l);
                break;
            case Il11.Lli:
                setIcon(l1);
                break;
            case Il11.Il1:
                setIcon(lI);
                break;
        }
        return this;
    }
}
