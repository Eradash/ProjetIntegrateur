package logiqueCircuit;

import gestion.BD;
import java.util.ArrayList;
import observer.Observable;
import observer.Observateur;

public class Circuit extends Serie implements Observable{
    
    private double ampere;
    private double voltage;
    private String nom;
    
    public Circuit(){
        super(-1);
    }

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
    
    public void setAmpere(double amp){
        this.ampere = amp;
    }
    
    public double getVoltage(){
        return voltage;
    }
    
    public void setVoltage(double volt){
        this.voltage = volt;
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
    
    public Branche getComposanteEmplacement(int emplacement){
        ArrayList<Integer> liste = recherche(emplacement);
        Composante c = null;
        while (!liste.isEmpty()){
            super.getComposante(liste.remove(0));
        }
        return (Branche)c;
    }
    
    public void ajouterComposante(Composante c, int ID_Parent){
        getComposanteEmplacement(ID_Parent).ajouterComposante(c);
    }
    
    @Override
    public void supprimerComposante(int ID_Parent){
        getComposanteEmplacement(ID_Parent).supprimerComposante(ID_Parent);
    }

    @Override
    public void notifier() {
        
    }

    @Override
    public void ajouterObservateur(Observateur obs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimerObservateur(Observateur obs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}