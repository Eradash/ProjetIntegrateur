package projetintegrateur;

import java.util.ArrayList;

public class Parallele extends Branche{
    
    ArrayList<Serie> listeBranches;

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

    @Override
    public void calculAmpere(double voltage) {
        //Inutile ici pour l'instant...
    }

    @Override
    public void calculVoltage(double ampere) {
        double voltage = getResistanceEquivalente() * ampere;
        for(Serie s : listeBranches){
            s.calculAmpere(voltage);
        }
        
    }
}