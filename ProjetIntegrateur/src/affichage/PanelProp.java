package affichage;

import javax.swing.JPanel;
import logiqueCircuit.Circuit;

public class PanelProp extends JPanel{
    ControlleurFrame cf;
    Circuit c;
    int IDSelected = -1;
    
    public PanelProp(ControlleurFrame cf, Circuit c){
        this.cf = cf;
        this.c = c;
    }
    
    public void setIDSelection(int ID){
        this.IDSelected = ID;
        update();
    }
    
    private void update(){
        //Update des infos selon l'ID sélectionné
    }
}
