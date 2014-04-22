package affichage;

import ListenersCircuit.*;
import gestion.ControleurCircuit;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ControlleurFrame implements ComposanteObservable, CompModifObservable{

    FrameProjet frame;
    PanelBoutons panelBoutons;
    PanelCircuit panelCircuit;
    ControleurCircuit cc;
    
    ArrayList<ComposanteListener> listenerAjoutSupp;
    ArrayList<CompModifListener> listenerModif;

    public ControlleurFrame(ControleurCircuit cc) {
        this.cc = cc;
        frame = new FrameProjet(this);
        
        panelBoutons = frame.getPanelBoutons();
        panelCircuit = frame.getPanelCircuit();
        
        listenerAjoutSupp = new ArrayList<>();
        listenerModif = new ArrayList<>();
    }
    
    public void BoutonResistance(ActionEvent evt){
        panelCircuit.setOutil(2);
    }
    
    public void BoutonParallele(ActionEvent evt){
        panelCircuit.setOutil(3);
    }
    
    public void BoutonFil(ActionEvent evt){
        panelCircuit.setOutil(1);
    }

    public void composanteAjoutSupp(AjoutSuppEvent evt){
        
    }
    
    public void composanteModif(CompModifEvent evt){
        
    }

    @Override
    public void ajouterListener(ComposanteListener listener) {
        listenerAjoutSupp.add(listener);
    }

    @Override
    public void supprimerListener(ComposanteListener listener) {
        listenerAjoutSupp.remove(listener);
    }

    @Override
    public void notifierAjoutSuppComposante(AjoutSuppEvent event) {
        for (ComposanteListener composanteListener : listenerAjoutSupp) {
            if(event.isAjout()){
                composanteListener.composanteAjout(event);
            } else {
                composanteListener.composanteSupp(event);
            }
        }
    }

    @Override
    public void ajouterListener(CompModifListener listener) {
        listenerModif.add(listener);
    }

    @Override
    public void supprimerListener(CompModifListener listener) {
        listenerModif.remove(listener);
    }

    @Override
    public void notifierModificationComposante(CompModifEvent event) {
        for (CompModifListener composanteListener : listenerModif) {
            composanteListener.composanteModif(event);
        }
    }
}