package gestion;

import java.util.HashMap;

/**
 * Permet de ranger toutes les informations sur les composantes
 */
public class BD {

    private static volatile BD instance = null;
    private final static GestionnaireID gestionnaire = GestionnaireID.getInstance();

    private final MultiMap<Integer, String, Double> listeComposante;

    private BD() {
        super();
        listeComposante = new MultiMap<>();
    }

    /**
     * Permet de ajouter/modifier une information sur une composante
     * @param ID ID de la composante à modifier
     * @param info Information de la composante à modifier
     * @param donne Valeur de l'information
     */
    public void SetComposante(int ID, String info, double donne) {
        listeComposante.put(ID, info, donne);
        gestionnaire.ajouterComp(ID);
    }

    /**
     * Permet de supprimer une composante de la BD
     * @param ID ID de la composante à supprimer
     */
    public void supprimerComposante(int ID) {
        if (gestionnaire.supprimerComp(ID)) {
            listeComposante.removeX(ID);
        }
    }

    /**
     * Permet d'avoir une information sur une composante
     * @param ID ID de la composante
     * @param info Information recherchée
     * @return Valeur de l'information (Double)
     */
    public Double getComposante(int ID, String info) {
        return listeComposante.get(ID, info);
    }

    /**
     * Permet d'avoir une liste des informations sur une composante
     * @param ID ID de la composante recherchée
     * @return HashMap d'informations
     */
    public HashMap<String, Double> getComposante(int ID) {
        return listeComposante.getLigne(ID);
    }

    /**
     * Permet de remettre la BD à 0
     */
    public void resetCircuit() {
        gestionnaire.resetCircuit();
        listeComposante.clear();
        gestionnaire.resetCircuit();
    }

    /**
     * Permet d'avoir l'instance de la BD (Singloton)
     * @return l'instance de la BD
     */
    public final static BD getInstance() {
        if (BD.instance == null) {
            synchronized (BD.class) {
                if (BD.instance == null) {
                    BD.instance = new BD();
                }
            }
        }
        return BD.instance;
    }
}
