
package Interface;

import Code.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class Anyall extends javax.swing.JInternalFrame {
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet urs = null;
    
    
    public Anyall() {
        initComponents();
        con = DBconnect.connect();
        rmvtableload();
        
    }
    
    public void rmvtableload()
    {
        try {
            
            String rmvallqry = "SELECT * FROM vehicles";
            pst = con.prepareStatement(rmvallqry);
            urs = pst.executeQuery();
            
            rmvalltable.setModel(DbUtils.resultSetToTableModel(urs));
            
        } catch (Exception e) {
        }
        
        
        
        
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        rmvalltable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        avnumberbox = new javax.swing.JLabel();
        rmvallbtn = new javax.swing.JButton();

        rmvalltable.setModel(new javax.swing.table.DefaultTableModel(
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
        rmvalltable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rmvalltableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(rmvalltable);

        jLabel1.setText("Vehicle Number : ");

        avnumberbox.setText("Number");

        rmvallbtn.setText("Remove Vehicle");
        rmvallbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmvallbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1350, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(avnumberbox, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(rmvallbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(avnumberbox)
                    .addComponent(rmvallbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 228, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rmvalltableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rmvalltableMouseClicked
        int ar = rmvalltable.getSelectedRow();
        
        String avnumber = (String) rmvalltable.getValueAt(ar, 5);
        
        avnumberbox.setText(avnumber);
        
        
    }//GEN-LAST:event_rmvalltableMouseClicked

    private void rmvallbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmvallbtnActionPerformed
        int rx = JOptionPane.showConfirmDialog(null , "Do you really want to remove this vehicle?");
        
        if(rx==0)
        {
            String avnum = avnumberbox.getText();
            
            try 
            {
                String allqry = "DELETE FROM vehicles WHERE vnumber = '"+avnum+"'";
                pst = con.prepareStatement(allqry);
                pst.execute();
                
                
                
                
            } catch (Exception e) {
            }
            
        
        
        
        
        
        
        }
        
    }//GEN-LAST:event_rmvallbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avnumberbox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton rmvallbtn;
    private javax.swing.JTable rmvalltable;
    // End of variables declaration//GEN-END:variables
}
