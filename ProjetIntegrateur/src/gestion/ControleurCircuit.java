package gestion;

import ListenersCircuit.ComposanteEvent;
import ListenersCircuit.ComposanteListener;
import affichage.ControlleurFrame;
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

    @Override
    public void composanteAjout(ComposanteEvent event) {
        if(event.getSource() == ControlleurFrame.class){
            
        } else if(event.getSource() == BD.class){
            
        }
        
    }

    @Override
    public void composanteSupp(ComposanteEvent event) {
        if(event.getSource() == ControlleurFrame.class){
            
        } else if(event.getSource() == BD.class){
            
        }
    }

    @Override
    public void composanteModif(ComposanteEvent event) {
        if(event.getSource() == ControlleurFrame.class){
            
        } else if(event.getSource() == BD.class){
            
        }
    }
}