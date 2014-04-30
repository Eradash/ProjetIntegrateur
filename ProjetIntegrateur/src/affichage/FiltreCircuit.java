package affichage;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class FiltreCircuit extends FileFilter {

    String extention;
    String description;

    public FiltreCircuit() {
        this.extention = "circuit";
        this.description = "Circuit électrique";
    }

    boolean isGood(String suffixe) {
        return suffixe.equals(extention);
    }

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        String suffixe = null;
        String s = f.getName();
        int i = s.lastIndexOf('.');
        if (i > 0 && i < s.length() - 1) {
            suffixe = s.substring(i + 1).toLowerCase();
        }
        return suffixe != null && isGood(suffixe);
    }

    @Override
    public String getDescription() {
        return description;
    }
}
