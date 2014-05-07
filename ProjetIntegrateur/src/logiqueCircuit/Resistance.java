package logiqueCircuit;

import gestion.GestionnaireID;
import java.util.ArrayList;

public class Resistance implements Composante {

    private final int ID;
    private double ohm;
    private boolean isBurned = false;

    public Resistance(double ohm, int id) {
        ID = GestionnaireID.getInstance().ajouterComp(id);
        this.ohm = ohm;
    }

    public Resistance(double ohm) {
        ID = GestionnaireID.getInstance().ajouterComp();
        this.ohm = ohm;
    }

    public Resistance() {
        ID = GestionnaireID.getInstance().ajouterComp();
        ohm = -1;
    }

    public boolean isBurned() {
        return isBurned;
    }

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
