package gestion;

import java.util.ArrayList;

/**
 * Permet de gérer la distribution des ID
 */
public class GestionnaireID {

    private static volatile GestionnaireID instance = null;
    private final ArrayList<Integer> ID;

    private GestionnaireID() {
        super();
        ID = new ArrayList<>();
    }

    /**
     * Permet d'avoir l'instance du Gestionnaire d'ID (Singloton)
     * @return l'instance du Gestionnaire d'ID
     */
    public static final GestionnaireID getInstance() {
        if (GestionnaireID.instance == null) {
            synchronized (GestionnaireID.class) {
                if (GestionnaireID.instance == null) {
                    instance = new GestionnaireID();
                }
            }
        }
        return instance;
    }

    /**
     * Permet de libérer une valeur d'ID non utilisée. Fonction appelée quand une composante est supprimée
     * @param noComp ID de la composante supprimée
     * @return True si réussi, False si échoué
     */
    public boolean supprimerComp(int noComp) {
        if (ID.contains(noComp)) {
            ID.remove(noComp);
            return true;
        }
        return false;
    }

    /**
     * Permet de libérer toutes les valeurs d'ID
     */
    public void resetCircuit() {
        ID.clear();
    }

    /**
     * Permet de distribuer une valeur d'ID non utilisée jusqu'à présent
     * @return ID
     */
    public synchronized int ajouterComp() {
        int i = 1;
        while (true) {
            if (ID.contains(i)) {
                i++;
            } else {
                break;
            }
        }
        return i;
    }

    /**
     * Permet d'ajouter manuellement un ID utilisé
     * @param id ID à ajouter manuellement
     * @return l'ID ajouté
     */
    public synchronized int ajouterComp(int id) {
        ID.add(id);

        return id;
    }
}
