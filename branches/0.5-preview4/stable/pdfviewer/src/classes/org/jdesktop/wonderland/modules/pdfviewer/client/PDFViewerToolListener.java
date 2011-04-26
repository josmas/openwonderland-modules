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
package org.jdesktop.wonderland.modules.pdfviewer.client;

/**
 * Listener methods for PDF viewer control panel buttons.
 *
 * @author nsimpson
 */
public interface PDFViewerToolListener {

    public void toggleHUD();

    public void openDocument();

    public void firstPage();

    public void previousPage();

    public void nextPage();

    public void lastPage();

    public void gotoPage(int page);

    public void togglePlay();

    public void zoomIn();

    public void zoomOut();

    public void toggleSync();
}