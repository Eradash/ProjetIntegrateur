package affichage;

import JTree.Tree;
import ListenersCircuit.*;
import gestion.BD;
import gestion.ControleurCircuit;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ControlleurFrame implements ComposanteListener{

    FrameProjet frame;
    Tree arbre;
    ControleurCircuit cc;
    
    ArrayList<ComposanteListener> listenerAjoutSupp;

    public ControlleurFrame(ControleurCircuit cc) {
        this.cc = cc;
        frame = new FrameProjet(this, cc);
        arbre = frame.getTree();
        
        listenerAjoutSupp = new ArrayList<>();
    }
    
    public void BoutonResistance(ActionEvent evt){

    }
    
    public void BoutonParallele(ActionEvent evt){

    }
    
    public void BoutonBranche(ActionEvent evt){

    }
    
    @Override
    public void composanteAjout(ComposanteEvent event) {
        if(event.getSource() instanceof PanelCircuit){
            System.out.println("Message recu du PanelCircuit (CF)");
            cc.composanteAjout(event);
        } else if(event.getSource() instanceof BD){

        }
    }

    @Override
    public void composanteSupp(ComposanteEvent event) {
        if(event.getSource() instanceof PanelCircuit){
            cc.composanteSupp(event);
        } else if(event.getSource() == BD.class){

        }
    }

    @Override
    public void composanteModif(ComposanteEvent event) {
        if(event.getSource() instanceof PanelCircuit){
            cc.composanteModif(event);
        } else if(event.getSource() instanceof BD){

        }
    }
    
    
}