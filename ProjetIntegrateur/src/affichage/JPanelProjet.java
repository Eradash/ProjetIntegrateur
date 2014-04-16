package affichage;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;
import logiqueCircuit.Composante;
import observer.Observateur;

public class JPanelProjet extends JPanel implements MouseListener{
    
    ArrayList <Composante> listeComp;
    ArrayList <Observateur> listeO;
    ControlleurBouton cb;
    
    public JPanelProjet() {
        cb = ControlleurBouton.getInstance();
        listeComp = new ArrayList<>();
        listeO = new ArrayList<>();
        addMouseListener(this);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
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
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        switch (cb.getOutil()) {
            case 0 :
                break;
            case 1 :
                break;
            case 2 :
                this.getGraphics().fillOval(e.getX()-10, e.getY()-10, 20, 20);
                cb.selectionnerOutil(cb.AUCUN);
                break;
            case 3 :
                
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
