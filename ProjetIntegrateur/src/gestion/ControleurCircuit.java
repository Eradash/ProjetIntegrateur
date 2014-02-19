package gestion;

import java.nio.file.Path;
import java.util.ArrayList;
import logiqueCircuit.Circuit;

public class ControleurCircuit {
    
    ArrayList<Circuit> circuitsOuverts = new ArrayList<>();
    GestionnaireID gestID = GestionnaireID.getInstance();
    
    public ControleurCircuit(){
        
    }
    
    public void nouveauCircuit(){
        gestID.resetCircuit();
        circuitsOuverts.add(new Circuit());
    }
    
    public void fermeCircuit(Circuit c) {
        gestID.resetCircuit();
        circuitsOuverts.remove(c);
    }
    
    public void ouvrirCircuit(Path emplacement) {
        
    }
    
    public void enregistrerCircuit(Circuit c){
        
    }
}
