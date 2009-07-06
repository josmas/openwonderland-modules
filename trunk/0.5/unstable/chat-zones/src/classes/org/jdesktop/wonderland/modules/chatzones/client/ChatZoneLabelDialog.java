/**
 * Project Wonderland
 *
 * Copyright (c) 2004-2009, Sun Microsystems, Inc., All Rights Reserved
 *
 * Redistributions in source code form must reproduce the above
 * copyright and this condition.
 *
 * The contents of this file are subject to the GNU General Public
 * License, Version 2 (the "License"); you may not use this file
 * except in compliance with the License. A copy of the License is
 * available at http://www.opensource.org/licenses/gpl-license.php.
 *
 * Sun designates this particular file as subject to the "Classpath"
 * exception as provided by Sun in the License file that accompanied
 * this code.
 */
package org.jdesktop.wonderland.modules.chatzones.client;

import javax.swing.JFrame;

/**
 * A dialog box for setting the name of a ChatZone. 
 *
 * @author Drew Harry <drew_harry@dev.java.net>
 */
public class ChatZoneLabelDialog extends JFrame {

    private ChatZonesCell cell;

    /** Creates new form UserListJFrame */
    public ChatZoneLabelDialog(ChatZonesCell cell) {
        this.cell = cell;
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
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

        jPanel3 = new javax.swing.JPanel();
        chatZoneLabelField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        setLabelButton = new javax.swing.JButton();

        setTitle("Set ChatZone Label");
        setAlwaysOnTop(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        chatZoneLabelField.setName("chatZoneLabelField"); // NOI18N
        chatZoneLabelField.setPreferredSize(new java.awt.Dimension(100, 28));
        chatZoneLabelField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chatZoneLabelFieldActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.ipady = 3;
        gridBagConstraints.weightx = 1.0;
        getContentPane().add(chatZoneLabelField, gridBagConstraints);

        jLabel1.setText("Chat Zone Label:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.ipady = 3;
        getContentPane().add(jLabel1, gridBagConstraints);

        cancelButton.setText("Cancel");
        cancelButton.setName("cancelButton"); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(cancelButton);

        setLabelButton.setText("Set Label");
        setLabelButton.setName("setLabelButton"); // NOI18N
        setLabelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setLabelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(setLabelButton);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        getContentPane().add(jPanel1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void setLabelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setLabelButtonActionPerformed
        this.cell.setLabel(this.chatZoneLabelField.getText());
        this.setVisible(false);
    }//GEN-LAST:event_setLabelButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void chatZoneLabelFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chatZoneLabelFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chatZoneLabelFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField chatZoneLabelField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton setLabelButton;
    // End of variables declaration//GEN-END:variables
}
