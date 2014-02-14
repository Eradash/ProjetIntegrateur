package projetintegrateur;

public class Parallele extends Branche{

    @Override
    public void ajouterComposante(Composante c, int noComp) {

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
}