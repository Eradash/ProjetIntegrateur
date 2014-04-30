package affichage;

import JTree.Tree;
import gestion.ControleurCircuit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import logiqueCircuit.Parallele;
import logiqueCircuit.Resistance;
import logiqueCircuit.Serie;
import logiqueCircuit.Type;

public class ControlleurFrame {

    private final FrameProjet frame;
    private final Tree arbre;
    private final ControleurCircuit cc;

    public ControlleurFrame(ControleurCircuit cc) {
        this.cc = cc;
        cc.setCF(this);
        frame = new FrameProjet(this);
        arbre = frame.getTree();
    }

    public void update() {
        arbre.update(cc.getCircuit());
    }

    public void BoutonResistance() {
        int ID;
        double d;
        try {
            ID = arbre.getIDSelected();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Aucune composante sélectionnée...");
            return;
        }
        Type t = cc.getCircuit().getCompEmp(ID).getType();
        if (t == Type.CIRCUIT || Type.SERIE == t) {
            String input = (String) JOptionPane.showInputDialog(new JFrame(), "Entrez la valeur de la nouvelle résistance:", "Nouvelle résistance", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("java2sLogo.GIF"), null, "");
            try {
                d = Double.parseDouble(input);
                if(d <= 0){
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valeur incorrecte");
                return;
            }

            cc.ajouterComposante(new Resistance(d), ID);
        } else {
            JOptionPane.showMessageDialog(null, "Sélection incorrecte");
        }
    }

    public void BoutonParallele() {
        int ID;
        try {
            ID = arbre.getIDSelected();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Aucune composante sélectionnée...");
            return;
        }
        Type t = cc.getCircuit().getCompEmp(ID).getType();
        if (t == Type.CIRCUIT || t == Type.SERIE) {
            cc.ajouterComposante(new Parallele(), ID);
        } else {
            JOptionPane.showMessageDialog(null, "Sélection incorrecte");
        }
    }

    public void BoutonBranche() {
        int ID;
        try {
            ID = arbre.getIDSelected();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Aucune composante sélectionnée...");
            return;
        }
        Type t = cc.getCircuit().getCompEmp(ID).getType();
        if (t == Type.PARALLELE) {
            cc.ajouterComposante(new Serie(), ID);
        } else {
            JOptionPane.showMessageDialog(null, "Sélection incorrecte");
        }
    }

    public void BoutonModifier() {
        int ID;
        double d;
        String input = null;
        try {
            ID = arbre.getIDSelected();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Aucune composante sélectionnée...");
            return;
        }
        Type t = cc.getCircuit().getCompEmp(ID).getType();
        if (t == Type.CIRCUIT || t == Type.RESISTANCE) {
            if (t == Type.CIRCUIT) {
                input = (String) JOptionPane.showInputDialog(new JFrame(), "Entrez la valeur du nouveau voltage", "Modification voltage", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("java2sLogo.GIF"), null, "");
            } else if (t == Type.RESISTANCE) {
                input = (String) JOptionPane.showInputDialog(new JFrame(), "Entrez la nouvelle valeur de la résistance", "Modification résistance", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("java2sLogo.GIF"), null, "");
            }
            try {
                d = Double.parseDouble(input);
                if(d <= 0){
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valeur incorrecte");
                return;
            }
            cc.modifierComposante(ID, d);
        } else {
            JOptionPane.showMessageDialog(null, "Sélection incorrecte");
        }
    }

    public void BoutonSupprimer() {
        int ID;
        try {
            ID = arbre.getIDSelected();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Aucune composante sélectionnée...");
            return;
        }
        cc.supprimerComposante(ID);
    }
    
    public void menuOuvrir(){
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FiltreCircuit());
        int valeur = chooser.showOpenDialog(frame);
        if (valeur == JFileChooser.APPROVE_OPTION) {
            cc.ouvrirCircuit(chooser.getSelectedFile().getPath());
        } else {
            JOptionPane.showMessageDialog(null, "Fichier invalide");
        }
    }
    
    public void menuSauvegarder(){
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FiltreCircuit());
        int valeur = chooser.showSaveDialog(frame);
        if (valeur == JFileChooser.APPROVE_OPTION) {
            cc.enregistrerCircuit(chooser.getSelectedFile().getPath());
        } else {
            JOptionPane.showMessageDialog(null, "Fichier invalide");
        }
    }
    
    public void menuNouveau(){
        cc.nouveauCircuit();
        arbre.update(cc.getCircuit());
    }

    public void IDSelected(int ID) {
        frame.getPanelProp().setIDSelection(ID);
    }

    public ArrayList<Double> getComposanteInfo(int ID) {
        ArrayList<Double> listeInfo = new ArrayList<>();

        cc.getInstanceBD().getComposante(ID, "resistance");

        return listeInfo;
    }
}
