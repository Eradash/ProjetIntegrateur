package logiqueCircuit;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Série d'un circuit. Principalement utilisé pour les paralèles, et le circuit
 */
public class Serie extends Branche {

    private final HashMap<Integer, Composante> listeComposante;

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
    public void supprimerComposante(int ID) {
        listeComposante.remove(ID);
    }

    @Override
    public ArrayList<Composante> getComposantes() {
        ArrayList<Composante> liste = new ArrayList(listeComposante.values());
        return liste;
    }

    @Override
    public double getResistanceEquivalente() {
        double resistance = 0;
        for (Composante c : listeComposante.values()) {
            resistance += c.getResistanceEquivalente();
        }
        return resistance;
    }

    @Override
    public Composante getComposante(int ID) {
        return listeComposante.get(ID);
    }

    @Override
    public void modifier(double newValue) {
    }
}
