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
    PanelProp pp;
    
    ArrayList<ComposanteListener> listenerAjoutSupp;

    public ControlleurFrame(ControleurCircuit cc) {
        this.cc = cc;
        cc.setCF(this);
        frame = new FrameProjet(this, cc);
        arbre = frame.getTree();
        pp = frame.getPanelProp();
        
        listenerAjoutSupp = new ArrayList<>();
    }
    
    public void update(){
        arbre.update(cc.getCircuit());
    }
    
    public void BoutonResistance(ActionEvent evt){
        //Créer l'évènement, et l'envoyer au Controlleur Circuit
    }
    
    public void BoutonParallele(ActionEvent evt){

    }
    
    public void BoutonBranche(ActionEvent evt){

    }
    
    public void IDSelected(int ID){
        pp.setIDSelection(ID);
    }
    
    public ArrayList<Double> getComposanteInfo(int ID) {
        ArrayList<Double> listeInfo = new ArrayList<>();
        
        cc.getInstanceBD().getComposante(ID, "resistance");
        
        return listeInfo;
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