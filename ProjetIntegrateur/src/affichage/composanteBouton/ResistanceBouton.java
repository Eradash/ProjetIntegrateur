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
    
    private BufferedImage image, imageJaune, imageVerticale, imageVerticaleJaune;
    private boolean mouseOver, selected, verticale;
    
    public ResistanceBouton() {
        
        super();
        
        setBorderPainted(false);
        setContentAreaFilled(false);
        setRolloverEnabled(true);
        
        mouseOver = false;
        verticale = false;
        
        try {
            image = ImageIO.read(new File("image/resistance.png"));
            imageJaune = ImageIO.read(new File("image/resistanceJaune.png"));
            imageVerticale = ImageIO.read(new File("image/resistanceVerticale.png"));
            imageVerticaleJaune = ImageIO.read(new File("image/resistanceVerticaleJaune.png"));
        } catch (IOException e) {}
        
        addMouseListener(this);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        
        this.setSize(getPreferredSize());
        
        if(!mouseOver && !verticale) {
            Image imageIc = new ImageIcon(image).getImage();
            g.drawImage(imageIc, 0, 0, this);
        } else if(mouseOver && !verticale){
            Image imageIc2 = new ImageIcon(imageJaune).getImage();
            g.drawImage(imageIc2, 0, 0, this);
        } else if(!mouseOver && verticale){
            Image imageIc3 = new ImageIcon(imageVerticale).getImage();
            g.drawImage(imageIc3, 0, 0, this);
        } else if(mouseOver && verticale){
            Image imageIc4 = new ImageIcon(imageVerticaleJaune).getImage();
            g.drawImage(imageIc4, 0, 0, this);
        }
    }
    
    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        
        if(!verticale)
            size.setSize(63,20);
        else
            size.setSize(20,63);
        
        return size;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == 3) {
            if(verticale == false) {
                verticale = true;
            } else {
                verticale = false;
            }
            repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseOver = true;
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(!selected)
            mouseOver = false;
    }
    
    public boolean isHighlighted() {
        return mouseOver;
    }
    
    @Override
    public void setSelected(boolean sel) {
        selected = sel;
        if(sel == false) {
            mouseOver = false;
        }
        repaint();
    }
    
    public void setVerticale(boolean verticale) {
        this.verticale = verticale;
    }
    
    public boolean isVerticale() {
        return verticale;
    }
}
