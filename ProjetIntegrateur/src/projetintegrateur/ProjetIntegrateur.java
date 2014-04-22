package projetintegrateur;

<<<<<<< HEAD
import affichage.JFrameProjet;
=======
import affichage.ControlleurFrame;
import affichage.FrameProjet;
>>>>>>> Affichage_test
import gestion.ControleurCircuit;

public class ProjetIntegrateur {

<<<<<<< HEAD
    public static void main(String[] args) throws Exception {
        
        ControleurCircuit cc = new ControleurCircuit();
        
        cc.ouvrirCircuit("test");
        cc.run();
        cc.enregistrerCircuit();
=======
    public static void main(String[] args) {
        ControleurCircuit cc = new ControleurCircuit();
        ControlleurFrame cf = new ControlleurFrame(cc);
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameProjet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
>>>>>>> Affichage_test
    }
}