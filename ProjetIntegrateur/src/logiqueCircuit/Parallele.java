package logiqueCircuit;

import java.util.ArrayList;
import java.util.HashMap;

public class Parallele extends Branche implements Composante{
    
    HashMap<Integer, Serie> listeBranches;

    public Parallele() {
        super();
        listeBranches = new HashMap<>();
    }

    public Parallele(int ID) {
        super(ID);
        listeBranches = new HashMap<>();
    }
    
    @Override
    public void ajouterComposante(Composante c) {
        listeBranches.put(c.getNumero(), (Serie)c);
    }

    @Override
    public Type getType() {
        return Type.PARALLELE;
    }

    @Override
    public void supprimerComposante(Composante c) {
        listeBranches.remove(c.getNumero());
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

    @Override
    public Composante getComposante(int ID) {
        return listeBranches.get(ID);
    }
}