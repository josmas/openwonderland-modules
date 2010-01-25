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

/*
 * MovementSettingsPanel.java
 *
 * Created on Jan 15, 2010, 4:01:18 AM
 */
package org.jdesktop.wonderland.modules.cmu.client.ui.events;

import org.jdesktop.wonderland.modules.cmu.common.events.AvatarMovementEvent;
import org.jdesktop.wonderland.modules.cmu.common.events.responses.AvatarPositionFunction;
import org.jdesktop.wonderland.modules.cmu.common.events.responses.CMUResponseFunction;

/**
 *
 * @author kevin
 */
public class MovementSettingsPanel extends EventSettingsPanel<AvatarMovementEvent> {

    /** Creates new form MovementSettingsPanel */
    public MovementSettingsPanel() {
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

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        distanceSpinner = new javax.swing.JSpinner();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("When avatar moves within");

        distanceSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                distanceChanged(evt);
            }
        });

        jLabel2.setText("meters of scene,");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(distanceSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(distanceSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void distanceChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_distanceChanged
        if (((Integer) this.distanceSpinner.getValue()).intValue() < 0) {
            this.distanceSpinner.setValue(new Integer(0));
        }
    }//GEN-LAST:event_distanceChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner distanceSpinner;
    // End of variables declaration//GEN-END:variables

    @Override
    public AvatarMovementEvent getEvent() {
        return new AvatarMovementEvent(((Integer) this.distanceSpinner.getValue()).intValue());
    }

    @Override
    public void setEvent(AvatarMovementEvent event) {
        this.distanceSpinner.setValue(new Integer((int) event.getDistance()));
    }

    @Override
    public Class getEventClass() {
        return AvatarMovementEvent.class;
    }

    @Override
    public boolean allowsResponse(CMUResponseFunction response) {
        return response instanceof AvatarPositionFunction;
    }
}
