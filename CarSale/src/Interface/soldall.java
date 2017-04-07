
package Interface;

import Code.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class soldall extends javax.swing.JInternalFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet urs = null;
    
    
    public soldall() {
        initComponents();
        
        con = DBconnect.connect();
        soldtableload();
    }
    
    public void soldtableload()
    {
        try 
        {
            String soldqry = "SELECT * FROM soldvehicles";
            pst = con.prepareStatement(soldqry);
            urs = pst.executeQuery();
            
            rmvsoldtable.setModel(DbUtils.resultSetToTableModel(urs));
            
            
        } catch (Exception e) {
        }
    
    
    
    
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        rmvsoldtable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        rmvnumber = new javax.swing.JLabel();
        rmvslbtn = new javax.swing.JButton();

        rmvsoldtable.setModel(new javax.swing.table.DefaultTableModel(
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
        rmvsoldtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rmvsoldtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(rmvsoldtable);

        jLabel1.setText("Vehicle Number : ");

        rmvnumber.setText("Number");

        rmvslbtn.setText("Remove Vehicle");
        rmvslbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmvslbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1350, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rmvnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(rmvslbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(rmvnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rmvslbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 213, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rmvsoldtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rmvsoldtableMouseClicked
        int sr = rmvsoldtable.getSelectedRow();
        
        String number = (String) rmvsoldtable.getValueAt(sr, 1);
        
        rmvnumber.setText(number);
        
    }//GEN-LAST:event_rmvsoldtableMouseClicked

    private void rmvslbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmvslbtnActionPerformed
        
        int c = JOptionPane.showConfirmDialog(null , "Do you really want to remove this vehicle?");
        
        if(c==0){
            String num = rmvnumber.getText();
        
            try 
            {
                String rmvqry = "DELETE FROM soldvehicles WHERE VehicleNumber = '"+num+"'";
                String rmvqry2 = "DELERE FROM vehicles WHERE vnumber = '"+num+"'";
                
                pst = con.prepareStatement(rmvqry);
                
                pst.execute();
                
                
            
            
            
            } catch (Exception e) {
            }
        
        
        }
        
        
        
        
    }//GEN-LAST:event_rmvslbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel rmvnumber;
    private javax.swing.JButton rmvslbtn;
    private javax.swing.JTable rmvsoldtable;
    // End of variables declaration//GEN-END:variables
}
