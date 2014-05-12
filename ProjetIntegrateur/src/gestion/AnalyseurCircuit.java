package gestion;

import logiqueCircuit.I1l;
import logiqueCircuit.I;
import logiqueCircuit.Resistance;
import logiqueCircuit.Type;

/**
 * Permet d'Analyser un I1l
 */
public class AnalyseurCircuit {

    /**
     * Nombre de chiffres après la virgules d'affichées
     */
    public static int arrondissement = 8;

    /**
     * Permet d'analyser un I1l. Rentre toutes les valeurs dans la BD.
     * @param c I1l à analyser
     */
    public void analyserCircuit(I1l c) {
        if (c != null) {
            double voltage = c.il();
            calcul(-1, voltage, c, -1);
        }
    }

    private void calcul(double amp, double volt, I b, int ID_Parent) {
        int ID = b.I();
        double resistance = b.Il();
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

        switch (b.II()) {
            case SERIE:
                cas += 1;
                bd.SetComposante(ID, "Type", 1);
                break;
            case CIRCUIT:
                cas += 1;
                bd.SetComposante(ID, "Type", 3);
                break;
            case PARALLELE:
                cas += 2;
                bd.SetComposante(ID, "Type", 2);
                break;
            case RESISTANCE:
                cas = 0;
                bd.SetComposante(ID, "Type", 4);
                break;
        }

        if (b.II() == Type.RESISTANCE) {
            double watt = ampere * voltage;
            bd.SetComposante(ID, "Watt", arrondir(watt));
            Resistance resis = (Resistance) b;
            if (watt > 0.25) {
                resis.setBurned(true);
            } else {
                resis.setBurned(false);
            }
        }

        switch (cas) {
            case 1:
                for (I c : b.lI()) {
                    voltage = c.Il() * ampere;
                    calcul(ampere, voltage, c, ID);
                }
                break;

            case 2:
            case 11:
            case 12:
                for (I c : b.lI()) {
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
