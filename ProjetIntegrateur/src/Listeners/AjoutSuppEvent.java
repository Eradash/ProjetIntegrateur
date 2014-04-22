package Listeners;

import logiqueCircuit.Type;

public class AjoutSuppEvent{
    
    public final Type type;
    public final int ID;
    public final boolean ajout;
    
    public AjoutSuppEvent(Type type, int ID, boolean ajout){
        this.type = type;
        this.ID = ID;
        this.ajout = ajout;
    }

    public Type getType() {
        return type;
    }

    public int getID() {
        return ID;
    }

    public boolean isAjout() {
        return ajout;
    }
}