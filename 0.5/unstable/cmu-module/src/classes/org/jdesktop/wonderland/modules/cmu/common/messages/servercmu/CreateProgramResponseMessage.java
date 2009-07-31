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
package org.jdesktop.wonderland.modules.cmu.common.messages.servercmu;

import org.jdesktop.wonderland.common.cell.CellID;
import org.jdesktop.wonderland.common.messages.MessageID;
import org.jdesktop.wonderland.common.messages.ResponseMessage;

/**
 *
 * @author kevin
 */
public class CreateProgramResponseMessage extends ResponseMessage {

    private static final long serialVersionUID = 1L;
    private String server;
    private int port;
    private CellID cellID;

    public CreateProgramResponseMessage(MessageID messageID, CellID cellID, String server, int port) {
        super(messageID);
        this.setCellID(cellID);
        this.setPort(port);
        this.setServer(server);
    }

    public CellID getCellID() {
        return cellID;
    }

    public void setCellID(CellID cellID) {
        this.cellID = cellID;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    @Override
    public String toString() {
        return "Program created [Cell:"+ cellID + "] [Server:" + server + "] [Port:" + port + "]";
    }
}