package logiqueCircuit;

import java.util.ArrayList;
import java.util.HashMap;

public class II extends I1 {

    private final HashMap<Integer, I> I;

    public II() {
        super();
        I = new HashMap<>();
    }

    public II(int I1) {
        super(I1);
        I = new HashMap<>();
    }

    @Override
    public I1I I1() {
        return I1I.III;
    }

    @Override
    public void I(I I1) {
        I.put(I1.I(), I1);
    }

    @Override
    public void I1(I I1) {
        I.remove(I1.I());
    }

    @Override
    public void I1(int I1) {
        I.remove(I1);
    }

    @Override
    public ArrayList<I> III() {
        ArrayList<I> I1 = new ArrayList(I.values());
        return I1;
    }

    @Override
    public double II() {
        double I1 = 0;
        for (I II : I.values()) {
            I1 += II.II();
        }
        return I1;
    }

    @Override
    public I I(int I1) {
        return I.get(I1);
    }

    @Override
    public void I(double I) {
    }
}
