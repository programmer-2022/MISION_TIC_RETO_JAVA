package views.pets;

import controllers.CustomerController;
import controllers.PetController;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.vo.CustomerVO;
import models.vo.PetVO;
import utils.Constants;

public class PnlPets extends javax.swing.JPanel {

    private CustomerController customerController = null;
    private PetController petController = null;
    private LinkedList<PetVO> petList;
    private CustomerVO customer = null;
    private LinkedList<CustomerVO> list = null;
    
    private String petID;
    private String code;
    private String name;
    private String age;
    private String weight;
    private String specie;
    private String idCustomer;
            
    public PnlPets() {
        initComponents();
        customerController = new CustomerController();
        petController = new PetController();
        //txtPetID.setVisible(false);
        //txtIDCustomerQuery.setVisible(false);
        showHideOwner(false);
        fillCustomersComboBox();
        fillDataTable();
    }
    
    public void create_pet() {
        readFields();
        
        if(code.equals("") || name.equals("") || age.equals("") || weight.equals("")) {
            JOptionPane.showMessageDialog(this, Constants.MSG_REQUIRED, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(cbxSpecie.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Select a species", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(txtCustomerID.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please select an owner for the pet", "Message", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(petController.create(getPetCreate())) {
            JOptionPane.showMessageDialog(this, Constants.MSG_SAVE_SUCESS, "Message", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, Constants.MSG_SAVE_ERROR, "Error", JOptionPane.ERROR_MESSAGE);
        }        
        fillDataTable();
        resetVariables();
        showHideOwner(false);
    }
    
    public void update_pet() {
        readFields();
        
        if(code.equals("") || name.equals("") || age.equals("") || weight.equals("") || idCustomer.equals("")) {
            JOptionPane.showMessageDialog(this, Constants.MSG_REQUIRED, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(cbxSpecie.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Select a species", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(petController.update(getPetUpdate())) {
            JOptionPane.showMessageDialog(this, Constants.MSG_UPDATE_SUCESS, "Message", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, Constants.MSG_SAVE_ERROR, "Error", JOptionPane.ERROR_MESSAGE);
        }        
        fillDataTable();
        resetVariables();
    }
    
    public void findPetById() {
        code = txtCode.getText().trim();
        if(code.equals("")) {
            JOptionPane.showMessageDialog(this, Constants.MSG_REQUIRED, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PetVO pet = petController.read(code);
      
        if(pet.getId() > 0) {
            txtPetID.setText(String.valueOf(pet.getId()));
            txtPetName.setText(pet.getName());
            txtAge.setText(String.valueOf(pet.getAge()));
            txtWeight.setText(String.valueOf(pet.getWeight()));
            cbxSpecie.setSelectedItem(pet.getSpecie());
            txtIDCustomerQuery.setText(String.valueOf(pet.getCustomer().getId()));
            txtOwnerName.setText(pet.getCustomer().getName() + " " + pet.getCustomer().getLastname());        
        } else {
           JOptionPane.showMessageDialog(this, Constants.MSG_NO_EXIST_DATABASE, "Error", JOptionPane.ERROR_MESSAGE); 
        }
        resetVariables();
    }
    
    private void clearFields() {
        txtPetID.setText("");
        txtCode.setText("");
        txtPetName.setText("");
        txtAge.setText("");
        txtWeight.setText("");
        cbxSpecie.setSelectedIndex(0);
        txtCustomerID.setText("");
        txtOwnerName.setText("");
        txtIDCustomerQuery.setText("");
    }
    
    private void readFields() {
        petID = txtPetID.getText().trim();
        code = txtCode.getText().trim().toUpperCase();
        name = txtPetName.getText().trim().toUpperCase();
        age = txtAge.getText().trim();
        weight = txtWeight.getText().trim();
        specie = cbxSpecie.getSelectedItem().toString();
        idCustomer = txtIDCustomerQuery.getText().trim();
    }
    
    public void findCustomerById(String id) {
        customer = customerController.read(Integer.parseInt(id));
        if(customer.getId() > 0) {
            txtCustomerID.setText(String.valueOf(customer.getId()));
        }
    }
    
    public void delete_pet() {
        petID = txtPetID.getText().trim();
        
        if(petID.equals("")) {
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
            if(petController.delete(petID)) {
                JOptionPane.showMessageDialog(this, Constants.MSG_DELETE_SUCESS, "Message", JOptionPane.INFORMATION_MESSAGE);
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, Constants.MSG_DELETE_ERROR, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        fillDataTable();
        resetVariables();
    }
        
    private void resetVariables() {
        petID = "";
        code = "";
        name = "";
        age = "";
        weight = "";
        specie = "";
        customer = null;
        idCustomer = "";
    }
        
    private PetVO getPetCreate() {
        PetVO pet = new PetVO();
        pet.setCode(code);
        pet.setName(name);
        pet.setAge(Integer.parseInt(age));
        pet.setWeight(Float.parseFloat(weight));
        pet.setSpecie(specie);
        pet.setCustomer(customer);
        return pet;
    }
    
      private PetVO getPetUpdate() {
        PetVO pet = new PetVO();
        pet.setId(Integer.parseInt(petID));
        pet.setCode(code);
        pet.setName(name);
        pet.setAge(Integer.parseInt(age));
        pet.setWeight(Float.parseFloat(weight));
        pet.setSpecie(specie);
        pet.setCustomer(customer);
        return pet;
    }
    
    private void fillCustomersComboBox() {
        list = customerController.readAll();
        if(list.size() > 0){
            ArrayList<String> fullname = new ArrayList<>();
            list.forEach((c) -> {
                fullname.add(c.getName() + " " + c.getLastname() + "-" + String.valueOf(c.getId()));
            });
            DefaultComboBoxModel model = new DefaultComboBoxModel(fullname.toArray());
            cbxCustomerName.setModel(model);
        }
    }
    
    private void fillDataTable() {
        petList = petController.readAll();
        String datos[][] = new String[petList.size()][8];

        if(petList.size() > 0) {
            for (int i = 0; i < petList.size(); i++) {
                datos[i][Constants.ID_PET] = Integer.toString(petList.get(i).getId());
                datos[i][Constants.CODE_PET] = petList.get(i).getCode();
                datos[i][Constants.NAME_PET] = petList.get(i).getName();
                datos[i][Constants.AGE_PET] = Integer.toString(petList.get(i).getAge());
                datos[i][Constants.WEIGHT_PET] = Float.toString(petList.get(i).getWeight());
                datos[i][Constants.SPECIE_PET] = petList.get(i).getSpecie();
                datos[i][Constants.OWNER_ID_PET] = Integer.toString(petList.get(i).getCustomer().getId());
                datos[i][Constants.OWNER_FULLNAME_PET] = petList.get(i).getCustomer().getName() 
                        + " " + petList.get(i).getCustomer().getLastname();
            }        
        }
        String[] columns = {
            "PetID", "Code", "Name", "Age", "Weight", "Specie", "Owner ID", "Owner Name"
        };
        DefaultTableModel model = new DefaultTableModel(datos, columns);
        int[] columnSize = {10, 50, 50, 50, 50, 50, 50, 50};
        for(int x=0; x<columnSize.length;x++)
            tblPets.getColumnModel().getColumn(x).setPreferredWidth(columnSize[x]);
        tblPets.setRowHeight(30);
        tblPets.setModel(model);        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtCode = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPetName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbxSpecie = new javax.swing.JComboBox<>();
        btnSearchPetID = new javax.swing.JButton();
        btnClearPets = new javax.swing.JButton();
        txtPetID = new javax.swing.JTextField();
        txtWeight = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPets = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        txtOwnerName = new javax.swing.JTextField();
        lblOwnerList = new javax.swing.JLabel();
        cbxCustomerName = new javax.swing.JComboBox<>();
        lblOwnerID = new javax.swing.JLabel();
        txtCustomerID = new javax.swing.JTextField();
        btnAssignOwner = new javax.swing.JToggleButton();
        txtIDCustomerQuery = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(950, 570));
        setMinimumSize(new java.awt.Dimension(950, 570));
        setPreferredSize(new java.awt.Dimension(950, 570));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Pet Profile");

        txtCode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodeKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Pet Code");

        txtPetName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Name");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Age (years)");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Weight (kg)");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Specie");

        cbxSpecie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxSpecie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Select -", "Canine", "Feline" }));

        btnSearchPetID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/assets/search_30px_black.png"))); // NOI18N
        btnSearchPetID.setBorderPainted(false);
        btnSearchPetID.setContentAreaFilled(false);
        btnSearchPetID.setFocusPainted(false);
        btnSearchPetID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchPetIDActionPerformed(evt);
            }
        });

        btnClearPets.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/assets/waste_15px.png"))); // NOI18N
        btnClearPets.setBorderPainted(false);
        btnClearPets.setContentAreaFilled(false);
        btnClearPets.setFocusPainted(false);
        btnClearPets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearPetsActionPerformed(evt);
            }
        });

        txtWeight.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtAge.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tblPets.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "PetID", "Code", "Name", "Age", "Weight", "Specie", "OwnerID", "OwnerName"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Owner Name:");

        txtOwnerName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtOwnerName.setEnabled(false);

        lblOwnerList.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblOwnerList.setText("Owners List");

        cbxCustomerName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxCustomerName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Select -" }));
        cbxCustomerName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCustomerNameActionPerformed(evt);
            }
        });

        lblOwnerID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblOwnerID.setText("Owner ID:");

        txtCustomerID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCustomerID.setEnabled(false);

        btnAssignOwner.setBackground(new java.awt.Color(51, 51, 51));
        btnAssignOwner.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAssignOwner.setForeground(new java.awt.Color(204, 204, 204));
        btnAssignOwner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/assets/team_30px.png"))); // NOI18N
        btnAssignOwner.setText("Assign Owner");
        btnAssignOwner.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAssignOwner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAssignOwnerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtPetName, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(120, 120, 120)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11)
                                            .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(cbxSpecie, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(txtPetID, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnClearPets, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtCode, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSearchPetID, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel12)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxCustomerName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtCustomerID)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblOwnerList)
                                            .addComponent(lblOwnerID)
                                            .addComponent(btnAssignOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtIDCustomerQuery, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtPetID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCode)
                    .addComponent(btnAssignOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchPetID, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel9)
                    .addComponent(btnClearPets)
                    .addComponent(lblOwnerList))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPetName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(lblOwnerID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtWeight, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAge, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxSpecie, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtOwnerName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIDCustomerQuery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchPetIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchPetIDActionPerformed
        this.findPetById();
    }//GEN-LAST:event_btnSearchPetIDActionPerformed

    private void btnClearPetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearPetsActionPerformed
        txtPetID.setText("");
        txtCode.setText("");
        txtPetName.setText("");
        txtAge.setText("");
        txtWeight.setText("");
        cbxSpecie.setSelectedIndex(0);
        txtCustomerID.setText("");
        txtOwnerName.setText("");
    }//GEN-LAST:event_btnClearPetsActionPerformed

    private void txtCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodeKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.findPetById();
        }
    }//GEN-LAST:event_txtCodeKeyPressed

    private void cbxCustomerNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCustomerNameActionPerformed
        String[] valueCombo = cbxCustomerName.getSelectedItem().toString().split("-");
        findCustomerById(valueCombo[1]);
    }//GEN-LAST:event_cbxCustomerNameActionPerformed

    private void tblPetsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPetsMouseClicked
        int row = tblPets.getSelectedRow();
        String id = tblPets.getValueAt(row, 1).toString();
        PetVO pet = petController.read(id);
        
        if(pet.getId() > 0) {
            txtPetID.setText(String.valueOf(pet.getId()));
            txtCode.setText(pet.getCode());
            txtPetName.setText(pet.getName());
            txtAge.setText(String.valueOf(pet.getAge()));
            txtWeight.setText(Float.toString(pet.getWeight()));
            cbxSpecie.setSelectedItem(pet.getSpecie());
            customer = customerController.read(pet.getCustomer().getId());
            if(customer != null) {
                txtIDCustomerQuery.setText(String.valueOf(customer.getId()));
                txtOwnerName.setText(customer.getName() + " " + customer.getLastname());
            }
        }
    }//GEN-LAST:event_tblPetsMouseClicked

    private void btnAssignOwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAssignOwnerActionPerformed
        if(btnAssignOwner.isSelected())
            showHideOwner(true);
        else 
            showHideOwner(false);
    }//GEN-LAST:event_btnAssignOwnerActionPerformed

    private void showHideOwner(boolean state) {
        lblOwnerList.setVisible(state);
        cbxCustomerName.setVisible(state);
        lblOwnerID.setVisible(state);
        txtCustomerID.setVisible(state);
    }    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAssignOwner;
    private javax.swing.JButton btnClearPets;
    private javax.swing.JButton btnSearchPetID;
    private javax.swing.JComboBox<String> cbxCustomerName;
    private javax.swing.JComboBox<String> cbxSpecie;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblOwnerID;
    private javax.swing.JLabel lblOwnerList;
    private javax.swing.JTable tblPets;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtCode;
    private javax.swing.JTextField txtCustomerID;
    private javax.swing.JTextField txtIDCustomerQuery;
    private javax.swing.JTextField txtOwnerName;
    private javax.swing.JTextField txtPetID;
    private javax.swing.JTextField txtPetName;
    private javax.swing.JTextField txtWeight;
    // End of variables declaration//GEN-END:variables
}