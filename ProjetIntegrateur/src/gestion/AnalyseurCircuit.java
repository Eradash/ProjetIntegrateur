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
    
    private void calcul(double amp, double volt, Branche b) {
        double resistance = b.getResistanceEquivalente();
        double ampere;
        double voltage;
        int cas = 0;

        if (amp != -1 || volt != -1) {
            if (amp == -1) {
                ampere = volt / resistance;
            } else if (volt == -1) {
                cas += 10;
                voltage = resistance * amp;
            }
        }

        if (b.getType() == Type.SERIE) {
            cas += 1;
        } else if (b.getType() == Type.PARALELLE) {
            cas += 2;
        }
        
        switch (cas){
            case 1:
                
                break;
                
            case 2:
                
                break;
                
            case 11:
                
                break;
                
            case 12:
                
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
