package logiqueCircuit;

import gestion.GestionnaireID;
import java.util.ArrayList;

/**
 * Résistance d'un circuit électrique
 */
public class Resistance implements Composante {

    private final int ID;
    private double ohm;
    private boolean isBurned = false;

    /**
     * Permet de créer une résistance avec un ID prédéfini
     * @param ohm Résistance
     * @param id ID prédéfini
     */
    public Resistance(double ohm, int id) {
        ID = GestionnaireID.getInstance().ajouterComp(id);
        this.ohm = ohm;
    }

    /**
     * Permet de créer une résistance
     * @param ohm Résistance
     */
    public Resistance(double ohm) {
        ID = GestionnaireID.getInstance().ajouterComp();
        this.ohm = ohm;
    }

    /**
     * Permet de créer une résistance vide...
     */
    public Resistance() {
        ID = GestionnaireID.getInstance().ajouterComp();
        ohm = -1;
    }

    /**
     * Permet de savoir si la résistance est brulée
     * @return
     */
    public boolean isBurned() {
        return isBurned;
    }

    /**
     * Permet d'ajuster l'état brulée de la résistance
     * @param burn True = Brulée, False = pas brulée..
     */
    public void setBurned(boolean burn) {
        isBurned = burn;
    }

    @Override
    public int getNumero() {
        return ID;
    }

    @Override
    public Type getType() {
        return Type.RESISTANCE;
    }

    @Override
    public double getResistanceEquivalente() {
        return ohm;
    }

    @Override
    public ArrayList<Composante> getComposantes() {
        return null;
    }

    @Override
    public Composante getComposante(int ID) {
        return null;
    }

    @Override
    public void modifier(double newValue) {
        ohm = newValue;
    }
}
