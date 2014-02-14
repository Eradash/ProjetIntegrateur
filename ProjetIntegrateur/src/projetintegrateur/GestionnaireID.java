package projetintegrateur;

import java.util.ArrayList;

public class GestionnaireID {
    
    private static volatile GestionnaireID instance = null;
    private ArrayList<Integer> ID;
    private int nbrAcces = 0;
    
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
    
    /*
     * Créer une classe exception pour gérer le nbr d'acces
     */
    
    public int ajouterComp() {
        nbrAcces++;
        int i = 0;
        
        while (!ID.contains(i)){
            i++;
        }
        
        return i;
    }
}
