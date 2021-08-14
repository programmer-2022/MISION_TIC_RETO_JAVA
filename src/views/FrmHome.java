package views;

import views.reports.PnlReports;
import views.settings.PnlSettings;
import views.payments.PnlPayments;
import views.plans.PnlPlans;
import views.pets.PnlPets;
import views.customers.PnlCustomers;
import controllers.CustomerController;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import utils.Constants;

public final class FrmHome extends JFrame {

    private String panelActive;

    private final Color INITIAL_COLOR_MENU = new Color(28, 31, 52);
    private final Color CHANGE_COLOR_MENU = new Color(40, 45, 77);
        
    private JScrollPane spContainer;
    private final PnlHome pnlHome;
    private PnlCustomers pnlCustomers;
    private PnlPets pnlPets;
    private PnlPlans pnlPlans;
    private PnlPayments pnlPayments;
    private PnlReports pnlReports;
    private PnlSettings pnlSettings;
    
    //Controllers
    private CustomerController customerController;    
                
    public FrmHome() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.init_container();
        this.getContentPane().add(spContainer);        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        pnlHome = new PnlHome();
        this.loadPanel(pnlHome);
        setMyPanelActive("FrmHome");   
    }
    
    private void init_container() {
        spContainer = new JScrollPane();
        spContainer.setBounds(248, 96, 956, 576);
        spContainer.setBackground(new Color(255, 0,255));
        spContainer.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        spContainer.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }
    
    private void loadPanel(JPanel panel) {
        spContainer.setViewportView(panel);
        spContainer.validate();
    }
    
    private void changeColorMenu(JPanel panel) {
        panel.setBackground(CHANGE_COLOR_MENU);
    }
    
    private void resetColorMenu(JPanel panel) {
        panel.setBackground(INITIAL_COLOR_MENU);
    }
    
    private void closeApp() {
        int dialogResult = JOptionPane.showConfirmDialog (
                null, 
                "¿Are you sure to exit the application?",
                "Warning",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        
        if(dialogResult == JOptionPane.YES_OPTION){
            System.exit(0);
        }
    }
    
    public String getMyPanelActive() {
        return panelActive;
    }

    public void setMyPanelActive(String panelActive) {
        this.panelActive = panelActive;
    }
    
    private void changeIconSubtitleBar(String subtitle, String urlImage) {
        lblSubtitle.setText(subtitle);
        lblIcon.setIcon(new ImageIcon(getClass().getResource("/views/assets/" + urlImage)));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFirstTopBar = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        pnlSideBar = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        pnlPaymentsMenu = new javax.swing.JPanel();
        btnPayments = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        pnlCustomersMenu = new javax.swing.JPanel();
        btnCustomers = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        pnlPlansMenu = new javax.swing.JPanel();
        btnPlans = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        pnlPetsMenu = new javax.swing.JPanel();
        btnPets = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        pnlReportsMenu = new javax.swing.JPanel();
        btnReports = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        pnlExitMenu = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        pnlSettingsMenu = new javax.swing.JPanel();
        btnSettings = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pnlTopBar = new javax.swing.JPanel();
        lblIcon = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        lblSubtitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlFirstTopBar.setBackground(new java.awt.Color(28, 31, 52));
        pnlFirstTopBar.setMaximumSize(new java.awt.Dimension(1200, 720));
        pnlFirstTopBar.setMinimumSize(new java.awt.Dimension(1200, 720));
        pnlFirstTopBar.setPreferredSize(new java.awt.Dimension(1200, 720));
        pnlFirstTopBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 204, 204));
        jLabel24.setText("Pet Center v0.1");
        pnlFirstTopBar.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        getContentPane().add(pnlFirstTopBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));

        pnlSideBar.setBackground(new java.awt.Color(28, 31, 52));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 204, 204));
        jLabel14.setText("PET CENTER");

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 204, 204));
        jLabel22.setText("NIT: 800333444-8");

        jLabel23.setForeground(new java.awt.Color(204, 204, 204));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/assets/veterinarian_30px.png"))); // NOI18N

        pnlPaymentsMenu.setBackground(new java.awt.Color(28, 31, 52));
        pnlPaymentsMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPayments.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPayments.setForeground(new java.awt.Color(204, 204, 204));
        btnPayments.setText("Payments");
        btnPayments.setBorderPainted(false);
        btnPayments.setContentAreaFilled(false);
        btnPayments.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPayments.setFocusPainted(false);
        btnPayments.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPayments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPaymentsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPaymentsMouseExited(evt);
            }
        });
        btnPayments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaymentsActionPerformed(evt);
            }
        });
        pnlPaymentsMenu.add(btnPayments, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 0, 200, 50));

        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/assets/pay_30px.png"))); // NOI18N
        pnlPaymentsMenu.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        pnlCustomersMenu.setBackground(new java.awt.Color(28, 31, 52));
        pnlCustomersMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCustomers.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCustomers.setForeground(new java.awt.Color(204, 204, 204));
        btnCustomers.setText("Customers");
        btnCustomers.setBorderPainted(false);
        btnCustomers.setContentAreaFilled(false);
        btnCustomers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCustomers.setFocusPainted(false);
        btnCustomers.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCustomers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCustomersMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCustomersMouseExited(evt);
            }
        });
        btnCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomersActionPerformed(evt);
            }
        });
        pnlCustomersMenu.add(btnCustomers, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 0, 200, 50));

        jLabel21.setForeground(new java.awt.Color(204, 204, 204));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/assets/team_30px.png"))); // NOI18N
        pnlCustomersMenu.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        pnlPlansMenu.setBackground(new java.awt.Color(28, 31, 52));
        pnlPlansMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPlans.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPlans.setForeground(new java.awt.Color(204, 204, 204));
        btnPlans.setText("Plans");
        btnPlans.setBorderPainted(false);
        btnPlans.setContentAreaFilled(false);
        btnPlans.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPlans.setFocusPainted(false);
        btnPlans.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPlans.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPlansMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPlansMouseExited(evt);
            }
        });
        btnPlans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlansActionPerformed(evt);
            }
        });
        pnlPlansMenu.add(btnPlans, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 0, 200, 50));

        jLabel25.setForeground(new java.awt.Color(204, 204, 204));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/assets/file_30px.png"))); // NOI18N
        pnlPlansMenu.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        pnlPetsMenu.setBackground(new java.awt.Color(28, 31, 52));
        pnlPetsMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnPets.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnPets.setForeground(new java.awt.Color(204, 204, 204));
        btnPets.setText("Pets");
        btnPets.setBorderPainted(false);
        btnPets.setContentAreaFilled(false);
        btnPets.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPets.setFocusPainted(false);
        btnPets.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnPets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnPetsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPetsMouseExited(evt);
            }
        });
        btnPets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPetsActionPerformed(evt);
            }
        });
        pnlPetsMenu.add(btnPets, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 0, 200, 50));

        jLabel26.setForeground(new java.awt.Color(204, 204, 204));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/assets/pets_30px.png"))); // NOI18N
        pnlPetsMenu.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        pnlReportsMenu.setBackground(new java.awt.Color(28, 31, 52));
        pnlReportsMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnReports.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnReports.setForeground(new java.awt.Color(204, 204, 204));
        btnReports.setText("Reports");
        btnReports.setBorderPainted(false);
        btnReports.setContentAreaFilled(false);
        btnReports.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReports.setFocusPainted(false);
        btnReports.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReportsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReportsMouseExited(evt);
            }
        });
        btnReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportsActionPerformed(evt);
            }
        });
        pnlReportsMenu.add(btnReports, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 0, 200, 50));

        jLabel27.setForeground(new java.awt.Color(204, 204, 204));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/assets/audit_30px.png"))); // NOI18N
        pnlReportsMenu.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        pnlExitMenu.setBackground(new java.awt.Color(28, 31, 52));
        pnlExitMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnExit.setForeground(new java.awt.Color(204, 204, 204));
        btnExit.setText("Exit");
        btnExit.setBorderPainted(false);
        btnExit.setContentAreaFilled(false);
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.setFocusPainted(false);
        btnExit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
        });
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        pnlExitMenu.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 0, 200, 50));

        jLabel28.setForeground(new java.awt.Color(204, 204, 204));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/assets/exit_30px.png"))); // NOI18N
        pnlExitMenu.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        pnlSettingsMenu.setBackground(new java.awt.Color(28, 31, 52));
        pnlSettingsMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSettings.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnSettings.setForeground(new java.awt.Color(204, 204, 204));
        btnSettings.setText("Settings");
        btnSettings.setBorderPainted(false);
        btnSettings.setContentAreaFilled(false);
        btnSettings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSettings.setFocusPainted(false);
        btnSettings.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnSettings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSettingsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSettingsMouseExited(evt);
            }
        });
        btnSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSettingsActionPerformed(evt);
            }
        });
        pnlSettingsMenu.add(btnSettings, new org.netbeans.lib.awtextra.AbsoluteConstraints(48, 0, 200, 50));

        jLabel29.setForeground(new java.awt.Color(204, 204, 204));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/assets/wrench_30px.png"))); // NOI18N
        pnlSettingsMenu.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        javax.swing.GroupLayout pnlSideBarLayout = new javax.swing.GroupLayout(pnlSideBar);
        pnlSideBar.setLayout(pnlSideBarLayout);
        pnlSideBarLayout.setHorizontalGroup(
            pnlSideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSideBarLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(pnlSideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(39, 39, 39))
            .addGroup(pnlSideBarLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlSideBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1)
                .addContainerGap())
            .addComponent(pnlCustomersMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlPetsMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlPlansMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlPaymentsMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlReportsMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlSettingsMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlExitMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlSideBarLayout.setVerticalGroup(
            pnlSideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSideBarLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(pnlSideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSideBarLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22))
                    .addComponent(jLabel23))
                .addGap(13, 13, 13)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(pnlCustomersMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPetsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPlansMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPaymentsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlReportsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(pnlSettingsMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlExitMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        getContentPane().add(pnlSideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 250, 620));

        pnlTopBar.setBackground(new java.awt.Color(28, 31, 52));
        pnlTopBar.setMaximumSize(new java.awt.Dimension(1200, 720));
        pnlTopBar.setMinimumSize(new java.awt.Dimension(1200, 720));
        pnlTopBar.setPreferredSize(new java.awt.Dimension(1200, 720));
        pnlTopBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlTopBarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlTopBarMouseExited(evt);
            }
        });
        pnlTopBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/assets/home_30px.png"))); // NOI18N
        pnlTopBar.add(lblIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, -1, -1));

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(204, 204, 204));
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/assets/delete_bin_30px.png"))); // NOI18N
        btnDelete.setText("Del");
        btnDelete.setToolTipText("");
        btnDelete.setContentAreaFilled(false);
        btnDelete.setFocusPainted(false);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        pnlTopBar.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 100, 35));

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(204, 204, 204));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/assets/add_30px.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setContentAreaFilled(false);
        btnAdd.setFocusPainted(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        pnlTopBar.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 100, 35));

        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(204, 204, 204));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/views/assets/edit_30px.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.setContentAreaFilled(false);
        btnEdit.setFocusPainted(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        pnlTopBar.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 100, 35));

        lblSubtitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSubtitle.setForeground(new java.awt.Color(204, 204, 204));
        lblSubtitle.setText("HOME");
        pnlTopBar.add(lblSubtitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 15, -1, -1));

        getContentPane().add(pnlTopBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 950, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPaymentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaymentsActionPerformed
        pnlPayments = new PnlPayments();
        this.loadPanel(pnlPayments);
        setMyPanelActive(Constants.PANEL_PAYMENTS);
        changeIconSubtitleBar(Constants.TITLE_PAYMENTS, Constants.ICON_PAYMENTS);
    }//GEN-LAST:event_btnPaymentsActionPerformed

    private void btnCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomersActionPerformed
        pnlCustomers = new PnlCustomers();
        this.loadPanel(pnlCustomers);
        setMyPanelActive(Constants.PANEL_CUSTOMERS);
        changeIconSubtitleBar(Constants.TITLE_CUSTOMERS, Constants.ICON_CUSTOMERS);
    }//GEN-LAST:event_btnCustomersActionPerformed

    private void btnPlansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlansActionPerformed
        pnlPlans = new PnlPlans();
        this.loadPanel(pnlPlans);
        setMyPanelActive(Constants.PANEL_PLANS);
        changeIconSubtitleBar(Constants.TITLE_PLANS, Constants.ICON_PLANS);
    }//GEN-LAST:event_btnPlansActionPerformed

    private void btnPetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPetsActionPerformed
        pnlPets = new PnlPets();
        this.loadPanel(pnlPets);
        setMyPanelActive(Constants.PANEL_PETS);
        changeIconSubtitleBar(Constants.TITLE_PETS, Constants.ICON_PETS);
    }//GEN-LAST:event_btnPetsActionPerformed

    private void btnReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportsActionPerformed
        pnlReports = new PnlReports();
        this.loadPanel(pnlReports);
        setMyPanelActive(Constants.PANEL_REPORTS);
        changeIconSubtitleBar(Constants.TITLE_REPORTS, Constants.ICON_REPORTS);
    }//GEN-LAST:event_btnReportsActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        setMyPanelActive("FrmHome");
        this.closeApp();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSettingsActionPerformed
        pnlSettings = new PnlSettings();
        this.loadPanel(pnlSettings);
        setMyPanelActive(Constants.PANEL_SETTINGS);
        changeIconSubtitleBar(Constants.TITLE_SETTINGS, Constants.ICON_SETTINGS);
    }//GEN-LAST:event_btnSettingsActionPerformed

    private void btnCustomersMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustomersMouseEntered
        changeColorMenu(pnlCustomersMenu);
    }//GEN-LAST:event_btnCustomersMouseEntered

    private void btnCustomersMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustomersMouseExited
        resetColorMenu(pnlCustomersMenu);
    }//GEN-LAST:event_btnCustomersMouseExited

    private void btnPetsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPetsMouseEntered
        changeColorMenu(pnlPetsMenu);
    }//GEN-LAST:event_btnPetsMouseEntered

    private void btnPetsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPetsMouseExited
        resetColorMenu(pnlPetsMenu);
    }//GEN-LAST:event_btnPetsMouseExited

    private void btnPlansMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlansMouseEntered
        changeColorMenu(pnlPlansMenu);
    }//GEN-LAST:event_btnPlansMouseEntered

    private void btnPlansMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlansMouseExited
        resetColorMenu(pnlPlansMenu);
    }//GEN-LAST:event_btnPlansMouseExited

    private void btnPaymentsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPaymentsMouseEntered
        changeColorMenu(pnlPaymentsMenu);
    }//GEN-LAST:event_btnPaymentsMouseEntered

    private void btnPaymentsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPaymentsMouseExited
        resetColorMenu(pnlPaymentsMenu);
    }//GEN-LAST:event_btnPaymentsMouseExited

    private void btnReportsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportsMouseEntered
        changeColorMenu(pnlReportsMenu);
    }//GEN-LAST:event_btnReportsMouseEntered

    private void btnReportsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportsMouseExited
        resetColorMenu(pnlReportsMenu);
    }//GEN-LAST:event_btnReportsMouseExited

    private void btnSettingsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSettingsMouseEntered
        changeColorMenu(pnlSettingsMenu);
    }//GEN-LAST:event_btnSettingsMouseEntered

    private void btnSettingsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSettingsMouseExited
        resetColorMenu(pnlSettingsMenu);
    }//GEN-LAST:event_btnSettingsMouseExited

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        changeColorMenu(pnlExitMenu);
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        resetColorMenu(pnlExitMenu);
    }//GEN-LAST:event_btnExitMouseExited

    private void pnlTopBarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTopBarMouseEntered
        changeColorMenu(pnlTopBar);
    }//GEN-LAST:event_pnlTopBarMouseEntered

    private void pnlTopBarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlTopBarMouseExited
        resetColorMenu(pnlTopBar);
    }//GEN-LAST:event_pnlTopBarMouseExited

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.closeApp();
    }//GEN-LAST:event_formWindowClosing

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        switch(getMyPanelActive()) {
            case Constants.PANEL_CUSTOMERS:
                pnlCustomers.create_customer();
                break;
            case Constants.PANEL_PETS:
                pnlPets.create_pet();
                break;
            case Constants.PANEL_PLANS:
                pnlPlans.create_plan();
                break;
            case Constants.PANEL_PAYMENTS:
                pnlPayments.create_payment();
                break;
            case Constants.PANEL_REPORTS:
                System.out.println("PANEL REPORTS");
                break;
            case Constants.PANEL_SETTINGS:
                System.out.println("PANEL SETTINGS");
                break;
            default:
                System.out.println("NO ACTION");
                break;
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        switch(getMyPanelActive()) {
            case Constants.PANEL_CUSTOMERS:
                pnlCustomers.delete_customer();
                break;
            case Constants.PANEL_PETS:
                pnlPets.delete_pet();
                break;
            case Constants.PANEL_PLANS:
                pnlPlans.delete_plan();
                break;
            case Constants.PANEL_PAYMENTS:
                pnlPayments.delete_payment();
                break;
            case Constants.PANEL_REPORTS:
                System.out.println("PANEL REPORTS");
                break;
            case Constants.PANEL_SETTINGS:
                System.out.println("PANEL SETTINGS");
                break;
            default:
                System.out.println("NO ACTION");
                break;
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        switch(getMyPanelActive()) {
            case Constants.PANEL_CUSTOMERS:
                pnlCustomers.update_customer();
                break;
            case Constants.PANEL_PETS:
                pnlPets.update_pet();
                break;
            case Constants.PANEL_PLANS:
                pnlPlans.update_plan();
                break;
            case Constants.PANEL_PAYMENTS:
                pnlPayments.update_payment();
                break;
            case Constants.PANEL_REPORTS:
                System.out.println("PANEL REPORTS");
                break;
            case Constants.PANEL_SETTINGS:
                System.out.println("PANEL SETTINGS");
                break;
            default:
                System.out.println("NO ACTION");
                break;
        }
    }//GEN-LAST:event_btnEditActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(() -> {
            new FrmHome().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCustomers;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnPayments;
    private javax.swing.JButton btnPets;
    private javax.swing.JButton btnPlans;
    private javax.swing.JButton btnReports;
    private javax.swing.JButton btnSettings;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblSubtitle;
    public static javax.swing.JPanel pnlCustomersMenu;
    private javax.swing.JPanel pnlExitMenu;
    private javax.swing.JPanel pnlFirstTopBar;
    private javax.swing.JPanel pnlPaymentsMenu;
    private javax.swing.JPanel pnlPetsMenu;
    private javax.swing.JPanel pnlPlansMenu;
    private javax.swing.JPanel pnlReportsMenu;
    private javax.swing.JPanel pnlSettingsMenu;
    private javax.swing.JPanel pnlSideBar;
    private javax.swing.JPanel pnlTopBar;
    // End of variables declaration//GEN-END:variables
}
