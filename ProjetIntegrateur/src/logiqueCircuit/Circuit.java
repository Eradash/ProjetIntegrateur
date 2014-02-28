package logiqueCircuit;

public class Circuit extends Serie{

    private double ampere;
    private double voltage;
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    @Override
    public Type getType() {
        return Type.CIRCUIT;
    }
    
    public double getAmpere(){
        return ampere;
    }
    
    public double getVoltage(){
        return voltage;
    }
}