package gestion;

import ListenersCircuit.ComposanteEvent;
import ListenersCircuit.ComposanteListener;
import ListenersCircuit.ComposanteObservable;
import java.util.ArrayList;

public class BD implements ComposanteObservable{
    
    private static volatile BD instance = null;
    private final static GestionnaireID gestionnaire = GestionnaireID.getInstance();
    
    MultiMap<Integer, String, Double> listeComposante;
    ArrayList<ComposanteListener> listeListeners;
    
    
    private BD() {
        super();
        listeListeners = new ArrayList<>();
        listeComposante = new MultiMap<>();
    }
    
    public void SetComposante(int ID, String info, double donne) {
        listeComposante.put(ID, info, donne);
        gestionnaire.ajouterComp(ID);
        ComposanteEvent evt = new ComposanteEvent(this, ComposanteEvent.TypeEvent.MODIF);
        evt.setValeurs(listeComposante.getComp(ID));
        notifierComposante(evt);
    }
    
    public boolean supprimerComposante(int ID) {
        if(gestionnaire.supprimerComp(ID)) {
            listeComposante.removeID(ID);
            ComposanteEvent evt = new ComposanteEvent(this, ComposanteEvent.TypeEvent.SUPP);
            evt.ajouterValeur("ID", ID);
            notifierComposante(evt);
            return true;
        }
        return false;
    }
        
    public Double getComposante(int ID, String info) {
        return listeComposante.get(ID, info);
    }
    
    public void resetCircuit() {
        gestionnaire.resetCircuit();
        listeComposante.clear();
    }
    
    public final static BD getInstance() {
        if(BD.instance == null) {
            synchronized(BD.class) {
                if(BD.instance == null) {
                    BD.instance = new BD();
                }
            }
        }
        return BD.instance;
    }

    @Override
    public void ajouterListener(ComposanteListener listener) {
        listeListeners.add(listener);
    }

    @Override
    public void supprimerListener(ComposanteListener listener) {
        listeListeners.add(listener);
    }

    @Override
    public void notifierComposante(ComposanteEvent event) {
        for(ComposanteListener listener : listeListeners){
            listener.composanteModif(event);
        }
    }
}
