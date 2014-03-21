package logiqueCircuit;

import gestion.BD;
import java.util.ArrayList;

public class Circuit extends Serie{

    private double ampere;
    private double voltage;
    private String nom;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    @Override
    public Type getType() {
        return Type.CIRCUIT;
    }
    
    public double getAmpere(){
        return ampere;
    }
    
    public double getVoltage(){
        return voltage;
    }
    
    public ArrayList<Integer> recherche(int ID){
        ArrayList<Integer> liste = new ArrayList<>();
        liste.add(ID);
        int parent = ID;
        boolean resistance = BD.getInstance().getComposante(ID, "type") == 5;
        
        while(parent != -1){
            parent = gestion.BD.getInstance().getComposante(parent, "parent").intValue();
            liste.add(parent);
        }
        
        if(resistance){
            liste.remove(0);
        }
        //Inversion de l'arrayList
        ArrayList<Integer> liste2 = new ArrayList<>();
        for(int i = liste.size() ; i >= 0 ; i--){
            liste2.add(liste.get(i));
        }
        
        return liste2;
    }
    
    public void ajouterComposante(Composante c, int emplacement){
        ArrayList<Integer> ordre = recherche(emplacement);
        Composante composantePresente = this.listeComposante.get(ordre.remove(0));
        
        while (!ordre.isEmpty()){
            composantePresente = composantePresente.getComposante(ordre.remove(0));
        }
        
        Branche composantePresente2 = (Branche)composantePresente;
        
        composantePresente2.ajouterComposante(c);
    }
}