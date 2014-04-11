package logiqueCircuit;

import java.util.ArrayList;
import java.util.HashMap;


public class Serie extends Branche{
    
    HashMap<Integer, Composante> listeComposante;

    public Serie() {
        super();
        listeComposante = new HashMap<>();

    }

    public Serie(int ID) {
        super(ID);
        listeComposante = new HashMap<>();
    }

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
        ArrayList<Composante> liste = new ArrayList(listeComposante.values());
        return liste;
    }

    @Override
    public double getResistanceEquivalente() {
        double resistance = 0;
        for(Composante c : listeComposante.values()){
            resistance += c.getResistanceEquivalente();
        }
        return resistance;
    }

    @Override
    public Composante getComposante(int ID) {
        return listeComposante.get(ID);
    }
}
