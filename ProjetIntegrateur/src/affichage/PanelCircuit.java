package affichage;

import ListenersCircuit.AjoutSuppEvent;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import logiqueCircuit.Type;

public class PanelCircuit extends JPanel implements MouseListener{
    
    ControlleurFrame cf;
    private int outilPresent = 0;
    
    public PanelCircuit(ControlleurFrame cf){
        this.cf = cf;
        initComponents();
        addMouseListener(this);
    }
    
    private void initComponents(){
        
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
    
    public void setOutil(int outil){
        this.outilPresent = outil;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        switch (outilPresent) {
            case 0 :
                break;
            case 1 :
                break;
            case 2 :
                this.getGraphics().fillRect(e.getX(), e.getY(), 20, 30);
                outilPresent = 0;
                System.out.println("Outil Résistance");
                break;
            case 3 :
                this.getGraphics().fillOval(e.getX()-10, e.getY()-10, 20, 20);
                outilPresent = 0;
                break;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
}
