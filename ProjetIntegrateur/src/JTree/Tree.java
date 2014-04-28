package JTree;

import java.awt.BorderLayout;
 
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeModel;
 
public class Tree extends JPanel implements TreeSelectionListener {
    
    private final JTree tree;
    
    public Tree() {
        setLayout(new BorderLayout());
        
        MaNode rootNode = MonTreeBuilder.build();
        
        TreeModel model = new MonTreeModel(rootNode);
        
        tree = new JTree(model);
        
        tree.setCellRenderer(new NodeRender());
        
        tree.addTreeSelectionListener(this);
        
        tree.setEditable(true);
        
        add(new JScrollPane(tree), BorderLayout.CENTER);
        
        // expand all nodes in the tree to be visible
        for (int i = 0; i < tree.getRowCount(); i++) {
            tree.expandRow(i);
        }
        
        setSize(280, 300);
        
        setVisible(true);
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