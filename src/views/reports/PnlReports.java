package views.reports;

import controllers.PetReportController;
import java.awt.BorderLayout;
import java.util.LinkedList;
import models.vo.PetReportVO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class PnlReports extends javax.swing.JPanel {

    private PetReportController controller = null;
    
    public PnlReports() {
        initComponents();
        controller = new PetReportController();
    }
    
    private void draw(LinkedList<PetReportVO> datalist) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        datalist.forEach((e)->{
            dataset.setValue(e.getSpecie().concat(" :" + String.valueOf(e.getCount())), e.getCount());
        });
                
        JFreeChart chart = ChartFactory.createPieChart(
            "Pets by species",
            dataset,
            true,
            true,
            true                
        );
        
        ChartPanel panel = new ChartPanel(chart);
        panel.setMouseWheelEnabled(true);
        
        pnlCanvas.setLayout(new BorderLayout());
        pnlCanvas.add(panel);
        pnlCanvas.validate();
    }    
    
    public void getAllPetsBySpecie() {
        LinkedList<PetReportVO> reportList = controller.getPetSpecie();
        if(reportList.size() > 0) draw(reportList);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCanvas = new javax.swing.JPanel();
        btnGenerateChart = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        pnlCanvas.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout pnlCanvasLayout = new javax.swing.GroupLayout(pnlCanvas);
        pnlCanvas.setLayout(pnlCanvasLayout);
        pnlCanvasLayout.setHorizontalGroup(
            pnlCanvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlCanvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnGenerateChart, javax.swing.GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlCanvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGenerateChart, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerateChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateChartActionPerformed
        getAllPetsBySpecie();
    }//GEN-LAST:event_btnGenerateChartActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerateChart;
    private javax.swing.JPanel pnlCanvas;
    // End of variables declaration//GEN-END:variables
}
