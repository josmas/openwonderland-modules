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
package org.jdesktop.wonderland.modules.cmu.common.messages.serverclient;

import org.jdesktop.wonderland.common.cell.messages.CellMessage;
import org.jdesktop.wonderland.modules.cmu.common.NodeID;

/**
 * Message to forward mouse button events to a CMUCellMO, which can then
 * pass them on to the relevant CMU program.
 * @author kevin
 */
public class MouseButtonEventMessage extends CellMessage {

    private final static long serialVersionUID = 1L;
    private final NodeID nodeID;

    public MouseButtonEventMessage(NodeID nodeID) {
        this.nodeID = nodeID;
    }

    public NodeID getNodeID() {
        return nodeID;
    }
}
