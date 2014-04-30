package ListenersCircuit;

public interface ComposanteObservable {
    public void ajouterListener(ComposanteListener listener);
    public void supprimerListener(ComposanteListener listener);
    public void notifierComposante(ComposanteEvent event);
}