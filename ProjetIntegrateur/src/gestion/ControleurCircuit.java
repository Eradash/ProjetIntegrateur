package gestion;

import java.util.ArrayList;
import logiqueCircuit.Circuit;
import logiqueCircuit.Composante;

public class ControleurCircuit{
    
    ArrayList<Circuit> circuitsOuverts = new ArrayList<>();
    BD donnee = BD.getInstance();
    AnalyseurCircuit analyseur = new AnalyseurCircuit();
    private final static GestionXML xml = GestionXML.getInstance();
    GestionnaireID gestID = GestionnaireID.getInstance();
    AnalyseurCircuit ac = new AnalyseurCircuit();
    
    Circuit c = new Circuit();
    
    public ControleurCircuit(){
    }
    
    public void nouveauCircuit(){
        donnee.resetCircuit();
        circuitsOuverts.add(new Circuit());
    }
    
    public void fermeCircuit(Circuit c) {
        donnee.resetCircuit();
        circuitsOuverts.remove(c);
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
    
    public Circuit getCircuit() {
        return c;
    }
    
    public void ajouterComposante(Composante c, int emplacement){
        this.c.ajouterComposante(c, emplacement);
    }
    
    public void run(){
        ac.analyserCircuit(c);
    }
}
