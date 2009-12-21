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

package org.jdesktop.wonderland.modules.pdfpresentation.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jdesktop.wonderland.modules.pdfpresentation.common.PresentationLayout;
import org.jdesktop.wonderland.modules.pdfpresentation.common.PresentationLayout.LayoutType;

/**
 * A JPanel to be used in the HUD to allow users to edit the layout of the
 * slides.
 * 
 * @author Drew Harry <drew_harry@dev.java.net>
 * @author Jordan Slott <jslott@dev.java.net>
 */
public class PDFLayoutHUDPanel extends JPanel implements ActionListener {

    // The error logger
    private static final Logger LOGGER =
        Logger.getLogger(PDFLayoutHUDPanel.class.getName());

    private PresentationCell cell;

    private final static String LINEAR_COMMAND = "linear";
    private final static String SEMICIRCLE_COMMAND = "semicircle";
    private final static String CIRCLE_COMMAND = "cicle";

    // This boolean indicates whether the values of the sliders are being
    // set programmatically, e.g. when a transform changed event has been
    // received from the Cell. In such a case, we do not want to generate a
    // new message to the server. This value is only set in the AWT Event
    // Thread.
    private boolean setLocal = false;

    /** Creates new form PDFLayoutHUDPanel */
    public PDFLayoutHUDPanel(PresentationCell c) {
        initComponents();

        this.cell = c;

        // Add the layout buttons to the same group
        ButtonGroup layoutButtons = new ButtonGroup();
        layoutButtons.add(linearButton);
        layoutButtons.add(semicircleButton);
        layoutButtons.add(circleButton);

        // Make sure the HUD has the right intial state.
        LayoutType layoutType = c.getLayout().getLayout();
        switch(layoutType) {
            case LINEAR:
                linearButton.setSelected(true);
                break;
            case SEMICIRCLE:
                semicircleButton.setSelected(true);
                break;
            case CIRCLE:
                circleButton.setSelected(true);
                break;
            default:
                break;
        }

        // Set the initial values of the sliders to the default values
        scaleSlider.setValue(getScaleSliderValue(c.getScale()));
        spacingSlider.setValue(getSpacingSliderValue(
                c.getSpacing(), layoutType));

        // setup button listeners. 
        linearButton.setActionCommand(LINEAR_COMMAND);
        linearButton.addActionListener(this);
        semicircleButton.addActionListener(this);
        semicircleButton.setActionCommand(SEMICIRCLE_COMMAND);
        circleButton.addActionListener(this);
        circleButton.setActionCommand(CIRCLE_COMMAND);

        // Listen for changes to the scale value and update the cell as
        // a result. Only update the result if it doesn't happen because the
        // value in the slider is changed programmatically. The value of
        // 'setLocal' is set always in the AWT Event Thread, the same thread
        // as this listener.
        scaleSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                if (setLocal == false) {
                    LOGGER.warning("Scale Slide State Changed!");

                    cell.setScale(getScaleValue(scaleSlider.getValue()));
                    cell.sendCurrentLayoutToServer();
                }
            }
        });

        spacingSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                if (setLocal == false) {
                    LOGGER.warning("Spacing Slide State Changed!");

                    cell.setSpacing(getSpacingValue(spacingSlider.getValue(),
                            cell.getLayout().getLayout()));
                    cell.sendCurrentLayoutToServer();
                }
            }
        });
    }

    /**
     * Sets whether the changes being made to the sliders are done so
     * programmatically. This is used to make sure that updates to the servers
     * only happen when necessary.
     *
     * @param isLocal True to indicate the slider values are being set
     * programmatically.
     */
    void setLocalChanges(boolean isLocal) {
        setLocal = isLocal;
    }

    /**
     * Given the integer value of the scale slider, between 0 and 100, returns
     * the floating point value of the scale, between 0.0 and 4.0
     */
    private float getScaleValue(int scale) {
        return (float) (scale / 100.0f * 4.0f);
    }

    /**
     * Given the floating point value of the scale, returns the slide value as
     * an integer between 0 and 100. The value of the scale should be between
     * 0.0 and 4.0.
     */
    private int getScaleSliderValue(float scale) {
        return (int) (scale / 4.0f * 100.0f);
    }

    /**
     * Given the integer value of the spacing slider, between 0 and 100,
     * returns the floating point value of the spacing, between 0.0 and 15.0
     * for linear layouts and between 0.0 and 75.0 for (semi)circular layouts.
     */
    private float getSpacingValue(int spacing, LayoutType layoutType) {
        if (layoutType == LayoutType.LINEAR) {
            // The spacing for the linear type is between 0.0 and 15.0.
            return (float) (spacing / 100.0f * 15.0f);
        }
        else {
            // The spacing for all other types is between 0.0 and 75.0.
            return (float) (spacing / 100.0f * 75.0f);
        }
    }

    /**
     * Given the floating point value of the slide spacing, and the current
     * layout, returns the slide value as an integer between 0 and 100.
     */
    private int getSpacingSliderValue(float spacing, LayoutType layoutType) {
        if (layoutType == LayoutType.LINEAR) {
            // The spacing for the linear type is between 0.0 and 15.0. Turn
            // into an integer value between 0 and 100.
            return (int) (spacing / 15.0f * 100.0f);
        }
        else {
            // The spacing for all other types is between 0.0 and 75.0. Turn
            // into an integer value between 0 and 100.0.
            return (int) (spacing / 75.0f * 100.0f);
        }
    }

    /**
     * Set the Cell associated with the HUD panel.
     *
     * @param cell The presentation Cell
     */
    public void setCell(PresentationCell cell) {
        this.cell = cell;

        // Update the slider values with the current values of the scale and
        // spacing for the slides.
        scaleSlider.setValue(getScaleSliderValue(cell.getScale()));
        spacingSlider.setValue(getSpacingSliderValue(cell.getSpacing(),
                cell.getLayout().getLayout()));
    }

    public void actionPerformed(ActionEvent arg0) {
        // Update the layout of the Cell. Also, update the values of the spacing
        // and scale values to the default.
        if (arg0.getActionCommand().equals(LINEAR_COMMAND)) {
            cell.setLayoutType(LayoutType.LINEAR);
        } else if (arg0.getActionCommand().equals(SEMICIRCLE_COMMAND)) {
            cell.setLayoutType(LayoutType.SEMICIRCLE);
        } else if (arg0.getActionCommand().equals(CIRCLE_COMMAND)) {
            cell.setLayoutType(LayoutType.CIRCLE);
        }

        // Update the scale and spacing values
        cell.setScale(PresentationLayout.DEFAULT_SCALE);
        cell.setSpacing(PresentationLayout.DEFAULT_SPACING);

        // Update the values of the sliders, but indicate that we are adjusting
        // the slider values programmatically. This will prevent spurious
        // layouts from happening and messages sent to the server.
        setLocalChanges(true);
        try {
            scaleSlider.setValue(getScaleSliderValue(cell.getScale()));
            spacingSlider.setValue(getSpacingSliderValue(cell.getSpacing(),
                    cell.getLayout().getLayout()));
        } finally {
            setLocalChanges(false);
        }
        
        // Tell the server of the new layout to inform all other clients
        cell.sendCurrentLayoutToServer();
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

        jRadioButton2 = new javax.swing.JRadioButton();
        scaleSlider = new javax.swing.JSlider();
        spacingSlider = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        linearButton = new javax.swing.JRadioButton();
        semicircleButton = new javax.swing.JRadioButton();
        circleButton = new javax.swing.JRadioButton();
        createPresentationButton = new javax.swing.JButton();

        jRadioButton2.setText("jRadioButton2");

        setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 4;
        add(scaleSlider, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 4;
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

        linearButton.setText("Linear");

        semicircleButton.setText("Semicircle");

        circleButton.setText("Circle");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(semicircleButton)
                    .addComponent(circleButton)
                    .addComponent(linearButton)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(linearButton)
                .addGap(5, 5, 5)
                .addComponent(semicircleButton)
                .addGap(5, 5, 5)
                .addComponent(circleButton))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        add(jPanel1, gridBagConstraints);

        createPresentationButton.setText("Create Presentation Space");
        createPresentationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createPresentationButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(createPresentationButton, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void createPresentationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createPresentationButtonActionPerformed
        // Make a call into the presentation manager to tell it that this PDF wants to be
        // turned into a full presentation space.

        // rip this button out once everything is functionally merged
//        PresentationCell.createPresentationSpace((Cell)cell);

    }//GEN-LAST:event_createPresentationButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton circleButton;
    private javax.swing.JButton createPresentationButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton linearButton;
    private javax.swing.JSlider scaleSlider;
    private javax.swing.JRadioButton semicircleButton;
    private javax.swing.JSlider spacingSlider;
    // End of variables declaration//GEN-END:variables
}
