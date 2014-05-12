package I1ll;

import java.util.HashMap;
import java.util.Iterator;

public class Ii1<i, l, ll> extends HashMap<l, HashMap<i, ll>> {

    public ll il(i l, l i) {
        return super.get(i).get(l);
    }

    public ll put(i l, l i, ll ll) {
        if (!super.containsKey(i)) {
            super.put(i, new HashMap<i, ll>());
        }
        return super.get(i).put(l, ll);
    }

    public void il(i l) {
        for (l i : super.keySet()) {
            super.get(i).remove(l);
        }
    }

    public HashMap<l, ll> l(i l) {
        HashMap<l, ll> ll = new HashMap<>();
        Iterator<l> i = super.keySet().iterator();
        while (i.hasNext()) {
            l p = i.next();
            ll.put(p, super.get(p).get(l));
        }
        return ll;
    }
}
