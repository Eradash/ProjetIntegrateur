package affichage;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class JFrameProjet extends JFrame implements KeyListener{
    
    public JFrameProjet() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension d = tk.getScreenSize();
        
        this.setResizable(true);
        this.setSize(d);
        this.setTitle("Projet Integrateur");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JPanelProjet jpanel = new JPanelProjet();
        jpanel.setSize(d);
        this.add(jpanel, BorderLayout.CENTER);
        
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode() == e.VK_F1) {
            
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
