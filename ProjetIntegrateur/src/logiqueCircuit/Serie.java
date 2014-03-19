package logiqueCircuit;

import java.util.ArrayList;
import java.util.HashMap;


public class Serie extends Branche implements Composante{
    
    HashMap<Integer, Composante> listeComposante;

    @Override
    public Type getType() {
        return Type.SERIE;
    }
    
    @Override
    public void ajouterComposante(Composante c) {
        listeComposante.put(c.getNumero(), c);
    }

    @Override
    public void supprimerComposante(Composante c) {
        listeComposante.remove(c.getNumero());
    }
    
    @Override
    public ArrayList<Composante> getComposantes(){
        return (ArrayList)listeComposante.values();
    }

    @Override
    public double getResistanceEquivalente() {
        double resistance = 0;
        for(Composante c : getComposantes()){
            resistance += c.getResistanceEquivalente();
        }
        return resistance;
    }
}
