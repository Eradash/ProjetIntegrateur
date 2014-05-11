package logiqueCircuit;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Série d'un circuit. Principalement utilisé pour les paralèles, et le circuit
 */
public class Serie extends Branche {

    private final HashMap<Integer, I> listeComposante;

    /**
     * Constructeur par défaut.
     * Voir Branche
     */
    public Serie() {
        super();
        listeComposante = new HashMap<>();

    }

    /**
     * Créer un Série avec un ID Prédifini
     * @param ID ID Prédéfini
     */
    public Serie(int ID) {
        super(ID);
        listeComposante = new HashMap<>();
    }

    @Override
    public Type II() {
        return Type.SERIE;
    }

    @Override
    public void ajouterComposante(I c) {
        listeComposante.put(c.I(), c);
    }

    @Override
    public void supprimerComposante(I c) {
        listeComposante.remove(c.I());
    }

    @Override
    public void supprimerComposante(int ID) {
        listeComposante.remove(ID);
    }

    @Override
    public ArrayList<I> lI() {
        ArrayList<I> liste = new ArrayList(listeComposante.values());
        return liste;
    }

    @Override
    public double Il() {
        double resistance = 0;
        for (I c : listeComposante.values()) {
            resistance += c.Il();
        }
        return resistance;
    }

    @Override
    public I i(int ID) {
        return listeComposante.get(ID);
    }

    @Override
    public void l(double newValue) {
    }
}
