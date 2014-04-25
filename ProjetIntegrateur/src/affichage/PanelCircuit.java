package affichage;

import ListenersCircuit.ComposanteEvent;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.MemoryImageSource;
import javax.swing.JPanel;
import logiqueCircuit.Type;

public class PanelCircuit extends JPanel implements MouseListener{
    
    public static enum Outil{PARALELLE,RESISTANCE,FIL,NULL};
    
    ControlleurFrame cf;
    private Outil outilPresent = Outil.NULL;
    private final Cursor curseurNull;
    
    public PanelCircuit(ControlleurFrame cf){
        this.cf = cf;
        initComponents();
        addMouseListener(this);
        
        //Setting pour un curseur null
        int[] pixels = new int[16 * 16];
        Image image = Toolkit.getDefaultToolkit().createImage(
        new MemoryImageSource(16, 16, pixels, 0, 16));
        curseurNull = Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(0, 0), "invisibleCursor");
    }
    
    private void initComponents(){
        
    }
    
    //Va chercher toutes les informations dans la BD et les affiches
    public void update(ComposanteEvent event){
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        graduerAxe(g);
    }
    
    private void graduerAxe(Graphics g) {
        int _x = this.getHeight();
        int _y = this.getWidth();
        
        for(int x = 0; x < _x; x += 20) {
            g.drawLine(0,x,_y,x);
        }
        for(int y = 0; y < _y; y += 20) {
            g.drawLine(y,0,y,_x);
        }
    }
    
    public void setOutil(Outil outil){
        this.outilPresent = outil;
        if(outil == Outil.NULL){
            this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        } else {
            this.setCursor(curseurNull);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (outilPresent) {
            case NULL:
                break;
            case FIL :
                break;
            case RESISTANCE :
                this.getGraphics().fillRect(e.getX(), e.getY(), 20, 30);
                setOutil(Outil.NULL);
                //Test... (qui fonctionne, jusqu'à présent :) )
                creerResistance(300);
                break;
            case PARALELLE :
                this.getGraphics().fillOval(e.getX()-10, e.getY()-10, 20, 20);
                setOutil(Outil.NULL);
                break;
        }
    }
    
    private void creerResistance(double valeur){
        ComposanteEvent evt = new ComposanteEvent(this, ComposanteEvent.TypeEvent.AJOUT);
        evt.ajouterValeur("Valeur", valeur);
        evt.setType(Type.RESISTANCE);
        System.out.println("Envoi du message au ControlleurFrame");
        cf.composanteAjout(evt);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
}
