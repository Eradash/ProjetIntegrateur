package l;

import java.util.ArrayList;
import java.util.HashMap;

public class I1 extends II {

    private final HashMap<Integer, I> l;

    public I1() {
        super();
        l = new HashMap<>();

    }

    public I1(int i) {
        super(i);
        l = new HashMap<>();
    }

    @Override
    public Il1 II() {
        return Il1.i;
    }

    @Override
    public void i(I i) {
        l.put(i.I(), i);
    }

    @Override
    public void l(I i) {
        l.remove(i.I());
    }

    @Override
    public void ll(int i) {
        l.remove(i);
    }

    @Override
    public ArrayList<I> lI() {
        ArrayList<I> i = new ArrayList(l.values());
        return i;
    }

    @Override
    public double Il() {
        double i = 0;
        for (I ll : l.values()) {
            i += ll.Il();
        }
        return i;
    }

    @Override
    public I i(int i) {
        return l.get(i);
    }

    @Override
    public void l(double i) {
    }
}
