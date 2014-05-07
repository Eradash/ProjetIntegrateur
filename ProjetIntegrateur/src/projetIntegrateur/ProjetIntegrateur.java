package projetIntegrateur;

import affichage.ControlleurFrame;
import gestion.ControleurCircuit;

public class ProjetIntegrateur {

    public static void main(String[] args) {
        new ControlleurFrame(new ControleurCircuit());
    }
}
