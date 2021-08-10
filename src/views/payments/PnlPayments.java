package views.payments;

import controllers.CustomerController;
import controllers.PaymentController;
import controllers.PetController;
import controllers.PlanController;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import models.vo.CustomerVO;
import models.vo.PaymentVO;
import models.vo.PetVO;
import models.vo.PlanVO;
import utils.Constants;
import utils.MyDate;

public class PnlPayments extends javax.swing.JPanel {

    private CustomerController customerController = null;
    private PlanController planController = null;
    private PetController petController = null;
    private CustomerVO customer = null;
    private LinkedList<CustomerVO> listCustomers = null;
    private LinkedList<PetVO> petList;
    private PlanVO plan = null;
    private LinkedList<PlanVO> listPlans = null;
    private PaymentController paymentController = null;
    
    private String paymentID;
    private String planID;
    private String petID;
    private String subscription;
    private String paymentDate;
    
    public PnlPayments() {
        initComponents();
        customerController = new CustomerController();
        petController = new PetController();
        planController = new PlanController();
        paymentController = new PaymentController();
        fillCustomersComboBox();
        fillPlansComboBox();
        //txtOwnerID.setVisible(false);
        //txtPaymentID.setVisible(false);
        //txtPlanID.setVisible(false);
        //txtPetID.setVisible(false);
    }
    
    public void create_payment() {
        readFields();
        
        if(planID.equals("") || petID.equals("") || subscription.equals("") || paymentDate.equals("")) {
            JOptionPane.showMessageDialog(this, Constants.MSG_REQUIRED, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(paymentController.create(getPayment())) {
            JOptionPane.showMessageDialog(this, Constants.MSG_SAVE_SUCESS, "Message", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, Constants.MSG_SAVE_ERROR, "Error", JOptionPane.ERROR_MESSAGE);
        }        
        resetTable();
        resetVariables();
    }
    public void update_payment() {
        //Start update
        System.out.println("Start update");
    }
    public void delete_payment() {
        
    
    }
    public void findByID_payment() {
            
    }   
    
    private void readFields() {
        paymentID = txtPaymentID.getText().trim();
        planID = txtPlanID.getText().trim();
        petID = txtPetID.getText().trim();
        subscription = spnPaymentSubscription.getValue().toString();
        paymentDate = MyDate.getDate(dpPayment);
    }
    
    private void resetVariables() {
        paymentID = "";
        planID = "";
        petID = "";
        subscription = "";
        paymentDate = "";
    }
    
    private void clearFields() {
        txtPetID.setText("");
        txtPlanID.setText("");
        txtOwnerID.setText("");
        txtPaymentID.setText("");
        txtPetCode.setText("");
        txtPetName.setText("");
        txtPetSpecie.setText("");
        txtPlanDescription.setText("");
        txtPlanPrice.setText("");
        spnPaymentSubscription.setValue(0);
        ((JTextField)dpPayment.getDateEditor().getUiComponent()).setText("");
    }
    
    private PaymentVO getPayment() {
        PaymentVO _paymentVO = new PaymentVO();
        PetVO _petVO = new PetVO();
        PlanVO _planVO = new PlanVO();
        _petVO.setId(Integer.parseInt(petID));
        _planVO.setId(Integer.parseInt(planID));
        //_paymentVO.setId(Integer.parseInt(paymentID));
        _paymentVO.setPet(_petVO);
        _paymentVO.setPlan(_planVO);
        _paymentVO.setSubscription(Integer.parseInt(subscription));
        _paymentVO.setDate(Date.valueOf(paymentDate));
        return _paymentVO;
    }
    
    private void fillCustomersComboBox() {
        listCustomers = customerController.readAll();
        if(listCustomers.size() > 0){
            ArrayList<String> fullname = new ArrayList<>();
            listCustomers.forEach((c) -> {
                fullname.add(c.getName() + " " + c.getLastname() + "-" + String.valueOf(c.getId()));
            });
            DefaultComboBoxModel model = new DefaultComboBoxModel(fullname.toArray());
            cbxCustomerName.setModel(model);
        }
    }
    
    private void fillPlansComboBox() {
        listPlans = planController.readAll();
        if(listPlans.size() > 0){
            ArrayList<String> namePlan = new ArrayList<>();
            listPlans.forEach((p) -> {
                namePlan.add(p.getName() + "-" + (p.getCode()));
            });
            DefaultComboBoxModel model = new DefaultComboBoxModel(namePlan.toArray());
            cbxPlanName.setModel(model);
        }
    }
    
    private void resetTable() {
        String datos[][] = new String[1][6];

        for (String[] dato : datos) {
            dato[Constants.ID_PET] = "";
            dato[Constants.CODE_PET] = "";
            dato[Constants.NAME_PET] = "";
            dato[Constants.AGE_PET] = "";
            dato[Constants.WEIGHT_PET] = "";
            dato[Constants.SPECIE_PET] = "";
        }
        
        String[] columns = {
            "PetID", "Code", "Name", "Age", "Weight", "Specie"
        };
        DefaultTableModel model = new DefaultTableModel(datos, columns);
        int[] columnSize = {10, 50, 50, 50, 50, 50};
        for(int x=0; x<columnSize.length;x++)
            tblPets.getColumnModel().getColumn(x).setPreferredWidth(columnSize[x]);
        tblPets.setRowHeight(30);
        tblPets.setModel(model);        
    }
    
    private void fillDataTable(int id) {
        petList = petController.readPetsByCustomerID(id);
        String datos[][] = new String[petList.size()][6];

        if(petList.size() > 0) {
            for (int i = 0; i < petList.size(); i++) {
                datos[i][Constants.ID_PET] = Integer.toString(petList.get(i).getId());
                datos[i][Constants.CODE_PET] = petList.get(i).getCode();
                datos[i][Constants.NAME_PET] = petList.get(i).getName();
                datos[i][Constants.AGE_PET] = Integer.toString(petList.get(i).getAge());
                datos[i][Constants.WEIGHT_PET] = Float.toString(petList.get(i).getWeight());
                datos[i][Constants.SPECIE_PET] = petList.get(i).getSpecie();
            }
        }
        String[] columns = {
            "PetID", "Code", "Name", "Age", "Weight", "Specie"
        };
        DefaultTableModel model = new DefaultTableModel(datos, columns);
        int[] columnSize = {10, 50, 50, 50, 50, 50};
        for(int x=0; x<columnSize.length;x++)
            tblPets.getColumnModel().getColumn(x).setPreferredWidth(columnSize[x]);
        tblPets.setRowHeight(30);
        tblPets.setModel(model);        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPets = new javax.swing.JTable();
        txtPaymentID = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtPetSpecie = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtPetName = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtPetCode = new javax.swing.JTextField();
        txtPlanPrice = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        dpPayment = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPlanDescription = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        cbxCustomerName = new javax.swing.JComboBox<>();
        cbxPlanName = new javax.swing.JComboBox<>();
        txtOwnerID = new javax.swing.JTextField();
        txtPlanID = new javax.swing.JTextField();
        spnPaymentSubscription = new javax.swing.JSpinner();
        txtPetID = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(950, 570));
        setMinimumSize(new java.awt.Dimension(950, 570));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Owner's pets");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Specie");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Select Owner");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Owner Information");

        tblPets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Code", "Name", "Age", "Weight", "Specie"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.String.class
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

        txtPaymentID.setEnabled(false);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Select a pet from the list to proceed with the payment");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("PetCode");

        txtPetSpecie.setEnabled(false);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("PetName");

        txtPetName.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("PlanName");

        txtPetCode.setEnabled(false);

        txtPlanPrice.setEnabled(false);

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Price");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Subscription");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Payment date");

        dpPayment.setDateFormatString("yyyy/MM/d");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Pet");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Payment");

        txtPlanDescription.setColumns(20);
        txtPlanDescription.setRows(5);
        txtPlanDescription.setEnabled(false);
        jScrollPane1.setViewportView(txtPlanDescription);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Plan");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Description");

        cbxCustomerName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxCustomerName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Select -" }));
        cbxCustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCustomerNameActionPerformed(evt);
            }
        });

        cbxPlanName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Select -", " " }));
        cbxPlanName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPlanNameActionPerformed(evt);
            }
        });

        txtOwnerID.setEnabled(false);

        txtPlanID.setEnabled(false);

        spnPaymentSubscription.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtPetID.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel18)
                            .addComponent(jLabel13)
                            .addComponent(jLabel3)
                            .addComponent(txtPetCode, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtPetSpecie, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                .addComponent(txtPetName, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel24)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxPlanName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(txtPlanPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel22)
                            .addComponent(spnPaymentSubscription)
                            .addComponent(jLabel23)
                            .addComponent(dpPayment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(46, 46, 46))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(cbxCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtPetID, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtPlanID, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtOwnerID, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtPaymentID, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel2)
                            .addComponent(jLabel17))
                        .addContainerGap(46, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPaymentID)
                    .addComponent(txtOwnerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPlanID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPetID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxPlanName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtPetCode, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                    .addComponent(spnPaymentSubscription))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPlanPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dpPayment, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPetName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPetSpecie, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void findCustomerById(String id) {
        customer = customerController.read(Integer.parseInt(id));
        if(customer.getId() > 0) {
            txtOwnerID.setText(String.valueOf(customer.getId()));
        }
    }
    
    public void findPlanByCode(String code) {
        plan = planController.read(code);
        if(plan.getId() > 0) {
            txtPlanID.setText(String.valueOf(plan.getId()));
            txtPlanPrice.setText(Float.toString(plan.getPrice()));
            txtPlanDescription.setText(plan.getDescription());
        }
    }
    
    private void cbxCustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCustomerNameActionPerformed
        String[] valueCombo = cbxCustomerName.getSelectedItem().toString().split("-");
        findCustomerById(valueCombo[1]);
        fillDataTable(Integer.parseInt(valueCombo[1]));
    }//GEN-LAST:event_cbxCustomerNameActionPerformed

    private void tblPetsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPetsMouseClicked
        int row = tblPets.getSelectedRow();
        String id = tblPets.getValueAt(row, 1).toString();
        PetVO pet = petController.read(id);
        
        if(pet.getId() > 0) {
            txtPetID.setText(String.valueOf(pet.getId()));
            txtPetCode.setText(pet.getCode());
            txtPetName.setText(pet.getName());
            txtPetSpecie.setText(pet.getSpecie());
        }
    }//GEN-LAST:event_tblPetsMouseClicked

    private void cbxPlanNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPlanNameActionPerformed
        String[] valueCombo = cbxPlanName.getSelectedItem().toString().split("-");
        findPlanByCode(valueCombo[1]);
    }//GEN-LAST:event_cbxPlanNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxCustomerName;
    private javax.swing.JComboBox<String> cbxPlanName;
    private com.toedter.calendar.JDateChooser dpPayment;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner spnPaymentSubscription;
    private javax.swing.JTable tblPets;
    private javax.swing.JTextField txtOwnerID;
    private javax.swing.JTextField txtPaymentID;
    private javax.swing.JTextField txtPetCode;
    private javax.swing.JTextField txtPetID;
    private javax.swing.JTextField txtPetName;
    private javax.swing.JTextField txtPetSpecie;
    private javax.swing.JTextArea txtPlanDescription;
    private javax.swing.JTextField txtPlanID;
    private javax.swing.JTextField txtPlanPrice;
    // End of variables declaration//GEN-END:variables
}
