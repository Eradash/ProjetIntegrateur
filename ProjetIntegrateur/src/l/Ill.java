package l;

import gestion.GestionnaireID;
import java.util.ArrayList;

public class Ill implements I {

    private final int i;
    private double l;
    private boolean li = false;

    public Ill(double l, int il) {
        i = GestionnaireID.getInstance().ajouterComp(il);
        this.l = l;
    }

    public Ill(double l) {
        i = GestionnaireID.getInstance().ajouterComp();
        this.l = l;
    }

    public boolean il() {
        return li;
    }

    public void il(boolean i) {
        li = i;
    }

    @Override
    public int I() {
        return i;
    }

    @Override
    public Il1 II() {
        return Il1.li;
    }

    @Override
    public double Il() {
        return l;
    }

    @Override
    public ArrayList<I> lI() {
        return null;
    }

    @Override
    public I i(int i) {
        return null;
    }

    @Override
    public void l(double i) {
        l = i;
    }
}
