/**
 * Project Wonderland
 *
 * Copyright (c) 2004-2010, Sun Microsystems, Inc., All Rights Reserved
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

package org.jdesktop.wonderland.modules.poster.client;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 * Dialogue box for entering the text for a poster
 * @author  Bernard Horan
 */
public class PosterForm extends javax.swing.JFrame {
    private static final Logger posterLogger = Logger.getLogger(PosterForm.class.getName());

    
    private PosterCell posterCell;

    public PosterForm() {
        initComponents();
        textArea.setText("");
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
    }
    
    /** Creates new form PosterForm
     * @param posterCell the cell that initiates this dialogue box
     */
    public PosterForm(PosterCell posterCell) {
        this();
        this.posterCell = posterCell;
        //updateTextArea();
    }

    void updateTextArea() {
        if (posterCell == null) {
            return;
        }
        String posterText = posterCell.getPosterText();
        posterLogger.info("posterText: " + posterText);
        textArea.setText(posterCell.getPosterText());
        updatePreviewLabel();
    }

    @Override
    public void setVisible(boolean isVisible) {
        updateTextArea();
        super.setVisible(isVisible);
    }

    private void updatePreviewLabel() {
        previewLabel.setIcon(null);
        ImageIcon icon = new ImageIcon(getPreviewImage());
        previewLabel.setIcon(icon);       
    }

    Image getPreviewImage() {
        if (textArea.getText().isEmpty()) {
            return null;
        }
        //String oldLabelText = previewLabel.getText();
        
        //posterLogger.info("old text: " + oldLabelText);

        previewLabel.setText(textArea.getText());
        posterLogger.info("new text: " + previewLabel.getText());
        Dimension size = previewLabel.getPreferredSize();
        posterLogger.info("label preferred size: " + size);
        previewLabel.setSize(size);
        Image image = createImage(size.width, size.height);
        Graphics2D g2d = (Graphics2D) image.getGraphics();
        //g2d.setClip(new Rectangle(size));
        g2d.setFont(getFont());
        previewLabel.paint(g2d);
        previewLabel.setText("");
        g2d.dispose();
        return image;
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        doneButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        previewLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        previewButton = new javax.swing.JButton();

        setTitle("Enter Poster Text");
        setAlwaysOnTop(true);

        doneButton.setText("OK");
        doneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        previewLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        previewLabel.setText("jLabel1");
        previewLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        previewLabel.setOpaque(true);

        textArea.setColumns(20);
        textArea.setRows(5);
        textArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(textArea);

        previewButton.setText("Preview");
        previewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewButtonActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(previewLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(80, 80, 80)
                        .add(previewButton))
                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(doneButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 105, Short.MAX_VALUE)
                        .add(cancelButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 149, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(previewButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(previewLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(doneButton)
                    .add(cancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void doneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneButtonActionPerformed
        posterCell.setPosterText(textArea.getText());
        setVisible(false);
}//GEN-LAST:event_doneButtonActionPerformed

    private void previewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewButtonActionPerformed
        updatePreviewLabel();
    }//GEN-LAST:event_previewButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed
   
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PosterForm().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton doneButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton previewButton;
    private javax.swing.JLabel previewLabel;
    private javax.swing.JTextArea textArea;
    // End of variables declaration//GEN-END:variables


    
}
