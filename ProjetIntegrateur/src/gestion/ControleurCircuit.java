package gestion;

import Listeners.AjoutSuppEvent;
import Listeners.ComposanteListener;
import Listeners.ComposanteObservable;
import java.util.ArrayList;
import logiqueCircuit.Circuit;
import logiqueCircuit.Composante;

public class ControleurCircuit implements ComposanteObservable{
    
    private final static GestionXML xml = GestionXML.getInstance();
    ArrayList<Circuit> circuitsOuverts;
    GestionnaireID gestID = GestionnaireID.getInstance();
    ArrayList<ComposanteListener> listeListeners;
    
    Circuit c = new Circuit();
    
    public ControleurCircuit(){
        circuitsOuverts = new ArrayList<>();
        listeListeners = new ArrayList<>();
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
    
    public void ajouterComposante(Composante c, int emplacement){
        this.c.ajouterComposante(c, emplacement);
    }

    @Override
    public void ajouterListener(ComposanteListener listener) {
        listeListeners.add(listener);
    }

    @Override
    public void supprimerListener(ComposanteListener listener) {
        listeListeners.remove(listener);
    }

    @Override
    public void notifierAjoutSuppComposante(AjoutSuppEvent event) {
        switch (event.getType()) {
            case "ajout":
                for(ComposanteListener listener : listeListeners){
                    listener.composanteAjout(event);
                }   break;
            case "suppression":
                for(ComposanteListener listener : listeListeners){
                    listener.composanteSupp(event);
                }   break;
        }
    }
}
