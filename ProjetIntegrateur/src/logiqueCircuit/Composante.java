package logiqueCircuit;

import java.util.ArrayList;

/**
 * Définit les comportements d'une Composante
 */
public interface Composante {

    /**
     * Permet d'obtenir l'ID d'une composante
     * @return ID de la composante
     */
    public int getNumero();

    /**
     * Permet d'obtenir le type de la composante
     * @return Type de la composante
     */
    public Type getType();

    /**
     * Permet d'obtenir la résistance équivalente de la composante
     * @return Résistance équivalente (Double)
     */
    public double getResistanceEquivalente();

    /**
     * Permet d'avoir une liste de composantes qui sont contenues dans la composante
     * @return Liste de composante filles
     */
    public ArrayList<Composante> getComposantes();

    /**
     * Permtet d'avoir une composante avec son ID
     * @param ID ID de la composante recherchée
     * @return Composante demandée
     */
    public Composante getComposante(int ID);

    /**
     * Permet de modifier la valeur principale de la composante (Voltage pour le circuit, Résistance pour les résistances)
     * @param newValue Nouvelle valeur
     */
    public void modifier(double newValue);
}
