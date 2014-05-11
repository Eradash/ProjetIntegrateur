package logiqueCircuit;

import java.util.ArrayList;

/**
 * Définit les comportements d'une I
 */
public interface I {

    /**
     * Permet d'obtenir l'ID d'une composante
     * @return ID de la composante
     */
    public int I();

    /**
     * Permet d'obtenir le type de la composante
     * @return Type de la composante
     */
    public Type II();

    /**
     * Permet d'obtenir la résistance équivalente de la composante
     * @return Résistance équivalente (Double)
     */
    public double Il();

    /**
     * Permet d'avoir une liste de composantes qui sont contenues dans la composante
     * @return Liste de composante filles
     */
    public ArrayList<I> lI();

    /**
     * Permtet d'avoir une composante avec son ID
     * @param ID ID de la composante recherchée
     * @return I demandée
     */
    public I i(int ID);

    /**
     * Permet de l la valeur principale de la composante (Voltage pour le circuit, Résistance pour les résistances)
     * @param newValue Nouvelle valeur
     */
    public void l(double newValue);
}
