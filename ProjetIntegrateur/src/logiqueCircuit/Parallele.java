package logiqueCircuit;

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
        double resistance = 0;
        for(Serie s : listeBranches){
            resistance += 1 / s.getResistanceEquivalente();
        }
        return 1/resistance;
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