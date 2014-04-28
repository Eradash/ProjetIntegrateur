package affichage;

import JTree.Tree;
import gestion.ControleurCircuit;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FrameProjet extends javax.swing.JFrame{
    
    ControlleurFrame cf;
    ControleurCircuit cc;
    Tree t = new Tree(cf);
    
    public FrameProjet(ControlleurFrame cf, ControleurCircuit cc) {
        this.cf = cf;
        this.cc = cc;
        initComponents();
        setVisible(true);
    }
    
    public Tree getTree(){
        return t;
    }
    
    public void update(){
        repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBoutons = new javax.swing.JPanel();
        boutonResistance = new javax.swing.JButton();
        boutonParallele = new javax.swing.JButton();
        boutonBranche = new javax.swing.JButton();
        panelProp = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        MenuBar = new javax.swing.JMenuBar();
        MenuFichier = new javax.swing.JMenu();
        MenuOuvrir = new javax.swing.JMenuItem();
        MenuSauvegarder = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        MenuQuitter = new javax.swing.JMenuItem();
        MenuEdition = new javax.swing.JMenu();
        MenuCopier = new javax.swing.JMenuItem();
        MenuCouper = new javax.swing.JMenuItem();
        MenuColler = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analyseur de circuit");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);

        panelBoutons.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        boutonResistance.setText("Ajouter résistance");
        boutonResistance.setFocusPainted(false);
        boutonResistance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonResistanceActionPerformed(evt);
            }
        });

        boutonParallele.setText("Ajouter parallèle");
        boutonParallele.setFocusPainted(false);
        boutonParallele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonParalleleActionPerformed(evt);
            }
        });

        boutonBranche.setText("Ajouter branche");
        boutonBranche.setFocusPainted(false);
        boutonBranche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonBrancheActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBoutonsLayout = new javax.swing.GroupLayout(panelBoutons);
        panelBoutons.setLayout(panelBoutonsLayout);
        panelBoutonsLayout.setHorizontalGroup(
            panelBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoutonsLayout.createSequentialGroup()
                .addGroup(panelBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boutonParallele, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boutonResistance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                    .addComponent(boutonBranche, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelBoutonsLayout.setVerticalGroup(
            panelBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBoutonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(boutonResistance, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boutonParallele, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boutonBranche, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelProp.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Propriétés", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12))); // NOI18N

        javax.swing.GroupLayout panelPropLayout = new javax.swing.GroupLayout(panelProp);
        panelProp.setLayout(panelPropLayout);
        panelPropLayout.setHorizontalGroup(
            panelPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelPropLayout.setVerticalGroup(
            panelPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );

        jPanel1.add(t);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 766, Short.MAX_VALUE)
        );

        MenuFichier.setText("Fichier");

        MenuOuvrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        MenuOuvrir.setText("Ouvrir");
        MenuOuvrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuOuvrirActionPerformed(evt);
            }
        });
        MenuFichier.add(MenuOuvrir);

        MenuSauvegarder.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        MenuSauvegarder.setText("Sauvegarder");
        MenuSauvegarder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSauvegarderActionPerformed(evt);
            }
        });
        MenuFichier.add(MenuSauvegarder);
        MenuFichier.add(jSeparator1);

        MenuQuitter.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        MenuQuitter.setText("Quitter");
        MenuQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuQuitterActionPerformed(evt);
            }
        });
        MenuFichier.add(MenuQuitter);

        MenuBar.add(MenuFichier);

        MenuEdition.setText("Édition");

        MenuCopier.setText("Copier");
        MenuCopier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCopierActionPerformed(evt);
            }
        });
        MenuEdition.add(MenuCopier);

        MenuCouper.setText("Couper");
        MenuEdition.add(MenuCouper);

        MenuColler.setText("Coller");
        MenuEdition.add(MenuColler);

        MenuBar.add(MenuEdition);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBoutons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelProp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelBoutons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelProp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("FramePrincipal");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MenuCopierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCopierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuCopierActionPerformed

    private void MenuOuvrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuOuvrirActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FiltreCircuit());
        int valeur = chooser.showOpenDialog(this);
            if (valeur == JFileChooser.APPROVE_OPTION) {
                cc.ouvrirCircuit(chooser.getSelectedFile().getPath());
            } else {
                JOptionPane.showMessageDialog(null,"Fichier invalide");
            }
    }//GEN-LAST:event_MenuOuvrirActionPerformed

    private void MenuSauvegarderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSauvegarderActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FiltreCircuit());
        int valeur = chooser.showSaveDialog(this);
            if (valeur == JFileChooser.APPROVE_OPTION) {
                cc.enregistrerCircuit(chooser.getSelectedFile().getPath());
            } else {
                JOptionPane.showMessageDialog(null,"Fichier invalide");
            }
    }//GEN-LAST:event_MenuSauvegarderActionPerformed

    private void boutonResistanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonResistanceActionPerformed
        cf.BoutonResistance(evt);
    }//GEN-LAST:event_boutonResistanceActionPerformed

    private void boutonParalleleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonParalleleActionPerformed
        cf.BoutonParallele(evt);
    }//GEN-LAST:event_boutonParalleleActionPerformed

    private void boutonBrancheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonBrancheActionPerformed
        cf.BoutonBranche(evt);
    }//GEN-LAST:event_boutonBrancheActionPerformed

    private void MenuQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuQuitterActionPerformed
        int n = JOptionPane.showConfirmDialog(
                this,
                "Voulez-vous vraiment quitter ?\nAssurez-vous d'avoir enregistré",
                "Quitter",
                JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
        if(n == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_MenuQuitterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem MenuColler;
    private javax.swing.JMenuItem MenuCopier;
    private javax.swing.JMenuItem MenuCouper;
    private javax.swing.JMenu MenuEdition;
    private javax.swing.JMenu MenuFichier;
    private javax.swing.JMenuItem MenuOuvrir;
    private javax.swing.JMenuItem MenuQuitter;
    private javax.swing.JMenuItem MenuSauvegarder;
    private javax.swing.JButton boutonBranche;
    private javax.swing.JButton boutonParallele;
    private javax.swing.JButton boutonResistance;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPanel panelBoutons;
    private javax.swing.JPanel panelProp;
    // End of variables declaration//GEN-END:variables
}
