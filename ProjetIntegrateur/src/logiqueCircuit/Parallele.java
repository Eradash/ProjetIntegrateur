package logiqueCircuit;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Parallele
 */
public class Parallele extends Branche implements I {

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
    public void ajouterComposante(I c) {
        listeBranches.put(c.I(), (Serie) c);
    }

    @Override
    public Type II() {
        return Type.PARALLELE;
    }

    @Override
    public void supprimerComposante(I c) {
        listeBranches.remove(c.I());
    }

    @Override
    public void supprimerComposante(int ID) {
        listeBranches.remove(ID);
    }

    @Override
    public double Il() {
        double resistance = 0;
        for (Serie s : listeBranches.values()) {
            resistance += 1 / s.Il();
        }
        return 1 / resistance;
    }

    @Override
    public ArrayList<I> lI() {
        ArrayList liste = new ArrayList(listeBranches.values());
        return liste;
    }

    @Override
    public I i(int ID) {
        return listeBranches.get(ID);
    }

    @Override
    public void l(double newValue) {
    }
}
