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
package org.jdesktop.wonderland.modules.telepointer.client.cell;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBoxMenuItem;
import org.jdesktop.wonderland.client.ClientPlugin;
import org.jdesktop.wonderland.client.cell.view.ViewCell;
import org.jdesktop.wonderland.client.jme.ClientContextJME;
import org.jdesktop.wonderland.client.jme.JmeClientMain;
import org.jdesktop.wonderland.client.jme.ViewManager;
import org.jdesktop.wonderland.client.jme.ViewManager.ViewManagerListener;
import org.jdesktop.wonderland.client.login.ServerSessionManager;
import org.jdesktop.wonderland.modules.telepointer.client.cell.TelePointerComponent;

/**
 *
 * @author paulby
 */
public class TelePointerPlugin implements ClientPlugin {

    public void initialize(ServerSessionManager loginInfo) {
        final JCheckBoxMenuItem sharedPointerMI = new JCheckBoxMenuItem("Telepointer");
        sharedPointerMI.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ViewCell cell = ClientContextJME.getViewManager().getPrimaryViewCell();
                TelePointerComponent comp = cell.getComponent(TelePointerComponent.class);
                if (comp!=null) {
                    comp.setEnabled(sharedPointerMI.isSelected());
                }
            }
        });
        JmeClientMain.getFrame().addToEditMenu(sharedPointerMI);
        
        ViewManager.getViewManager().addViewManagerListener(new ViewManagerListener() {

            public void primaryViewCellChanged(ViewCell oldViewCell, ViewCell newViewCell) {
                if (oldViewCell!=null) {
                    oldViewCell.getComponent(TelePointerComponent.class).setEnabled(false);
                }

                newViewCell.getComponent(TelePointerComponent.class).setEnabled(sharedPointerMI.isSelected());
            }

        });


    }

}
