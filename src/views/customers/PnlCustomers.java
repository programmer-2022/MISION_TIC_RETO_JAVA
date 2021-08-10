package views.customers;

import controllers.CustomerController;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.vo.CustomerVO;
import utils.Constants;

public class PnlCustomers extends javax.swing.JPanel {

    private CustomerController controller = null;
    private LinkedList<CustomerVO> list;
    
    private String customerID;
    private String name;
    private String lastname;
    private String address;
    private String phone;
    private String email;
         
    public PnlCustomers() {
        initComponents();
        controller = new CustomerController();
        resetVariables();
        fillDataTable();
    }
    
    public void create_customer() {
        readFields();    

        if(customerID.equals("") || lastname.equals("") || address.equals("") || phone.equals("") || email.equals("")) {
            JOptionPane.showMessageDialog(this, "Fields must not be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(!isNumeric(customerID)) {
            JOptionPane.showMessageDialog(this, "CustomerID, Enter only numbers", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(controller.create(getCustomer())) {
            JOptionPane.showMessageDialog(this, "The record was saved successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Error when registering a client", "Error", JOptionPane.ERROR_MESSAGE);
        }
        fillDataTable();
        resetVariables();
    }
    
    public void update_customer() {
        readFields();

        if(customerID.equals("") || lastname.equals("") || address.equals("") || phone.equals("") || email.equals("")) {
            JOptionPane.showMessageDialog(this, "Fields must not be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(!isNumeric(customerID)) {
            JOptionPane.showMessageDialog(this, "CustomerID, Enter only numbers", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(controller.update(getCustomer())) {
            JOptionPane.showMessageDialog(this, "The record was updated successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Error trying to update a client", "Error", JOptionPane.ERROR_MESSAGE);
        }
        fillDataTable();
        resetVariables();
    }
    
    public void delete_customer() {
        customerID = txtCustomerID.getText().trim();
        
        if(customerID.equals("")) {
            JOptionPane.showMessageDialog(this, "Fields must not be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(!isNumeric(customerID)) {
            JOptionPane.showMessageDialog(this, "CustomerID, Enter only numbers", "Error", JOptionPane.ERROR_MESSAGE);
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
            if(controller.delete(Integer.parseInt(customerID))) {
                JOptionPane.showMessageDialog(this, "The record was deleted successfully", "Message", JOptionPane.INFORMATION_MESSAGE);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "An error occurred while trying to delete a record", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        resetVariables();
        fillDataTable();
    }
    
    private boolean isNumeric(String str) {
        return str.matches("[0-9]+");
    }
        
    private void readFields() {
        customerID = txtCustomerID.getText().trim();
        name = txtName.getText().trim().toUpperCase();
        lastname = txtLastname.getText().trim().toUpperCase();
        address = txtAddress.getText().trim().toUpperCase();
        phone = txtPhone.getText().trim();
        email = txtEmail.getText().trim().toLowerCase();        
    }
    
    private CustomerVO getCustomer() {
        CustomerVO customer = new CustomerVO();
        customer.setId(Integer.parseInt(customerID));
        customer.setName(name);
        customer.setLastname(lastname);
        customer.setAddress(address);
        customer.setPhone(phone);
        customer.setEmail(email);
        return customer;
    }   
    
    private void clearFields() {
        txtCustomerID.setText("");
        txtName.setText("");
        txtLastname.setText("");
        txtAddress.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
    }
    
    private void resetVariables() {
        customerID = "";
        name = "";
        lastname = "";
        address = "";
        phone = "";
        email = "";
    }
    
    private void fillDataTable() {
        list = controller.readAll();
        String datos[][] = new String[list.size()][6];
        
        if(list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                datos[i][Constants.ID_CUSTOMER] = Integer.toString(list.get(i).getId());
                datos[i][Constants.NAME_CUSTOMER] = list.get(i).getName();
                datos[i][Constants.LASTNAME_CUSTOMER] = list.get(i).getLastname();
                datos[i][Constants.ADDRESS_CUSTOMER] = list.get(i).getAddress();
                datos[i][Constants.PHONE_CUSTOMER] = list.get(i).getPhone();
                datos[i][Constants.EMAIL_CUSTOMER] = list.get(i).getEmail();
            }        
        }        
        String[] columns = {
            "ID", "Name", "Lastname", "Address", "Phone", "Email"
        };
        DefaultTableModel model = new DefaultTableModel(datos, columns);
        int[] columnSize = {10, 50, 50, 50, 50, 50};
        for(int x=0; x<columnSize.length;x++)
            tblCustomers.getColumnModel().getColumn(x).setPreferredWidth(columnSize[x]);
        tblCustomers.setRowHeight(30);
        tblCustomers.setModel(model);
    }
    
    public void findById() {
        customerID = txtCustomerID.getText().trim();

        if(customerID.equals("")) {
            JOptionPane.showMessageDialog(this, "Fields must not be empty", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(!isNumeric(customerID)) {
            JOptionPane.showMessageDialog(this, "CustomerID, Enter only numbers", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        CustomerVO customer = controller.read(Integer.parseInt(customerID));
        
        if(customer.getId() > 0) {
            txtName.setText(customer.getName());
            txtLastname.setText(customer.getLastname());
            txtAddress.setText(customer.getAddress());
            txtPhone.setText(customer.getPhone());
            txtEmail.setText(customer.getEmail());
        } else {
           JOptionPane.showMessageDialog(this, "The client has not been registered", "Error", JOptionPane.ERROR_MESSAGE); 
        }
        
        resetVariables();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCustomerID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        txtLastname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnSearchID = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnClearCustomer = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCustomers = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Name");

        txtCustomerID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCustomerID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCustomerIDKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Lastname");

        txtName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtLastname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Address");

        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Phone");

        txtPhone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Email");

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnSearchID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/assets/search_30px_black.png"))); // NOI18N
        btnSearchID.setBorderPainted(false);
        btnSearchID.setContentAreaFilled(false);
        btnSearchID.setFocusPainted(false);
        btnSearchID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchIDActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Customer ID");

        btnClearCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/assets/waste_15px.png"))); // NOI18N
        btnClearCustomer.setBorderPainted(false);
        btnClearCustomer.setContentAreaFilled(false);
        btnClearCustomer.setFocusPainted(false);
        btnClearCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearCustomerActionPerformed(evt);
            }
        });

        tblCustomers.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblCustomers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Lastname", "Address", "Phone", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustomersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCustomers);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnClearCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addComponent(txtPhone, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(txtAddress)
                            .addComponent(txtLastname)
                            .addComponent(txtName)
                            .addComponent(txtCustomerID)
                            .addComponent(txtEmail)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addComponent(btnSearchID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearchID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addComponent(btnClearCustomer))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtLastname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchIDActionPerformed
        this.findById();
    }//GEN-LAST:event_btnSearchIDActionPerformed

    private void btnClearCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearCustomerActionPerformed
        this.clearFields();        
    }//GEN-LAST:event_btnClearCustomerActionPerformed

    private void txtCustomerIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerIDKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.findById();
        }
    }//GEN-LAST:event_txtCustomerIDKeyPressed

    private void tblCustomersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomersMouseClicked
        int row = tblCustomers.getSelectedRow();
        String id = tblCustomers.getValueAt(row, 0).toString();
        
        CustomerVO customer = controller.read(Integer.parseInt(id));
        
        if(customer.getId() > 0) {
            txtCustomerID.setText(String.valueOf(customer.getId()));
            txtName.setText(customer.getName());
            txtLastname.setText(customer.getLastname());
            txtAddress.setText(customer.getAddress());
            txtPhone.setText(customer.getPhone());
            txtEmail.setText(customer.getEmail());
        }
    }//GEN-LAST:event_tblCustomersMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearCustomer;
    private javax.swing.JButton btnSearchID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCustomers;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCustomerID;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtLastname;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
