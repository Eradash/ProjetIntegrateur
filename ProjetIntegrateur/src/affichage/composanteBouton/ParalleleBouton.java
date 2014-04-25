package affichage.composanteBouton;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;

public class ParalleleBouton extends JButton{
    
    public ParalleleBouton () {
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        
        g.fillOval(10, 10, 0, 0);
    }
    
    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        size.setSize(10,10);
        return size;
    }
}
