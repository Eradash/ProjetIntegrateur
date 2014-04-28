package affichage;

import JTree.Tree;
import ListenersCircuit.*;
import gestion.ControleurCircuit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logiqueCircuit.Resistance;

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
    
    public void BoutonResistance(){
        int ID;
        int d;
        try {
            ID = arbre.getIDSelected();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Aucune composante sélectionnée...");
            return;
        }
        String input = (String) JOptionPane.showInputDialog(new JFrame(),"Entrez la valeur de la nouvelle résistance:","Nouvelle résistance", JOptionPane.INFORMATION_MESSAGE,new ImageIcon("java2sLogo.GIF"), null, "");
        try {
            d = Integer.parseInt(input);
        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null,"Valeur incorrecte");
            return;
        }
        cc.ajouterComposante(new Resistance(d), ID);
    }
    
    public void BoutonParallele(){

    }
    
    public void BoutonBranche(){

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
        }
    }

    @Override
    public void composanteSupp(ComposanteEvent event) {
        if(event.getSource() instanceof PanelCircuit){
            cc.composanteSupp(event);
        }
    }

    @Override
    public void composanteModif(ComposanteEvent event) {
        if(event.getSource() instanceof PanelCircuit){
            cc.composanteModif(event);
        }
    }
    
    
}