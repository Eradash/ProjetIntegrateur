package projetintegrateur;

public class AnalyseurCircuit {
    
    public AnalyseurCircuit() {
        
    }
    
    public void analyserCircuit(Circuit c) {
        double ampere = c.getAmpere();
        double voltage = c.getVoltage();
        calculerVoltages(c, ampere);
    }
    
    private void calculerVoltages(Circuit c, double ampere){
        for(Composante comp : c.getComposantes()){
            comp.calculVoltage(ampere);
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
