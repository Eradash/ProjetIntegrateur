package projetintegrateur;

public class Resistance implements Composante{

    int numero;
    double ohm;
    
    
    public boolean calculExplosion(int ampere){
        return true;
    }
    
    @Override
    public int getNumero() {
        return numero;
    }

    @Override
    public Type getType() {
        return Type.RESISTANCE;
    }

    @Override
    public double getResistanceEquivalente() {
        return ohm;
    }

    @Override
    public void calculAmpere(int voltage) {
        double ampere = voltage/ohm;
    }

    @Override
    public void calculVoltage(int ampere) {
        double voltage = ampere*ohm;
    }
}