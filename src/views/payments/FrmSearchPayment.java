package views.payments;

import controllers.PaymentController;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.vo.PaymentVO;
import utils.Constants;

public class FrmSearchPayment extends javax.swing.JDialog {
    
    private PaymentController paymentController = null;

    public FrmSearchPayment(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        paymentController = new PaymentController();
        this.clearFields();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblPets = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        txtPetID = new javax.swing.JTextField();
        txtPlanID = new javax.swing.JTextField();
        txtPaymentID = new javax.swing.JTextField();
        btnClearFields = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblPets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "PetCode", "PetName", "Specie", "PlanName", "Subscription", "DatePayment"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPetsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPets);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Pet Search");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Filter by CodePet");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setText("Pet List");

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/assets/search_30px_black.png"))); // NOI18N
        btnSearch.setBorderPainted(false);
        btnSearch.setContentAreaFilled(false);
        btnSearch.setFocusPainted(false);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtPetID.setEnabled(false);

        txtPlanID.setEnabled(false);

        txtPaymentID.setEnabled(false);

        btnClearFields.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/assets/waste_15px.png"))); // NOI18N
        btnClearFields.setBorderPainted(false);
        btnClearFields.setContentAreaFilled(false);
        btnClearFields.setFocusPainted(false);
        btnClearFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFieldsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel15))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnClearFields, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPaymentID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPetID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtPlanID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPaymentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPetID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPlanID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addComponent(jLabel17))
                    .addComponent(btnClearFields))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblPetsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPetsMouseClicked
        
    }//GEN-LAST:event_tblPetsMouseClicked

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        fillTable();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void fillTable() {
        String search = txtSearch.getText().trim();
        if(search.equals("")) {
            JOptionPane.showMessageDialog(this, Constants.MSG_REQUIRED, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        LinkedList<PaymentVO> paymentList = paymentController.searchByPet(search.toUpperCase());
        String datos[][] = new String[paymentList.size()][6];
        
        if(paymentList.size() > 0) {
            for (int i = 0; i < paymentList.size(); i++) {
                datos[i][0] = paymentList.get(i).getPet().getCode();
                datos[i][1] = paymentList.get(i).getPet().getName();
                datos[i][2] = paymentList.get(i).getPet().getSpecie();
                datos[i][3] = paymentList.get(i).getPlan().getName();
                datos[i][4] = Integer.toString(paymentList.get(i).getSubscription());
                datos[i][5] = paymentList.get(i).getDate().toString();
            }
        
            String[] columns = {
                "PetCode", "PetName", "Specie", "PlanName", "Subscription", "PaymentDate"
            };
            DefaultTableModel model = new DefaultTableModel(datos, columns);
            int[] columnSize = {10, 50, 50, 50, 50, 50};
            for(int x=0; x<columnSize.length;x++)
                tblPets.getColumnModel().getColumn(x).setPreferredWidth(columnSize[x]);
            tblPets.setRowHeight(30);
            tblPets.setModel(model);
        } else {
            JOptionPane.showMessageDialog(this, Constants.MSG_NO_EXIST_DATABASE, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void resetTable() {
        String datos[][] = new String[1][6];

        for (String[] dato : datos) {
            dato[0] = "";
            dato[1] = "";
            dato[2] = "";
            dato[3] = "";
            dato[4] = "";
            dato[5] = "";
        }
        
        String[] columns = {
                "PetCode", "PetName", "Specie", "PlanName", "Subscription", "PaymentDate"
            };
        DefaultTableModel model = new DefaultTableModel(datos, columns);
        int[] columnSize = {10, 50, 50, 50, 50, 50};
        for(int x=0; x<columnSize.length;x++)
            tblPets.getColumnModel().getColumn(x).setPreferredWidth(columnSize[x]);
        tblPets.setRowHeight(30);
        tblPets.setModel(model);
    }
    
    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.fillTable();
        }
    }//GEN-LAST:event_txtSearchKeyPressed

    private void btnClearFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFieldsActionPerformed
        this.clearFields();
    }//GEN-LAST:event_btnClearFieldsActionPerformed

    private void clearFields() {
        txtSearch.setText("");
        resetTable();
        txtSearch.requestFocus();
    }
    
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSearchPayment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            FrmSearchPayment dialog = new FrmSearchPayment(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearFields;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblPets;
    private javax.swing.JTextField txtPaymentID;
    private javax.swing.JTextField txtPetID;
    private javax.swing.JTextField txtPlanID;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
