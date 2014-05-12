package l;

import gestion.Ili;
import java.util.ArrayList;

public abstract class II implements I {

    private final int ID;

    public II() {
        ID = Ili.il().l();
    }

    public II(int id) {
        ID = Ili.il().l(id);
    }

    @Override
    public int I() {
        return ID;
    }

    @Override
    public abstract ArrayList<I> lI();

    public abstract void i(I c);

    public abstract void l(I c);

    public abstract void ll(int ID);
}
