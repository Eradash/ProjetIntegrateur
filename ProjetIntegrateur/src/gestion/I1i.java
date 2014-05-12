package gestion;

import affichage.ControlleurFrame;
import l.I1l;
import l.I;

public class I1i {

    private final Iil l = Iil.ll();
    private final Ii ll = new Ii();
    private final static GestionXML li = GestionXML.getInstance();
    private ControlleurFrame il;
    private I1l Il;
    
    public void il(ControlleurFrame i) {
        this.il = i;
    }

    public void il() {
        l.il();
        Il = new I1l();
        l();
    }

    public void il(String i) {
        Il = li.decoder(i);
        l();
    }

    public void ll(String l) {
        li.encoder(Il, l);
    }

    public I1l ll() {
        return Il;
    }

    public void il(I i, int l) {
        this.Il.ll(i, l);
        l();
    }

    public void il(int i) {
        this.Il.ll(i);
        l.il(i);
        l();
    }

    public void ll(int l, double i) {
        Il.ll(l, i);
        l();
    }

    public void l() {
        ll.il(Il);
        il.update();
    }
}