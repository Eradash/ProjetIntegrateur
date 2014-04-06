package gestion;

import java.nio.file.Path;
import java.util.ArrayList;
import logiqueCircuit.Circuit;

public class ControleurCircuit {
    
    ArrayList<Circuit> circuitsOuverts = new ArrayList<>();
    BD donnee = BD.getInstance();
    AnalyseurCircuit analyseur = new AnalyseurCircuit();
    
    public ControleurCircuit(){
        
    }
    
    public void nouveauCircuit(){
        donnee.resetCircuit();
        circuitsOuverts.add(new Circuit());
    }
    
    public void fermeCircuit(Circuit c) {
        donnee.resetCircuit();
        circuitsOuverts.remove(c);
    }
    
    public void ouvrirCircuit(Path emplacement) {
        donnee.resetCircuit();
    }
    
    public void enregistrerCircuit(Circuit c){
        
    }
}
