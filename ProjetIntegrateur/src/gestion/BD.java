package gestion;

import java.util.ArrayList;
import java.util.HashMap;

public class BD {
    
    private static volatile BD instance = null;
    private final static GestionnaireID gestionnaire = GestionnaireID.getInstance();
    
    /*
     * La deuxieme partie du hashmap:
     * 1- resistance de la composante
     * 2- amperage de la composante
     * 3- voltage de la composante
     */
    
    HashMap<Integer, ArrayList<Integer>> listeComposante = new HashMap<>();
    
    private BD() {
        super();
    }
    
    public void SetComposante(int ID, ArrayList<Integer> paramettre) {
        listeComposante.put(ID, paramettre);
    }
    
    public boolean supprimerComposante(int ID) {
        if(gestionnaire.supprimerComp(ID)) {
            listeComposante.remove(ID);
            return true;
        }
        return false;
    }
    
    public ArrayList<Integer> getComposante(int ID) {
        if(listeComposante.containsKey(ID))
            return listeComposante.get(ID);
        
        return null;
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
