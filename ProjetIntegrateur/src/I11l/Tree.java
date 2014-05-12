package I11l;

import I1l1.I11;
import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import l.I1l;

/**
 * Arbre d'affichage
 * @author Vincent Poirier (Tiré d'Internet)
 */
public class Tree extends JPanel implements TreeSelectionListener {

    private final JTree tree;
    private final I11 cf;

    /**
     * Permet de créer un arbre. Initialise les composantes, les listeners et le ScrollPane, et garde une référence avec le I11
     * @param cf Controlleur Frame du pojet (pour la jonction avec le reste du projet)
     */
    public Tree(I11 cf) {
        this.cf = cf;
        setLayout(new BorderLayout());
        Il11 rootNode = I111.l(null);
        TreeModel model = new IllI(rootNode);
        tree = new JTree(model);
        tree.setCellRenderer(new IlIl());
        tree.addTreeSelectionListener(this);

        add(new JScrollPane(tree), BorderLayout.CENTER);

        expand();

        setSize(321, 545);

        setVisible(true);
    }

    /**
     * Permet de mettre à jour l'Arbre. Utilisé quand une composante est modifiée, ajoutée/supprimée, ou quand des modifications sont faites sur les variables importantes du circuit
     * @param c I1l sur lequel se baser pour la construction de l'Arbre
     */
    public void update(I1l c) {
        tree.setModel(new IllI(I111.l(c)));
        expand();
    }

    private void expand() {
        for (int i = 0; i < tree.getRowCount(); i++) {
            tree.expandRow(i);
        }
    }

    /**
     * Permet d'obtenir l'ID de la composante présentement sélectionnée dans l'Arbre
     * @return L'ID de la composante sélectionnée présentement
     * @throws Exception Erreur si aucune composante n'est présentement sélectionné
     */
    public int getIDSelected() throws Exception {
        TreePath tp = tree.getSelectionPath();
        Il11 m = (Il11) tp.getLastPathComponent();
        return m.l();
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath tp = tree.getSelectionPath();
        if (tp != null) {
            Il11 m = (Il11) tp.getLastPathComponent();
            cf.l(m.l());
        }
    }
}
