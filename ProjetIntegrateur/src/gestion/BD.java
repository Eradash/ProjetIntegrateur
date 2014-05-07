package gestion;

import java.util.HashMap;

public class BD {

    private static volatile BD instance = null;
    private final static GestionnaireID gestionnaire = GestionnaireID.getInstance();

    private final MultiMap<Integer, String, Double> listeComposante;

    private BD() {
        super();
        listeComposante = new MultiMap<>();
    }

    public void SetComposante(int ID, String info, double donne) {
        listeComposante.put(ID, info, donne);
        gestionnaire.ajouterComp(ID);
    }

    public boolean supprimerComposante(int ID) {
        if (gestionnaire.supprimerComp(ID)) {
            listeComposante.removeID(ID);
            return true;
        }
        return false;
    }

    public Double getComposante(int ID, String info) {
        return listeComposante.get(ID, info);
    }

    public HashMap<String, Double> getComposante(int ID) {
        return listeComposante.getComp(ID);
    }

    public void resetCircuit() {
        gestionnaire.resetCircuit();
        listeComposante.clear();
        gestionnaire.resetCircuit();
    }

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
