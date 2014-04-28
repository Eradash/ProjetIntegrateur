package affichage;

import gestion.BD;
import java.awt.Graphics;
import java.util.HashMap;
import javax.swing.JPanel;
import logiqueCircuit.Circuit;

public class PanelProp extends JPanel{
    ControlleurFrame cf;
    Circuit c;
    int IDSelected = -1;
    HashMap<String, Double> map;
    
    public PanelProp(ControlleurFrame cf, Circuit c){
        this.cf = cf;
        this.c = c;
        this.setSize(241, 346);
        repaint();
    }
    
    public void setIDSelection(int ID){
        this.IDSelected = ID;
        map = BD.getInstance().getComposante(IDSelected);
        repaint();
    }

    @Override
    public void paintComponents(Graphics g) {
        super.paintComponents(g);
        g.drawString("TEST", 20, 20);

    }
}
