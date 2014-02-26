package gestion;

import logiqueCircuit.Branche;
import logiqueCircuit.Circuit;
import logiqueCircuit.Composante;
import logiqueCircuit.Type;

public class AnalyseurCircuit {
    
    public AnalyseurCircuit() {
        
    }
    
    public void analyserCircuit(Circuit c) {
        double resistance = c.getResistanceEquivalente();
        double voltage = c.getVoltage();
        double ampere = c.getAmpere();
        
        calcul(ampere, voltage, c);
    }
    
    private void calcul(double amp, double volt, Composante b) {
        double resistance = b.getResistanceEquivalente();
        double ampere = amp;
        double voltage = volt;
        int cas = 0;

        //Ajouter les valeurs pour la branche présente à la BD
        if (ampere != -1 || voltage != -1) {
            if (ampere == -1 && voltage != -1) {
                ampere = voltage / resistance;
            } else if (voltage == -1 && ampere != -1) {
                cas += 10;
                voltage = resistance * ampere;
            }
        }

        if (b.getType() == Type.SERIE) { 
            cas += 1;
        } else if (b.getType() == Type.PARALELLE) {
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
    
    /*
     ***********************************
     * Ajouter les infos a retourner   *
     ***********************************
     */
    
    public void getValeurComposante(int noComp) {
        
    }
    
    /*
     ******************************************
     * Changer le return pour un vrai circuit *
     ******************************************
     */
    
    public Circuit decoderCircuit() {
        return new Circuit();
    }
    
    /*
     ***********************************
     * Ajouter les infos a retourner   *
     ***********************************
     */
    
    public void creerCircuit(Circuit c) {
        
    }
    
    /*
     ***********************************
     * Ajouter le XML a retourner      *
     ***********************************
     */
    
    public void encoderCircuit() {
        
    }
    
}
