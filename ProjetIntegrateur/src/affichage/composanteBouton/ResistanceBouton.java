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
import javax.swing.JComponent;

public class ResistanceBouton extends JComponent implements MouseListener{
    
    private BufferedImage image;
    
    public ResistanceBouton() {
        
        super();
        
        try {
            image = ImageIO.read(new File("image/resistance.png"));
        } catch (IOException e) {}
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        
        Image imageIc = new ImageIcon(image).getImage();
        g.drawImage(imageIc, 0, 0, this);
    }
    
    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        size.setSize(50,16);
        return size;
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
