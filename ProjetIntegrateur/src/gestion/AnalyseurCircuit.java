package gestion;

import logiqueCircuit.Circuit;
import logiqueCircuit.Composante;
import logiqueCircuit.Type;

public class AnalyseurCircuit {
    
    public void analyserCircuit(Circuit c) {
        double voltage = c.getVoltage();
        double ampere = c.getAmpere();
        
        calcul(ampere, voltage, c);
    }
    
    private void calcul(double amp, double volt, Composante b) {
        double resistance = b.getResistanceEquivalente();
        double ampere = amp;
        double voltage = volt;
        int cas = 0;

        if (ampere != -1 || voltage != -1) {
            if (ampere == -1 && voltage != -1) {
                ampere = voltage / resistance;
                BD.getInstance().setComposante(b.getNumero(), "Ampere", ampere);
            } else if (voltage == -1 && ampere != -1) {
                cas += 10;
                voltage = resistance * ampere;
                BD.getInstance().setComposante(b.getNumero(), "Voltage", voltage);
            }
        }

        if (b.getType() == Type.SERIE || b.getType() == Type.CIRCUIT) { 
            cas += 1;
        } else if (b.getType() == Type.PARALLELE) {
            cas += 2;
        } else {
            cas = 0;
        }
        
        switch (cas) {
            case 1:
                for (Composante c : b.getComposantes()) {
                    voltage = c.getResistanceEquivalente() * ampere;
                    calcul(ampere, voltage, c);
                }
                break;

            case 2:
            case 11:
            case 12:
                for (Composante c : b.getComposantes()) {
                    calcul(ampere, voltage, c);
                }
                break;
        }

    }
    
    public Double getValeurComposante(int noComp, String info) {
        return BD.getInstance().getComposante(noComp, info);
    }
}