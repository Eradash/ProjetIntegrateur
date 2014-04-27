package affichage.composanteBouton;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BatterieBouton extends JButton implements MouseListener{
    
    private BufferedImage image;
    private BufferedImage imageJaune;
    private boolean mouseOver;

    public BatterieBouton() {
        super();
        
        mouseOver = false;
        
        setBorderPainted(false);
        setContentAreaFilled(false);
        setRolloverEnabled(true);
        
        try {
            image = ImageIO.read(new File("image/batterie.png"));
            imageJaune = ImageIO.read(new File("image/batterieJaune.png"));
        } catch(IOException e) {}
        
        addMouseListener(this);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        
        if(!mouseOver) {
            Image imageIc = new ImageIcon(image).getImage();
            g.drawImage(imageIc, 0, 0, this);
        } else {
            Image imageJauneIc = new ImageIcon(imageJaune).getImage();
            g.drawImage(imageJauneIc, 0, 0, this);
        }
    }
    
    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        size.setSize(20,80);
        return size;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseOver =  true;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseOver = false;
    }
    
}
