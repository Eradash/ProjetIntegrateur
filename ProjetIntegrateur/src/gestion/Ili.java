package gestion;

import java.util.ArrayList;

public class Ili {

    private static volatile Ili l = null;
    private final ArrayList<Integer> ll;

    private Ili() {
        super();
        ll = new ArrayList<>();
    }

    public static final Ili il() {
        if (Ili.l == null) {
            synchronized (Ili.class) {
                if (Ili.l == null) {
                    l = new Ili();
                }
            }
        }
        return l;
    }

    public boolean il(int noComp) {
        if (ll.contains(noComp)) {
            ll.remove(noComp);
            return true;
        }
        return false;
    }

    public void ll() {
        ll.clear();
    }

    public synchronized int l() {
        int i = 1;
        while (true) {
            if (ll.contains(i)) {
                i++;
            } else {
                break;
            }
        }
        return i;
    }

    public synchronized int l(int id) {
        ll.add(id);
        return id;
    }
}
