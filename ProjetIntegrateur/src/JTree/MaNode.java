package JTree;

import java.util.Enumeration;
import java.util.Vector;
import javax.swing.tree.TreeNode;

/**
 * Neud de l'Arbre d'affichage (code tiré d'Internet)
 * @author Vincent Poirier
 */
public class MaNode implements TreeNode {

    private String titre;
    private final int ID;

    private final int type;

    private final Vector<TreeNode> children = new Vector<>();
    private TreeNode parent;

    // Constantes des types de Nodes

    /**
     * Node racine
     */
    public static final int NODE_ROOT = 0;

    /**
     * Node parallèle
     */
    public static final int NODE_PARALLELE = 2;

    /**
     * Node branche
     */
    public static final int NODE_BRANCHE = 4;

    /**
     * Node résistance
     */
    public static final int NODE_RESISTANCE = 5;

    /**
     * Node résistance brûlée
     */
    public static final int NODE_BURNED = 6;

    /**
     * Initialise la Node avec un titre, un type et l'ID de la composante représentée par cette node
     * @param title Texte affiché dans l'arbre
     * @param type Type de la Node
     * @param ID ID de la composante représentée par cette Node
     */
    public MaNode(String title, int type, int ID) {
        this.titre = title;
        this.type = type;
        this.ID = ID;
    }

    /**
     * Permet de connaître l'ID de la composante représentée par cette node
     * @return L'ID de la composante
     */
    public int getID() {
        return ID;
    }

    /**
     * Permet d'ajouter un enfant à la Node
     * @param child Node à ajouter comme enfant
     */
    public void addChild(TreeNode child) {
        children.add(child);
    }

    /**
     * Permet de préciser le parent de cette Node
     * @param parent Node parent
     */
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

    /**
     * Permet de modifier le texte affiché
     * @param titre Le nouveau texte à afficher
     */
    public void setTitre(String titre) {
        this.titre = titre;
    }

    /**
     * Permet d'avoir le texte affiché
     * @return Le texte affiché
     */
    public String getTitre() {
        return titre;
    }

    @Override
    public String toString() {
        return titre;
    }

    /**
     * Permet d'avoir le type de Node
     * @return Le type de cette Node
     */
    public int getType() {
        return type;
    }
}
