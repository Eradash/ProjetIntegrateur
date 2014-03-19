package gestion;

import java.util.ArrayList;
import logiqueCircuit.Circuit;

public class ControleurCircuit {
    
    private final static GestionXML xml = GestionXML.getInstance();
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
    
    // Reste à finaliser
    public void ouvrirCircuit(String nom) throws Exception{
        xml.decoder(nom);
    }
    
    public void enregistrerCircuit(Circuit c) throws Exception{
        xml.encoder(c);
    }
}
