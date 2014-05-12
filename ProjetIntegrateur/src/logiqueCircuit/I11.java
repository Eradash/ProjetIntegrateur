package logiqueCircuit;

import gestion.BD;
import java.util.ArrayList;

public class I11 extends II {

    private double I;
    private double I1;

    public I11() {
        super(-1);
        I1 = 6;
    }

    @Override
    public I1I I1() {
        return I1I.I1I;
    }

    public double II1() {
        return I;
    }

    public void I1(double I) {
        this.I = I;
    }

    public double I1I() {
        return I1;
    }

    @Override
    public void I(double I) {
        I1 = I;
    }

    public ArrayList<Integer> II(int I) {
        ArrayList<Integer> II = new ArrayList<>();
        II.add(I);
        int II1 = I;
        while (II1 != -1) {
            II1 = gestion.BD.getInstance().getComposante(II1, "Parent").intValue();
            II.add(II1);
        }
        ArrayList<Integer> I1I = new ArrayList<>();
        for (int i = 0; i < II.size(); i++) {
            I1I.add(II.get(II.size() - 1 - i));
        }
        return I1I;
    }

    public I1 II1(int I) {
        return (I1) I1I(I);
    }

    public I I1I(int I) {
        if (I == -1) {
            return this;
        }
        ArrayList<Integer> II = II(I);
        I II1 = this;
        II.remove(0);
        while (!II.isEmpty()) {
            II1 = II1.I(II.remove(0));
        }
        return II1;
    }

    public void I(I I, int II) {
        II1(II).I(I);
    }

    @Override
    public void I1(int I) {
        double II = BD.getInstance().getComposante(I, "Parent");
        if ((int) II == -1) {
            super.I1(I);
        } else {
            II1((int) II).I1(I);
        }
    }

    public void I(int I, double II) {
        if (I == -1) {
            I1 = II;
        } else {
            I1I(I).I(II);
        }
    }
}
