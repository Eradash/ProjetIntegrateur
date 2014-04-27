package affichage.composanteBouton;

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

public class ResistanceBouton extends JButton implements MouseListener{
    
    private BufferedImage image;
    private BufferedImage imageJaune;
    private boolean mouseOver;
    
    public ResistanceBouton() {
        
        super();
        
        setBorderPainted(false);
        setContentAreaFilled(false);
        setRolloverEnabled(true);
        
        mouseOver = false;
        
        try {
            image = ImageIO.read(new File("image/resistance.png"));
            imageJaune = ImageIO.read(new File("image/resistanceJaune.png"));
        } catch (IOException e) {}
        
        addMouseListener(this);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        
        
        if(!mouseOver) {
            Image imageIc = new ImageIcon(image).getImage();
            g.drawImage(imageIc, 0, 0, this);
        } else {
            Image imageIc2 = new ImageIcon(imageJaune).getImage();
            g.drawImage(imageIc2, 0, 0, this);
        }
    }
    
    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        size.setSize(63,20);
        return size;
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseOver = true;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseOver = false;
    }
    
    public boolean isHighlighted() {
        return mouseOver;
    }
}
