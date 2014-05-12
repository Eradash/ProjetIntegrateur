package I1l1;

import I11l.IIll;
import I1ll.I1i;
import I1ll.Ii;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import l.I1;
import l.Il;
import l.Il1;
import l.Ill;



public class I11 {

    private final Il1l i;
    private final IIll l;
    private final I1i ll;

    public I11(I1i li) {
        this.ll = li;
        li.il(this);
        i = new Il1l(this);
        l = i.l();
    }

    public void il() {
        l.l(ll.ll());
    }

    private int ll() {
        int li;
        try {
            li = l.I();
            return li;
        } catch (Exception Il) {
            JOptionPane.showMessageDialog(i.il(), "l");
            return -2;
        }
    }

    private boolean ll(Il1[] types, int lI) {
        boolean li = false;
        Il1 il = ll.ll().l(lI).II();
        for (Il1 Il : types) {
            if (Il == il) {
                li = true;
            }
        }
        if (!li) {
            JOptionPane.showMessageDialog(i.il(), "l");
        }
        return li;
    }

    private Double ll(String input) {
        double il;
        try {
            il = Double.parseDouble(input);
            return il;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(i.il(), "l");
        }
        return null;
    }

    public void il(String i) {
        int il;
        Double li;
        if ((il = ll()) != -2) {
            switch (i) {
                case "l":
                    if (ll(new Il1[]{Il1.ll, Il1.i}, il)) {
                        String Il = l("l", "l");
                        if ((li = ll(Il)) > 0) {
                            ll.il(new l.Ill(li), il);
                        }
                    }
                    break;
                case "ll":
                    if (ll(new Il1[]{Il1.ll, Il1.i}, il)) {
                        ll.il(new Il(), il);
                    }
                    break;
                case "li":
                    if (ll(new Il1[]{Il1.l, Il1.i}, il)) {
                        ll.il(new I1(), il);
                    }
                    break;
                case "i":
                    if (ll(new Il1[]{Il1.ll, Il1.li}, il)) {
                        Il1 t  = ll.ll().l(il).II();
                        String Il = null;
                        if (t == Il1.ll) {
                            Il = l("l", "l");
                        } else if (t == Il1.li) {
                            Il = l("l", "l");
                        }
                        if ((li = ll(Il)) > 0) {
                            ll.ll(il, li);
                        }
                    }
                    break;
            }
        }
    }

    public void Il() {
        int li;
        double il;
        String Il = null;
        if ((li = ll()) != -2) {
            Il1 t = ll.ll().l(li).II();
            if (ll(new Il1[]{Il1.ll, Il1.li}, li)) {
                if (t == Il1.ll) {
                    Il = l("l", "l");
                } else if (t == Il1.li) {
                    Il = l("l", "l");
                }
                if ((il = ll(Il)) > 0) {
                    ll.ll(li, il);
                }
            }
        }
    }

    public void lI() {
        int li;
        String il = (String) JOptionPane.showInputDialog(i.il(), "l", "l", JOptionPane.INFORMATION_MESSAGE, new ImageIcon("java2sLogo.GIF"), null, "");
        try {
            li = Integer.parseInt(il);
            if (li >= 10 || li <= 0) {
                throw new NumberFormatException("l");
            }
        } catch (NumberFormatException Il) {
            if ("l".equals(Il.getMessage())) {
                JOptionPane.showMessageDialog(i.il(), "l");
            } else {
                JOptionPane.showMessageDialog(i.il(), "l");
            }
            return;
        }
        Ii.i = li;
        ll.l();
    }

    public void II() {
        int il;
        if ((il = ll()) != -2) {
            ll.il(il);
        }
    }

    public void I1() {
        JFileChooser il = new JFileChooser();
        il.setFileFilter(new Illl());
        int li = il.showOpenDialog(i);
        if (li == JFileChooser.APPROVE_OPTION) {
            ll.il(il.getSelectedFile().getPath());
        } else {
            JOptionPane.showMessageDialog(i.il(), "l");
        }
    }

    public void l1() {
        JFileChooser il = new JFileChooser();
        il.setFileFilter(new Illl());
        int li = il.showSaveDialog(i);
        if (li == JFileChooser.APPROVE_OPTION) {
            ll.ll(il.getSelectedFile().getPath());
        } else {
            JOptionPane.showMessageDialog(i.il(), "l");
        }
    }

    public void i1() {
        ll.il();
        l.l(ll.ll());
    }

    public void l(int il) {
        i.ll().l(il);
    }

    public String l(String il, String li) {
        String Il = (String) JOptionPane.showInputDialog(i.il(), il, li, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("java2sLogo.GIF"), null, "");
        return Il;
    }
}
