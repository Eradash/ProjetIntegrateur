package affichage;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import logiqueCircuit.Circuit;
import logiqueCircuit.Composante;
import logiqueCircuit.Type;

public class JPanelProjet extends JPanel implements observer.Observateur{
    
    ArrayList <Composante> listeComp;
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        listeComp = new ArrayList<>();
        graduerAxe(g);
    }
    
    private void graduerAxe(Graphics g) {
        int _x = this.getHeight();
        int _y = this.getWidth();
        
        for(int x = 0; x < _x; x += 20) {
            g.drawLine(0,x,_y,x);
        }
        for(int y = 0; y < _y; y += 20) {
            g.drawLine(y,0,y,_x);
        }
    }
    
    @Override
    public void notifier(Circuit c) {
        for(Composante comp : c.getComposantes()) {
            ajouterComposante(comp);
        }
    }
    
    private void ajouterComposante(Composante comp) {
        listeComp.add(comp);
        if(comp.getType() == Type.PARALLELE) {
            for(Composante comp2 : comp.getComposantes()) {
                ajouterComposante(comp2);
            }
        }
    }
}
