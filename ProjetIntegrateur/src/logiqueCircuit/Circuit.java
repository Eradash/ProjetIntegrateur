package logiqueCircuit;

import gestion.BD;
import java.util.ArrayList;

public class Circuit extends Serie{
    
    private double ampere;
    private double voltage;
    private String nom;
    
    public Circuit(){
        super(-1);
        voltage = 6;
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
        boolean resistance = BD.getInstance().getComposante(ID, "Type") == 5;
        
        while(parent != -1){
            parent = gestion.BD.getInstance().getComposante(parent, "Parent").intValue();
            liste.add(parent);
        }
        
        if(resistance){
            liste.remove(0);
        }
               
        //Inversion de l'arrayList
        ArrayList<Integer> liste2 = new ArrayList<>();
        for(int i = 0 ; i < liste.size() ; i++){
            liste2.add(liste.get( liste.size() - 1 - i ));
        }
        
        return liste2;
    }
    
    public Branche getComposanteEmplacement(int emplacement){
        return (Branche)getCompEmp(emplacement);
    }
    
    public Composante getCompEmp(int emplacement){
        if(emplacement == -1){
            return this;
        }
        ArrayList<Integer> liste = recherche(emplacement);
        Composante c = this;
        liste.remove(0);
        while (!liste.isEmpty()){
            c = c.getComposante(liste.remove(0));
        }
        return c;
    }
    
    public void ajouterComposante(Composante c, int ID_Parent){
        getComposanteEmplacement(ID_Parent).ajouterComposante(c);
    }
    
    @Override
    public void supprimerComposante(int ID_Parent){
        getComposanteEmplacement(ID_Parent).supprimerComposante(ID_Parent);
    }
}