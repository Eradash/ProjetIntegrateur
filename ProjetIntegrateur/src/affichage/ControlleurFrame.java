package affichage;

import JTree.Tree;
import gestion.AnalyseurCircuit;
import gestion.ControleurCircuit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
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

    private int treeSelected() {
        int ID;
        try {
            ID = arbre.getIDSelected();
            return ID;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame.getFrame(), "Aucune composante sélectionnée...");
            return -2;
        }
    }

    private boolean verifierSelection(Type[] types, int ID) {
        boolean ok = false;
        Type verification = cc.getCircuit().getCompEmp(ID).getType();
        for (Type t : types) {
            if (t == verification) {
                ok = true;
            }
        }
        if (!ok) {
            JOptionPane.showMessageDialog(frame.getFrame(), "Sélection incorrecte");
        }
        return ok;
    }

    private Integer inputInt(String input) throws NumberFormatException {
        int i;
        try {
            i = Integer.parseInt(input);
            return i;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame.getFrame(), "Valeur incorrecte");
        }
        return null;
    }

    private Double inputDouble(String input) {
        double d;
        try {
            d = Double.parseDouble(input);
            return d;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame.getFrame(), "Valeur incorrecte");
        }
        return null;
    }

    public void Bouton(String bouton) {
        int ID;
        Double d;
        if ((ID = treeSelected()) != -2) {
            switch (bouton) {
                case "Resistance":
                    if (verifierSelection(new Type[]{Type.CIRCUIT, Type.SERIE}, ID)) {
                        String input = afficherOptionPane("Entrez la valeur de la nouvelle résistance:", "Nouvelle résistance");
                        if ((d = inputDouble(input)) > 0) {
                            cc.ajouterComposante(new Resistance(d), ID);
                        } else {
                            //Messages d'erreur pour les bonnes valeurs d'une résistance...
                        }
                    }
                case "Parallele":
                    if (verifierSelection(new Type[]{Type.CIRCUIT, Type.SERIE}, ID)) {
                        cc.ajouterComposante(new Parallele(), ID);
                    }
                case "Branche":
                    if (verifierSelection(new Type[]{Type.PARALLELE, Type.SERIE}, ID)) {
                        cc.ajouterComposante(new Serie(), ID);
                    }
            }
        }
    }

    public void BoutonModifier() {
        int ID;
        double d;
        String input = null;
        if ((ID = treeSelected()) != -2) {
            Type t = cc.getCircuit().getCompEmp(ID).getType();
            if (verifierSelection(new Type[]{Type.CIRCUIT, Type.RESISTANCE}, ID)) {
                if (t == Type.CIRCUIT) {
                    input = afficherOptionPane("Entrez la valeur du nouveau voltage", "Modification voltage");
                } else if (t == Type.RESISTANCE) {
                    input = afficherOptionPane("Entrez la nouvelle valeur de la résistance", "Modification résistance");
                }
                if ((d = inputDouble(input)) > 0) {
                    cc.modifierComposante(ID, d);
                }
            }
        }
    }

    public void menuArrondissement() {
        int d;
        String input = (String) JOptionPane.showInputDialog(frame.getFrame(), "Entrez la valeur du nouvel arrondissement:", "Changement arrondissement", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("java2sLogo.GIF"), null, "");
        try {
            d = Integer.parseInt(input);
            if (d >= 10 || d <= 0) {
                throw new NumberFormatException("BAM");
            }
        } catch (NumberFormatException e) {
            if ("BAM".equals(e.getMessage())) {
                JOptionPane.showMessageDialog(frame.getFrame(), "Veuillez entrer une valeure inférieur à 10 et supérieure à 0");
            } else {
                JOptionPane.showMessageDialog(frame.getFrame(), "Valeur incorrecte");
            }
            return;
        }
        AnalyseurCircuit.arrondissement = d;
        cc.run();
    }

    public void BoutonSupprimer() {
        int ID;
        if ((ID = treeSelected()) != -2) {
            cc.supprimerComposante(ID);
        }
    }

    public void menuOuvrir() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FiltreCircuit());
        int valeur = chooser.showOpenDialog(frame);
        if (valeur == JFileChooser.APPROVE_OPTION) {
            cc.ouvrirCircuit(chooser.getSelectedFile().getPath());
        } else {
            JOptionPane.showMessageDialog(frame.getFrame(), "Fichier invalide");
        }
    }

    public void menuSauvegarder() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FiltreCircuit());
        int valeur = chooser.showSaveDialog(frame);
        if (valeur == JFileChooser.APPROVE_OPTION) {
            cc.enregistrerCircuit(chooser.getSelectedFile().getPath());
        } else {
            JOptionPane.showMessageDialog(frame.getFrame(), "Fichier invalide");
        }
    }

    public void menuNouveau() {
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

    public String afficherOptionPane(String texte, String titre) {
        String input = (String) JOptionPane.showInputDialog(frame.getFrame(), texte, titre, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("java2sLogo.GIF"), null, "");
        return input;
    }
}
