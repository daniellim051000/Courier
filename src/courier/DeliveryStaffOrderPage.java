/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courier;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jasmi
 */
public class DeliveryStaffOrderPage extends javax.swing.JFrame {
     String UserID = "";
     
    class DeliveryStaff{
           //to show the order details of the user
        /*String filepath = "txt";
        File file = new File(filepath);
        
        BufferedReader br;
        String strLine;
        try {
            br = new BufferedReader (new FileReader(file));

            String[] columnName = {"Course", "Time", "Date" , "Fee", "Venue", "Trainer"};

            DefaultTableModel model = (DefaultTableModel)check_schedule.getModel();
            model.setColumnIdentifiers(columnName);
            model.setRowCount(0); //clear the model
            check_schedule.revalidate(); //refresh the table
                try {
                    while((strLine=br.readLine())!=null){
                        Object[] details = strLine.lines().toArray();
                        for (Object detail : details) {
                            String line = detail.toString().trim();
                            String[] row = line.split(",");

                            if (trainer.equals(row[5])) {
                                model.addRow(row);
                            }
                        }
                        
                    }   } catch (IOException ex) {
                    Logger.getLogger(check_schedule.class.getName()).log(Level.SEVERE, null, ex);
                }

        } catch (IOException ex) {
            Logger.getLogger(check_schedule.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    }
    class ManagingStaff{}
    class Customer{}
    /**
     * Creates new form DeliveryStaffOrderPage
     */
    public DeliveryStaffOrderPage(String user_id) {
        initComponents();
         UserID = user_id;
         
       try{
          //read data from the file  
         File file = new File("UserDetails.txt");
         Scanner sc = new Scanner(file); 
         File file1 = new File("Orders.txt");
         String temp;
         boolean found = false;
         String strLine;
         BufferedReader br = new BufferedReader (new FileReader(file1));

          String[] columnName = {"OrderID", "Sender's Address", "Receiver's Address" , "Delivery Person", "UserID"};

           DefaultTableModel model = (DefaultTableModel)Ordertbl.getModel();
           model.setColumnIdentifiers(columnName);
           model.setRowCount(0); //clear the model
           Ordertbl.revalidate(); //refresh the table
           
            
           //check equals userid with database and retrieve user type 
           while(sc.hasNext() && !found /*the system will stop running while it found the correct username and password*/){
           temp = sc.nextLine(); //read a line of text from file
           String[] tempArr;
           tempArr = temp.split (",");

              if (UserID.equals(tempArr[0])) { 
                String Temptype = tempArr[2];
                  if(Temptype.equals("Managing Staff")){
                    addbtn.setVisible(false);
                       // table show details for managing staff                        
                        while((strLine=br.readLine())!=null){
                          Object[] details = strLine.lines().toArray();
                              for (Object detail : details) {
                                  String line = detail.toString().trim();
                                  String[] row = line.split(",");
                                  String delivery = row[19];
                                     if (!delivery.equals("None")) {
                                        model.addRow(row);
                                    }
                              }
                       }
                    }else if (Temptype.equals("Customer")){
                     // table show details for customer
                      while((strLine=br.readLine())!=null){
                         Object[] details = strLine.lines().toArray();
                           for (Object detail : details) {
                              String line = detail.toString().trim();
                              String[] row = line.split(",");
                              String orderuserid = row[21];
                                 if (UserID.equals(orderuserid)) {
                                   model.addRow(row);
                                  }
                           }
                     }                        

                  }else {
                        addbtn.setVisible(false);
                        // table show details for delivery staff
                      while((strLine=br.readLine())!=null){
                         Object[] details = strLine.lines().toArray();
                           for (Object detail : details) {
                              String line = detail.toString().trim();
                              String[] row = line.split(",");
                              String deliveryuserid = row[19];
                                 if (UserID.equals(deliveryuserid)) {
                                   model.addRow(row);
                                  }
                           }
                     }                        
                    }
                 }
              }
   }  catch (IOException ex) {
         Logger.getLogger(DeliveryStaffOrderPage.class.getName()).log(Level.SEVERE, null, ex);
   }      
 }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        deliveryOrderlbl = new javax.swing.JLabel();
        assigndeliveryorderlbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Ordertbl = new javax.swing.JTable();
        logoutbtn = new javax.swing.JButton();
        addbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        deliveryOrderlbl.setFont(new java.awt.Font("Tahoma", 1, 35)); // NOI18N
        deliveryOrderlbl.setText("Delivery");

        assigndeliveryorderlbl.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        assigndeliveryorderlbl.setText("Assigned Order");

        Ordertbl.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        Ordertbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(Ordertbl);

        logoutbtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        logoutbtn.setText("Logout");
        logoutbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutbtnActionPerformed(evt);
            }
        });

        addbtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        addbtn.setText("Add");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deliveryOrderlbl)
                            .addComponent(assigndeliveryorderlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(logoutbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(logoutbtn)
                        .addGap(18, 18, 18)
                        .addComponent(addbtn)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(deliveryOrderlbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(assigndeliveryorderlbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        this.dispose();
        new DeliveryStaffChangeStatusAndView(UserID).setVisible(true);
    }//GEN-LAST:event_addbtnActionPerformed

    private void logoutbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutbtnActionPerformed
        this.dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutbtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DeliveryStaffOrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeliveryStaffOrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeliveryStaffOrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeliveryStaffOrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new DeliveryStaffOrderPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Ordertbl;
    private javax.swing.JButton addbtn;
    private javax.swing.JLabel assigndeliveryorderlbl;
    private javax.swing.JLabel deliveryOrderlbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutbtn;
    // End of variables declaration//GEN-END:variables
}
