package affichage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class JFrameProjet extends JFrame{
    
    public JFrameProjet() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        
        this.setResizable(true);
        this.setVisible(true);
        this.setSize(d);
        this.setTitle("Projet Integrateur");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.add(new JPanelOutil(), BorderLayout.WEST);
        
        JPanelProjet jpanel = new JPanelProjet();
        jpanel.setSize(d);
        this.add(jpanel, BorderLayout.CENTER);
    }
}
