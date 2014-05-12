package I1ll;

import l.I1l;
import l.I;
import l.Ill;
import l.Il1;

public class Ii {

    public static int i = 8;

    public void il(I1l i) {
        if (i != null) {
            double l = i.il();
            il(-1, l, i, -1);
        }
    }

    private void il(double i, double il, I l, int li) {
        int ll = l.I();
        double Il = l.Il();
        double lI = i;
        double l1 = il;

        Iil I1 = Iil.ll();

        I1.il(ll, "Parent", li);
        I1.il(ll, "Resistance", il(Il));

        int II = 0;

        if (lI != -1 || l1 != -1) {
            if (lI == -1 && l1 != -1) {
                lI = l1 / Il;
            } else if (l1 == -1 && lI != -1) {
                II += 10;
                l1 = Il * lI;
            }
        }

        I1.il(ll, "Ampere", il(lI));
        I1.il(ll, "Voltage", il(l1));

        switch (l.II()) {
            case i:
                II += 1;
                I1.il(ll, "Type", 1);
                break;
            case ll:
                II += 1;
                I1.il(ll, "Type", 3);
                break;
            case l:
                II += 2;
                I1.il(ll, "Type", 2);
                break;
            case li:
                II = 0;
                I1.il(ll, "Type", 4);
                break;
        }

        if (l.II() == Il1.li) {
            double lIl = lI * l1;
            I1.il(ll, "Watt", il(lIl));
            Ill IlI = (Ill) l;
            if (lIl > 0.25) {
                IlI.il(true);
            } else {
                IlI.il(false);
            }
        }

        switch (II) {
            case 1:
                for (I c : l.lI()) {
                    l1 = c.Il() * lI;
                    il(lI, l1, c, ll);
                }
                break;

            case 2:
            case 11:
            case 12:
                for (I c : l.lI()) {
                    il(-1, l1, c, ll);
                }
                break;
        }
    }

    private double il(double l) {
        if(l != Double.NEGATIVE_INFINITY && l != Double.POSITIVE_INFINITY && l != Double.NaN){
            double ll = l * Math.pow(10, l);
            ll = Math.round(ll);
            ll = ll / Math.pow(10, l);
            return ll;
        }
        return l;
    }
}
