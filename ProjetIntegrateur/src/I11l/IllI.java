package I11l;

import java.util.Vector;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class IllI implements TreeModel {

    private final TreeNode i;
    private final Vector<TreeModelListener> ll;

    public IllI(TreeNode i) {
        this.ll = new Vector<>();
        this.i = i;
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
        ll.add(l);
    }

    @Override
    public Object getChild(Object parent, int index) {
        TreeNode parentNode = (TreeNode) parent;
        return parentNode.getChildAt(index);
    }

    @Override
    public int getChildCount(Object parent) {
        TreeNode parentNode = (TreeNode) parent;
        return parentNode.getChildCount();
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        TreeNode parentNode = (TreeNode) parent;
        TreeNode childNode = (TreeNode) child;
        return parentNode.getIndex(childNode);
    }

    @Override
    public Object getRoot() {
        return i;
    }

    @Override
    public boolean isLeaf(Object node) {
        TreeNode treeNode = (TreeNode) node;
        return treeNode.isLeaf();
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        ll.remove(l);
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
    }
}
