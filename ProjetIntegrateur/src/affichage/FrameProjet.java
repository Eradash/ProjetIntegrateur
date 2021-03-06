package affichage;

import JTree.Tree;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Frame du projet. Gère toutes les entrées utilisateur et envoie les notifications au ControlleurFrame
 */
public class FrameProjet extends JFrame {

    private ControlleurFrame cf;
    private Tree t = new Tree(cf);
    private final PanelProp pp;

    /**
     * Initialisation du Frame, création du Panel Propriétés et de l'Arbre 
     * @param cf Controlleur Frame du pojet (pour la jonction avec le reste du projet)
     */
    public FrameProjet(ControlleurFrame cf) {
        this.cf = cf;
        this.pp = new PanelProp();
        t = new Tree(cf);
        initComponents();
        setVisible(true);
    }

    /**
     * Permet au ControlleurFrame d'avoir une instance de l'Arbre (Pour imiter le MVC)
     * @return L'Arbre de l'affichage
     */
    public Tree getTree() {
        return t;
    }

    /**
     * Permet au ControlleurFrame d'avoir une instance du Panel Propriétés (Pour imiter le MVC)
     * @return Le Panel Propriétés
     */
    public PanelProp getPanelProp() {
        return pp;
    }

    /**
     * Permet au ControlleurFrame d'avoir une instance du Frame (Pour imiter le MVC)
     * @return Le Frame
     */
    public JFrame getFrame() {
        return this;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBoutons = new javax.swing.JPanel();
        boutonResistance = new javax.swing.JButton();
        boutonParallele = new javax.swing.JButton();
        boutonBranche = new javax.swing.JButton();
        panelTree = new javax.swing.JPanel();
        panelProp = new javax.swing.JPanel();
        MenuBar = new javax.swing.JMenuBar();
        MenuFichier = new javax.swing.JMenu();
        menuOuvrir = new javax.swing.JMenuItem();
        menuSauvegarder = new javax.swing.JMenuItem();
        menuNouveau = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        MenuQuitter = new javax.swing.JMenuItem();
        MenuEdition = new javax.swing.JMenu();
        menuModifier = new javax.swing.JMenuItem();
        menuSupprimer = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuModifArron = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Analyseur de circuit");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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
                .addContainerGap()
                .addGroup(panelBoutonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boutonBranche, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boutonParallele, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boutonResistance, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
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

        panelTree.add(t);

        javax.swing.GroupLayout panelTreeLayout = new javax.swing.GroupLayout(panelTree);
        panelTree.setLayout(panelTreeLayout);
        panelTreeLayout.setHorizontalGroup(
            panelTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 321, Short.MAX_VALUE)
        );
        panelTreeLayout.setVerticalGroup(
            panelTreeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        panelProp.add(pp);

        javax.swing.GroupLayout panelPropLayout = new javax.swing.GroupLayout(panelProp);
        panelProp.setLayout(panelPropLayout);
        panelPropLayout.setHorizontalGroup(
            panelPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelPropLayout.setVerticalGroup(
            panelPropLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );

        MenuFichier.setText("Fichier");

        menuOuvrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuOuvrir.setText("Ouvrir");
        menuOuvrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOuvrirActionPerformed(evt);
            }
        });
        MenuFichier.add(menuOuvrir);

        menuSauvegarder.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuSauvegarder.setText("Sauvegarder");
        menuSauvegarder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSauvegarderActionPerformed(evt);
            }
        });
        MenuFichier.add(menuSauvegarder);

        menuNouveau.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menuNouveau.setText("Nouveau");
        menuNouveau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNouveauActionPerformed(evt);
            }
        });
        MenuFichier.add(menuNouveau);
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

        menuModifier.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_M, 0));
        menuModifier.setText("Modifier");
        menuModifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModifierActionPerformed(evt);
            }
        });
        MenuEdition.add(menuModifier);

        menuSupprimer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        menuSupprimer.setText("Supprimer");
        menuSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSupprimerActionPerformed(evt);
            }
        });
        MenuEdition.add(menuSupprimer);
        MenuEdition.add(jSeparator2);

        menuModifArron.setText("Modifier arrondissement");
        menuModifArron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModifArronActionPerformed(evt);
            }
        });
        MenuEdition.add(menuModifArron);

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
                .addComponent(panelTree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTree, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelBoutons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelProp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("FramePrincipal");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModifierActionPerformed
        cf.Bouton("Modifier");
    }//GEN-LAST:event_menuModifierActionPerformed

    private void menuOuvrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuOuvrirActionPerformed
        cf.menuOuvrir();
    }//GEN-LAST:event_menuOuvrirActionPerformed

    private void menuSauvegarderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSauvegarderActionPerformed
        cf.menuSauvegarder();
    }//GEN-LAST:event_menuSauvegarderActionPerformed

    private void boutonResistanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonResistanceActionPerformed
        cf.Bouton("Resistance");
    }//GEN-LAST:event_boutonResistanceActionPerformed

    private void boutonParalleleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonParalleleActionPerformed
        cf.Bouton("Parallele");
    }//GEN-LAST:event_boutonParalleleActionPerformed

    private void boutonBrancheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boutonBrancheActionPerformed
        cf.Bouton("Branche");
    }//GEN-LAST:event_boutonBrancheActionPerformed

    private void MenuQuitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuQuitterActionPerformed
        int n = JOptionPane.showConfirmDialog(
                this,
                "Voulez-vous vraiment quitter ?\nAssurez-vous d'avoir enregistré",
                "Quitter",
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (n == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_MenuQuitterActionPerformed

    private void menuNouveauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNouveauActionPerformed
        cf.menuNouveau();
    }//GEN-LAST:event_menuNouveauActionPerformed

    private void menuSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSupprimerActionPerformed
        cf.BoutonSupprimer();
    }//GEN-LAST:event_menuSupprimerActionPerformed

    private void menuModifArronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModifArronActionPerformed
        cf.menuArrondissement();
        
    }//GEN-LAST:event_menuModifArronActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu MenuEdition;
    private javax.swing.JMenu MenuFichier;
    private javax.swing.JMenuItem MenuQuitter;
    private javax.swing.JButton boutonBranche;
    private javax.swing.JButton boutonParallele;
    private javax.swing.JButton boutonResistance;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuItem menuModifArron;
    private javax.swing.JMenuItem menuModifier;
    private javax.swing.JMenuItem menuNouveau;
    private javax.swing.JMenuItem menuOuvrir;
    private javax.swing.JMenuItem menuSauvegarder;
    private javax.swing.JMenuItem menuSupprimer;
    private javax.swing.JPanel panelBoutons;
    private javax.swing.JPanel panelProp;
    private javax.swing.JPanel panelTree;
    // End of variables declaration//GEN-END:variables
}
