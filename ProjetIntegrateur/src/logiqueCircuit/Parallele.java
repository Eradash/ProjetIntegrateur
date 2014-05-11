package logiqueCircuit;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Parallele
 */
public class Parallele extends Branche implements Composante {

    private final HashMap<Integer, Serie> listeBranches;

    /**
     * Constructeur par défaut... Initialise les composantes
     * Voir constructeur Branche
     */
    public Parallele() {
        super();
        listeBranches = new HashMap<>();
    }

    /**
     * Voir constructeur Branche
     * @param ID
     */
    public Parallele(int ID) {
        super(ID);
        listeBranches = new HashMap<>();
    }

    @Override
    public void ajouterComposante(Composante c) {
        listeBranches.put(c.getNumero(), (Serie) c);
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
    public void supprimerComposante(int ID) {
        listeBranches.remove(ID);
    }

    @Override
    public double getResistanceEquivalente() {
        double resistance = 0;
        for (Serie s : listeBranches.values()) {
            resistance += 1 / s.getResistanceEquivalente();
        }
        return 1 / resistance;
    }

    @Override
    public ArrayList<Composante> getComposantes() {
        ArrayList liste = new ArrayList(listeBranches.values());
        return liste;
    }

    @Override
    public Composante getComposante(int ID) {
        return listeBranches.get(ID);
    }

    @Override
    public void modifier(double newValue) {
    }
}
