package ListenersCircuit;

public interface ComposanteListener {
    public void composanteAjout(ComposanteEvent event);
    public void composanteSupp(ComposanteEvent event);
    public void composanteModif(ComposanteEvent event);
}