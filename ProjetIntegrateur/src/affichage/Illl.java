package affichage;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class Illl extends FileFilter {

    private final String i;
    private final String l;

    public Illl() {
        this.i = "l";
        this.l = "l";
    }

    private boolean l(String l) {
        return l.equals(i);
    }

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        String il = null;
        String li = f.getName();
        int ll = li.lastIndexOf('.');
        if (ll > 0 && ll < li.length() - 1) {
            il = li.substring(ll + 1).toLowerCase();
        }
        return il != null && l(il);
    }

    @Override
    public String getDescription() {
        return l;
    }
}
