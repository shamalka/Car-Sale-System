
package Interface;

import Code.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;


public class ShowAll extends javax.swing.JInternalFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public ShowAll() {
        initComponents();
        
        con = DBconnect.connect();
        tableload();
        
    }
    
    public void tableload()
    {
    
        try {
            String sql = "SELECT * FROM vehicles";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            showalltable.setModel(DbUtils.resultSetToTableModel(rs));
            
            
            
        } catch (Exception e) {
        }
        
    
    
    
    }
    
    
    

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        showalltable = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(1366, 650));

        showalltable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        showalltable.setPreferredSize(new java.awt.Dimension(1360, 64));
        jScrollPane1.setViewportView(showalltable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable showalltable;
    // End of variables declaration//GEN-END:variables
}
