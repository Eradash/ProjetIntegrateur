package affichage;

import gestion.BD;
import java.awt.Graphics;
import java.util.HashMap;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class PanelProp extends JPanel {

    int IDSelected = -1;
    HashMap<String, Double> map;
    boolean instance = false;

    public PanelProp() {
        this.setSize(241, 346);
        this.setBorder(new TitledBorder("Propriétés:"));
        repaint();
    }

    public void setIDSelection(int ID) {
        this.IDSelected = ID;
        map = BD.getInstance().getComposante(IDSelected);
        instance = true;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (instance) {
            int x = 30;
            int y = 30;
            for (String s : map.keySet()) {
                if (!"Type".equals(s) && !"Parent".equals(s)) {
                    if (map.get(s) != null) {
                        g.drawString(s, x, y);
                        g.drawString(map.get(s).toString(), x + 80, y);
                        y += 30;
                    }
                }
            }
        }
    }
}
