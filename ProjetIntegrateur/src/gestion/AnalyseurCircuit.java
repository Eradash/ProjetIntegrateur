package gestion;

import logiqueCircuit.I11;
import logiqueCircuit.I;
import logiqueCircuit.II1;
import logiqueCircuit.I1I;

/**
 * Permet d'Analyser un I11
 */
public class AnalyseurCircuit {

    /**
     * Nombre de chiffres après la virgules d'affichées
     */
    public static int arrondissement = 8;

    /**
     * Permet d'analyser un I11. Rentre toutes les valeurs dans la BD.
     * @param c I11 à analyser
     */
    public void analyserCircuit(I11 c) {
        if (c != null) {
            double voltage = c.I1I();
            calcul(-1, voltage, c, -1);
        }
    }

    private void calcul(double amp, double volt, I b, int ID_Parent) {
        int ID = b.I();
        double resistance = b.II();
        double ampere = amp;
        double voltage = volt;

        BD bd = BD.getInstance();

        bd.SetComposante(ID, "Parent", ID_Parent);
        bd.SetComposante(ID, "Resistance", arrondir(resistance));

        int cas = 0;

        if (ampere != -1 || voltage != -1) {
            if (ampere == -1 && voltage != -1) {
                ampere = voltage / resistance; //cas 1 ou 2
            } else if (voltage == -1 && ampere != -1) {
                cas += 10; // cas 11 ou 12
                voltage = resistance * ampere;
            }
        }

        bd.SetComposante(ID, "Ampere", arrondir(ampere));
        bd.SetComposante(ID, "Voltage", arrondir(voltage));

        switch (b.I1()) {
            case III:
                cas += 1;
                bd.SetComposante(ID, "Type", 1);
                break;
            case I1I:
                cas += 1;
                bd.SetComposante(ID, "Type", 3);
                break;
            case II1:
                cas += 2;
                bd.SetComposante(ID, "Type", 2);
                break;
            case I11:
                cas = 0;
                bd.SetComposante(ID, "Type", 4);
                break;
        }

        if (b.I1() == I1I.I11) {
            double watt = ampere * voltage;
            bd.SetComposante(ID, "Watt", arrondir(watt));
            II1 resis = (II1) b;
            if (watt > 0.25) {
                resis.I(true);
            } else {
                resis.I(false);
            }
        }

        switch (cas) {
            case 1:
                for (I c : b.III()) {
                    voltage = c.II() * ampere;
                    calcul(ampere, voltage, c, ID);
                }
                break;

            case 2:
            case 11:
            case 12:
                for (I c : b.III()) {
                    calcul(-1, voltage, c, ID);
                }
                break;
        }
    }

    private double arrondir(double nombre) {
        if(nombre != Double.NEGATIVE_INFINITY && nombre != Double.POSITIVE_INFINITY && nombre != Double.NaN){
            double n = nombre * Math.pow(10, arrondissement);
            n = Math.round(n);
            n = n / Math.pow(10, arrondissement);
            return n;
        }
        return nombre;
    }
}
