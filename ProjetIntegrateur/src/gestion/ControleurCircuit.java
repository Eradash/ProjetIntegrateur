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
    ControlleurFrame cf;
    
    Circuit c;
    
    public ControleurCircuit(){
    }
    
    public void setCF(ControlleurFrame cf){
        this.cf = cf;
    }
    
    public void nouveauCircuit(){
        donnee.resetCircuit();
        c = new Circuit();
    }
    
    public void fermeCircuit() {
        donnee.resetCircuit();
        gestID.resetCircuit();
        c = null;
    }
    
    public void ouvrirCircuit(String nom){
        c = xml.decoder(nom);
        run();
    }
    
    public void enregistrerCircuit(String endroit){
        xml.encoder(c, endroit);
    }
    
    public Circuit getCircuit() {
        return c;
    }
    
    public void ajouterComposante(Composante c, int emplacement){
        this.c.ajouterComposante(c, emplacement);
        run();
    }
    
    public void supprimerComposante(int ID){
        this.c.supprimerComposante(ID);
        run();
    }
    
    public void run(){
        analyseur.analyserCircuit(c);
        cf.update();
    }
    
    public BD getInstanceBD() {
        return BD.getInstance();
    }

    @Override
    public void composanteAjout(ComposanteEvent event) {
        if(event.getSource() instanceof PanelCircuit){
            System.out.println("Message reçu du Frame (CC)");
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