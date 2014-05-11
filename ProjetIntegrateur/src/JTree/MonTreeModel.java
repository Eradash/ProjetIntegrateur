package JTree;

import java.util.Vector;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 * Permet de gérer je sais pas trop quoi... J'ai pris ça d'Internet, et il parait que ça prennait ça...
 * @author Vincent Poirier (Tiré d'Internet)
 */
public class MonTreeModel implements TreeModel {

    private final TreeNode rootNode;
    private final Vector<TreeModelListener> listeners;

    /**
     * Permet de créer le TreeModel avec une rootNode
     * @param rootNode
     */
    public MonTreeModel(TreeNode rootNode) {
        this.listeners = new Vector<>();
        this.rootNode = rootNode;
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
        listeners.add(l);
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
        return rootNode;
    }

    @Override
    public boolean isLeaf(Object node) {
        TreeNode treeNode = (TreeNode) node;
        return treeNode.isLeaf();
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        listeners.remove(l);
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
    }
}
