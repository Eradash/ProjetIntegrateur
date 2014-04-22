package projetIntegrateur;

import affichage.ControlleurFrame;
import affichage.FrameProjet;
import gestion.BD;
import gestion.ControleurCircuit;

public class ProjetIntegrateur {
        
    public static void main(String[] args) {
        
        ControleurCircuit cc = new ControleurCircuit();
        ControlleurFrame cf = new ControlleurFrame(cc);
        
        BD.getInstance().ajouterListener(cf);
        BD.getInstance().ajouterListener(cc);

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
    }
}