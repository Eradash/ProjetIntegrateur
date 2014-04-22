package ListenersCircuit;

import java.util.HashMap;
import logiqueCircuit.Composante;
import logiqueCircuit.Type;

public class ComposanteEvent{
    
    private Type type;
    private Composante comp;
    private boolean ajout;
    private final HashMap<String, Integer> valeurs;
    protected transient Object source;

    public ComposanteEvent(Object source) {
        this.type = null;
        this.comp = null;
        this.ajout = false;
        this.valeurs = new HashMap<>();
        this.source = source;
    }

    public ComposanteEvent(Object source, Type type, Composante comp, boolean ajout, HashMap<String, Integer> valeurs) {
        this.source = source.getClass();
        this.type = type;
        this.comp = comp;
        this.ajout = ajout;
        this.valeurs = valeurs;
    }
    
    public Object getSource(){
        return source;
    }
    
    public void ajouterValeur(String cle, int valeur){
        valeurs.put(cle, valeur);
    }
    
    public int getValeur(String cle){
        return valeurs.get(cle);
    }
    
    public void setType(Type type){
        this.type = type;
    }
    
    public Type getType() {
        return type;
    }
    
    public void setComp(Composante c){
        this.comp = c;
    }
    
    public Composante getComp(){
        return comp;
    }

    public void setIsAjout(Boolean ajout){
        this.ajout = ajout;
    }
    
    public boolean isAjout() {
        return ajout;
    }
}