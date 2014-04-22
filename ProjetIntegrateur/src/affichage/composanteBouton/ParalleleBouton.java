package affichage.composanteBouton;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ParalleleBouton extends JButton{
    
    private BufferedImage image;
    
    public ParalleleBouton () {
        try {
            image = ImageIO.read(new File("image\\resistance.png"));
        } catch (IOException e) {
            this.setIcon(null);
        }
        ImageIcon imageIc = new ImageIcon(image);
        this.setIcon(imageIc);
    }
}
