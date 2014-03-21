package Listeners;

public interface CompModifObservable {
    public void ajouterListener(CompModifListener listener);
    public void supprimerListener(CompModifListener listener);
    public void notifierModificationComposante(CompModifEvent event);
}
