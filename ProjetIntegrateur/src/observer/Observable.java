package observer;

import java.util.ArrayList;
import logiqueCircuit.Composante;

public interface Observable {
    public void ajouterObservateur(Observateur obs);
    public void supprimerObservateur(Observateur obs);
    public void notifier(ArrayList<Composante> listeComp);
}