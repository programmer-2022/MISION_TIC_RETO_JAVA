package views.reports;

import controllers.PetReportController;
import java.awt.BorderLayout;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import models.vo.PetReportByPlanVO;
import models.vo.PetReportBySpecieVO;
import models.vo.PetVO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class PnlReports extends javax.swing.JPanel {

    private PetReportController controller = null;
    private DefaultPieDataset dataset;
    
    private LinkedList<PetReportBySpecieVO> petSpecieList;
    private LinkedList<PetReportByPlanVO> petPlanList;
        
    public PnlReports() {
        initComponents();
        controller = new PetReportController();
    }
    
    private void getAllPetsBySpecie() {
        petSpecieList = controller.getAllPetsBySpecie();
        if(petSpecieList.size() > 0) {
            drawPetsBySpecie();
        }
    }
    
    private void getAllPetsByPlan() {
        petPlanList = controller.getAllPetsByPlan();
        if(petPlanList.size() > 0) {
            drawPetByPlan();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCanvas = new javax.swing.JPanel();
        btnGenerateChart = new javax.swing.JButton();
        btnExportExcel = new javax.swing.JButton();
        cbxSelectChart = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));

        pnlCanvas.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout pnlCanvasLayout = new javax.swing.GroupLayout(pnlCanvas);
        pnlCanvas.setLayout(pnlCanvasLayout);
        pnlCanvasLayout.setHorizontalGroup(
            pnlCanvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 950, Short.MAX_VALUE)
        );
        pnlCanvasLayout.setVerticalGroup(
            pnlCanvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 509, Short.MAX_VALUE)
        );

        btnGenerateChart.setBackground(new java.awt.Color(51, 51, 51));
        btnGenerateChart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGenerateChart.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerateChart.setText("Generate chart");
        btnGenerateChart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerateChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateChartActionPerformed(evt);
            }
        });

        btnExportExcel.setBackground(new java.awt.Color(51, 51, 51));
        btnExportExcel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExportExcel.setForeground(new java.awt.Color(255, 255, 255));
        btnExportExcel.setText("Export Excel");
        btnExportExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportExcelActionPerformed(evt);
            }
        });

        cbxSelectChart.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Select -", "Pets by species", "Pets affiliated with a plan" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCanvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(cbxSelectChart, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGenerateChart, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnExportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlCanvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxSelectChart)
                    .addComponent(btnGenerateChart, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExportExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerateChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateChartActionPerformed
        getOptionsComboBox();
    }//GEN-LAST:event_btnGenerateChartActionPerformed

    private void drawPetsBySpecie() {
        dataset = new DefaultPieDataset();
        petSpecieList.forEach((e)->{
            dataset.setValue(e.getSpecie().concat(" :" + String.valueOf(e.getCount())), e.getCount());
        });
        draw("Pets by Specie");
    }
    
    private void drawPetByPlan() {
        dataset = new DefaultPieDataset();
        petPlanList.forEach((e)->{
            dataset.setValue(e.getPlanName().concat(" :" + String.valueOf(e.getAmount())), e.getAmount());
        });
        draw("Pets affiliated with a plan");
    }
    
    private void draw(String title) {
        JFreeChart chart = ChartFactory.createPieChart(title, dataset, true, true, true);
        ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        pnlCanvas.removeAll();
        pnlCanvas.setLayout(new BorderLayout());
        pnlCanvas.add(panel);
        pnlCanvas.validate();
    }
    
    private void getOptionsComboBox() {
        int value = cbxSelectChart.getSelectedIndex();
        switch(value) {
            case 1: getAllPetsBySpecie(); break;
            case 2: getAllPetsByPlan();   break;
            default:
                JOptionPane.showMessageDialog(null, "Select an option to generate a chart", "Error", JOptionPane.ERROR_MESSAGE);
                break;
        }
    }
    
    private void exportExcel() {
        
    }
    
    private void getAllPetsCustomers() {
        LinkedList<PetVO> list = controller.getAllPetsCustomers();
        if(list.size() > 0) {
            exportExcel();
        }
    }
        
    private void btnExportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportExcelActionPerformed
        getAllPetsCustomers();
    }//GEN-LAST:event_btnExportExcelActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportExcel;
    private javax.swing.JButton btnGenerateChart;
    private javax.swing.JComboBox<String> cbxSelectChart;
    private javax.swing.JPanel pnlCanvas;
    // End of variables declaration//GEN-END:variables
}
