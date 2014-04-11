package affichage;

import java.util.HashMap;

public class ControlleurBouton {
    
    HashMap<String, Boolean> typeBouton;
    final HashMap<String, Boolean> typeBoutonFalse;
    
    public ControlleurBouton() {
        typeBouton = new HashMap<>();
        typeBoutonFalse = new HashMap<>();
        
        typeBouton.put("fil", Boolean.FALSE);
        typeBouton.put("resistance", Boolean.FALSE);
        typeBouton.put("parallele", Boolean.FALSE);
        
        typeBoutonFalse.putAll(typeBouton);
    }
    
    public void selectionnerOutil(String nomOutil) {
        typeBouton.putAll(typeBoutonFalse);
        typeBouton.put(nomOutil, Boolean.TRUE);
    }
}
