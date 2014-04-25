package gestion;

import ListenersCircuit.ComposanteEvent;
import ListenersCircuit.ComposanteListener;
import affichage.PanelCircuit;
import logiqueCircuit.Circuit;
import logiqueCircuit.Composante;

public class ControleurCircuit implements ComposanteListener{
    
    BD donnee = BD.getInstance();
    AnalyseurCircuit analyseur = new AnalyseurCircuit();
    private final static GestionXML xml = GestionXML.getInstance();
    GestionnaireID gestID = GestionnaireID.getInstance();
    AnalyseurCircuit ac = new AnalyseurCircuit();
    
    Circuit c;
    
    public ControleurCircuit(){
    }
    
    public void nouveauCircuit(){
        donnee.resetCircuit();
    }
    
    public void fermeCircuit() {
        donnee.resetCircuit();
        gestID.resetCircuit();
        c = null;
    }
    
    public void ouvrirCircuit(String nom){
        c = xml.decoder(nom);
    }
    
    public void enregistrerCircuit(){
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

    @Override
    public void composanteAjout(ComposanteEvent event) {
        if(event.getSource() instanceof PanelCircuit){
            System.out.println("Message reçu du PanelCircuit (CC)");
            //Créer une composante et l'ajouter au circuit
        }
    }

    @Override
    public void composanteSupp(ComposanteEvent event) {
        if(event.getSource() instanceof PanelCircuit){
            //Supprimer la composante
        }
    }

    @Override
    public void composanteModif(ComposanteEvent event) {
        if(event.getSource() instanceof PanelCircuit){
            //Modifier la composante
        }
    }
}