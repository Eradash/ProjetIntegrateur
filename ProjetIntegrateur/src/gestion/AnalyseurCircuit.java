package gestion;

import logiqueCircuit.Circuit;
import logiqueCircuit.Composante;
import logiqueCircuit.Resistance;
import logiqueCircuit.Type;

public class AnalyseurCircuit {

    public void analyserCircuit(Circuit c) {
        double voltage = c.getVoltage();
        calcul(-1, voltage, c, -1);
    }

    private void calcul(double amp, double volt, Composante b, int ID_Parent) {
        int ID = b.getNumero();
        double resistance = b.getResistanceEquivalente();
        double ampere = amp;
        double voltage = volt;

        BD bd = BD.getInstance();

        bd.SetComposante(ID, "Parent", ID_Parent);
        bd.SetComposante(ID, "Resistance", resistance);

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

        switch (b.getType()) {
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

        if (b.getType() == Type.RESISTANCE) {
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
                for (Composante c : b.getComposantes()) {
                    voltage = c.getResistanceEquivalente() * ampere;
                    calcul(ampere, voltage, c, ID);
                }
                break;

            case 2:
            case 11:
            case 12:
                for (Composante c : b.getComposantes()) {
                    calcul(-1, voltage, c, ID);
                }
                break;
        }
    }
    
    private double arrondir(double nombre){
        double n = nombre * 1000000;
        n = Math.round(n);
        return n/1000000;
    }

    public Double getValeurComposante(int noComp, String info) {
        return BD.getInstance().getComposante(noComp, info);
    }
}
