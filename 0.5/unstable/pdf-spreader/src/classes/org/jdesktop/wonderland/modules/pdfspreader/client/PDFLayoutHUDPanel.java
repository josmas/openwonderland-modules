/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PDFLayoutHUDPanel.java
 *
 * Created on Jul 16, 2009, 5:19:26 PM
 */

package org.jdesktop.wonderland.modules.pdfspreader.client;

/**
 *
 * @author drew
 */
public class PDFLayoutHUDPanel extends javax.swing.JPanel {

    /** Creates new form PDFLayoutHUDPanel */
    public PDFLayoutHUDPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        layoutType = new javax.swing.JComboBox();
        scaleSlider = new javax.swing.JSlider();
        spacingSlider = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        layoutType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Linear", "Semi-circle", "Circle" }));
        layoutType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                layoutTypeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        add(layoutType, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        add(scaleSlider, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        add(spacingSlider, gridBagConstraints);

        jLabel1.setText("Slide Scale");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        add(jLabel1, gridBagConstraints);

        jLabel2.setText("Slide Spacing");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        add(jLabel2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void layoutTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_layoutTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_layoutTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox layoutType;
    private javax.swing.JSlider scaleSlider;
    private javax.swing.JSlider spacingSlider;
    // End of variables declaration//GEN-END:variables

}
