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

    @Override
    public double getResistanceEquivalente() {
        double resistance = 0;
        for(Composante c : listeComposante){
            resistance += c.getResistanceEquivalente();
        }
        return resistance;
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
