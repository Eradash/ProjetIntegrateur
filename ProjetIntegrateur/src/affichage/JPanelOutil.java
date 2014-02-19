package affichage;

import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class JPanelOutil extends JPanel{
    
    public JPanelOutil() {
        JToolBar toolbar = new JToolBar(JToolBar.VERTICAL);
        toolbar.setMargin(new Insets(5, 0, 2, 0));
        
        toolbar.add(new JButton("Bonjour"));
        toolbar.add(new JButton("Bonjour"));
        toolbar.add(new JButton("Bonjour"));
        toolbar.add(new JButton("Bonjour"));
        toolbar.add(new JButton("Bonjour"));
        toolbar.add(new JButton("Bonjour"));
        
        this.add(toolbar);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
