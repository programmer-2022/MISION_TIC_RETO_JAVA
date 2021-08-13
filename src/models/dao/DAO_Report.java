package models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import models.vo.MySQLConnection;
import models.vo.PetReportVO;


public class DAO_Report {

    private static MySQLConnection xcon;
    
    public LinkedList<PetReportVO> getPetSpecie() {
        xcon = MySQLConnection.getInstance();
        LinkedList<PetReportVO> petList = new LinkedList<>();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_getAllPetsBySpecie}");
            ResultSet rs = ps.executeQuery();
              
            while(rs.next()) {
                PetReportVO report = new PetReportVO();
                report.setCount(rs.getInt(1));
                report.setSpecie(rs.getString(2));
                petList.add(report);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Query error" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            xcon.close_connection();
        }
        return petList;
    }    
}