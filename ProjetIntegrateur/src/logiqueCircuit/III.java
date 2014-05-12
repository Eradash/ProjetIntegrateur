package logiqueCircuit;

import java.util.ArrayList;
import java.util.HashMap;

public class III extends I1 implements I {

    private final HashMap<Integer, II> I;

    public III() {
        super();
        I = new HashMap<>();
    }
    public III(int I1) {
        super(I1);
        I = new HashMap<>();
    }
    @Override
    public void I(I I1) {
        I.put(I1.I(), (II) I1);
    }
    @Override
    public I1I I1() {
        return I1I.II1;
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
    public double II() {
        double I1 = 0;
        for (II II : I.values()) {
            I1 += 1 / II.II();
        }
        return 1 / I1;
    }
    @Override
    public ArrayList<I> III() {
        ArrayList I1 = new ArrayList(I.values());
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
