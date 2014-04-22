package affichage;

import java.util.HashMap;

public class ControlleurBouton {
    
    HashMap<Integer, Boolean> typeBouton;
    final HashMap<Integer, Boolean> typeBoutonFalse;
    private static volatile ControlleurBouton instance = null;
    public final int AUCUN = 0;
    public final int FIL = 1;
    public final int RESISTANCE = 2;
    public final int PARALLELE = 3;
    
    private ControlleurBouton() {
        typeBouton = new HashMap<>();
        typeBoutonFalse = new HashMap<>();
        
        typeBouton.put(AUCUN, Boolean.FALSE);
        typeBouton.put(FIL, Boolean.FALSE);
        typeBouton.put(RESISTANCE, Boolean.FALSE);
        typeBouton.put(PARALLELE, Boolean.FALSE);
        
        typeBoutonFalse.putAll(typeBouton);
    }
    
    public void selectionnerOutil(int nomOutil) {
        typeBouton.putAll(typeBoutonFalse);
        typeBouton.put(nomOutil, Boolean.TRUE);
    }
    
    public int getOutil() {
        int i = 0;
        while (!typeBouton.get(i)) {
            i++;
        }
        return i;
    }
    
    public final static ControlleurBouton getInstance() {
        if(instance == null) {
            synchronized (ControlleurBouton.class) {
                if(instance == null) {
                    ControlleurBouton.instance = new ControlleurBouton();
                }
            }
        }
        return instance;
    }
}
