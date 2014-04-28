package affichage;

import javax.swing.JLabel;
import javax.swing.JPanel;
import logiqueCircuit.Circuit;

public class PanelProp extends JPanel{
    ControlleurFrame cf;
    Circuit c;
    int IDSelected = -1;
    private JLabel resistance;
    
    public PanelProp(ControlleurFrame cf, Circuit c){
        this.cf = cf;
        this.c = c;
        this.setLayout(null);
        
        resistance = new JLabel("Résistance");
    }
    
    public void setIDSelection(int ID){
        this.IDSelected = ID;
        update();
    }
    
    private void update(){
        cf.getComposanteInfo(IDSelected);
    }
}
