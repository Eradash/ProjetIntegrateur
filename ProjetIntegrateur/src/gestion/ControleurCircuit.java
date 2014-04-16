package gestion;

import java.util.ArrayList;
import logiqueCircuit.Circuit;
import logiqueCircuit.Composante;

public class ControleurCircuit{
    
    private final static GestionXML xml = GestionXML.getInstance();
    ArrayList<Circuit> circuitsOuverts;
    GestionnaireID gestID = GestionnaireID.getInstance();
    
    Circuit c = new Circuit();
    
    public ControleurCircuit(){
        circuitsOuverts = new ArrayList<>();
    }
    
    public void nouveauCircuit(){
        gestID.resetCircuit();
        circuitsOuverts.add(new Circuit());
    }
    
    public void fermeCircuit(Circuit c) {
        gestID.resetCircuit();
        circuitsOuverts.remove(c);
    }
    
    public void ouvrirCircuit(String nom) throws Exception{
        xml.decoder(nom);
    }
    
    public void enregistrerCircuit(Circuit c) throws Exception{
        xml.encoder(c);
    }
    
    public Circuit getCircuit() {
        return c;
    }
    
    public void ajouterComposante(Composante c, int emplacement){
        this.c.ajouterComposante(c, emplacement);
    }
}