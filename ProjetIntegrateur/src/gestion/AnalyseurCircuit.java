package gestion;

import logiqueCircuit.Circuit;
/*
 * Cette classe jouera avec le XML
 */
import logiqueCircuit.Composante;
import logiqueCircuit.Type;

public class AnalyseurCircuit {
    
    public void analyserCircuit(Circuit c) {
        double voltage = c.getVoltage();
        double ampere = c.getAmpere();
        
        calcul(ampere, voltage, c, -1);
    }
    
<<<<<<< HEAD
    private void calcul(double amp, double volt, Composante comp) {
        double resistance = comp.getResistanceEquivalente();
=======
    private void calcul(double amp, double volt, Composante b, int ID_Parent) {
        int ID = b.getNumero();
        double resistance = b.getResistanceEquivalente();
>>>>>>> Uniformisation-de-la-BD
        double ampere = amp;
        double voltage = volt;
        
        BD bd = BD.getInstance();
        
        bd.SetComposante(ID, "Parent", ID_Parent);
        
        int cas = 0;

        if (ampere != -1 || voltage != -1) {
            if (ampere == -1 && voltage != -1) {
                ampere = voltage / resistance;
<<<<<<< HEAD
                BD.getInstance().SetComposante(comp.getNumero(), "Ampere", ampere);
            } else if (voltage == -1 && ampere != -1) {
                cas += 10;
                voltage = resistance * ampere;
                BD.getInstance().SetComposante(comp.getNumero(), "Voltage", voltage);
            }
        }

        if (comp.getType() == Type.SERIE || comp.getType() == Type.CIRCUIT) { 
            cas += 1;
        } else if (comp.getType() == Type.PARALLELE) {
=======
                bd.SetComposante(ID, "Ampere", ampere);
                bd.SetComposante(ID, "Voltage", voltage);
            } else if (voltage == -1 && ampere != -1) {
                cas += 10;
                voltage = resistance * ampere;
                bd.SetComposante(ID, "Voltage", voltage);
                bd.SetComposante(ID, "Ampere", ampere);
            }
        }

        if (b.getType() == Type.SERIE){
            cas +=1;
            bd.SetComposante(ID, "Type", 1);
        } else if(b.getType() == Type.CIRCUIT){
            cas += 1;
            bd.SetComposante(ID, "Type", 3);
        } else if (b.getType() == Type.PARALLELE) {
>>>>>>> Uniformisation-de-la-BD
            cas += 2;
            bd.SetComposante(ID, "Type", 2);
        } else {
            cas = 0;
            bd.SetComposante(ID, "Type", 4);
        }
        
        switch (cas) {
            case 1:
                for (Composante c : comp.getComposantes()) {
                    voltage = c.getResistanceEquivalente() * ampere;
                    calcul(ampere, voltage, c, ID);
                }
                break;

            case 2:
            case 11:
            case 12:
<<<<<<< HEAD
                for (Composante c : comp.getComposantes()) {
                    calcul(ampere, voltage, c);
=======
                for (Composante c : b.getComposantes()) {
                    calcul(ampere, voltage, c, ID);
>>>>>>> Uniformisation-de-la-BD
                }
                break;
        }

    }
    
    public Double getValeurComposante(int noComp, String info) {
        return BD.getInstance().getComposante(noComp, info);
    }
}
