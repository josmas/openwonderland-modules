/*
 * RDPDialog.java
 *
 * Created on December 6, 2007, 6:24 PM
 */
package org.jdesktop.lg3d.wonderland.tightvncmodule.client.cell;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author  nsimpson
 */
public class VNCSessionDialog extends javax.swing.JDialog {

    private static final Logger logger =
            Logger.getLogger(VNCSessionDialog.class.getName());

    public enum VNCEncoding {

        TIGHT
    }

    public VNCSessionDialog(java.awt.Frame parent, boolean modal) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        initComponents();
        connectionOptionsPanel.setVisible(false);
        this.pack();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        geometryButtonGroup = new javax.swing.ButtonGroup();
        serverLabel = new javax.swing.JLabel();
        serverTextField = new javax.swing.JTextField();
        portTextField = new javax.swing.JTextField();
        portLabel = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        userLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        userTextField = new javax.swing.JTextField();
        passwordTextField = new javax.swing.JPasswordField();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        connectionOptionsButton = new javax.swing.JButton();
        connectionOptionsPanel = new javax.swing.JPanel();
        compressionCheckBox = new javax.swing.JCheckBox();
        networkLabel = new javax.swing.JLabel();
        bandwidthComboBox = new javax.swing.JComboBox();
        colorDepthLabel = new javax.swing.JLabel();
        colorDepthComboBox = new javax.swing.JComboBox();
        bitsPerPixelLabel = new javax.swing.JLabel();

        setTitle("Open VNC Session");
        setResizable(false);

        serverLabel.setFont(new java.awt.Font("Dialog", 1, 12));
        serverLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        serverLabel.setText("VNC server:");

        serverTextField.setFont(new java.awt.Font("DialogInput", 0, 12));
        serverTextField.setNextFocusableComponent(userTextField);
        serverTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serverTextFieldActionPerformed(evt);
            }
        });

        portTextField.setFont(new java.awt.Font("DialogInput", 0, 12));
        portTextField.setText("5900");
        portTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portTextFieldActionPerformed(evt);
            }
        });

        portLabel.setFont(new java.awt.Font("Dialog", 1, 12));
        portLabel.setText("Port:");

        descriptionLabel.setFont(new java.awt.Font("Dialog", 1, 12));
        descriptionLabel.setText("Open a VNC Session to the following system:");

        userLabel.setFont(new java.awt.Font("Dialog", 1, 12));
        userLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        userLabel.setText("User name:");
        userLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        passwordLabel.setFont(new java.awt.Font("Dialog", 1, 12));
        passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        passwordLabel.setText("Password:");
        passwordLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        userTextField.setFont(new java.awt.Font("DialogInput", 0, 12));
        userTextField.setNextFocusableComponent(passwordTextField);
        userTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userTextFieldActionPerformed(evt);
            }
        });

        passwordTextField.setFont(new java.awt.Font("DialogInput", 0, 12)); // NOI18N
        passwordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextFieldActionPerformed(evt);
            }
        });

        okButton.setFont(new java.awt.Font("Dialog", 1, 12));
        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setFont(new java.awt.Font("Dialog", 1, 12));
        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        connectionOptionsButton.setFont(new java.awt.Font("Dialog", 0, 12));
        connectionOptionsButton.setText("Show Connection Options");
        connectionOptionsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectionOptionsButtonActionPerformed(evt);
            }
        });

        connectionOptionsPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        compressionCheckBox.setFont(new java.awt.Font("Dialog", 0, 12));
        compressionCheckBox.setText("Enable compression");
        compressionCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compressionCheckBoxActionPerformed(evt);
            }
        });

        networkLabel.setFont(new java.awt.Font("Dialog", 1, 12));
        networkLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        networkLabel.setText("Session Encoding");
        networkLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        bandwidthComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        bandwidthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tight" }));

        colorDepthLabel.setFont(new java.awt.Font("Dialog", 1, 12));
        colorDepthLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        colorDepthLabel.setText("Color depth:");
        colorDepthLabel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        colorDepthComboBox.setFont(new java.awt.Font("Dialog", 0, 12));
        colorDepthComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Default", "8", "16", "24" }));

        bitsPerPixelLabel.setFont(new java.awt.Font("Dialog", 1, 12));
        bitsPerPixelLabel.setText("bits per pixel");

        org.jdesktop.layout.GroupLayout connectionOptionsPanelLayout = new org.jdesktop.layout.GroupLayout(connectionOptionsPanel);
        connectionOptionsPanel.setLayout(connectionOptionsPanelLayout);
        connectionOptionsPanelLayout.setHorizontalGroup(
            connectionOptionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(connectionOptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(connectionOptionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(networkLabel)
                    .add(colorDepthLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(connectionOptionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(bandwidthComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(colorDepthComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(connectionOptionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(connectionOptionsPanelLayout.createSequentialGroup()
                        .add(3, 3, 3)
                        .add(bitsPerPixelLabel))
                    .add(connectionOptionsPanelLayout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(compressionCheckBox)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        connectionOptionsPanelLayout.setVerticalGroup(
            connectionOptionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(connectionOptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(connectionOptionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(networkLabel)
                    .add(bandwidthComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(compressionCheckBox))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(connectionOptionsPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(colorDepthComboBox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(colorDepthLabel)
                    .add(bitsPerPixelLabel))
                .add(33, 33, 33))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(layout.createSequentialGroup()
                            .add(connectionOptionsPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .add(layout.createSequentialGroup()
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(descriptionLabel)
                                .add(layout.createSequentialGroup()
                                    .add(24, 24, 24)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                        .add(serverLabel)
                                        .add(userLabel)
                                        .add(passwordLabel))
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(layout.createSequentialGroup()
                                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                                .add(userTextField)
                                                .add(serverTextField, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                                                .add(passwordTextField))
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                            .add(portLabel)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                            .add(portTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 42, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                        .add(connectionOptionsButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))))
                            .addContainerGap(90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(okButton)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(cancelButton)
                        .add(131, 131, 131))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(descriptionLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(serverLabel)
                    .add(serverTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(portLabel)
                    .add(portTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(userLabel)
                    .add(userTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(passwordLabel)
                    .add(passwordTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(connectionOptionsButton)
                .add(12, 12, 12)
                .add(connectionOptionsPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(okButton)
                    .add(cancelButton))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        if (evt.getID() == ActionEvent.ACTION_PERFORMED) {
            this.setVisible(false);
            displaySettings();
        }
}//GEN-LAST:event_okButtonActionPerformed

    private void serverTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serverTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_serverTextFieldActionPerformed

    private void userTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userTextFieldActionPerformed

    private void connectionOptionsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectionOptionsButtonActionPerformed
        if (evt.getID() == ActionEvent.ACTION_PERFORMED) {
            showConnectionOptions(!isShowingConnectionOptions());
        }
}//GEN-LAST:event_connectionOptionsButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        if (evt.getID() == ActionEvent.ACTION_PERFORMED) {
            this.setVisible(false);
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void portTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_portTextFieldActionPerformed

private void compressionCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compressionCheckBoxActionPerformed
// TODO add your handling code here:
}//GEN-LAST:event_compressionCheckBoxActionPerformed

private void passwordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextFieldActionPerformed
    okButton.doClick();
}//GEN-LAST:event_passwordTextFieldActionPerformed

    public void addActionListener(ActionListener listener) {
        okButton.addActionListener(listener);
        cancelButton.addActionListener(listener);
    }

    public void setServer(String server) {
        serverTextField.setText(server);
    }

    public String getServer() {
        return serverTextField.getText();
    }

    public void setPort(int port) {
        portTextField.setText(String.valueOf(port));
    }

    public int getPort() {
        return Integer.valueOf(portTextField.getText());
    }

    public void setUser(String user) {
        userTextField.setText(user);
    }

    public String getUser() {
        return userTextField.getText();
    }

    public void setPassword(String password) {
        passwordTextField.setText(password);
    }

    public String getPassword() {
        return new String(passwordTextField.getPassword());
    }

    public void setCompression(boolean compressed) {
        compressionCheckBox.setSelected(compressed);
    }

    public boolean getCompression() {
        return compressionCheckBox.isSelected();
    }

    public void setBandwidthOption(VNCEncoding option) {
        switch (option) {
            case TIGHT:
                bandwidthComboBox.setSelectedIndex(0);
                break;
            default:
                bandwidthComboBox.setSelectedIndex(0);
                break;
        }
    }

    public VNCEncoding getVNCEncoding() {
        VNCEncoding option = VNCEncoding.TIGHT;
        switch (bandwidthComboBox.getSelectedIndex()) {
            case 0:
                option = VNCEncoding.TIGHT;
                break;
            default:
                option = VNCEncoding.TIGHT;
                break;
        }

        return option;
    }

    public void setColorDepth(int depth) {
        for (int i = 0; i < colorDepthComboBox.getItemCount(); i++) {
            String ci = (String) colorDepthComboBox.getItemAt(i);
            if ((ci.equals("Default") && (depth == 0)) ||
                    (ci.equals(String.valueOf(depth)))) {
                colorDepthComboBox.setSelectedIndex(i);
                break;
            }
        }
    }

    public int getColorDepth() {
        String depthStr = (String) colorDepthComboBox.getSelectedItem();
        int depth = 0;

        if (!depthStr.equals("Default")) {
            depth = Integer.valueOf(depthStr);
        }

        return depth;
    }

    public void showConnectionOptions(boolean show) {
        connectionOptionsPanel.setVisible(show);
        if (show == true) {
            connectionOptionsButton.setText("Hide Connection Options");
        } else {
            connectionOptionsButton.setText("Show Connection Options");
        }
        this.pack();
    }

    public boolean isShowingConnectionOptions() {
        return connectionOptionsPanel.isVisible();
    }

    public void displaySettings() {
        logger.fine("Remote Desktop properties:" + "\n" +
                "system:   " + getServer() + "\n" +
                "port:     " + getPort() + "\n" +
                "user:     " + getUser() + "\n" +
                "options:  " + isShowingConnectionOptions() + "\n" +
                "  encoding:   " + getVNCEncoding() + "\n" +
                "  compression: " + getCompression() + "\n" +
                "  color depth: " + getColorDepth());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                VNCSessionDialog dialog = new VNCSessionDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox bandwidthComboBox;
    private javax.swing.JLabel bitsPerPixelLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox colorDepthComboBox;
    private javax.swing.JLabel colorDepthLabel;
    private javax.swing.JCheckBox compressionCheckBox;
    private javax.swing.JButton connectionOptionsButton;
    private javax.swing.JPanel connectionOptionsPanel;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.ButtonGroup geometryButtonGroup;
    private javax.swing.JLabel networkLabel;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordTextField;
    private javax.swing.JLabel portLabel;
    private javax.swing.JTextField portTextField;
    private javax.swing.JLabel serverLabel;
    private javax.swing.JTextField serverTextField;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField userTextField;
    // End of variables declaration//GEN-END:variables
}
