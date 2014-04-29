package affichage;

import JTree.Tree;
import ListenersCircuit.*;
import gestion.ControleurCircuit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logiqueCircuit.Parallele;
import logiqueCircuit.Resistance;
import logiqueCircuit.Serie;
import logiqueCircuit.Type;

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
        double d;
        try {
            ID = arbre.getIDSelected();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Aucune composante sélectionnée...");
            return;
        }
        Type t = cc.getCircuit().getCompEmp(ID).getType();
        if (t == Type.CIRCUIT || Type.SERIE == t) {
            String input = (String) JOptionPane.showInputDialog(new JFrame(), "Entrez la valeur de la nouvelle résistance:", "Nouvelle résistance", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("java2sLogo.GIF"), null, "");
            try {
                d = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valeur incorrecte");
                return;
            }

            cc.ajouterComposante(new Resistance(d), ID);
        } else {
            JOptionPane.showMessageDialog(null, "Sélection incorrecte");
        }
    }

    public void BoutonParallele(){
        int ID;
        try {
            ID = arbre.getIDSelected();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Aucune composante sélectionnée...");
            return;
        }
        cc.ajouterComposante(new Parallele(), ID);
    }
    
    public void BoutonBranche(){
        int ID;
        try {
            ID = arbre.getIDSelected();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Aucune composante sélectionnée...");
            return;
        }Type t = cc.getCircuit().getCompEmp(ID).getType();
        if (t == Type.PARALLELE) {
            cc.ajouterComposante(new Serie(), ID);
        } else {
            JOptionPane.showMessageDialog(null, "Sélection incorrecte");
        }
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