package projetintegrateur;

import java.util.ArrayList;
import java.util.HashMap;

public class BD {
    
    private static volatile BD instance = null;
    
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
    
    public boolean setComposante(int noComp, ArrayList<Integer> paramettre) {
        if(listeComposante.containsKey(noComp)) {
            listeComposante.remove(noComp);
            listeComposante.put(noComp, paramettre);
            return true;
        }
        return false;
    }
    
    public ArrayList<Integer> getComposante(int noComp) {
        if(listeComposante.containsKey(noComp))
            return listeComposante.get(noComp);
        
        return null;
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
