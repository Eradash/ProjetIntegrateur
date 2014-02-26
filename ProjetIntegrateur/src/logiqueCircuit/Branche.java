package logiqueCircuit;

import gestion.GestionnaireID;
import java.util.ArrayList;

public abstract class Branche implements Composante{
    
    final int ID;

    public Branche() {
        ID = GestionnaireID.getInstance().ajouterComp();
    }
    
    @Override
    public int getNumero(){
        return ID;
    }
    
    public abstract void ajouterComposante(Composante c, int noComp);
    public abstract void supprimerComposante(Composante c);
    public abstract ArrayList<Composante> getComposantes();
}