package affichage;

import gestion.ControleurCircuit;

public class ControlleurFrame {

    FrameProjet frame;
    ControleurCircuit cc;

    public ControlleurFrame(ControleurCircuit cc) {
        this.cc = cc;
        frame = new FrameProjet();
    }

    
}
