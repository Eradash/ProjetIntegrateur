package logiqueCircuit;

import gestion.GestionnaireID;
import java.util.ArrayList;

public class Resistance implements Composante{

    final int ID;
    double ohm;

    public Resistance(int ohm) {
        ID = GestionnaireID.getInstance().ajouterComp();
        this.ohm = ohm;
    }

    public Resistance() {
        ID = GestionnaireID.getInstance().ajouterComp();
        ohm = -1;
    }

    
    public boolean calculExplosion(int ampere){
        return true;
    }
    
    @Override
    public int getNumero() {
        return ID;
    }

    @Override
    public Type getType() {
        return Type.RESISTANCE;
    }

    @Override
    public double getResistanceEquivalente() {
        return ohm;
    }

    @Override
    public ArrayList<Composante> getComposantes() {
        return null;
    }
}