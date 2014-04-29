package gestion;

import java.util.ArrayList;

public class GestionnaireID {
    
    private static volatile GestionnaireID instance = null;
    private ArrayList<Integer> ID;
    
    private GestionnaireID() {
        super();
        ID = new ArrayList<>();
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
    
    public synchronized int ajouterComp() {
        int i = 1;
        for(Integer in : ID){
            if(i == in){
                i++;
            } else {
                break;
            }
        }
        return i;
    }
    
    public synchronized int ajouterComp(int id) {
        ID.add(id);
        
        return id;
    }
}