package projetintegrateur;

public class Serie extends Branche{

    @Override
    public Type getType() {
        return Type.SERIE;
    }

    @Override
    public void ajouterComposante(Composante c) {

    }

    @Override
    public void supprimerComposante(Composante c) {
    }

    @Override
    public void getComposante(int branche, int composante) {
        
    }
    
    public void getComposante(int composante){
        getComposante(0,composante);
    }

    @Override
    public double getResistanceEquivalente() {
        //Calcul résistance entre ses composantes...
        return 0;
    }

    @Override
    public void calculAmpere(int voltage) {
    
    }

    @Override
    public void calculVoltage(int ampere) {
    
    }
}