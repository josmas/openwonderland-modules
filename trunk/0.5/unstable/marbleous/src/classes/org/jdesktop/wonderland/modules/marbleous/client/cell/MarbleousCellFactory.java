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
package org.jdesktop.wonderland.modules.marbleous.client.cell;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.jdesktop.wonderland.client.cell.registry.annotation.CellFactory;
import org.jdesktop.wonderland.client.cell.registry.spi.CellFactorySPI;
import org.jdesktop.wonderland.common.cell.state.CellServerState;
import org.jdesktop.wonderland.modules.marbleous.common.cell.MarbleousCellServerState;
import org.jdesktop.wonderland.modules.appbase.client.swing.SwingCellFactoryUtils;

/**
 * The cell factory for Marbleous.
 * 
 * @author deronj
 */
@CellFactory
public class MarbleousCellFactory implements CellFactorySPI {

    public String[] getExtensions() {
        return new String[] {};
    }

    public <T extends CellServerState> T getDefaultCellServerState(Properties props) {
        MarbleousCellServerState state = new MarbleousCellServerState();

        // Minor Optimization
        SwingCellFactoryUtils.skipSystemInitialPlacement(state);

        return (T)state;
    }

    public String getDisplayName() {
        return "Marbleous";
    }

    public Image getPreviewImage() {
        /*
        // TODO: come up with a marble png
        URL url = MarbleousCellFactory.class.getResource("resources/swingtest_preview.png");
        return Toolkit.getDefaultToolkit().createImage(url);
        */
        return null;
    }
}
