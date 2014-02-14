package projetintegrateur;

import java.util.ArrayList;
import java.util.HashMap;

public class BD {
    
    private static volatile BD instance = null;
    
    /*
     **************************************************
     * Changer le 2ieme type de la map pour les infos *
     **************************************************
     */
    
    HashMap<Composante, Circuit> listeComposante = new HashMap<>();
    
    private BD() {
        super();
    }
    
    /*
     ***********************************
     * Ajouter les infos en paramettre *
     ***********************************
     */
    
    public void setComposante(int noComp, ArrayList<Integer> paramettre) {
        
    }
    
    /*
     ***********************************
     * Ajouter les infos a renvoyer    *
     ***********************************
     */
    
    public void getComposante(int noComp) {
        
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
