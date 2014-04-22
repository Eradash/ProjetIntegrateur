package affichage;

public class PanelBoutons extends javax.swing.JPanel {

    public PanelBoutons() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BoutonResistance = new javax.swing.JButton();
        BoutonFil = new javax.swing.JButton();
        BoutonParallele = new javax.swing.JButton();

        BoutonResistance.setText("Ajouter Résistance");
        BoutonResistance.setFocusPainted(false);
        BoutonResistance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonResistanceActionPerformed(evt);
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

        BoutonParallele.setText("Ajouter Parallele");
        BoutonParallele.setFocusPainted(false);
        BoutonParallele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoutonParalleleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BoutonFil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BoutonResistance, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BoutonParallele, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BoutonResistance, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BoutonParallele, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BoutonFil, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BoutonResistanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonResistanceActionPerformed

    }//GEN-LAST:event_BoutonResistanceActionPerformed

    private void BoutonFilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonFilActionPerformed

    }//GEN-LAST:event_BoutonFilActionPerformed

    private void BoutonParalleleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoutonParalleleActionPerformed

    }//GEN-LAST:event_BoutonParalleleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BoutonFil;
    private javax.swing.JButton BoutonParallele;
    private javax.swing.JButton BoutonResistance;
    // End of variables declaration//GEN-END:variables
}
