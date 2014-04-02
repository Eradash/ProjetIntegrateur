package gestion;

import logiqueCircuit.Circuit;
import logiqueCircuit.Composante;

public class ControleurCircuit{
    
    private final static GestionXML xml = GestionXML.getInstance();
    GestionnaireID gestID = GestionnaireID.getInstance();
    AnalyseurCircuit ac = new AnalyseurCircuit();
    
    Circuit c = new Circuit();
    
    public ControleurCircuit(){
    }
    
    public void nouveauCircuit(){
        gestID.resetCircuit();
        c = new Circuit();
    }
    
    public void fermeCircuit() {
        gestID.resetCircuit();
        c = null;
    }
    
    public void ouvrirCircuit(String nom) throws Exception{
        c = xml.decoder(nom);
    }
    
    public void enregistrerCircuit() throws Exception{
        xml.encoder(c);
    }
    
    public void ajouterComposante(Composante c, int emplacement){
        this.c.ajouterComposante(c, emplacement);
    }
    
    public void run(){
        ac.analyserCircuit(c);
    }
}