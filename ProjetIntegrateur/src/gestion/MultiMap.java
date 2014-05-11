package gestion;

import java.util.HashMap;
import java.util.Iterator;

/**
 * HashMap avec 2 clées pour une valeur
 * @author Vincent Poirier
 * @param <X> Le type de clé qui représente une ligne du tableau
 * @param <Y> Le type de clé qui représente les titres des colonnes
 * @param <VALEUR> Le type de valeur qui représente les valeurs des cases
 */
public class MultiMap<X, Y, VALEUR> extends HashMap<Y, HashMap<X, VALEUR>> {

    /**
     * Permet d'obtenir une valeur d'une case
     * @param x Ligne du tableau à aller chercher
     * @param y Colonne du tableau à aller chercher
     * @return La valeur associée avec les clées
     */
    public VALEUR get(X x, Y y) {
        return super.get(y).get(x);
    }

    /**
     * Permet de ranger une valeur à un emplacement précis
     * @param x Ligne du tableau
     * @param y Colonne du tableau
     * @param v Valeur à mettre dans la case sélectionnée
     * @return La valeur qui vient d'être mise pour les clées, null si non réussi.
     */
    public VALEUR put(X x, Y y, VALEUR v) {
        if (!super.containsKey(y)) {
            super.put(y, new HashMap<X, VALEUR>());
        }
        return super.get(y).put(x, v);
    }

    /**
     * Permet de retirer une ligne complète du tableau
     * @param x Ligne du tableau à retirer
     */
    public void removeX(X x) {
        for (Y k1 : super.keySet()) {
            super.get(k1).remove(x);
        }
    }

    /**
     * Permet d'obtenir une ligne complète de tableau
     * @param x Ligne à obtenir
     * @return HashMap de Titre de colonne, avec les valeurs des cases de la ligne correspondante
     */
    public HashMap<Y, VALEUR> getLigne(X x) {

        HashMap<Y, VALEUR> composante = new HashMap<>();

        Iterator<Y> iterator = super.keySet().iterator();

        while (iterator.hasNext()) {
            Y p = iterator.next();
            composante.put(p, super.get(p).get(x));
        }
        return composante;
    }
}
