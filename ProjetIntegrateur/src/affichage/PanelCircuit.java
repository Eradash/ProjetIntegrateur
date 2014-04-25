package affichage;

import affichage.composanteBouton.ParalleleBouton;
import affichage.composanteBouton.ResistanceBouton;
import java.awt.Color;
import ListenersCircuit.ComposanteEvent;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.MemoryImageSource;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import logiqueCircuit.Type;

public class PanelCircuit extends JPanel implements MouseListener, MouseMotionListener{
    
    private final ControlleurFrame cf;
    ArrayList<Point> coords;
    ArrayList<ResistanceBouton> listeResistance;
    ArrayList<ParalleleBouton> listeParallele;
    private BufferedImage resImage;
    public static enum Outil{PARALLELE,RESISTANCE,FIL,NULL};
    private Outil outilPresent = Outil.NULL;
    private final Cursor curseurNull;
    
    private Point positionSouris;
    
    public PanelCircuit(ControlleurFrame cf){
        this.cf = cf;
        initComponents();
        addMouseListener(this);
        
        positionSouris = new Point();
        
        //Setting pour un curseur null
        int[] pixels = new int[16 * 16];
        Image image = Toolkit.getDefaultToolkit().createImage(
        new MemoryImageSource(16, 16, pixels, 0, 16));
        curseurNull = Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(0, 0), "invisibleCursor");
        
        this.setLayout(null);
        
        listeResistance = new ArrayList<>();
        listeParallele = new ArrayList<>();
        coords = new ArrayList<>();
        
        try {
            resImage = ImageIO.read(new File("image/resistance.png"));
        } catch (IOException i) {}
    }
    
    private void initComponents(){
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    
    //Va chercher toutes les informations dans la BD et les affiches
    public void update(ComposanteEvent event){
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Point _p = getPointPres(positionSouris);
        
        if(outilPresent == Outil.RESISTANCE)
            g.drawImage(resImage, _p.x, _p.y, new Color(1F, 1F, 1F, 0.9F),this);
        else if (outilPresent == Outil.PARALLELE) {
                g.setColor(Color.BLUE);
                g.fillOval(_p.x, _p.y, 7, 7);
        }
        g.setColor(Color.BLACK);
        graduerAxe(g);
    }
    
    private void graduerAxe(Graphics g) {
        int _x = this.getHeight();
        int _y = this.getWidth();
        
        for(int x = 0; x < _x; x += 20) {
            g.drawLine(0,x,_y,x);
            for(int y = 0; y < _y; y += 20) {
                g.drawLine(y,0,y,_x);
                coords.add(new Point(x,y));
            }
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
                ResistanceBouton boutonRes = new ResistanceBouton();
            
                boutonRes.setSize(boutonRes.getPreferredSize());
                boutonRes.setLocation(getPointPres(e.getPoint()));
            
                this.add(boutonRes);
                listeResistance.add(boutonRes);
                setOutil(Outil.NULL);
                //Test... (qui fonctionne, jusqu'à présent :) )
                creerResistance(300);
                repaint();
                break;
            case PARALLELE:
                this.getGraphics().setColor(Color.BLUE);
                
                this.getGraphics().fillOval(e.getX()-5, e.getY()-5, 7, 7);
                setOutil(Outil.NULL);

        }
    }
    
    private Point getPointPres(Point p1) {
        Point _p = new Point(0,0);
        
        for(Point p2 : coords) {
            if(_p.distance(p1) > p2.distance(p1)) {
                _p = p2;
            }
        }
        
        _p.setLocation(_p.getX(), _p.getY()-8);
        
        return _p;
    }
    
    private void creerResistance(double valeur){
        ComposanteEvent evt = new ComposanteEvent(this, ComposanteEvent.TypeEvent.AJOUT);
        evt.ajouterValeur("Valeur", valeur);
        evt.setType(Type.RESISTANCE);
        System.out.println("Envoi du message au ControlleurFrame");
        cf.composanteAjout(evt);
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        positionSouris = e.getPoint();
        repaint();
    }
}
