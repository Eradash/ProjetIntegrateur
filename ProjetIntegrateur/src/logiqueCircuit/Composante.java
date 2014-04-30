package logiqueCircuit;

import java.util.ArrayList;

public interface Composante {

    public int getNumero();

    public Type getType();

    public double getResistanceEquivalente();

    public ArrayList<Composante> getComposantes();

    public Composante getComposante(int ID);

    public void modifier(double newValue);
}
