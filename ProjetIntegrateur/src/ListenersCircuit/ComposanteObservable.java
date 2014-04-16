package ListenersCircuit;

public interface ComposanteObservable {
    public void ajouterListener(ComposanteListener listener);
    public void supprimerListener(ComposanteListener listener);
    public void notifierAjoutSuppComposante(AjoutSuppEvent event);
}