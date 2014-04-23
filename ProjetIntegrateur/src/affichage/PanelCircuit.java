package affichage;

import affichage.composanteBouton.ParalleleBouton;
import affichage.composanteBouton.ResistanceBouton;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PanelCircuit extends JPanel implements MouseListener, MouseMotionListener{
    
    private final ControlleurFrame cf;
    ArrayList<Point> coords;
    ArrayList<ResistanceBouton> listeResistance;
    ArrayList<ParalleleBouton> listeParallele;
    ResistanceBouton ResCourrant;
    ParalleleBouton ParaCourrant;
    private int outilPresent = 0;
    
    public PanelCircuit(ControlleurFrame cf){
        this.cf = cf;
        initComponents();
        
        this.setLayout(null);
        
        listeResistance = new ArrayList<>();
        listeParallele = new ArrayList<>();
        coords = new ArrayList<>();
    }
    
    private void initComponents(){
        addMouseListener(this);
        addMouseMotionListener(this);
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
            for(int y = 0; y < _y; y += 20) {
                g.drawLine(y,0,y,_x);
                coords.add(new Point(x,y));
            }
        }
    }
    
    public void setOutil(int outil){
        this.outilPresent = outil;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        switch (outilPresent) {
            case 0 :
                break;
            case 1 :
                break;
            case 2 :
                ResistanceBouton boutonRes = new ResistanceBouton();
            
                boutonRes.setSize(boutonRes.getPreferredSize());
                boutonRes.setLocation(getPointPres(e.getPoint()));
            
                this.add(boutonRes);
                listeResistance.add(boutonRes);
            
                outilPresent = 0;
                repaint();
                break;
            case 3 :
                this.getGraphics().setColor(Color.BLUE);
                
                this.getGraphics().fillOval(e.getX()-5, e.getY()-5, 7, 7);
                outilPresent = 0;
                break;
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
        if(outilPresent != 0) {
            switch (outilPresent) {
                case 1 :
                    break;
                case 2 :
                    
                    break;
                case 3 :
                    break;
        }
        }
    }
}
