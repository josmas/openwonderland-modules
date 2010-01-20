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
package org.jdesktop.wonderland.modules.npc.client.cell;

import imi.character.avatar.AvatarContext.TriggerNames;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.wonderland.client.cell.Cell;
import org.jdesktop.wonderland.client.cell.ChannelComponent;
import org.jdesktop.wonderland.client.cell.asset.AssetUtils;
import org.jdesktop.wonderland.modules.avatarbase.client.imi.ImiAvatarLoaderFactory;
import org.jdesktop.wonderland.modules.avatarbase.client.jme.cellrenderer.WlAvatarCharacter;
import org.jdesktop.wonderland.modules.avatarbase.common.cell.AvatarConfigInfo;
import org.jdesktop.wonderland.modules.avatarbase.common.cell.messages.AvatarConfigMessage;

/**
 *
 * @author jkaplan
 * @author david <dmaroto@it.uc3m.es> UC3M - "Project España Virtual"
 */
public class NpcControllerFrame extends javax.swing.JFrame {

    private static Logger logger = Logger.getLogger(NpcControllerFrame.class.getName());
    private Cell cell;
    private WlAvatarCharacter avatar;

    /** Creates new form NpcControllerFrame */
    public NpcControllerFrame(Cell cell, WlAvatarCharacter avatar) {
        this.cell = cell;
        this.avatar = avatar;

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

        jLabel1 = new javax.swing.JLabel();
        avatarComboBox = new javax.swing.JComboBox();
        applyButton = new javax.swing.JButton();
        forwardButton = new javax.swing.JButton();
        leftButton = new javax.swing.JButton();
        rightButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Avatar:");

        avatarComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "assets/configurations/MaleD_CA_00_bin.xml", "assets/configurations/MaleD_CA_01_bin.xml", "assets/configurations/FemaleD_AZ_00_bin.xml", "assets/configurations/FemaleD_CA_00_bin.xml", "assets/configurations/FemaleFG_AA_01_bin.xml", "assets/configurations/FemaleFG_AA_02_bin.xml", "assets/configurations/FemaleFG_AA_03_bin.xml", "assets/configurations/FemaleFG_AA_04_bin.xml", "assets/configurations/FemaleFG_AA_05_bin.xml", "assets/configurations/FemaleFG_AA_06_bin.xml", "assets/configurations/FemaleFG_CA_00_bin.xml", "assets/configurations/FemaleFG_CA_01_bin.xml", "assets/configurations/FemaleFG_CA_02_bin.xml", "assets/configurations/FemaleFG_CA_03_bin.xml", "assets/configurations/FemaleFG_CA_04_bin.xml", "assets/configurations/FemaleFG_CA_05_bin.xml", "assets/configurations/FemaleFG_CA_06_bin.xml", "assets/configurations/FemaleFG_CA_07_bin.xml", "assets/configurations/MaleFG_AA_02_bin.xml", "assets/configurations/MaleFG_AA_03_bin.xml", "assets/configurations/MaleFG_AA_04_bin.xml", "assets/configurations/MaleD_CA_00_bin.xml", "assets/configurations/MaleD_CA_01_bin.xml", "assets/configurations/MaleFG_AA_00_bin.xml", "assets/configurations/MaleFG_AA_01_bin.xml", "assets/configurations/MaleFG_CA_01_bin.xml", "assets/configurations/MaleFG_CA_03_bin.xml", "assets/configurations/MaleFG_CA_04_bin.xml", "assets/configurations/MaleFG_CA_05_bin.xml", "assets/configurations/MaleFG_CA_06_bin.xml", "assets/configurations/MaleMeso_00.xml", "assets/configurations/MaleMeso_01.xml", "assets/configurations/ObamaTest.xml" }));

        applyButton.setText("Apply");
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });

        forwardButton.setText("Forward");
        forwardButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                forwardButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                forwardButtonMouseReleased(evt);
            }
        });

        leftButton.setText("Left");
        leftButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                leftButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                leftButtonMouseReleased(evt);
            }
        });

        rightButton.setText("Right");
        rightButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rightButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rightButtonMouseReleased(evt);
            }
        });

        backButton.setText("Back");
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backButtonMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                backButtonMouseReleased(evt);
            }
        });

        jButton1.setText("Go To");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("X:");

        jLabel3.setText("Y:");

        jLabel4.setText("Z:");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, applyButton)
                            .add(layout.createSequentialGroup()
                                .add(jLabel1)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(jLabel2)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(18, 18, 18)
                                        .add(jLabel3)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(18, 18, 18)
                                        .add(jLabel4)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                        .add(18, 18, 18)
                                        .add(jButton1))
                                    .add(avatarComboBox, 0, 425, Short.MAX_VALUE)))))
                    .add(layout.createSequentialGroup()
                        .add(176, 176, 176)
                        .add(forwardButton))
                    .add(layout.createSequentialGroup()
                        .add(128, 128, 128)
                        .add(leftButton)
                        .add(50, 50, 50)
                        .add(rightButton))
                    .add(layout.createSequentialGroup()
                        .add(188, 188, 188)
                        .add(backButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(avatarComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(applyButton)
                .add(36, 36, 36)
                .add(forwardButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(leftButton)
                    .add(rightButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(backButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 56, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel2)
                    .add(jTextField1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel3)
                    .add(jTextField2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel4)
                    .add(jTextField3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        ChannelComponent cc = cell.getComponent(ChannelComponent.class);

        // From the partial URI, add the module prefix
        String uri = "wla://avatarbaseart/" + avatarComboBox.getSelectedItem();
        String urlString = null;
        try {
            urlString = AssetUtils.getAssetURL(uri, cell).toExternalForm();
        } catch (java.net.MalformedURLException excp) {
            logger.log(Level.WARNING, "Unable to form URL from " + uri, excp);
            return;
        }

        // Form up a message and send
        String className = ImiAvatarLoaderFactory.class.getName();
        AvatarConfigInfo info = new AvatarConfigInfo(urlString, className);
        cc.send(AvatarConfigMessage.newRequestMessage(info));
        dispose();
    }//GEN-LAST:event_applyButtonActionPerformed

    private void forwardButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forwardButtonMousePressed
        avatar.triggerActionStart(TriggerNames.Move_Forward);
    }//GEN-LAST:event_forwardButtonMousePressed

    private void forwardButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forwardButtonMouseReleased
        avatar.triggerActionStop(TriggerNames.Move_Forward);
    }//GEN-LAST:event_forwardButtonMouseReleased

    private void leftButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftButtonMousePressed
        avatar.triggerActionStart(TriggerNames.Move_Left);
    }//GEN-LAST:event_leftButtonMousePressed

    private void leftButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftButtonMouseReleased
        avatar.triggerActionStop(TriggerNames.Move_Left);
    }//GEN-LAST:event_leftButtonMouseReleased

    private void rightButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rightButtonMousePressed
        avatar.triggerActionStart(TriggerNames.Move_Right);
    }//GEN-LAST:event_rightButtonMousePressed

    private void rightButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rightButtonMouseReleased
        avatar.triggerActionStop(TriggerNames.Move_Right);
    }//GEN-LAST:event_rightButtonMouseReleased

    private void backButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMousePressed
        avatar.triggerActionStart(TriggerNames.Move_Back);
    }//GEN-LAST:event_backButtonMousePressed

    private void backButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseReleased
        avatar.triggerActionStop(TriggerNames.Move_Back);
    }//GEN-LAST:event_backButtonMouseReleased

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
    NpcCell myNpc = (NpcCell)cell;
    int x = (Integer.parseInt(jTextField1.getText()));
    int y = (Integer.parseInt(jTextField2.getText()));
    int z = (Integer.parseInt(jTextField3.getText()));
    myNpc.move(x,y,z);
}//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JComboBox avatarComboBox;
    private javax.swing.JButton backButton;
    private javax.swing.JButton forwardButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton leftButton;
    private javax.swing.JButton rightButton;
    // End of variables declaration//GEN-END:variables

}