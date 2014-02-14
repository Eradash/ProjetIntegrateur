package projetintegrateur;

public interface Composante {
    public int getNumero();
    public Type getType();
    public double getResistanceEquivalente();
    public void calculAmpere(int voltage);
    public void calculVoltage(int ampere);
}