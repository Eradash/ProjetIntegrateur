package gestion;

import java.util.ArrayList;

public class GestionnaireID {
    
    private static volatile GestionnaireID instance = null;
    private ArrayList<Integer> ID;
    
    private GestionnaireID() {
        super();
    }
    
    public static final GestionnaireID getInstance() {
        if(GestionnaireID.instance == null) {
            synchronized(GestionnaireID.class) {
                if(GestionnaireID.instance == null) {
                    instance = new GestionnaireID();
                }
            }
        }
        return instance;
    }
    
    public boolean supprimerComp(int noComp) {
        if(ID.contains(noComp)) {
            ID.remove(noComp);
            return true;
        }
        return false;
    }
    
    public void resetCircuit() {
        ID.clear();
    }
    
    /*
     * Créer une classe exception pour gérer le nbr d'acces
     */
    
    public int ajouterComp() {
        int i = 0;
        
        while (!ID.contains(i)){
            ID.add(i);
            i++;
        }
        
        return i;
    }
}
