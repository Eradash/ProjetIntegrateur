package I1l1;

import I11l.IIll;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Il1l extends JFrame {

    private I11 i;
    private IIll l = new IIll(i);
    private final Ill1 ll;

    public Il1l(I11 i) {
        this.i = i;
        this.ll = new Ill1();
        l = new IIll(i);
        initComponents();
        setVisible(true);
    }

    public IIll l() {
        return l;
    }

    public Ill1 ll() {
        return ll;
    }

    public JFrame il() {
        return this;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Iii = new javax.swing.JPanel();
        I11 = new javax.swing.JButton();
        Illl = new javax.swing.JButton();
        Ill1 = new javax.swing.JButton();
        Il1l = new javax.swing.JPanel();
        I1ll = new javax.swing.JPanel();
        I = new javax.swing.JMenuBar();
        Il = new javax.swing.JMenu();
        II = new javax.swing.JMenuItem();
        I1 = new javax.swing.JMenuItem();
        I1l = new javax.swing.JMenuItem();
        Il1 = new javax.swing.JPopupMenu.Separator();
        Ill = new javax.swing.JMenuItem();
        Ii = new javax.swing.JMenu();
        Iil = new javax.swing.JMenuItem();
        Ili = new javax.swing.JMenuItem();
        Ii1 = new javax.swing.JPopupMenu.Separator();
        I1i = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analyseur de circuit");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(350, 150));

        Iii.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        I11.setText("Ajouter Résistance");
        I11.setFocusPainted(false);
        I11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I11ActionPerformed(evt);
            }
        });

        Illl.setText("Ajouter Parallele");
        Illl.setFocusPainted(false);
        Illl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IlllActionPerformed(evt);
            }
        });

        Ill1.setText("Ajouter branche");
        Ill1.setFocusPainted(false);
        Ill1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Ill1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout IiiLayout = new javax.swing.GroupLayout(Iii);
        Iii.setLayout(IiiLayout);
        IiiLayout.setHorizontalGroup(
            IiiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IiiLayout.createSequentialGroup()
                .addGroup(IiiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Illl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(I11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addComponent(Ill1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        IiiLayout.setVerticalGroup(
            IiiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(IiiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(I11, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Illl, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Ill1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Il1l.add(l);

        javax.swing.GroupLayout Il1lLayout = new javax.swing.GroupLayout(Il1l);
        Il1l.setLayout(Il1lLayout);
        Il1lLayout.setHorizontalGroup(
            Il1lLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 321, Short.MAX_VALUE)
        );
        Il1lLayout.setVerticalGroup(
            Il1lLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        I1ll.add(ll);

        javax.swing.GroupLayout I1llLayout = new javax.swing.GroupLayout(I1ll);
        I1ll.setLayout(I1llLayout);
        I1llLayout.setHorizontalGroup(
            I1llLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        I1llLayout.setVerticalGroup(
            I1llLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );

        Il.setText("Fichier");

        II.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        II.setText("Ouvrir");
        II.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IIActionPerformed(evt);
            }
        });
        Il.add(II);

        I1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        I1.setText("Sauvegarder");
        I1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I1ActionPerformed(evt);
            }
        });
        Il.add(I1);

        I1l.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        I1l.setText("Nouveau");
        I1l.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I1lActionPerformed(evt);
            }
        });
        Il.add(I1l);
        Il.add(Il1);

        Ill.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        Ill.setText("Quitter");
        Ill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IllActionPerformed(evt);
            }
        });
        Il.add(Ill);

        I.add(Il);

        Ii.setText("Édition");

        Iil.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, 0));
        Iil.setText("Modifier");
        Iil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IilActionPerformed(evt);
            }
        });
        Ii.add(Iil);

        Ili.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        Ili.setText("Supprimer");
        Ili.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IliActionPerformed(evt);
            }
        });
        Ii.add(Ili);
        Ii.add(Ii1);

        I1i.setText("Modifier arrondissement");
        I1i.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                I1iActionPerformed(evt);
            }
        });
        Ii.add(I1i);

        I.add(Ii);

        setJMenuBar(I);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Iii, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(I1ll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Il1l, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Il1l, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Iii, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(I1ll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("FramePrincipal");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IilActionPerformed
        i.il("i");
    }//GEN-LAST:event_IilActionPerformed

    private void IIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IIActionPerformed
        i.I1();
    }//GEN-LAST:event_IIActionPerformed

    private void I1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I1ActionPerformed
        i.l1();
    }//GEN-LAST:event_I1ActionPerformed

    private void I11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I11ActionPerformed
        i.il("l");
    }//GEN-LAST:event_I11ActionPerformed

    private void IlllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IlllActionPerformed
        i.il("ll");
    }//GEN-LAST:event_IlllActionPerformed

    private void Ill1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Ill1ActionPerformed
        i.il("li");
    }//GEN-LAST:event_Ill1ActionPerformed

    private void IllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IllActionPerformed
        int n = JOptionPane.showConfirmDialog(
                this,
                "l",
                "l",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (n == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_IllActionPerformed

    private void I1lActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I1lActionPerformed
        i.i1();
    }//GEN-LAST:event_I1lActionPerformed

    private void IliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IliActionPerformed
        i.II();
    }//GEN-LAST:event_IliActionPerformed

    private void I1iActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_I1iActionPerformed
        i.lI();
        
    }//GEN-LAST:event_I1iActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar I;
    private javax.swing.JMenuItem I1;
    private javax.swing.JButton I11;
    private javax.swing.JMenuItem I1i;
    private javax.swing.JMenuItem I1l;
    private javax.swing.JPanel I1ll;
    private javax.swing.JMenuItem II;
    private javax.swing.JMenu Ii;
    private javax.swing.JPopupMenu.Separator Ii1;
    private javax.swing.JPanel Iii;
    private javax.swing.JMenuItem Iil;
    private javax.swing.JMenu Il;
    private javax.swing.JPopupMenu.Separator Il1;
    private javax.swing.JPanel Il1l;
    private javax.swing.JMenuItem Ili;
    private javax.swing.JMenuItem Ill;
    private javax.swing.JButton Ill1;
    private javax.swing.JButton Illl;
    // End of variables declaration//GEN-END:variables
}
