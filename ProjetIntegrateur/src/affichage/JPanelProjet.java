package affichage;

import gestion.ControleurCircuit;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import logiqueCircuit.Circuit;
import observer.Observateur;

public class JPanelProjet extends JPanel implements MouseListener, Observateur{
    
    ControlleurBouton cb;
    ControleurCircuit cc;
    Circuit c;
    
    public JPanelProjet() {
        c = new Circuit();
        cb = ControlleurBouton.getInstance();
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
                this.getGraphics().fillRect(e.getX(), e.getY(), 20, 30);
                cb.selectionnerOutil(cb.AUCUN);
                break;
            case 3 :
                this.getGraphics().fillOval(e.getX()-10, e.getY()-10, 20, 20);
                cb.selectionnerOutil(cb.AUCUN);
                break;
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {}
    
    @Override
    public void mouseEntered(MouseEvent e) {}
    
    @Override
    public void mouseExited(MouseEvent e) {}
    
    @Override
    public void notifier(Circuit c) {
        this.c = c;
    }
}
