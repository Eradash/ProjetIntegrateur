package projetintegrateur;

public class Resistance implements Composante{

    int numero;
    
    @Override
    public int getNumero() {
        return numero;
    }

    @Override
    public Type getType() {
        return Type.RESISTANCE;
    }
    
}
