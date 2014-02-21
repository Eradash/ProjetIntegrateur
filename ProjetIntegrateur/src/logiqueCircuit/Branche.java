package logiqueCircuit;

import java.util.ArrayList;

public abstract class Branche implements Composante{
    
    int numero;
    
    @Override
    public int getNumero(){
        return numero;
    }
    
    public abstract void ajouterComposante(Composante c, int noComp);
    public abstract void supprimerComposante(Composante c);
    public abstract ArrayList<Composante> getComposantes();
}