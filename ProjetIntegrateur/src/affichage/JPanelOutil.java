package affichage;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        
        JButton jb1 = createButton("Fil", X, Y);
        
        jb1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        JButton jb2 = createButton("Résistance", X, Y);
        
        jb2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        JButton jb3 = createButton("Parallele", X, Y);
        
        jb3.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        toolbar.add(jb1);
        toolbar.add(jb2);
        toolbar.add(jb3);
        
        this.add(toolbar);
    }
    
    private JButton createButton(String nom, int x, int y) {
        JButton jb = new JButton(nom);
        
        jb.setPreferredSize(new Dimension(x,y));
        jb.setMaximumSize(new Dimension(x,y));
        jb.setMinimumSize(new Dimension(x,y));
        
        return jb;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
