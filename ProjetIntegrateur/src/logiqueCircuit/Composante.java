package logiqueCircuit;

public interface Composante {
    public int getNumero();
    public Type getType();
    public double getResistanceEquivalente();
    public void calculAmpere(double voltage);
    public void calculVoltage(double ampere);
}