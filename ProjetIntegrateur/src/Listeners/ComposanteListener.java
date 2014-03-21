package Listeners;

public interface ComposanteListener {
    public void composanteAjout(AjoutSuppEvent event);
    public void composanteSupp(AjoutSuppEvent event);
    public void composanteModif(CompModifEvent event);
}