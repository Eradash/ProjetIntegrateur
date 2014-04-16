package gestion;

import java.util.ArrayList;
import logiqueCircuit.Circuit;
import logiqueCircuit.Composante;

public class ControleurCircuit{
    
    private final static GestionXML xml = GestionXML.getInstance();
    ArrayList<Circuit> circuitsOuverts;
    GestionnaireID gestID = GestionnaireID.getInstance();
    
    Circuit c;
    
    public ControleurCircuit(){
        circuitsOuverts = new ArrayList<>();
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
        xml.decoder(nom);
    }
    
    public void enregistrerCircuit(Circuit c) throws Exception{
        xml.encoder(c);
    }
    
    public void ajouterComposante(Composante c, int emplacement){
        this.c.ajouterComposante(c, emplacement);
    }
}