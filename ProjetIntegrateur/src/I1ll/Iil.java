package I1ll;

import java.util.HashMap;

public class Iil {

    private static volatile Iil i = null;
    private final static Ili l = Ili.il();

    private final Ii1<Integer, String, Double> ll;

    private Iil() {
        super();
        ll = new Ii1<>();
    }

    public void il(int i, String li, double il) {
        ll.put(i, li, il);
        l.l(i);
    }

    public void il(int i) {
        if (l.il(i)) {
            ll.il(i);
        }
    }

    public Double il(int i, String li) {
        return ll.il(i, li);
    }

    public HashMap<String, Double> ll(int i) {
        return ll.l(i);
    }

    public void il() {
        l.ll();
        ll.clear();
        l.ll();
    }

    public final static Iil ll() {
        if (Iil.i == null) {
            synchronized (Iil.class) {
                if (Iil.i == null) {
                    Iil.i = new Iil();
                }
            }
        }
        return Iil.i;
    }
}
