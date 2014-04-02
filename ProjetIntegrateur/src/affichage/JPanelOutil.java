package affichage;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class JPanelOutil extends JPanel{
    
    JToolBar toolbar;
    
    public JPanelOutil() {  
        
        toolbar = new JToolBar(JToolBar.VERTICAL);
        toolbar.setMargin(new Insets(5, 0, 2, 0));
        
        final int X = 200;
        final int Y = 50;
        
        createButton("Fil", X, Y);
        createButton("Résistance", X, Y);
        createButton("Parallele", X, Y);
        
        this.add(toolbar);
    }
    
    private void createButton(String nom, int x, int y) {
        JButton jb = new JButton(nom);
        
        jb.setPreferredSize(new Dimension(x,y));
        jb.setMaximumSize(new Dimension(x,y));
        jb.setMinimumSize(new Dimension(x,y));
        
        toolbar.add(jb);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
