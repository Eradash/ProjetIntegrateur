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
    
    Circuit c = new Circuit();
    
    public ControleurCircuit(){
        circuitsOuverts = new ArrayList<>();
    }
    
    public void nouveauCircuit(){
        donnee.resetCircuit();
        circuitsOuverts.add(new Circuit());
    }
    
    public void fermeCircuit(Circuit c) {
        donnee.resetCircuit();
        circuitsOuverts.remove(c);
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
