package views.plans;

import controllers.PlanController;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.vo.PlanVO;
import utils.Constants;

public class PnlPlans extends javax.swing.JPanel {

    private PlanController planController = null;
    private LinkedList<PlanVO> planList;
    
    private String id;
    private String code;
    private String name;
    private String description;
    private String price;
    
    public PnlPlans() {
        initComponents();
        planController = new PlanController();
        txtID.setVisible(false);
        fillDataTable();
    }
    
    private void readFields() {
        id = txtID.getText().trim();
        code = txtCode.getText().trim().toUpperCase();
        name = txtName.getText().trim().toUpperCase();
        description = txtDescription.getText().trim();
        price = txtPrice.getText().trim();
    }
    
    private PlanVO getPlan() {
        PlanVO plan = new PlanVO();
        plan.setCode(code);
        plan.setName(name);
        plan.setDescription(description);
        plan.setPrice(Float.parseFloat(price));
        return plan;
    }
    
    private void resetVariables() {
        id = "";
        code = "";
        name = "";
        description = "";
        price = "";                
    }
    
    private void clearFields() {
        txtID.setText("");
        txtCode.setText("");
        txtName.setText("");
        txtDescription.setText("");
        txtPrice.setText("");
    }
    
    public void create_plan() {
        readFields();
        
        if(code.equals("") || name.equals("") || description.equals("") || price.equals("")) {
            JOptionPane.showMessageDialog(this, Constants.MSG_REQUIRED, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(planController.create(getPlan())) {
            JOptionPane.showMessageDialog(this, Constants.MSG_SAVE_SUCESS, "Message", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, Constants.MSG_SAVE_ERROR, "Error", JOptionPane.ERROR_MESSAGE);
        }        
        fillDataTable();
        resetVariables();
    }
    
    public void update_plan() {
        readFields();
        
        if(code.equals("") || name.equals("") || description.equals("") || price.equals("")) {
            JOptionPane.showMessageDialog(this, Constants.MSG_REQUIRED, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(planController.create(getPlan())) {
            JOptionPane.showMessageDialog(this, Constants.MSG_UPDATE_SUCESS, "Message", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, Constants.MSG_UPDATE_ERROR, "Error", JOptionPane.ERROR_MESSAGE);
        }        
        fillDataTable();
        resetVariables();
    }
    
    public void delete_plan() {
        id = txtID.getText().trim();
        
        if(id.equals("")) {
            JOptionPane.showMessageDialog(this, "Check pet first", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int dialogResult = JOptionPane.showConfirmDialog (
                null, 
                "¿Are you sure to delete this record?",
                "Warning",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );
        
        if(dialogResult == JOptionPane.YES_OPTION){
            if(planController.delete(id)) {
                JOptionPane.showMessageDialog(this, Constants.MSG_DELETE_SUCESS, "Message", JOptionPane.INFORMATION_MESSAGE);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, Constants.MSG_DELETE_ERROR, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        fillDataTable();
        resetVariables();
    }
    
    public void findPlanByID() {
        code = txtCode.getText().trim();
        if(code.equals("")) {
            JOptionPane.showMessageDialog(this, Constants.MSG_REQUIRED, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PlanVO plan = planController.read(code);
      
        if(plan.getId() > 0) {
            txtID.setText(String.valueOf(plan.getId()));
            txtCode.setText(plan.getCode());
            txtName.setText(plan.getName());
            txtDescription.setText(plan.getDescription());
            txtPrice.setText(Float.toString(plan.getPrice()));
        } else {
           JOptionPane.showMessageDialog(this, Constants.MSG_NO_EXIST_DATABASE, "Error", JOptionPane.ERROR_MESSAGE); 
        }
        resetVariables();      
    }
    
     private void fillDataTable() {
        planList = planController.readAll();
        String datos[][] = new String[planList.size()][5];

        if(planList.size() > 0) {
            for (int i = 0; i < planList.size(); i++) {
                datos[i][Constants.ID_PLAN] = Integer.toString(planList.get(i).getId());
                datos[i][Constants.CODE_PLAN] = planList.get(i).getCode();
                datos[i][Constants.NAME_PLAN] = planList.get(i).getName();
                datos[i][Constants.DESCRIPTION_PLAN] = planList.get(i).getDescription();
                datos[i][Constants.PRICE_PLAN] = Float.toString(planList.get(i).getPrice());
            }        
        }
        String[] columns = {
            "PlanID", "Code", "Name", "Description", "Price"
        };
        DefaultTableModel model = new DefaultTableModel(datos, columns);
        int[] columnSize = {10, 50, 50, 50, 50};
        for(int x=0; x<columnSize.length;x++)
            tblPlans.getColumnModel().getColumn(x).setPreferredWidth(columnSize[x]);
        tblPlans.setRowHeight(30);
        tblPlans.setModel(model);        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        txtID = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPlans = new javax.swing.JTable();
        btnSearchID = new javax.swing.JButton();
        btnClearFields = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(950, 570));
        setMinimumSize(new java.awt.Dimension(950, 570));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Price");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Code");

        txtCode.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodeKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Name");

        txtName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Description");

        txtPrice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane1.setViewportView(txtDescription);

        txtID.setText("id");

        tblPlans.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "PlanID", "Code", "Name", "Description", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPlans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPlansMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPlans);

        btnSearchID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/assets/search_30px_black.png"))); // NOI18N
        btnSearchID.setBorderPainted(false);
        btnSearchID.setContentAreaFilled(false);
        btnSearchID.setFocusPainted(false);
        btnSearchID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchIDActionPerformed(evt);
            }
        });

        btnClearFields.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/assets/waste_15px.png"))); // NOI18N
        btnClearFields.setBorderPainted(false);
        btnClearFields.setContentAreaFilled(false);
        btnClearFields.setFocusPainted(false);
        btnClearFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFieldsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnClearFields, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtPrice)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
                            .addComponent(txtName)
                            .addComponent(txtCode))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearchID, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCode, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(btnSearchID, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(btnClearFields))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(130, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblPlansMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPlansMouseClicked
        int row = tblPlans.getSelectedRow();
        String id_table = tblPlans.getValueAt(row, 1).toString();
        PlanVO plan = planController.read(id_table);
        
        if(plan.getId() > 0) {
            txtID.setText(String.valueOf(plan.getId()));
            txtCode.setText(plan.getCode());
            txtName.setText(plan.getName());
            txtDescription.setText(plan.getDescription());
            txtPrice.setText(Float.toString(plan.getPrice()));
        }
    }//GEN-LAST:event_tblPlansMouseClicked

    private void btnSearchIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchIDActionPerformed
        this.findPlanByID();
    }//GEN-LAST:event_btnSearchIDActionPerformed

    private void btnClearFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFieldsActionPerformed
        this.clearFields();
    }//GEN-LAST:event_btnClearFieldsActionPerformed

    private void txtCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodeKeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.findPlanByID();
        }
    }//GEN-LAST:event_txtCodeKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearFields;
    private javax.swing.JButton btnSearchID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblPlans;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables

}