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

package org.jdesktop.wonderland.modules.pdfspreader.common;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.jdesktop.wonderland.common.cell.state.CellServerState;
import org.jdesktop.wonderland.common.cell.state.annotation.ServerState;
import org.jdesktop.wonderland.modules.pdfspreader.common.PDFSpreaderCellChangeMessage.LayoutType;

@XmlRootElement(name="pdf-spreader-cell")
@ServerState
public class PDFSpreaderCellServerState extends CellServerState {


    @XmlElement(name="pdfURI")
    private String pdfURI = null;

    @XmlElement(name="scale")
    private float scale;

    @XmlElement(name="spacing")
    private float spacing;

    @XmlElement(name="layout")
    private LayoutType layout;

    public PDFSpreaderCellServerState() {
    }

    @Override
    public String getServerClassName() {
        return "org.jdesktop.wonderland.modules.pdfspreader.server.PDFSpreaderCellMO";
    }

    @XmlTransient public String getSourceURI() { return this.pdfURI; }
    public void setSourceURI(String uri) {
        this.pdfURI = uri;
    }

    @XmlTransient public float getScale() { return this.scale; }
    public void setScale (float scale) {
        this.scale = scale;
    }

    @XmlTransient public float getSpacing() { return this.spacing; }
    public void setSpacing(float spacing) {
        this.spacing = spacing;
    }

    @XmlTransient public LayoutType getLayout() { return this.layout; }
    public void setLayout(LayoutType layout) {
        this.layout = layout;
    }

}