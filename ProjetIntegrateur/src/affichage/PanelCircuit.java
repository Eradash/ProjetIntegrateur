package affichage;

import affichage.composanteBouton.ParalleleBouton;
import affichage.composanteBouton.ResistanceBouton;
import java.awt.Color;
import ListenersCircuit.ComposanteEvent;
import affichage.composanteBouton.BatterieBouton;
import java.awt.BasicStroke;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.MemoryImageSource;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import logiqueCircuit.Type;

public class PanelCircuit extends JPanel implements MouseListener, MouseMotionListener{
    
    ArrayList<Point> coords;
    ArrayList<ResistanceBouton> listeResistance;
    ArrayList<ParalleleBouton> listeParallele;
    ArrayList<Shape> listeFilX, listeFilY;
    Shape shapeCourranteX, shapeCourranteY;
    public static enum Outil{PARALLELE,RESISTANCE,FIL,NULL};
    private final ControlleurFrame cf;
    private BufferedImage resImage;
    private Outil outilPresent = Outil.NULL;
    private JButton composanteCourrante;
    private Point positionSouris;
    private final BatterieBouton batterie;
    private final Cursor curseurNull;
    
    public PanelCircuit(ControlleurFrame cf){
        this.cf = cf;
        initComponents();
        
        positionSouris = new Point();
        listeResistance = new ArrayList<>();
        listeParallele = new ArrayList<>();
        listeFilX = new ArrayList<>();
        listeFilY = new ArrayList<>();
        coords = new ArrayList<>();
        batterie = new BatterieBouton();
        shapeCourranteX = null;
        shapeCourranteY = null;
        
        batterie.setLocation(300,100);
        batterie.setSize(batterie.getPreferredSize());
        batterie.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        this.setLayout(null);
        add(batterie);
        
        //Setting pour un curseur null
        int[] pixels = new int[16 * 16];
        Image image = Toolkit.getDefaultToolkit().createImage(
        new MemoryImageSource(16, 16, pixels, 0, 16));
        curseurNull = Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(0, 0), "invisibleCursor");
        
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
        
        Graphics2D g2 = (Graphics2D) g;
        
        Point _p = getPointPres(positionSouris);
        
        if(outilPresent == Outil.RESISTANCE)
            g2.drawImage(resImage, _p.x, _p.y-8, new Color(1F, 1F, 1F, 0.9F),this);
        else if (outilPresent == Outil.PARALLELE) {
            g2.setColor(Color.BLUE);
            g2.fillOval(_p.x-5, _p.y-5, 10, 10);
        }
        
        if(listeFilX != null) {
            for(Shape s : listeFilX) {
                g2.setStroke(new BasicStroke(3));
                g2.draw(s);
            }
            g2.setStroke(new BasicStroke(1));
        }
        if(listeFilY != null) {
            for(Shape s : listeFilY) {
                g2.setStroke(new BasicStroke(3));
                g2.draw(s);
            }
            g2.setStroke(new BasicStroke(1));
        }
        
        g2.setColor(Color.BLACK);
        graduerAxe(g2);
    }
    
    private void graduerAxe(Graphics g) {
        coords.clear();
        int _x = this.getHeight();
        int _y = this.getWidth();
        
        for(int y = 0; y < _y; y += 20) {
            g.drawLine(y,0,y,_x);
                for(int x = 0; x < _x; x += 20) {
                g.drawLine(0,x,_y,x);
                coords.add(new Point(y,x));
            }
        }
    }
    
    public void setOutil(Outil outil){
        this.outilPresent = outil;
        if(outil == Outil.NULL || outil == Outil.FIL){
            this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        } else {
            this.setCursor(curseurNull);
        }
    }
    
    private Point getPointPres(Point p1) {
        Point _p = new Point(0,0);
        
        for(Point p2 : coords) {
            if(_p.distance(p1) > p2.distance(p1)) {
                _p = p2;
            }
        }
        
        _p.setLocation(_p.getX(), _p.getY());
        
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
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == 1) {
            switch (outilPresent) {
                case NULL:
                    break;
                case FIL :
                    break;
                case RESISTANCE :
                    ResistanceBouton boutonRes = new ResistanceBouton();

                    boutonRes.addItemListener(new ItemListener() {
                        @Override
                        public void itemStateChanged(ItemEvent e) {
                            if(e.getStateChange() == ItemEvent.MOUSE_EVENT_MASK) {
                                System.out.println(":)");
                            }
                        }
                    });
                    
                    boutonRes.setSize(boutonRes.getPreferredSize());
                    boutonRes.setCursor(new Cursor(Cursor.HAND_CURSOR));


                    Point _p = new Point(getPointPres(e.getPoint()).x,getPointPres(e.getPoint()).y-8);
                    boutonRes.setLocation(_p);

                    this.add(boutonRes);
                    listeResistance.add(boutonRes);
                    
                    creerResistance(300);
                    
                    setOutil(Outil.NULL);
                    repaint();
                    
                    break;
                case PARALLELE:
                    ParalleleBouton boutonPara = new ParalleleBouton();
                    
                    boutonPara.setSize(boutonPara.getPreferredSize());
                    boutonPara.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    
                    Point _p2 = new Point(getPointPres(e.getPoint()).x-5, getPointPres(e.getPoint()).y-5);
                    boutonPara.setLocation(_p2);
                    
                    this.add(boutonPara);
                    listeParallele.add(boutonPara);
                    
                    setOutil(Outil.NULL);
                    repaint();
                    
                    break;
            }
        } else if(e.getButton() == 3) {
            setOutil(Outil.NULL);
            repaint();
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        if(outilPresent == Outil.FIL) {
            shapeCourranteX = new Line2D.Double(getPointPres(e.getPoint()), getPointPres(e.getPoint()));
            shapeCourranteY = new Line2D.Double(getPointPres(e.getPoint()), getPointPres(e.getPoint()));
            listeFilX.add(shapeCourranteX);
            listeFilY.add(shapeCourranteY);
            repaint();
        }
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        if(outilPresent == Outil.FIL) {
            outilPresent = Outil.NULL;
        }
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {}
    
    @Override
    public void mouseExited(MouseEvent e) {}
    
    @Override
    public void mouseDragged(MouseEvent e) {
        if(outilPresent == Outil.FIL) {
            Line2D shapeX = (Line2D) shapeCourranteX;
            Line2D shapeY = (Line2D) shapeCourranteY;

            shapeX.setLine(shapeX.getP1(), new Point(getPointPres(e.getPoint()).x,(int)shapeX.getP1().getY()));
            shapeY.setLine(shapeX.getP2(), new Point((int)shapeX.getP2().getX(), getPointPres(e.getPoint()).y));

            repaint();
        }
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
        positionSouris = e.getPoint();
        repaint();
    }
}
