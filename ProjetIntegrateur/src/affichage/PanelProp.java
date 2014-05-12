package affichage;

import gestion.Iil;
import java.awt.Graphics;
import java.util.HashMap;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Permet d'afficher les propriétés d'une composante
 */
public class PanelProp extends JPanel {

    private int IDSelected = -1;
    private HashMap<String, Double> map;
    private boolean instance;

    /**
     * Initialisation du panel avec une bordure et une taille prédéfinie
     */
    public PanelProp() {
        this.instance = false;
        this.setSize(241, 346);
        this.setBorder(new TitledBorder("Propriétés:"));
        repaint();
    }

    /**
     * Permet de notifier le panel d'un changement de sélection de composante.
     * @param ID ID de la nouvelle composante sélectionnée
     */
    public void setIDSelection(int ID) {
        this.IDSelected = ID;
        map = Iil.ll().ll(IDSelected);
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
