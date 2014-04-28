package JTree;

import affichage.ControlleurFrame;
import java.awt.BorderLayout;
 
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeModel;
import logiqueCircuit.Circuit;
 
public class Tree extends JPanel implements TreeSelectionListener {
    
    private final JTree tree;
    private final ControlleurFrame cf;
    
    public Tree(ControlleurFrame cf) {
        this.cf = cf;
        setLayout(new BorderLayout());
        MaNode rootNode = MonTreeBuilder.build(null);
        TreeModel model = new MonTreeModel(rootNode);
        tree = new JTree(model);
        tree.setCellRenderer(new NodeRender());
        tree.addTreeSelectionListener(this);
        tree.setEditable(true);
        
        add(new JScrollPane(tree), BorderLayout.CENTER);
        
        expand();
        
        setSize(280, 300);
        
        setVisible(true);
    }
    
    public void update(Circuit c){
        tree.setModel(new MonTreeModel(MonTreeBuilder.build(c)));
        expand();
    }
    
    private void expand(){
        for (int i = 0; i < tree.getRowCount(); i++) {
            tree.expandRow(i);
        }
    }
    
    @Override
    public void valueChanged(TreeSelectionEvent e) {
       Object node = tree.getLastSelectedPathComponent();
       if (node == null) {
           return;
       }
        
       JOptionPane.showMessageDialog(this, "You have selected: " + node);
    }
}