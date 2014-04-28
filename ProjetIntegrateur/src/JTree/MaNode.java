package JTree;


import java.util.Enumeration;
import java.util.Vector;
import javax.swing.tree.TreeNode;

public class MaNode implements TreeNode {

    private String title;
    private final int ID;
    
    private final int type;
 
    private final Vector<TreeNode> children = new Vector<>();
    private TreeNode parent;
    
    // Constants for types of node
    public static final int NODE_ROOT       = 0;
    public static final int NODE_PROJECT    = 1;
    public static final int NODE_PARALLELE  = 2;
    public static final int NODE_BRANCHE    = 4;
    public static final int NODE_RESISTANCE = 5;
    public static final int NODE_FOLDER     = 6;
    
    public MaNode(String title, int type, int ID) {
        this.title = title;
        this.type = type;
        this.ID = ID;
    }
    
    public int getID(){
        return ID;
    }
    
    public void addChild(TreeNode child) {
        children.add(child);
    }
    
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }
    
    @Override
    public Enumeration<TreeNode> children() {
        return children.elements();
    }
 
    @Override
    public boolean getAllowsChildren() {
        return true;
    }
 
    @Override
    public TreeNode getChildAt(int childIndex) {
        return children.elementAt(childIndex);
    }
 
    @Override
    public int getChildCount() {
        return children.size();
    }
 
    @Override
    public int getIndex(TreeNode node) {
        return children.indexOf(node);
    }
 
    @Override
    public TreeNode getParent() {
        return this.parent;
    }
 
    @Override
    public boolean isLeaf() {
        return (children.isEmpty());
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
 
    public int getType() {
        return type;
    }   
}