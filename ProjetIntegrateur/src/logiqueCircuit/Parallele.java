package logiqueCircuit;

import java.util.ArrayList;
import java.util.HashMap;

public class Parallele extends Branche implements Composante{
    
    HashMap<Integer, Serie> listeBranches;

    @Override
    public void ajouterComposante(Composante c) {
        listeBranches.put(c.getNumero(), (Serie)c);
    }

    @Override
    public Type getType() {
        return Type.PARALELLE;
    }

    @Override
    public void supprimerComposante(Composante c) {
<<<<<<< HEAD
        
=======
        listeBranches.remove(c.getNumero());
>>>>>>> Travail-sur-AjoutComposante
    }

    @Override
    public double getResistanceEquivalente() {
        double resistance = 0;
        for(Serie s : listeBranches.values()){
            resistance += 1 / s.getResistanceEquivalente();
        }
        return 1/resistance;
    }

    @Override
    public ArrayList<Composante> getComposantes() {
        return (ArrayList)listeBranches.values();
    }
}