package logiqueCircuit;

import gestion.BD;
import java.util.ArrayList;

/**
 * Représente un Circuit électrique. Agit comme un Série, puisqu'il ne contient que des composantes en série, et se calcul comme tel...
 */
public class Circuit extends Serie {

    private double ampere;
    private double voltage;

    /**
     * Constructeur par défaut
     */
    public Circuit() {
        super(-1);
        voltage = 6;
    }

    @Override
    public Type getType() {
        return Type.CIRCUIT;
    }

    /**
     * Permet d'avoir l'Ampère que fournit la pile du circuit
     * @return Ampère fournit
     */
    public double getAmpere() {
        return ampere;
    }

    /**
     * Permet d'ajuster l'ampère fournit par la pile
     * @param amp Nouvel ampère
     */
    public void setAmpere(double amp) {
        this.ampere = amp;
    }

    /**
     * Permet d'avoir le voltage de la pile
     * @return Voltage de la pile
     */
    public double getVoltage() {
        return voltage;
    }

    @Override
    public void modifier(double newValue) {
        voltage = newValue;
    }

    /**
     * Permet de rechercher le chemin d'une composante dans le circuit avec son ID.
     * @param ID ID de la composante recherchée
     * @return Liste des composantes parents de la composante recherchée. ex. {-1,2,3}
     * La composante recherchée est dans la composante 3, qui est dans la composante 2, qui est dans le circuit (ID Circuit = -1)
     */
    public ArrayList<Integer> recherche(int ID) {
        ArrayList<Integer> liste = new ArrayList<>();
        liste.add(ID);
        int parent = ID;

        while (parent != -1) {
            parent = gestion.BD.getInstance().getComposante(parent, "Parent").intValue();
            liste.add(parent);
        }

        //Inversion de l'arrayList
        ArrayList<Integer> liste2 = new ArrayList<>();
        for (int i = 0; i < liste.size(); i++) {
            liste2.add(liste.get(liste.size() - 1 - i));
        }

        return liste2;
    }

    /**
     * Permet d'obtenir une composante à un emplacement du circuit
     * @param emplacement ID de la composante à obtenir
     * @return Une composante sous forme de branche
     */
    public Branche getComposanteEmplacement(int emplacement) {
        return (Branche) getCompEmp(emplacement);
    }

    /**
     * Permet d'obtenir une composante à un emplacement du circuit
     * @param emplacement ID de la composante à obtenir
     * @return La composante recherchée
     */
    public Composante getCompEmp(int emplacement) {
        if (emplacement == -1) {
            return this;
        }
        ArrayList<Integer> liste = recherche(emplacement);
        Composante c = this;
        liste.remove(0);
        while (!liste.isEmpty()) {
            c = c.getComposante(liste.remove(0));
        }
        return c;
    }

    /**
     * Ajouter une composante à une autre composante du circuit
     * @param c La composante à ajouter
     * @param ID_Parent ID du parent désiré pour la nouvelle composante
     */
    public void ajouterComposante(Composante c, int ID_Parent) {
        getComposanteEmplacement(ID_Parent).ajouterComposante(c);
    }

    @Override
    public void supprimerComposante(int ID) {
        double ID_Parent = BD.getInstance().getComposante(ID, "Parent");
        if ((int) ID_Parent == -1) {
            super.supprimerComposante(ID);
        } else {
            getComposanteEmplacement((int) ID_Parent).supprimerComposante(ID);
        }
    }

    /**
     * Permet de modifier une composante du circuit
     * @param ID ID de la composante à modifier
     * @param newValue 
     */
    public void modifierComposante(int ID, double newValue) {
        if (ID == -1) {
            voltage = newValue;
        } else {
            getCompEmp(ID).modifier(newValue);
        }
    }

}
