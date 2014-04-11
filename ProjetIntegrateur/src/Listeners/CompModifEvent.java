package Listeners;

public class CompModifEvent{
    
    public final int ID_COMP;
    public final float ANCIENNE_VALEUR;
    public final float NOUVELLE_VALEUR;
    public final String TYPE_VALEUR;

    public CompModifEvent(int ID_COMP, float ANCIENNE_VALEUR, float NOUVELLE_VALEUR, String TYPE_VALEUR) {
        this.ID_COMP = ID_COMP;
        this.ANCIENNE_VALEUR = ANCIENNE_VALEUR;
        this.NOUVELLE_VALEUR = NOUVELLE_VALEUR;
        this.TYPE_VALEUR = TYPE_VALEUR;
    }

    public int getID_COMP() {
        return ID_COMP;
    }

    public float getANCIENNE_VALEUR() {
        return ANCIENNE_VALEUR;
    }

    public float getNOUVELLE_VALEUR() {
        return NOUVELLE_VALEUR;
    }

    public String getTYPE_VALEUR() {
        return TYPE_VALEUR;
    }
}