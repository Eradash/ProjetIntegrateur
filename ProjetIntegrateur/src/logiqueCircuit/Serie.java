package logiqueCircuit;

import java.util.ArrayList;


public class Serie extends Branche implements Composante{
    
    ArrayList<Composante> listeComposante;

    @Override
    public Type getType() {
        return Type.SERIE;
    }

    @Override
<<<<<<< HEAD
    public void ajouterComposante(Composante c, int noComp) {
        listeComposante.add(c);
=======
    public void ajouterComposante(Composante c) {

>>>>>>> 1af50c0100556260d67a31eceadde8c04638e12f
    }

    @Override
    public void supprimerComposante(Composante c) {
        listeComposante.remove(c);
    }
    
    @Override
    public ArrayList<Composante> getComposantes(){
        return listeComposante;
    }

    @Override
    public double getResistanceEquivalente() {
        double resistance = 0;
        for(Composante c : listeComposante){
            resistance += c.getResistanceEquivalente();
        }
        return resistance;
    }
}
