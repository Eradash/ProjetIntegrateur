package gestion;

import affichage.ControlleurFrame;
import logiqueCircuit.Circuit;
import logiqueCircuit.I;

/**
 * Permet de controller un circuit électrique
 */
public class ControleurCircuit {

    private final BD donnee = BD.getInstance();
    private final AnalyseurCircuit analyseur = new AnalyseurCircuit();
    private final static GestionXML xml = GestionXML.getInstance();
    private ControlleurFrame cf;

    private Circuit c;

    /**
     * Indique le Controlleur à communiquer pour les évènements
     * @param cf
     */
    public void setCF(ControlleurFrame cf) {
        this.cf = cf;
    }

    /**
     * Permet de créer un nouveau circuit. Réinitialise tous les gestionnaires et ferme le circuit présentement ouvert.
     */
    public void nouveauCircuit() {
        donnee.resetCircuit();
        c = new Circuit();
        run();
    }

    /**
     * Permet d'ouvrir un circuit à partir d'un fichier
     * @param endroit Endroit du fichier
     */
    public void ouvrirCircuit(String endroit) {
        c = xml.decoder(endroit);
        run();
    }

    /**
     * Permet d'enregistrer le circuit vers un fichier
     * @param endroit Endroit où enregistrer le fichier
     */
    public void enregistrerCircuit(String endroit) {
        xml.encoder(c, endroit);
    }

    /**
     * Permet d'avoir le circuit présentement ouvert
     * @return Le circuit présentement ouvert
     */
    public Circuit getCircuit() {
        return c;
    }

    /**
     * Permet d'ajouter une composante à un endroit précis du circuit
     * @param c I à ajouter
     * @param emplacement ID du parent où ajouter la nouvelle composante
     */
    public void ajouterComposante(I c, int emplacement) {
        this.c.ajouterComposante(c, emplacement);
        System.out.println("Composante ajoutée");
        run();
    }

    /**
     * Permet de supprimer une composante du circuit. Efface aussi toutes les données relatives à la composante de la BD et du Gestionnaire ID
     * @param ID ID de la composante à effacer
     */
    public void supprimerComposante(int ID) {
        this.c.ll(ID);
        donnee.supprimerComposante(ID);
        run();
    }

    /**
     * Permet de l une composante précise du circuit (Résistance ou voltage de la pile). Appelle la fonction 'l' de la composante en question.
     * @param ID ID de la composante à l
     * @param newValue Nouvelle valeur de la composnte
     */
    public void modifierComposante(int ID, double newValue) {
        c.modifierComposante(ID, newValue);
        run();
    }

    /**
     * Permet de lancer une analyse du circuit (voir 'analyserCircuit' du AnalyseurCircuit) et d'updater l'affichage
     */
    public void run() {
        analyseur.analyserCircuit(c);
        cf.update();
    }
}