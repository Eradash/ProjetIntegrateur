package affichage;

import gestion.ControleurCircuit;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class FrameProjet extends javax.swing.JFrame{
    
    ControlleurFrame cf;
    ControleurCircuit cc;
    
    public FrameProjet(ControlleurFrame cf, ControleurCircuit cc) {
        this.cf = cf;
        this.cc = cc;
        initComponents();
        setVisible(true);
    }
    
    public PanelCircuit getPanelCircuit(){
        return (PanelCircuit)panelCircuit;
    }
    
    private Dimension getDimension(){
        Toolkit tk = Toolkit.getDefaultToolkit();
        return tk.getScreenSize();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCircuit = new javax.swing.JPanel();
        panelBoutons = new javax.swing.JPanel();
        boutonResistance = new javax.swing.JButton();
        boutonParallele = new javax.swing.JButton();
        boutonFil = new javax.swing.JButton();
        panelProp = new javax.swing.JPanel();
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

        panelCircuit = new PanelCircuit(cf);
        panelCircuit.setBackground(new java.awt.Color(255, 255, 255));
        panelCircuit.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        panelCircuit.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));

        javax.swing.GroupLayout panelCircuitLayout = new javax.swing.GroupLayout(panelCircuit);
        panelCircuit.setLayout(panelCircuitLayout);
        panelCircuitLayout.setHorizontalGroup(
            panelCircuitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1094, Short.MAX_VALUE)
        );
        panelCircuitLayout.setVerticalGroup(
            panelCircuitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

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

        boutonFil.setText("Ajouter fil");
        boutonFil.setFocusPainted(false);
        boutonFil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boutonFilActionPerformed(evt);
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
                    .addComponent(boutonFil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(boutonFil, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelBoutons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelProp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCircuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelCircuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
<<<<<<< HEAD
        JFileChooser chooser = new JFileChooser();
        chooser.addChoosableFileFilter(new FiltreCircuit());
        int valeur = chooser.showOpenDialog(this);
            if (valeur == JFileChooser.APPROVE_OPTION) {
                chooser.getSelectedFile( ).getPath( );
 
            } else {
 
                JOptionPane.showMessageDialog(null,"Vous n'avez rien sélectionné.");
 
            }
=======
        cc.ouvrirCircuit("test");
>>>>>>> CreationComposantes
    }//GEN-LAST:event_MenuOuvrirActionPerformed

    private void MenuSauvegarderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuSauvegarderActionPerformed
        try{
            cc.enregistrerCircuit();
        } catch(Exception e){
            
        }
    }//GEN-LAST:event_MenuSauvegarderActionPerformed

    private void boutonResistanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonResistanceActionPerformed
        cf.BoutonResistance(evt);
    }//GEN-LAST:event_boutonResistanceActionPerformed

    private void boutonParalleleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonParalleleActionPerformed
        cf.BoutonParallele(evt);
    }//GEN-LAST:event_boutonParalleleActionPerformed

    private void boutonFilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonFilActionPerformed
        cf.BoutonFil(evt);
    }//GEN-LAST:event_boutonFilActionPerformed


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
    private javax.swing.JButton boutonFil;
    private javax.swing.JButton boutonParallele;
    private javax.swing.JButton boutonResistance;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPanel panelBoutons;
    private javax.swing.JPanel panelCircuit;
    private javax.swing.JPanel panelProp;
    // End of variables declaration//GEN-END:variables
}
