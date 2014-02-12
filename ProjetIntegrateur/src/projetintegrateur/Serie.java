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
    
}