package gestion;

import java.util.HashMap;
import java.util.Iterator;

public class MultiMap<ID, PARAM, VALEUR> extends HashMap<PARAM, HashMap<ID, VALEUR>> {

    public VALEUR get(ID k, PARAM k1) {
        return super.get(k1).get(k);
    }

    public VALEUR put(ID k, PARAM k1, VALEUR v) {
        if (!super.containsKey(k1)) {
            super.put(k1, new HashMap<ID, VALEUR>());
        }
        return super.get(k1).put(k, v);
    }

    public void removeID(ID cle) {
        for (PARAM k1 : super.keySet()) {
            super.get(k1).remove(cle);
        }
    }

    public HashMap<PARAM, VALEUR> getComp(ID id) {

        HashMap<PARAM, VALEUR> composante = new HashMap<>();

        Iterator<PARAM> iterator = super.keySet().iterator();

        while (iterator.hasNext()) {
            PARAM p = iterator.next();
            composante.put(p, super.get(p).get(id));
        }
        return composante;
    }
}
