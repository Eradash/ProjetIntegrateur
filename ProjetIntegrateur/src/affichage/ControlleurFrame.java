package affichage;

import gestion.ControleurCircuit;
import java.awt.event.ActionEvent;

public class ControlleurFrame {

    FrameProjet frame;
    PanelBoutons panelBoutons;
    ControleurCircuit cc;

    public ControlleurFrame(ControleurCircuit cc) {
        this.cc = cc;
        frame = new FrameProjet(this);
        panelBoutons = new PanelBoutons();
    }
    
    public void BoutonResistance(ActionEvent evt){
        
    }
    
    public void BoutonParallele(ActionEvent evt){
        
    }
    
    public void BoutonFil(ActionEvent evt){
        
    }

    
}