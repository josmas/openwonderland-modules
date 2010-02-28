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

package org.jdesktop.wonderland.modules.metadata.client.plugin;

import com.jme.math.Quaternion;
import com.jme.math.Vector3f;
import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import org.jdesktop.wonderland.client.jme.ClientContextJME;
import org.jdesktop.wonderland.client.jme.JmeClientMain;
import org.jdesktop.wonderland.common.cell.CellID;
import org.jdesktop.wonderland.modules.metadata.client.MetadataTypesTable;
import org.jdesktop.wonderland.modules.metadata.common.Metadata;
import org.jdesktop.wonderland.modules.metadata.common.messages.MetadataCellInfo;

/**
 * Displays the results of a metadata search. Shown by MetadataPlugin.
 *
 * @author mabonner
 */
public class MetadataSearchResultsForm extends javax.swing.JFrame implements TableModelListener{

  private static Logger logger = Logger.getLogger(MetadataSearchResultsForm.class.getName());

  /**
   * Displays search results. Changed to point at appropriate MTT for currently
   * selected cell in search results.
   */
  private MetadataTypesTable tabs = new MetadataTypesTable();

  /**
   * stores metadata, with hits highlighted, for each cell result.
   * fetch the metadata and build a metadatatypestable on demand, cache the
   * result here.
   */
  private HashMap<CellID, MetadataTypesTable> metaTablesCache = new HashMap<CellID, MetadataTypesTable>();

  /**
   * maps cells to the results of a search
   */
  private HashMap<CellID, MetadataCellInfo> searchResults = new HashMap<CellID, MetadataCellInfo>();

  private JLabel noResultsLabel = new JLabel("No Search Results - Try Modifying Search");
  private boolean tabsAdded = false;

  // Note: querying cell cache will not let us get to the SERVER state, which
  // is where metadata is actually stored. For now, the metadata is sent over
  // in the response message and stored here.
  //
  // If in the future metadata is stored
  // on the server as well, then it could be accessed via the cell cache/request
  // cell outside of cache system, saving sending everything in a message.

  /** Creates new form MetadataSearchResultsForm */
  public MetadataSearchResultsForm() {
      initComponents();

      resultsTable.setModel(new ResultsTableModel());
//      tabDisplay.add(tabs);

      // add listeners
      resultsTable.getSelectionModel().addListSelectionListener(new resultsSelectionListener());
      resultsTable.getModel().addTableModelListener(this);
  }

  @Override
  public void repaint(){
    super.repaint();
    logger.info("repainting main frame, tabs has " + tabs.getMetadataCount() + " pieces of metadata");
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    resultsTable = new javax.swing.JTable();
    resultsLabel = new javax.swing.JLabel();
    tabDisplay = new javax.swing.JPanel();
    gotoButton = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setTitle("Metadata Search Results");

    resultsTable.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null},
        {null, null},
        {null, null},
        {null, null}
      },
      new String [] {
        "Cell Name", "Cell ID"
      }
    ) {
      Class[] types = new Class [] {
        java.lang.String.class, java.lang.String.class
      };
      boolean[] canEdit = new boolean [] {
        false, false
      };

      public Class getColumnClass(int columnIndex) {
        return types [columnIndex];
      }

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane1.setViewportView(resultsTable);

    resultsLabel.setText("# Results");

    tabDisplay.setBackground(new java.awt.Color(153, 153, 153));
    tabDisplay.setLayout(new java.awt.BorderLayout());

    gotoButton.setText("Goto Metadata");
    gotoButton.setEnabled(false);
    gotoButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        gotoButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(resultsLabel)
          .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(8, 8, 8)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(gotoButton)
          .addComponent(tabDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap())
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(tabDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(gotoButton))
          .addGroup(layout.createSequentialGroup()
            .addComponent(resultsLabel)
            .addGap(22, 22, 22)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)))
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void gotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gotoButtonActionPerformed
    Metadata meta = tabs.getCurrentlySelectedMetadata();
    Vector3f loc = meta.getLocation();
    if(loc == null){
      // use cell location by default
      int curRow = resultsTable.getSelectedRow();
      ResultsTableModel mod = (ResultsTableModel) resultsTable.getModel();
      CellID id = mod.getCellIDFromRow(curRow);
      loc = searchResults.get(id).getCellLocation();
    }
    try {
      // TODO temp
      Quaternion q = new Quaternion().fromAngleAxis(0, Vector3f.UNIT_Y);
      ClientContextJME.getClientMain().gotoLocation(null, loc, q);
    } catch (IOException ex) {
      logger.info("get location failed");
      Logger.getLogger(MetadataSearchResultsForm.class.getName()).log(Level.SEVERE, null, ex);
    }
  }//GEN-LAST:event_gotoButtonActionPerformed

  private JTable getCurrentTabTable() {
    return tabs.getCurrentTable();
  }

  /**
   * a search was completed, set the results to display, fetch metadata
   * @param results maps cellID's to list of mid hits for that cell
   */
  void setResults(HashMap<CellID, MetadataCellInfo> results) {
    logger.info("[Search Results] set new results there are " + results.size());
    // clear out old values
    tabs.clearTabs();
    metaTablesCache.clear();
    searchResults.clear();
    resultsTable.setModel(new ResultsTableModel());

    // set results counter
    resultsLabel.setText(results.size() + " cells match search");
    searchResults = results;
    for(Entry<CellID, MetadataCellInfo> e : searchResults.entrySet()){
      CellID cid = e.getKey();
//      logger.info("[Search Results] cid: " + cid + ", num hits:" + e.getValue().size());
      ResultsTableModel mod = (ResultsTableModel) resultsTable.getModel();
      // get cell and cell id, get name, add row
      String cellName = null;
      mod.addRow(e.getKey(), e.getValue().getName());
    }

    if(searchResults.size() == 0){
      
      tabs.setVisible(false);
      noResultsLabel.setVisible(true);
      if(tabsAdded){
        logger.info("[Search Results] remove tabs");
        tabDisplay.remove(tabs);
        tabsAdded = false;
        tabDisplay.add(noResultsLabel, BorderLayout.CENTER);
      }
      
    }
    else{
      tabDisplay.remove(noResultsLabel);
      // set first row selected, display that table
      logger.info("[Search Results] set selection");
      resultsTable.setRowSelectionInterval(0, 0);
      logger.info("[Search Results] selection set");
//      if(!tabsAdded){
//        tabDisplay.add(tabs);
//      }
      // will this fire automatically?
      tabs.setVisible(true);
      
    }
//    validate();
//    repaint();
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton gotoButton;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JLabel resultsLabel;
  private javax.swing.JTable resultsTable;
  private javax.swing.JPanel tabDisplay;
  // End of variables declaration//GEN-END:variables

  // End of variables declaration

  class ResultsTableModel extends AbstractTableModel{
    ArrayList<CellID> cids = new ArrayList<CellID>();
    ArrayList<String> names = new ArrayList<String>();
    public int getRowCount() {
      return cids.size();
    }

    public int getColumnCount() {
      return 2;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
      switch (columnIndex){
        case 0:
          if(rowIndex < cids.size()){
            return cids.get(rowIndex);
          }
          return null;
        case 1:
          if(rowIndex < names.size()){
            return names.get(rowIndex);
          }
          break;
      }
      return null;
    }

    void addRow(CellID cid, String name){
      logger.info("add row in search model");
//      logger.info("before adding, model size:" + cids.size());
      cids.add(cid);
      names.add(name);
      int row = cids.size() - 1;
      this.fireTableRowsInserted(cids.size() - 1,
                                 cids.size() - 1);
//      logger.info("after adding, model size:" + cids.size());
    }

    /**
     * disallow all edits
     * @param row
     * @param col
     * @return
     */
    @Override
    public boolean isCellEditable(int row, int col) {
      // never editable
      return false;
    }

    @Override
    public String getColumnName(int column){
      if(column == 0){
        return "Cell ID";
      }
      else{
        return "Cell Name";
      }
      
    }

    private CellID getCellIDFromRow(int curRow) {
      if(cids.get(curRow) == null){
        logger.info("get cid from results row: cid was null!");
        return null;
      }
      return cids.get(curRow);
    }

  }

  public void tableChanged(TableModelEvent e) {
    logger.info("[SEARCH RESULTS] res table changed, repaint");
    repaint();
  }

  /**
   * build a cell's MetadataTypesTable, using our stored information
   *
   * then cache it
   * 
   * @param cid
   */
  private void buildMTTForCell(CellID cid) {
    // this table could be connected to a cell, allowing edits and receiving updates
    // for now, this is effectively a static snapshot of the cell's metadata
    // from the time of the search
    logger.info("[SEARCH RESULTS] building MTT");
    MetadataTypesTable mtt = new MetadataTypesTable();
    mtt.setTableCellsEditable(MetadataTypesTable.AllowEdits.NEVER);
    MetadataCellInfo cellInfo = searchResults.get(cid);

    // load metadata, set which mids to highlight
    mtt.addMetadata(cellInfo.getMetadata(), cellInfo.getHits());
    // add selection listener to enable goto button on selections
    mtt.registerListSelectionListener(new gotoSelectionListener());
    
    metaTablesCache.put(cid, mtt);
  }

  /**
   * listens for selections of a row in the results panel
   * when a cell is selected, display its MetadataTypesTable
   */
  class gotoSelectionListener implements ListSelectionListener {
    public void valueChanged(ListSelectionEvent e) {
      boolean valid = false;
      JTable tab = getCurrentTabTable();
      int selectedIdx = tab.getSelectedRow();
      if (!e.getValueIsAdjusting() && selectedIdx >= 0) {
          valid = true;
      }
      if(!valid){
        logger.info("[SEARCH RESULTS] selection in progress!");
        return;
      }
      // cell ID from resultsTable
      // CellID cid = (CellID) resultsTable.getValueAt(selectedIdx, 0);
      // logger.info("[SEARCH RESULTS] selected new result: " + selectedIdx +
      //        " which is cid: " + cid);

      // enable goto button
      gotoButton.setEnabled(true);
    }


  }

  /**
   * listens for selections of a row in the results panel
   * when a cell is selected, display its MetadataTypesTable
   */
  class resultsSelectionListener implements ListSelectionListener {
    public void valueChanged(ListSelectionEvent e) {
      boolean valid = false;
      int selectedIdx = resultsTable.getSelectedRow();
      if (!e.getValueIsAdjusting() && selectedIdx >= 0) {
          valid = true;
      }
      if(!valid){
        logger.info("[SEARCH RESULTS] selection in progress!");
        return;
      }
      CellID cid = (CellID) resultsTable.getValueAt(selectedIdx, 0);
      logger.info("[SEARCH RESULTS] selected new result: " + selectedIdx +
              " which is cid: " + cid);

      // if already in the cache, simply display that table
      if(!metaTablesCache.containsKey(cid)){
        logger.info("[SEARCH RESULTS] was not in cache, build");
        buildMTTForCell(cid);
      }
//      if(tabsAdded){
        // remove old table first
        logger.info("[SEARCH RESULTS] remove old table");
        tabDisplay.remove(tabs);
//      }
//      else{
//        noResultsLabel.setVisible(false);
        // remove old 'no results' label
//        tabDisplay.remove(noResultsLabel);
//      }
      logger.info("old # tabs:" + tabs.getTabCount() + " # metadata:" + tabs.getMetadataCount());
      tabs = metaTablesCache.get(cid);
      logger.info("NEWWW # tabs:" + tabs.getTabCount() + " # metadata:" + tabs.getMetadataCount());
      logger.info("[Search Results] tabs added");
      tabDisplay.add(tabs, BorderLayout.CENTER);
      tabs.setVisible(true);
//      tabsAdded = true;
//      tabs.revalidate();
//      tabDisplay.revalidate();
//      tabs.repaint();
      tabDisplay.revalidate();
//      MetadataSearchResultsForm.this.repaint();
    }
  }
}
