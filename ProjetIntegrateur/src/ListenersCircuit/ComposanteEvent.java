package ListenersCircuit;

import java.util.HashMap;
import logiqueCircuit.Composante;
import logiqueCircuit.Type;

public class ComposanteEvent{
    
    public static enum TypeEvent{ AJOUT,SUPP,MODIF };
    
    private Type type;
    private final TypeEvent typeEvent;
    private Composante comp;
    private final HashMap<String, Double> valeurs;
    protected transient Object source;

    public ComposanteEvent(Object source ,TypeEvent type) {
        this.source = source;
        this.typeEvent = type;
        this.valeurs = new HashMap<>();
    }
    
    public ComposanteEvent(Object source, Type type, Composante comp, TypeEvent typeEvent, HashMap<String, Double> valeurs) {
        this(source, typeEvent);
        this.comp = comp;
        this.type = type;
        this.valeurs.putAll(valeurs);
    }
    
    public Object getSource(){
        return source;
    }
    
    public void ajouterValeur(String cle, double valeur){
        valeurs.put(cle, valeur);
    }
    
    public void setValeurs(HashMap<String,Double> valeurs){
        this.valeurs.putAll(valeurs);
    }
    
    public double getValeur(String cle){
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
    
    public TypeEvent getTypeEvent() {
        return typeEvent;
    }
}