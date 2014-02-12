package projetintegrateur;

import java.util.ArrayList;

public abstract class Branche implements Composante{
    
    int numero;
    ArrayList<ArrayList<Composante>> listeDeComposantes;
    
    @Override
    public int getNumero(){
        return numero;
    }
}