package affichage.composanteBouton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JButton;

public class ParalleleBouton extends JButton{
    
    public ParalleleBouton () {
        super();
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        
        g.setColor(Color.BLUE);
        g.fillOval(0, 0, 10, 10);
    }
    
    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        size.setSize(10,10);
        return size;
    }
}
