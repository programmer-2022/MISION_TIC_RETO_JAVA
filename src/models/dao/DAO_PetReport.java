package models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import models.vo.CustomerVO;
import models.vo.MySQLConnection;
import models.vo.PetReportByPlanVO;
import models.vo.PetReportBySpecieVO;
import models.vo.PetVO;

public class DAO_PetReport {

    private static MySQLConnection xcon;
    
    //Obtener todas las mascotas por especie
    public LinkedList<PetReportBySpecieVO> getAllPetsBySpecie() {
        xcon = MySQLConnection.getInstance();
        LinkedList<PetReportBySpecieVO> petList = new LinkedList<>();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_getAllPetsBySpecie_Report}");
            ResultSet rs = ps.executeQuery();
              
            while(rs.next()) {
                PetReportBySpecieVO report = new PetReportBySpecieVO();
                report.setCount(rs.getInt("amount"));
                report.setSpecie(rs.getString("PetSpecie"));
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
            
    public LinkedList<PetReportByPlanVO> getAllPetsByPlan() {
        xcon = MySQLConnection.getInstance();
        LinkedList<PetReportByPlanVO> petList = new LinkedList<>();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_getAllPetsByPlan_Report}");
            ResultSet rs = ps.executeQuery();
              
            while(rs.next()) {
                PetReportByPlanVO report = new PetReportByPlanVO();
                report.setAmount(rs.getInt("amount"));
                report.setPlanName(rs.getString("PlaName"));
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
    
    //Clientes con sus mascotas     
    public LinkedList<PetVO> getAllPetsCustomers() {
        xcon = MySQLConnection.getInstance();
        LinkedList<PetVO> petList = new LinkedList<>();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_getPetsCustomers_ReportExcel}");
            ResultSet rs = ps.executeQuery();
              
            while(rs.next()) {
                PetVO pet = new PetVO();
                CustomerVO customer = new CustomerVO();
                customer.setId(rs.getInt("CustomerID"));
                customer.setName(rs.getString("CusName"));
                customer.setLastname(rs.getString("CusLastname"));
                customer.setAddress(rs.getString("CusAddress"));
                customer.setPhone(rs.getString("CusPhone"));
                customer.setEmail(rs.getString("CusEmail"));                
                pet.setCode(rs.getString("PetCode"));
                pet.setName(rs.getString("PetName"));
                pet.setAge(rs.getInt("PetAge"));
                pet.setWeight(rs.getFloat("PetWeight"));
                pet.setSpecie(rs.getString("PetSpecie"));
                pet.setCustomer(customer);
                petList.add(pet);
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