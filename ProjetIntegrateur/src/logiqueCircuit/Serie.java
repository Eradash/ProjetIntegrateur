package logiqueCircuit;

import java.util.ArrayList;


public class Serie extends Branche implements Composante{
    
    ArrayList<Composante> listeComposante;

    @Override
    public Type getType() {
        return Type.SERIE;
    }

    @Override
    public void ajouterComposante(Composante c, int noCOmp) {

    }

    @Override
    public void supprimerComposante(Composante c) {
    }
    
    @Override
    public ArrayList<Composante> getComposantes(){
        return listeComposante;
    }

    @Override
    public double getResistanceEquivalente() {
        double resistance = 0;
        for(Composante c : listeComposante){
            resistance += c.getResistanceEquivalente();
        }
        return resistance;
    }
}
