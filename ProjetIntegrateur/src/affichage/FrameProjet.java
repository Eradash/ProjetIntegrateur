package affichage;

public class FrameProjet extends javax.swing.JFrame{
    
    ControlleurFrame cf;
    
    public FrameProjet(ControlleurFrame cf) {
        this.cf = cf;
        initComponents();
        setVisible(true);
    }
    
    public PanelBoutons getPanelBoutons(){
        return (PanelBoutons)PanelBoutons;
    }
    
    public PanelCircuit getPanelCircuit(){
        return (PanelCircuit)Panel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelBoutons = new javax.swing.JPanel();
        BoutonResistance = new javax.swing.JButton();
        BoutonParallele = new javax.swing.JButton();
        BoutonFil = new javax.swing.JButton();
        Panel = new javax.swing.JPanel();
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
        setBackground(new java.awt.Color(204, 204, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        PanelBoutons = new PanelBoutons(cf);

        BoutonResistance.setText("Ajouter Résistance");
        BoutonResistance.setFocusPainted(false);
        BoutonResistance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonResistanceActionPerformed(evt);
            }
        });

        BoutonParallele.setText("Ajouter Parallele");
        BoutonParallele.setFocusPainted(false);
        BoutonParallele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonParalleleActionPerformed(evt);
            }
        });

        BoutonFil.setText("Ajouter Fil");
        BoutonFil.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BoutonFil.setFocusPainted(false);
        BoutonFil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonFilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBoutonsLayout = new javax.swing.GroupLayout(PanelBoutons);
        PanelBoutons.setLayout(PanelBoutonsLayout);
        PanelBoutonsLayout.setHorizontalGroup(
            PanelBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBoutonsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BoutonFil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BoutonResistance, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BoutonParallele, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PanelBoutonsLayout.setVerticalGroup(
            PanelBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBoutonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BoutonResistance, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BoutonParallele, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BoutonFil, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BoutonResistance.getAccessibleContext().setAccessibleName("BoutonResistance");
        BoutonParallele.getAccessibleContext().setAccessibleName("BoutonParallele");
        BoutonFil.getAccessibleContext().setAccessibleName("BoutonAjouterFil");

        Panel = new PanelCircuit(cf);
        Panel.setBackground(new java.awt.Color(255, 255, 255));
        Panel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        Panel.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 883, Short.MAX_VALUE)
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        MenuFichier.setText("Fichier");

        MenuOuvrir.setText("Ouvrir");
        MenuOuvrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuOuvrirActionPerformed(evt);
            }
        });
        MenuFichier.add(MenuOuvrir);

        MenuSauvegarder.setText("Sauvegarder");
        MenuSauvegarder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuSauvegarderActionPerformed(evt);
            }
        });
        MenuFichier.add(MenuSauvegarder);
        MenuFichier.add(jSeparator1);

        MenuQuitter.setText("Quitter");
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PanelBoutons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanelBoutons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 372, Short.MAX_VALUE))
                    .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("FramePrincipal");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BoutonResistanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonResistanceActionPerformed
        cf.BoutonResistance(evt);
    }//GEN-LAST:event_BoutonResistanceActionPerformed

    private void BoutonParalleleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonParalleleActionPerformed
        cf.BoutonParallele(evt);
    }//GEN-LAST:event_BoutonParalleleActionPerformed

    private void BoutonFilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonFilActionPerformed
        cf.BoutonFil(evt);
    }//GEN-LAST:event_BoutonFilActionPerformed

    private void MenuCopierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCopierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MenuCopierActionPerformed

    private void MenuOuvrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuOuvrirActionPerformed
        System.out.println("Ouvrir un circuit");
    }//GEN-LAST:event_MenuOuvrirActionPerformed

    private void MenuSauvegarderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSauvegarderActionPerformed
        System.out.println("Sauvegarder un circuit");
    }//GEN-LAST:event_MenuSauvegarderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonFil;
    private javax.swing.JButton BoutonParallele;
    private javax.swing.JButton BoutonResistance;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenuItem MenuColler;
    private javax.swing.JMenuItem MenuCopier;
    private javax.swing.JMenuItem MenuCouper;
    private javax.swing.JMenu MenuEdition;
    private javax.swing.JMenu MenuFichier;
    private javax.swing.JMenuItem MenuOuvrir;
    private javax.swing.JMenuItem MenuQuitter;
    private javax.swing.JMenuItem MenuSauvegarder;
    private javax.swing.JPanel Panel;
    private javax.swing.JPanel PanelBoutons;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
