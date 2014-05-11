package logiqueCircuit;

import gestion.GestionnaireID;
import java.util.ArrayList;

/**
 * Branche d'un circuit. Sert pour les Séries et les branches du Paralèlle
 */
public abstract class Branche implements I {

    private final int ID;

    /**
     * Permet de créer une branche. La Branche va demander un ID au Gestionnaire d'ID, et le stocker dans sa variable.
     */
    public Branche() {
        ID = GestionnaireID.getInstance().ajouterComp();
    }

    /**
     * Permet de créer une branche avec un ID spécifique.
     * @param id ID à ranger. Faire attention de ne pas prendre un ID déjà utilisé.
     */
    public Branche(int id) {
        ID = GestionnaireID.getInstance().ajouterComp(id);
    }

    @Override
    public int I() {
        return ID;
    }

    @Override
    public abstract ArrayList<I> lI();

    /**
     * Permet d'ajouter une composante à la Branche
     * @param c La I à ajouter
     */
    public abstract void ajouterComposante(I c);

    /**
     * Permet de supprimer une composante de la Branche
     * @param c La I à supprimer
     */
    public abstract void supprimerComposante(I c);

    /**
     * Permet de supprimer une composante de la Branche par son ID
     * @param ID L'ID de la I à supprimer
     */
    public abstract void supprimerComposante(int ID);
}
