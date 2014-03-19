package logiqueCircuit;

import gestion.GestionnaireID;
import java.util.ArrayList;

public abstract class Branche implements Composante{
    
    final int ID;

    public Branche() {
        ID = GestionnaireID.getInstance().ajouterComp();
    }
    
    /*
     * Ajouter les ID au gestionnaireID
     */
    public Branche(int ID){
        this.ID = ID;
    }
    
    @Override
    public int getNumero(){
        return ID;
    }
    
    public abstract void ajouterComposante(Composante c);
    public abstract void supprimerComposante(Composante c);
    @Override
    public abstract ArrayList<Composante> getComposantes();
}