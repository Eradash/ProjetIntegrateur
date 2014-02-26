package gestion;

import java.util.ArrayList;

public class BD {
    
    private static volatile BD instance = null;
    private final static GestionnaireID gestionnaire = GestionnaireID.getInstance();
    
    /*
     * La deuxieme partie du hashmap:
     * 1- resistance de la composante
     * 2- amperage de la composante
     * 3- voltage de la composante
     */
    
    MapKKV<Integer, String, Integer> listeComposante = new MapKKV<>();
    
    private BD() {
        super();
    }
    
    public void SetComposante(int ID, String info, int donne) {
        listeComposante.put(ID, info, donne);
    }
    
    public boolean supprimerComposante(int ID) {
        if(gestionnaire.supprimerComp(ID)) {
//            listeComposante.remove(ID);
            return true;
        }
        return false;
    }
    
    public int getComposante(int ID, String info) {
        return listeComposante.get(ID, info);
    }
    
    public void resetCircuit() {
        gestionnaire.resetCircuit();
        listeComposante.clear();
    }
    
    public final static BD getInstance() {
        if(BD.instance == null) {
            synchronized(BD.class) {
                if(BD.instance == null) {
                    BD.instance = new BD();
                }
            }
        }
        return BD.instance;
    }
}
