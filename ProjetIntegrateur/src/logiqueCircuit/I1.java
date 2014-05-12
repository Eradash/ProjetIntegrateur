package logiqueCircuit;

import gestion.GestionnaireID;
import java.util.ArrayList;

public abstract class I1 implements I {

    private final int I;

    public I1() {
        I = GestionnaireID.getInstance().ajouterComp();
    }

    public I1(int I1) {
        I = GestionnaireID.getInstance().ajouterComp(I1);
    }

    @Override
    public int I() {
        return I;
    }

    @Override
    public abstract ArrayList<I> III();

    public abstract void I(I c);

    public abstract void I1(I c);

    public abstract void I1(int ID);
}