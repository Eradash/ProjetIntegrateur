package projetintegrateur;

import java.util.ArrayList;


public class Serie extends Branche {
    
    ArrayList<Composante> listeComposante;

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

    public void getComposante(int composante) {
        getComposante(0, composante);
    }

    @Override
    public double getResistanceEquivalente() {
        //Calcul résistance entre ses composantes...
        return 0;
    }

    @Override
    public void calculAmpere(double voltage) {
        double ampere = voltage / getResistanceEquivalente();
        for(Composante c : listeComposante){
            c.calculVoltage(ampere);
        }
    }

    @Override
    public void calculVoltage(double ampere) {
        //Inutile ici pour l'instant...
    }
}
