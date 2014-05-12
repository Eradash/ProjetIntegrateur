package logiqueCircuit;

import java.util.ArrayList;
import java.util.HashMap;

public class Il extends II implements I {

    private final HashMap<Integer, I1> i;

    public Il() {
        super();
        i = new HashMap<>();
    }

    public Il(int I) {
        super(I);
        i = new HashMap<>();
    }

    @Override
    public void i(I l) {
        i.put(l.I(), (I1) l);
    }

    @Override
    public Il1 II() {
        return Il1.l;
    }

    @Override
    public void l(I l) {
        i.remove(l.I());
    }

    @Override
    public void ll(int l) {
        i.remove(l);
    }

    @Override
    public double Il() {
        double l = 0;
        for (I1 ll : i.values()) {
            l += 1 / ll.Il();
        }
        return 1 / l;
    }

    @Override
    public ArrayList<I> lI() {
        ArrayList Il = new ArrayList(i.values());
        return Il;
    }

    @Override
    public I i(int l) {
        return i.get(l);
    }

    @Override
    public void l(double i) {
    }
}
