package I11l;

import java.util.ArrayList;
import l.I1l;
import l.I;
import l.Ill;
import l.Il1;

public class MonTreeBuilder {

    public static Il11 l(I1l i) {
        if (i != null) {
            Il11 il = new Il11("lI", Il11.Il1, -1);
            ArrayList<I> li = i.lI();
            for (I Il : li) {
                il.l(l(Il));
            }
            return il;
        } else {
            return null;
        }
    }

    private static Il11 l(I c) {
        Il1 i = c.II();
        switch (i) {
            case li:
                int li = Il11.Lil;
                Ill il = (Ill) c;
                if (il.il()) {
                    li = Il11.Lli;
                }
                return new Il11("l", li, c.I());
            case l:
                Il11 m = new Il11("ll", Il11.Ill, c.I());
                for (I s : c.lI()) {
                    m.l(l(s));
                }
                return m;
            case i:
                Il11 n = new Il11("li", Il11.Li, c.I());
                for (I Il : c.lI()) {
                    n.l(l(Il));
                }
                return n;
        }
        return null;
    }
}
