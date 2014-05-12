package I1l1;

import I1ll.Iil;
import java.awt.Graphics;
import java.util.HashMap;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Ill1 extends JPanel {

    private int i = -1;
    private HashMap<String, Double> l;
    private boolean ll;

    public Ill1() {
        this.ll = false;
        this.setSize(241, 346);
        this.setBorder(new TitledBorder("Propriétés:"));
        repaint();
    }

    public void l(int il) {
        this.i = il;
        l = Iil.ll().ll(i);
        ll = true;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (ll) {
            int il = 30;
            int li = 30;
            for (String Il : l.keySet()) {
                if (!"Type".equals(Il) && !"Parent".equals(Il)) {
                    if (l.get(Il) != null) {
                        g.drawString(Il, il, li);
                        g.drawString(l.get(Il).toString(), il + 80, li);
                        li += 30;
                    }
                }
            }
        }
    }
}
