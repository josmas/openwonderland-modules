/**
 * Open Wonderland
 *
 * Copyright (c) 2010, Open Wonderland Foundation, All Rights Reserved
 *
 * Redistributions in source code form must reproduce the above
 * copyright and this condition.
 *
 * The contents of this file are subject to the GNU General Public
 * License, Version 2 (the "License"); you may not use this file
 * except in compliance with the License. A copy of the License is
 * available at http://www.opensource.org/licenses/gpl-license.php.
 *
 * The Open Wonderland Foundation designates this particular file as
 * subject to the "Classpath" exception as provided by the Open Wonderland
 * Foundation in the License file that accompanied this code.
 */
package org.jdesktop.wonderland.modules.admintools.server;

import com.sun.mpk20.voicelib.app.Call;
import com.sun.mpk20.voicelib.app.VoiceManager;
import com.sun.sgs.app.AppContext;
import com.sun.sgs.app.ClientSession;
import com.sun.sgs.app.ManagedReference;
import com.sun.sgs.app.Task;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdesktop.wonderland.common.auth.WonderlandIdentity;
import org.jdesktop.wonderland.common.cell.ClientCapabilities;
import org.jdesktop.wonderland.common.cell.ComponentLookupClass;
import org.jdesktop.wonderland.common.cell.messages.CellMessage;
import org.jdesktop.wonderland.common.cell.security.ModifyAction;
import org.jdesktop.wonderland.common.cell.security.ViewAction;
import org.jdesktop.wonderland.common.cell.state.CellComponentClientState;
import org.jdesktop.wonderland.modules.admintools.common.AdminToolsComponentClientState;
import org.jdesktop.wonderland.modules.admintools.common.AdminToolsConnectionType;
import org.jdesktop.wonderland.modules.admintools.common.DisconnectMessage;
import org.jdesktop.wonderland.modules.admintools.common.InvisibleMessage;
import org.jdesktop.wonderland.modules.admintools.common.MuteMessage;
import org.jdesktop.wonderland.modules.presencemanager.common.PresenceInfo;
import org.jdesktop.wonderland.modules.presencemanager.server.PresenceManagerSrv;
import org.jdesktop.wonderland.modules.presencemanager.server.PresenceManagerSrvFactory;
import org.jdesktop.wonderland.modules.security.common.ActionDTO;
import org.jdesktop.wonderland.modules.security.common.Permission;
import org.jdesktop.wonderland.modules.security.common.Permission.Access;
import org.jdesktop.wonderland.modules.security.common.Principal;
import org.jdesktop.wonderland.modules.security.common.Principal.Type;
import org.jdesktop.wonderland.modules.security.common.SecurityComponentServerState;
import org.jdesktop.wonderland.modules.security.server.SecurityComponentMO;
import org.jdesktop.wonderland.modules.security.server.service.GroupMemberResource;
import org.jdesktop.wonderland.server.WonderlandContext;
import org.jdesktop.wonderland.server.auth.ClientIdentityManager;
import org.jdesktop.wonderland.server.cell.AbstractComponentMessageReceiver;
import org.jdesktop.wonderland.server.cell.CellComponentMO;
import org.jdesktop.wonderland.server.cell.CellMO;
import org.jdesktop.wonderland.server.cell.ChannelComponentMO;
import org.jdesktop.wonderland.server.cell.annotation.NoSnapshot;
import org.jdesktop.wonderland.server.cell.annotation.UsesCellComponentMO;
import org.jdesktop.wonderland.server.comms.CommsManager;
import org.jdesktop.wonderland.server.comms.WonderlandClientID;
import org.jdesktop.wonderland.server.comms.WonderlandClientSender;
import org.jdesktop.wonderland.server.security.ActionMap;
import org.jdesktop.wonderland.server.security.Resource;
import org.jdesktop.wonderland.server.security.ResourceMap;
import org.jdesktop.wonderland.server.security.SecureTask;
import org.jdesktop.wonderland.server.security.SecurityManager;

/**
 * Server side cell component for admin tools
 * @author Jonathan Kaplan <jonathankap@gmail.com>
 */
@NoSnapshot
public class AdminToolsComponentMO extends CellComponentMO {
    private static final Logger LOGGER =
            Logger.getLogger(AdminToolsComponentMO.class.getName());

    private final ManagedReference<CellMO> cellRef;
    private boolean invisible;

    @UsesCellComponentMO(ChannelComponentMO.class)
    private ManagedReference<ChannelComponentMO> channelRef;

    @UsesCellComponentMO(SecurityComponentMO.class)
    private ManagedReference<SecurityComponentMO> securityRef;

    public AdminToolsComponentMO(CellMO cellMO) {
        super (cellMO);
        
        cellRef = AppContext.getDataManager().createReference(cellMO);
    }

    @Override
    protected String getClientClass() {
        return "org.jdesktop.wonderland.modules.admintools.client.AdminToolsComponent";
    }

    @Override
    public void setLive(boolean live) {
        super.setLive(live);

        if (live) {
            MessageReceiver mr = new MessageReceiver(this);
            channelRef.get().addMessageReceiver(InvisibleMessage.class, mr);
            channelRef.get().addMessageReceiver(MuteMessage.class, mr);
            channelRef.get().addMessageReceiver(DisconnectMessage.class, mr);
        } else {
            channelRef.get().removeMessageReceiver(InvisibleMessage.class);
            channelRef.get().removeMessageReceiver(MuteMessage.class);
            channelRef.get().removeMessageReceiver(DisconnectMessage.class);
        }
    }

    @Override
    public CellComponentClientState getClientState(CellComponentClientState state,
                                                   WonderlandClientID clientID,
                                                   ClientCapabilities capabilities)
    {
        if (state == null) {
            state = new AdminToolsComponentClientState();
        }

        ((AdminToolsComponentClientState) state).setInvisible(invisible);
        return super.getClientState(state, clientID, capabilities);
    }

    CellMO getCell() {
        return cellRef.get();
    }

    void handleInvisible(WonderlandClientSender sender,
                         WonderlandClientID clientID,
                         InvisibleMessage invisible)
    {
        LOGGER.warning("Handle invsible request for " + clientID.getID() +
                       " invisible: " + invisible.isInvisible());

        SecurityComponentServerState scss = (SecurityComponentServerState)
                securityRef.get().getServerState(null);

        // make sure owner is set up
        if (scss.getPermissions().getOwners().isEmpty()) {
            ClientIdentityManager cim = AppContext.getManager(ClientIdentityManager.class);
            WonderlandIdentity id = cim.getClientID();
            scss.getPermissions().getOwners().add(
                    new Principal(id.getUsername(), Type.USER));
        }

        // add or update the view permission for everyone
        Permission perm = new Permission(
                new Principal("users", Type.EVERYBODY),
                new ActionDTO(new ViewAction()),
                invisible.isInvisible()?Access.DENY:Access.GRANT);
        
        scss.getPermissions().getPermissions().remove(perm);
        scss.getPermissions().getPermissions().add(perm);

        // update the security component
        securityRef.get().setServerState(scss);

        // notify everyone who still sees the cell
        sender.send(invisible);
    }

    void handleDisconnect(WonderlandClientSender sender,
                          WonderlandClientID clientID,
                          DisconnectMessage disconnect)
    {
        LOGGER.warning("Handle disconnect request for " +
                       disconnect.getSessionID());

        CommsManager cm = WonderlandContext.getCommsManager();
        WonderlandClientID remote =
                cm.getWonderlandClientID(disconnect.getSessionID());
        WonderlandClientSender noticeSender =
                cm.getSender(AdminToolsConnectionType.CONNECTION_TYPE);

        if (remote != null) {
            // notify the client
            noticeSender.send(remote, disconnect);

            // schedule a task to happen shortly. This should guarantee that the
            // preceding message gets sent before the actual disconnect happens
            AppContext.getTaskManager().scheduleTask(
                    new DisconnectTask(remote.getSession()), 2000);
        } else {
            LOGGER.warning("No clientID found for " + disconnect.getSessionID());
        }
    }

    void handleMute(WonderlandClientSender sender,
                    WonderlandClientID clientID,
                    MuteMessage mute)
    {
        LOGGER.warning("Handle mute request for " +
                       mute.getSessionID());

        PresenceManagerSrv pm = PresenceManagerSrvFactory.getInstance();
        PresenceInfo pi = pm.getPresenceInfo(mute.getSessionID());

        CommsManager cm = WonderlandContext.getCommsManager();
        WonderlandClientID remote =
                cm.getWonderlandClientID(mute.getSessionID());
        WonderlandClientSender noticeSender =
                cm.getSender(AdminToolsConnectionType.CONNECTION_TYPE);

        if (remote != null && pi != null && pi.getCallID() != null) {
            VoiceManager vm = AppContext.getManager(VoiceManager.class);
            Call call = vm.getCall(pi.getCallID());
            if (call != null) {
                try {
                    call.mute(true);

                    noticeSender.send(remote, mute);
                } catch (IOException ex) {
                    LOGGER.log(Level.WARNING, "Unable to mute call " +
                               pi.getCallID(), ex);
                }
            } else {
                LOGGER.warning("Unable to find call for callID " +
                               pi.getCallID());
            }
        } else {
            LOGGER.warning("Unable to find presence info for session " +
                           mute.getSessionID());
        }
    }

    private static class MessageReceiver extends AbstractComponentMessageReceiver
        implements Serializable
    {
        private final ManagedReference<AdminToolsComponentMO> componentRef;

        public MessageReceiver(AdminToolsComponentMO component) {
            super (component.getCell());

            componentRef = AppContext.getDataManager().createReference(component);
        }

        @Override
        public void messageReceived(WonderlandClientSender sender,
                                    WonderlandClientID clientID,
                                    CellMessage message)
        {
            // security check
            ResourceMap rm = new ResourceMap();
            Resource gmr = new GroupMemberResource("admin");
            rm.put(gmr.getId(), new ActionMap(gmr, new ModifyAction()));

            SecurityManager sm = AppContext.getManager(SecurityManager.class);
            sm.doSecure(rm, new HandleMessageTask(componentRef,
                                                  sender, clientID, message));
        }
    }

    private static class HandleMessageTask implements SecureTask, Serializable {
        private final ManagedReference<AdminToolsComponentMO> componentRef;
        private final WonderlandClientSender sender;
        private final WonderlandClientID clientID;
        private final CellMessage message;

        public HandleMessageTask(ManagedReference<AdminToolsComponentMO> componentRef,
                                 WonderlandClientSender sender,
                                 WonderlandClientID clientID,
                                 CellMessage message)
        {
            this.componentRef = componentRef;
            this.sender = sender;
            this.clientID = clientID;
            this.message = message;
        }

        public void run(ResourceMap granted) {
            ActionMap am = granted.values().iterator().next();
            if (am.isEmpty()) {
                // permission denied
                LOGGER.warning("Permission denied for non-admin user " +
                               clientID.getID());
                return;
            }
            
            if (message instanceof InvisibleMessage) {
                componentRef.get().handleInvisible(sender, clientID,
                                                   (InvisibleMessage) message);
            } else if (message instanceof DisconnectMessage) {
                componentRef.get().handleDisconnect(sender, clientID,
                                                    (DisconnectMessage) message);
            } else if (message instanceof MuteMessage) {
                componentRef.get().handleMute(sender, clientID,
                                              (MuteMessage) message);
            }
        }
    }

    private static class DisconnectTask implements Task, Serializable {
        private final ManagedReference<ClientSession> sessionRef;

        public DisconnectTask(ClientSession session) {
            sessionRef = AppContext.getDataManager().createReference(session);
        }

        public void run() throws Exception {
            AppContext.getDataManager().removeObject(sessionRef.get());
        }
    }
}