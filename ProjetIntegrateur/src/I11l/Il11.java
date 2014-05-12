package I11l;

import java.util.Enumeration;
import java.util.Vector;
import javax.swing.tree.TreeNode;

public class Il11 implements TreeNode {

    private String i;
    private final int Il;
    private final int II;
    private final Vector<TreeNode> I1 = new Vector<>();
    private TreeNode I1l;
    public static final int Il1 = 0;
    public static final int Ill = 2;
    public static final int Li = 4;
    public static final int Lil = 5;
    public static final int Lli = 6;

    public Il11(String l, int Il, int lI) {
        this.i = l;
        this.II = Il;
        this.Il = lI;
    }

    public int l() {
        return Il;
    }

    public void l(TreeNode child) {
        I1.add(child);
    }

    public void I(TreeNode parent) {
        this.I1l = parent;
    }

    @Override
    public Enumeration<TreeNode> children() {
        return I1.elements();
    }

    @Override
    public boolean getAllowsChildren() {
        return true;
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        return I1.elementAt(childIndex);
    }

    @Override
    public int getChildCount() {
        return I1.size();
    }

    @Override
    public int getIndex(TreeNode node) {
        return I1.indexOf(node);
    }

    @Override
    public TreeNode getParent() {
        return this.I1l;
    }

    @Override
    public boolean isLeaf() {
        return (I1.isEmpty());
    }

    public void l(String i) {
        this.i = i;
    }

    public String i() {
        return i;
    }

    @Override
    public String toString() {
        return i;
    }

    public int il() {
        return II;
    }
}
