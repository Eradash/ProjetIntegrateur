package gestion;

import affichage.ControlleurFrame;
import logiqueCircuit.Circuit;
import logiqueCircuit.Composante;

public class ControleurCircuit {

    private final BD donnee = BD.getInstance();
    private final AnalyseurCircuit analyseur = new AnalyseurCircuit();
    private final static GestionXML xml = GestionXML.getInstance();
    private ControlleurFrame cf;

    Circuit c;

    public ControleurCircuit() {
    }

    public void setCF(ControlleurFrame cf) {
        this.cf = cf;
    }

    public void nouveauCircuit() {
        donnee.resetCircuit();
        c = new Circuit();
        run();
    }

    public void fermeCircuit() {
        donnee.resetCircuit();
        c = null;
    }

    public void ouvrirCircuit(String nom) {
        c = xml.decoder(nom);
        run();
    }

    public void enregistrerCircuit(String endroit) {
        xml.encoder(c, endroit);
    }

    public Circuit getCircuit() {
        return c;
    }

    public void ajouterComposante(Composante c, int emplacement) {
        this.c.ajouterComposante(c, emplacement);
        System.out.println("Composante ajoutée");
        run();
    }

    public void supprimerComposante(int ID) {
        this.c.supprimerComposante(ID);
        run();
    }

    public void modifierComposante(int ID, double newValue) {
        c.modifierComposante(ID, newValue);
        run();
    }

    public void run() {
        analyseur.analyserCircuit(c);
        cf.update();

    }

    public BD getInstanceBD() {
        return BD.getInstance();
    }
}
