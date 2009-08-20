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

import org.jdesktop.wonderland.client.hud.CompassLayout.Layout;
import org.jdesktop.wonderland.client.hud.HUD;
import org.jdesktop.wonderland.client.hud.HUDComponent;
import org.jdesktop.wonderland.client.hud.HUDManagerFactory;
import org.jdesktop.wonderland.client.hud.HUDObject.DisplayMode;

/**
 * Class to manage the selected tool
 * @author bhoran
 * @author nsimpson
 */
public class PDFViewerToolManager implements PDFViewerToolListener {

    private boolean hudState = false;
    private HUDComponent component;

    public enum PDFViewerTool {

        NEW, FIRST, PREVIOUS, NEXT, LAST, GOTO, PLAY, PAUSE, ZOOM_IN, ZOOM_OUT, SYNC, UNSYNC
    }
    private PDFViewerTool currentTool = null;
    private PDFViewerWindow pdfViewerWindow;

    PDFViewerToolManager(PDFViewerWindow pdfViewerWindow) {
        this.pdfViewerWindow = pdfViewerWindow;
    }

    // PDFViewerMenuListener methods
    public void toggleHUD() {
        if (component == null) {
            HUD mainHUD = HUDManagerFactory.getHUDManager().getHUD("main");
            component = mainHUD.createComponent(pdfViewerWindow);
            component.setPreferredLocation(Layout.CENTER);
            mainHUD.addComponent(component);
        }
        if (pdfViewerWindow.getDisplayMode().equals(DisplayMode.HUD)) {
            pdfViewerWindow.setDisplayMode(DisplayMode.WORLD);
            component.setVisible(false);
        } else {
            pdfViewerWindow.setDisplayMode(DisplayMode.HUD);
            component.setVisible(true);
        }
        pdfViewerWindow.showControls(true);
    }

    public void openDocument() {
        pdfViewerWindow.openDocument();
    }

    public void openDocument(String documentURI) {
        pdfViewerWindow.openDocument(documentURI);
    }

    public void firstPage() {
        pdfViewerWindow.firstPage();
    }

    public void previousPage() {
        pdfViewerWindow.previousPage();
    }

    public void nextPage() {
        pdfViewerWindow.nextPage();
    }

    public void lastPage() {
        pdfViewerWindow.lastPage();
    }

    public void gotoPage(int page) {
        pdfViewerWindow.gotoPage(page);
    }

    public void play() {
        pdfViewerWindow.play();
    }

    public void pause() {
        pdfViewerWindow.pause();
    }

    public void zoomIn() {
        pdfViewerWindow.zoomIn();
    }

    public void zoomOut() {
        pdfViewerWindow.zoomOut();
    }

    public void sync() {
        pdfViewerWindow.sync(!pdfViewerWindow.isSynced());
    }

    public void unsync() {
        pdfViewerWindow.sync(!pdfViewerWindow.isSynced());
    }

    public boolean isOnHUD() {
        return (pdfViewerWindow.getDisplayMode().equals(DisplayMode.HUD));
    }

    /**
     * @return the currentTool
     */
    public PDFViewerTool getTool() {
        return currentTool;
    }
}