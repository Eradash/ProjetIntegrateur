package logiqueCircuit;

public class Circuit extends Serie{

    private double ampere;
    private double voltage;
    
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
