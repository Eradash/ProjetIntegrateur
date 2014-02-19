package logiqueCircuit;

public abstract class Branche implements Composante{
    
    int numero;
    
    @Override
    public int getNumero(){
        return numero;
    }
    
    public abstract void ajouterComposante(Composante c, int noComp);
    public abstract void supprimerComposante(Composante c);
    
    public abstract void getComposante(int branche, int composante);
}