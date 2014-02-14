package projetintegrateur;

public class Parallele extends Branche{

    @Override
    public void ajouterComposante(Composante c) {

    }

    @Override
    public Type getType() {
        return Type.PARALELLE;
    }

    @Override
    public void supprimerComposante(Composante c) {
    }

    @Override
    public void getComposante(int branche, int composante) {
    }

    @Override
    public double getResistanceEquivalente() {
        //Calcul de résistance entre ses branches...
        return 0;
    }

    @Override
    public void calculAmpere(int voltage) {

    }

    @Override
    public void calculVoltage(int ampere) {

    }
}