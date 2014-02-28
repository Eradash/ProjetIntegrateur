package logiqueCircuit;

import java.util.ArrayList;

public class Parallele extends Branche{
    
    ArrayList<Serie> listeBranches;

    @Override
    public void ajouterComposante(Composante c) {

    }

    @Override
    public Type getType() {
        return Type.PARALELLE;
    }

    @Override
    public void supprimerComposante(Composante c) {
    }

    @Override
    public double getResistanceEquivalente() {
        double resistance = 0;
        for(Serie s : listeBranches){
            resistance += 1 / s.getResistanceEquivalente();
        }
        return 1/resistance;
    }

    @Override
    public ArrayList<Composante> getComposantes() {
        ArrayList<Composante> liste = new ArrayList<>();
        liste.addAll(listeBranches);
        return liste;
    }
}