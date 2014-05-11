package projetIntegrateur;

import affichage.ControlleurFrame;
import gestion.ControleurCircuit;

public class ProjetIntegrateur {

    /**
     * Main...
     * @param args inutiles pour le projet
     */
    public static void main(String[] args) {
        new ControlleurFrame(new ControleurCircuit());
    }
}
