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
package org.jdesktop.wonderland.modules.webcamviewer.client.cell;

import com.jme.math.Vector2f;
import java.util.logging.Logger;
import org.jdesktop.wonderland.client.cell.CellCache;
import org.jdesktop.wonderland.client.cell.annotation.UsesCellComponent;
import org.jdesktop.wonderland.common.cell.CellID;
import org.jdesktop.wonderland.modules.appbase.client.cell.App2DCell;
import org.jdesktop.wonderland.common.ExperimentalAPI;
import org.jdesktop.wonderland.common.cell.CellStatus;
import org.jdesktop.wonderland.common.cell.state.CellClientState;
import org.jdesktop.wonderland.modules.appbase.client.App2D;
import org.jdesktop.wonderland.modules.sharedstate.client.SharedMapCli;
import org.jdesktop.wonderland.modules.sharedstate.client.SharedMapEventCli;
import org.jdesktop.wonderland.modules.sharedstate.client.SharedMapListenerCli;
import org.jdesktop.wonderland.modules.sharedstate.client.SharedStateComponent;
import org.jdesktop.wonderland.modules.sharedstate.common.SharedData;
import org.jdesktop.wonderland.modules.sharedstate.common.SharedString;
import org.jdesktop.wonderland.modules.webcamviewer.client.WebcamViewerApp;
import org.jdesktop.wonderland.modules.webcamviewer.client.WebcamViewerWindow;
import org.jdesktop.wonderland.modules.webcamviewer.common.WebcamViewerConstants;
import org.jdesktop.wonderland.modules.webcamviewer.common.WebcamViewerState;
import org.jdesktop.wonderland.modules.webcamviewer.common.cell.WebcamViewerCellClientState;

/**
 * Webcam Viewer client cell
 *
 * @author nsimpson
 */
@ExperimentalAPI
public class WebcamViewerCell extends App2DCell implements SharedMapListenerCli {

    private static final Logger logger = Logger.getLogger(WebcamViewerCell.class.getName());
    // The (singleton) window created by the webcam viewer app
    private WebcamViewerWindow webcamViewerWindow;
    // the webcam viewer application
    private WebcamViewerApp webcamViewerApp;
    // shared state
    @UsesCellComponent
    private SharedStateComponent ssc;
    private SharedMapCli statusMap;
    private WebcamViewerCellClientState clientState;

    /**
     * Create an instance of WebcamViewerCell.
     *
     * @param cellID The ID of the cell.
     * @param cellCache the cell cache which instantiated, and owns, this cell.
     */
    public WebcamViewerCell(CellID cellID, CellCache cellCache) {
        super(cellID, cellCache);
    }

    /**
     * Initialize the webcam viewer with parameters from the server.
     *
     * @param clientState the client state to initialize the cell with
     */
    @Override
    public void setClientState(CellClientState state) {
        super.setClientState(state);
        clientState = (WebcamViewerCellClientState) state;
    }

    /**
     * This is called when the status of the cell changes.
     */
    @Override
    protected void setStatus(CellStatus status, boolean increasing) {
        super.setStatus(status, increasing);

        switch (status) {
            case ACTIVE:
                // the cell is now visible
                if (increasing) {
                    if (this.getApp() == null) {
                        webcamViewerApp = new WebcamViewerApp(java.util.ResourceBundle.getBundle("org/jdesktop/wonderland/modules/webcamviewer/client/resources/Bundle").getString("WEBCAM"), clientState.getPixelScale());
                        setApp(webcamViewerApp);
                    }
                    // tell the app to be displayed in this cell.
                    webcamViewerApp.addDisplayer(this);

                    // set initial position above ground
                    float placementHeight = clientState.getPreferredHeight() + 200;
                    placementHeight *= clientState.getPixelScale().y;
                    setInitialPlacementSize(new Vector2f(0f, placementHeight));

                    // this app has only one window, so it is always top-level
                    try {
                        webcamViewerWindow = new WebcamViewerWindow(this, webcamViewerApp,
                                clientState.getPreferredWidth(), clientState.getPreferredHeight(),
                                true, clientState.getPixelScale());
                        webcamViewerWindow.setDecorated(clientState.getDecorated());

                        webcamViewerApp.setWindow(webcamViewerWindow);
                    } catch (InstantiationException ex) {
                        throw new RuntimeException(ex);
                    }

                    // load the webcam viewer's status map
                    webcamViewerWindow.setSSC(ssc);
                    statusMap = ssc.get(WebcamViewerConstants.STATUS_MAP);
                    statusMap.addSharedMapListener(this);

                    // get the current webcam URI
                    SharedString documentURI = statusMap.get(WebcamViewerConstants.CAMERA_URI,
                            SharedString.class);
                    handleConnectCamera(null, null, documentURI);

                    // get the current state of the viewer
                    SharedString state = statusMap.get(WebcamViewerConstants.PLAYER_STATE,
                            SharedString.class);
                    this.handleMediaStateChanged(null, null, state);

                    // both the app and the user want this window to be visible
                    webcamViewerWindow.setVisibleApp(true);
                    webcamViewerWindow.setVisibleUser(this, true);
                }
                break;
            case DISK:
                if (!increasing) {
                    // The cell is no longer visible
                    if (webcamViewerWindow != null) {
                        webcamViewerWindow.stop();
                        webcamViewerWindow.setVisibleApp(false);

                        App2D.invokeLater(new Runnable() {

                            public void run() {
                                webcamViewerWindow.cleanup();
                                webcamViewerWindow = null;
                            }
                        });
                    }
                }
                break;
        }
    }

    public void propertyChanged(SharedMapEventCli event) {
        SharedMapCli map = event.getMap();
        if (map.getName().equals(WebcamViewerConstants.STATUS_MAP)) {
            // there's only one map, a map containing the state of the viewer,
            // its key determines what changed:
            //
            // MEDIA_URI: new media has been loaded into this viewer
            // MEDIA_STATE: the state of the media has changed
            // MEDIA_POSITION: the media position has changed
            //
            // newData specifies the new value of the key
            // note that there's only one property change processed at a time

            handleStatusChange(event.getPropertyName(), event.getOldValue(),
                    event.getNewValue());
        } else {
            logger.warning("unrecognized shared map: " + map.getName());
        }
    }

    private void handleStatusChange(String key, SharedData oldData, SharedData newData) {
        if (key.equals(WebcamViewerConstants.CAMERA_URI)) {
            // a new media file
            handleConnectCamera(key, oldData, newData);
        } else if (key.equals(WebcamViewerConstants.PLAYER_STATE)) {
            // state changed
            handleMediaStateChanged(key, oldData, newData);
        } else {
            logger.warning("unhandled status change event: " + key);
        }
    }

    private void handleConnectCamera(String media, SharedData oldData, SharedData newData) {
        if ((newData != null) && webcamViewerWindow.isSynced()) {
            String cameraURI = ((SharedString) newData).getValue();
            logger.info("connect camera: " + cameraURI);
            webcamViewerWindow.connectCamera(cameraURI);
        }
    }

    private void handleMediaStateChanged(String key, SharedData oldData, SharedData newData) {
        if ((newData != null) && webcamViewerWindow.isSynced()) {
            String state = ((SharedString) newData).getValue();
            logger.fine("handle state change: " + state);
            if (state.equals(WebcamViewerState.PAUSED.name())) {
                // pause
                logger.info("pause");
                webcamViewerWindow.pause();
            } else if (state.equals(WebcamViewerState.PLAYING.name())) {
                // play
                logger.info("play");
                webcamViewerWindow.play();
            } else if (state.equals(WebcamViewerState.STOPPED.name())) {
                // stop
                logger.info("stop");
                webcamViewerWindow.stop();
            }
        }
    }
}
