package projetIntegrateur;

import affichage.ControlleurFrame;
import gestion.ControleurCircuit;

public class ProjetIntegrateur {

    public static void main(String[] args) {
        ControleurCircuit cc = new ControleurCircuit();
        ControlleurFrame cf = new ControlleurFrame(cc);
    }
}
