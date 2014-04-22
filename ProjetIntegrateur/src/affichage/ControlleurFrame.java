package affichage;

import ListenersCircuit.*;
import gestion.BD;
import gestion.ControleurCircuit;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ControlleurFrame implements ComposanteListener{

    FrameProjet frame;
    PanelBoutons panelBoutons;
    PanelCircuit panelCircuit;
    ControleurCircuit cc;
    
    ArrayList<ComposanteListener> listenerAjoutSupp;

    public ControlleurFrame(ControleurCircuit cc) {
        this.cc = cc;
        frame = new FrameProjet(this);
        
        panelBoutons = frame.getPanelBoutons();
        panelCircuit = frame.getPanelCircuit();
        
        listenerAjoutSupp = new ArrayList<>();
    }
    
    public void BoutonResistance(ActionEvent evt){
        panelCircuit.setOutil(2);
    }
    
    public void BoutonParallele(ActionEvent evt){
        panelCircuit.setOutil(3);
    }
    
    public void BoutonFil(ActionEvent evt){
        panelCircuit.setOutil(1);
    }
    
    @Override
    public void composanteAjout(ComposanteEvent event) {
        if(event.getSource() == PanelCircuit.class){
            cc.composanteAjout(event);
        } else if(event.getSource() == BD.class){
            panelCircuit.update(event);
        }
    }

    @Override
    public void composanteSupp(ComposanteEvent event) {
        if(event.getSource() == PanelCircuit.class){
            cc.composanteSupp(event);
        } else if(event.getSource() == BD.class){
            panelCircuit.update(event);
        }
    }

    @Override
    public void composanteModif(ComposanteEvent event) {
        if(event.getSource() == PanelCircuit.class){
            cc.composanteModif(event);
        } else if(event.getSource() == BD.class){
            panelCircuit.update(event);
        }
    }
}