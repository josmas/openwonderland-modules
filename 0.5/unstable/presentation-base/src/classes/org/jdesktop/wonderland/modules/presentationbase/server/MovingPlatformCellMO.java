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
package org.jdesktop.wonderland.modules.presentationbase.server;

import org.jdesktop.wonderland.common.cell.ClientCapabilities;
import org.jdesktop.wonderland.common.cell.state.CellClientState;
import org.jdesktop.wonderland.common.cell.state.CellServerState;
import org.jdesktop.wonderland.modules.presentationbase.common.MovingPlatformCellClientState;
import org.jdesktop.wonderland.modules.presentationbase.common.MovingPlatformCellServerState;
import org.jdesktop.wonderland.server.cell.CellMO;
import org.jdesktop.wonderland.server.comms.WonderlandClientID;

/**
 *
 * @author Drew Harry <drew_harry@dev.java.net>
 */

public class MovingPlatformCellMO extends CellMO {


    private float platformWidth;
    private float platformDepth;

    protected String getClientCellClassName(WonderlandClientID clientID, ClientCapabilities capabilities) {
        return "org.jdesktop.wonderland.modules.presentationbase.client.MovingPlatformCell";
    }

    @Override
    public void setServerState(CellServerState state) {
        super.setServerState(state);

        platformWidth = ((MovingPlatformCellServerState)state).getPlatformWidth();
        platformDepth = ((MovingPlatformCellServerState)state).getPlatformDepth();
    }

    @Override
    public CellServerState getServerState(CellServerState state) {
        if(state==null)
            state = new MovingPlatformCellServerState();

        ((MovingPlatformCellServerState)state).setPlatformWidth(platformWidth);
        ((MovingPlatformCellServerState)state).setPlatformDepth(platformDepth);


        return state;
    }

    @Override
    public CellClientState getClientState(CellClientState cellClientState, WonderlandClientID clientID, ClientCapabilities capabilities) {
        if (cellClientState == null)
            cellClientState = new MovingPlatformCellClientState();

        ((MovingPlatformCellClientState)cellClientState).setPlatformWidth(platformWidth);
        ((MovingPlatformCellClientState)cellClientState).setPlatformDepth(platformDepth);

        return cellClientState;
    }

}