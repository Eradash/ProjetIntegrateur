package affichage;

import JTree.Tree;
import gestion.AnalyseurCircuit;
import gestion.ControleurCircuit;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import logiqueCircuit.Parallele;
import logiqueCircuit.Resistance;
import logiqueCircuit.Serie;
import logiqueCircuit.Type;

/**
 * Permet une connection entre le Frame et le reste du projet
 */
public class ControlleurFrame {

    private final FrameProjet frame;
    private final Tree arbre;
    private final ControleurCircuit cc;

    /**
     * Initialise le Controlleur
     * @param cc Controlleur du circuit
     */
    public ControlleurFrame(ControleurCircuit cc) {
        this.cc = cc;
        cc.setCF(this);
        frame = new FrameProjet(this);
        arbre = frame.getTree();
    }

    /**
     * permet de mettre à jour l'affichage
     */
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

    /**
     * Fonction appelée losqu'un bouton est appuyé
     * @param bouton Nom du bouton appuyé
     */
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
                    break;
                case "Parallele":
                    if (verifierSelection(new Type[]{Type.CIRCUIT, Type.SERIE}, ID)) {
                        cc.ajouterComposante(new Parallele(), ID);
                    }
                    break;
                case "Branche":
                    if (verifierSelection(new Type[]{Type.PARALLELE}, ID)) {
                        cc.ajouterComposante(new Serie(), ID);
                    }
                    break;
                case "Modifier":
                    if (verifierSelection(new Type[]{Type.CIRCUIT, Type.RESISTANCE}, ID)) {
                        Type t  = cc.getCircuit().getCompEmp(ID).getType();
                        String input = null;
                        if (t == Type.CIRCUIT) {
                            input = afficherOptionPane("Entrez la valeur du nouveau voltage", "Modification voltage");
                        } else if (t == Type.RESISTANCE) {
                            input = afficherOptionPane("Entrez la nouvelle valeur de la résistance", "Modification résistance");
                        }
                        if ((d = inputDouble(input)) > 0) {
                            cc.modifierComposante(ID, d);
                        }
                    }
                    break;
            }
        }
    }

    /**
     * BontonModifier appuyé
     */
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

    /**
     * MenuArrondissement appuyé
     */
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

    /**
     * BoutonSupprimer appuyé
     */
    public void BoutonSupprimer() {
        int ID;
        if ((ID = treeSelected()) != -2) {
            cc.supprimerComposante(ID);
        }
    }

    /**
     * MenuOuvrir appuyé
     */
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

    /**
     * MenuSauvegarder appuyé
     */
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

    /**
     * menuNouveau appuyé
     */
    public void menuNouveau() {
        cc.nouveauCircuit();
        arbre.update(cc.getCircuit());
    }

    /**
     * Permet d'avertir le controlleur qu'une compsante est sélectionnée dans l'arbre
     * @param ID ID de la composante sélectionnée
     */
    public void IDSelected(int ID) {
        frame.getPanelProp().setIDSelection(ID);
    }

    /**
     * Permet d'afficher une question, avec une entrée
     * @param texte Question à afficher
     * @param titre Titre de la fenêtre
     * @return la réponse de l'utilisateur
     */
    public String afficherOptionPane(String texte, String titre) {
        String input = (String) JOptionPane.showInputDialog(frame.getFrame(), texte, titre, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("java2sLogo.GIF"), null, "");
        return input;
    }
}
