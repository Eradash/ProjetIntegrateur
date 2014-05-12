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

public class IIll extends JPanel implements TreeSelectionListener {

    private final JTree l;
    private final I11 l1;

    public IIll(I11 l1) {
        this.l1 = l1;
        setLayout(new BorderLayout());
        Il11 i = I111.l(null);
        TreeModel li = new IllI(i);
        l = new JTree(li);
        l.setCellRenderer(new IlIl());
        l.addTreeSelectionListener(this);
        add(new JScrollPane(l), BorderLayout.CENTER);
        l();
        setSize(321, 545);
        setVisible(true);
    }

    public void l(I1l c) {
        l.setModel(new IllI(I111.l(c)));
        l();
    }

    private void l() {
        for (int i = 0; i < l.getRowCount(); i++) {
            l.expandRow(i);
        }
    }

    public int I() throws Exception {
        TreePath il = l.getSelectionPath();
        Il11 li = (Il11) il.getLastPathComponent();
        return li.l();
    }

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath tp = l.getSelectionPath();
        if (tp != null) {
            Il11 m = (Il11) tp.getLastPathComponent();
            l1.l(m.l());
        }
    }
}
