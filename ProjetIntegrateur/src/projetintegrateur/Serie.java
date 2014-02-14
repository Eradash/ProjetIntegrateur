package projetintegrateur;

public class Serie extends Branche{

    @Override
    public Type getType() {
        return Type.SERIE;
    }

    @Override
    public void ajouterComposante(Composante c, int noCOmp) {

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
<<<<<<< HEAD
    public void calculAmpere(int voltage) {
    
    }

    @Override
    public void calculVoltage(int ampere) {
    
=======
    public void ajouterComposante(Composante c, int noComp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
>>>>>>> 62f84b59c76cd4cdedda3c40e79e93d2397e3300
    }
}