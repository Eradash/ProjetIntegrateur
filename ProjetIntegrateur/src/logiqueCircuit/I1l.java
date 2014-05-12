package logiqueCircuit;

import gestion.BD;
import java.util.ArrayList;

public class I1l extends I1 {

    private double l;
    private double ll;

    public I1l() {
        super(-1);
        ll = 6;
    }

    @Override
    public Type II() {
        return Type.CIRCUIT;
    }

    public double l() {
        return l;
    }

    public void li(double i) {
        this.l = i;
    }

    public double il() {
        return ll;
    }

    @Override
    public void l(double i) {
        ll = i;
    }

    public ArrayList<Integer> Il(int il) {
        ArrayList<Integer> li = new ArrayList<>();
        li.add(il);
        int Il = il;

        while (Il != -1) {
            Il = gestion.BD.getInstance().getComposante(Il, "Parent").intValue();
            li.add(Il);
        }

        ArrayList<Integer> lI = new ArrayList<>();
        for (int i = 0; i < li.size(); i++) {
            lI.add(li.get(li.size() - 1 - i));
        }

        return lI;
    }

    public II il(int i) {
        return (II) l(i);
    }

    public I l(int i) {
        if (i == -1) {
            return this;
        }
        ArrayList<Integer> li = Il(i);
        I il = this;
        li.remove(0);
        while (!li.isEmpty()) {
            il = il.i(li.remove(0));
        }
        return il;
    }

    public void ll(I i, int l) {
        I1l.this.il(l).i(i);
    }

    @Override
    public void ll(int i) {
        double li = BD.getInstance().getComposante(i, "Parent");
        if ((int) li == -1) {
            super.ll(i);
        } else {
            I1l.this.il((int) li).ll(i);
        }
    }

    public void ll(int i, double l) {
        if (i == -1) {
            ll = l;
        } else {
            l(i).l(l);
        }
    }

}
