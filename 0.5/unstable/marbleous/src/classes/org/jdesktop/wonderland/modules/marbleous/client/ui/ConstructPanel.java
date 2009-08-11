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

package org.jdesktop.wonderland.modules.marbleous.client.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.jdesktop.wonderland.modules.marbleous.client.cell.TrackCell;
import org.jdesktop.wonderland.modules.marbleous.common.Track;
import org.jdesktop.wonderland.modules.marbleous.common.TrackManager;
import org.jdesktop.wonderland.modules.marbleous.common.TrackSegment;
import org.jdesktop.wonderland.modules.marbleous.common.TrackSegmentType;
import org.jdesktop.wonderland.modules.marbleous.common.cell.messages.SimulationStateMessage.SimulationState;

/**
 * Panel used to construct the roller coaster and start it running
 * @author Bernard Horan
 */
public class ConstructPanel extends javax.swing.JPanel {

    /* The "No Preview Available" image */
    private Image noPreviewAvailableImage = null;

    /** The track. */
    private Track track;
       
    /** Number of segments in the track. */
    private int numSegments;

    private List<TrackSegmentType> segmentTypes = new ArrayList<TrackSegmentType>();

    private TrackListModel segmentListModel;

    private TrackCell cell;

    /** Creates new form ConstructPanel */
    public ConstructPanel(TrackCell cell) {
        this.cell = cell;

        initComponents();

        // Create the icon for the "No Preview Available" image
        URL url = ConstructPanel.class.getResource("resources/nopreview.png");
        noPreviewAvailableImage = Toolkit.getDefaultToolkit().createImage(url);

        typeList.addListSelectionListener(new TypeListSelectionListener());
        segmentList.addListSelectionListener(new SegmentListSelectionListener());

        initializeLists();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        typeScrollPane = new javax.swing.JScrollPane();
        typeList = new javax.swing.JList();
        runButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        segmentScrollPane = new javax.swing.JScrollPane();
        segmentList = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setText("Track Segment Type to Add:");

        addButton.setText("Add");
        addButton.setEnabled(false);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        typeList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        typeScrollPane.setViewportView(typeList);

        runButton.setText("Run");
        runButton.setActionCommand("run");
        runButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Track Segments:");

        segmentList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        segmentScrollPane.setViewportView(segmentList);

        jButton1.setText("Remove");
        jButton1.setActionCommand("remove");

        jButton2.setText("Stop");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(runButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2))
                    .addComponent(typeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(addButton)
                        .addGap(38, 38, 38)
                        .addComponent(jButton1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(segmentScrollPane, javax.swing.GroupLayout.Alignment.LEADING, 0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(runButton)
                    .addComponent(jButton2))
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(typeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(addButton))
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(segmentScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        TrackSegmentType selectedType = (TrackSegmentType) typeList.getSelectedValue();
        TrackSegment newSegment = selectedType.createSegment();
        // This adds the segment to the underlying model (the track)
        segmentListModel.addSegment(newSegment);

}//GEN-LAST:event_addButtonActionPerformed

    private void runButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runButtonActionPerformed
        cell.setSimulationState(SimulationState.STARTED);
        System.err.println("******** START!");
}//GEN-LAST:event_runButtonActionPerformed


    /**
     * Updates the list of values displayed from the track segment factory
     */
    private void initializeLists() {
        typeList.setDragEnabled(false);
        segmentTypes.addAll(TrackManager.getTrackManager().getTrackSegmentTypes());
        Collections.sort(segmentTypes);
        DefaultListModel typeListModel = new DefaultListModel();
        for (Iterator it = segmentTypes.iterator(); it.hasNext();) {
            typeListModel.addElement(it.next());
        }
        typeList.setModel(typeListModel);
        typeList.setCellRenderer(new TypeListRenderer());

        //TODo remove after testing
        if (track == null) {
            track = new Track();
        }
        segmentListModel = new TrackListModel(track);
        segmentList.setModel(segmentListModel);
        segmentList.setCellRenderer(new SegmentListRenderer());
    }
    
    private class TypeListSelectionListener implements ListSelectionListener {

        /**
         * Handles when a selection has been made of the list of segment type names.
         * @param e
         */
        public void valueChanged(ListSelectionEvent e) {
            TrackSegmentType selectedType = (TrackSegmentType) typeList.getSelectedValue();
            if (selectedType == null) {
                // If nothing is selected, then disable the Insert button, the
                // preview image and disable drag-and-drop from the preview
                // label.
                addButton.setEnabled(false);

                /*
                // Make sure the recognizers are not null, and set their
                // components to null;
                if (previewRecognizer != null) {
                previewRecognizer.setComponent(null);
                }

                if (listRecognizer != null) {
                listRecognizer.setComponent(null);
                }
                */
                return;
            }

            System.out.println("Selected Type: " + selectedType);

            // Enable the Insert button
            addButton.setEnabled(true);
        }
    }

    private class SegmentListSelectionListener implements ListSelectionListener {

        /**
         * Handles when a selection has been made of the list of segments.
         * @param e
         */
        public void valueChanged(ListSelectionEvent e) {
            TrackSegment selectedSegment = (TrackSegment) segmentList.getSelectedValue();
            /*
            if (selectedSegment == null) {
                ...
            }
            */

            System.out.println("Selected Segment: " + selectedSegment);
        }
    }

    /** Give this panel the track to construct. */
    public void setTrack (Track track) {
        this.track = track;
    }

    /**
     * @param args the command line arguments
     */
   /*
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                JPanel constructPanel = new ConstructPanel();
                JFrame frame = new JFrame();
                frame.getContentPane().add(constructPanel, BorderLayout.CENTER);
                frame.addWindowListener(
                        new WindowAdapter() {

                            public void windowClosing(WindowEvent e) {
                                System.exit(0);
                            }
                        });
                frame.setBounds(constructPanel.getBounds());
                frame.setVisible(true);
            }
        });
    }
    */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton addButton;
    protected javax.swing.JButton jButton1;
    protected javax.swing.JButton jButton2;
    protected javax.swing.JLabel jLabel1;
    protected javax.swing.JLabel jLabel2;
    protected javax.swing.JButton runButton;
    protected javax.swing.JList segmentList;
    protected javax.swing.JScrollPane segmentScrollPane;
    protected javax.swing.JList typeList;
    protected javax.swing.JScrollPane typeScrollPane;
    // End of variables declaration//GEN-END:variables

    private class TypeListRenderer extends JLabel implements ListCellRenderer {
     // This is the only method defined by ListCellRenderer.
     // We just reconfigure the JLabel each time we're called.

     public Component getListCellRendererComponent(
       JList list,
       Object value,            // value to display
       int index,               // cell index
       boolean isSelected,      // is the cell selected
       boolean cellHasFocus)    // the list and the cell have the focus
     {
         TrackSegmentType type = (TrackSegmentType) value;
         String s = type.getName();
         setText(s);
   	   if (isSelected) {
             setBackground(list.getSelectionBackground());
	       setForeground(list.getSelectionForeground());
	   }
         else {
	       setBackground(list.getBackground());
	       setForeground(list.getForeground());
	   }
	   setEnabled(list.isEnabled());
	   setFont(list.getFont());
         setOpaque(true);
         return this;
     }
 }

    private class SegmentListRenderer extends JLabel implements ListCellRenderer {

        public Component getListCellRendererComponent(JList list, Object value, int index, 
                                                      boolean isSelected, boolean cellHasFocus) {
            TrackSegment segment = (TrackSegment) value;
            String s = segment.getName();
            setText(s);
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            setEnabled(list.isEnabled());
            setFont(list.getFont());
            setOpaque(true);
            return this;
        }
    }

}
