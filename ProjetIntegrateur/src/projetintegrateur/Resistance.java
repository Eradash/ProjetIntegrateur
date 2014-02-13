package projetintegrateur;

public class Resistance implements Composante{

    int numero;
    int ohm;
    
    public int getOhm(){
        return ohm;
    }
    
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
    
}
