package affichage;

import java.awt.Graphics;
import javax.swing.JPanel;

public class JPanelProjet extends JPanel{
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        graduerAxe(g);
    }
    
    private void graduerAxe(Graphics g) {
        int _x = this.getWidth();
        int _y = this.getHeight();
        
        for(int x = 0; x < _x; x += 20) {
            g.drawLine(0,x,_y,x);
        }
        for(int y = 0; y < _y; y += 20) {
            g.drawLine(y,0,y,_x);
        }
    }
}
