package projetIntegrateur;

import gestion.ControleurCircuit;

public class ProjetIntegrateur {

    public static void main(String[] args) throws Exception {
        
        ControleurCircuit cc = new ControleurCircuit();
        
        cc.ouvrirCircuit("test");
        cc.run();
        cc.enregistrerCircuit();
    }
}