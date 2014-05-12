package logiqueCircuit;

import gestion.GestionnaireID;
import java.util.ArrayList;

public class II1 implements I {

    private final int I;
    private double I1;
    private boolean II = false;

    public II1(double I1, int II) {
        I = GestionnaireID.getInstance().ajouterComp(II);
        this.I1 = I1;
    }

    public II1(double I1) {
        I = GestionnaireID.getInstance().ajouterComp();
        this.I1 = I1;
    }

    public boolean II1() {
        return II;
    }

    public void I(boolean I) {
        II = I;
    }

    @Override
    public int I() {
        return I;
    }

    @Override
    public I1I I1() {
        return I1I.I11;
    }

    @Override
    public double II() {
        return I1;
    }

    @Override
    public ArrayList<I> III() {
        return null;
    }

    @Override
    public I I(int I) {
        return null;
    }

    @Override
    public void I(double I) {
        I1 = I;
    }
}
