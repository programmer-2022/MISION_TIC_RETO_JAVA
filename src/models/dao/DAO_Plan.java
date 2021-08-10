package models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import models.interfaces.ICrud;
import models.vo.MySQLConnection;
import models.vo.PlanVO;

public class DAO_Plan implements ICrud<PlanVO>{

    private static MySQLConnection xcon;

    public DAO_Plan() { }
    
    @Override
    public boolean create(PlanVO plan) {
        xcon = MySQLConnection.getInstance();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_create_plan(?,?,?,?)}");
            ps.setString(1, plan.getCode());
            ps.setString(2, plan.getName());
            ps.setString(3, plan.getDescription());
            ps.setFloat(4, plan.getPrice());

            if(ps.executeUpdate() > 0) return true;
                        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when trying to register a plan in the database\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            xcon.close_connection();
        }
        return false;
    }

    @Override
    public LinkedList<PlanVO> readAll() {
        xcon = MySQLConnection.getInstance();
        LinkedList<PlanVO> planList = new LinkedList<>();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_get_all_plans}");
            ResultSet rs = ps.executeQuery();
              
            while(rs.next()) {
                PlanVO plan = new PlanVO();
                plan.setId(rs.getInt(1));
                plan.setCode(rs.getString(2));
                plan.setName(rs.getString(3));
                plan.setDescription(rs.getString(4));
                plan.setPrice(rs.getFloat(5));
                planList.add(plan);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Query error" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            xcon.close_connection();
        }
        return planList;
    }

    @Override
    public boolean update(PlanVO plan) {
         xcon = MySQLConnection.getInstance();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_edit_plan(?,?,?,?,?)}");
            ps.setInt(1, plan.getId());
            ps.setString(2, plan.getCode());
            ps.setString(3, plan.getName());
            ps.setString(4, plan.getDescription());
            ps.setFloat(5, plan.getPrice());

            if(ps.executeUpdate() > 0) return true;
                        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when trying to update a plan in the database\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            xcon.close_connection();
        }
        return false;
    }

    @Override
    public boolean delete(Object id) {
        xcon = MySQLConnection.getInstance();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_delete_plan(?)}");
            ps.setInt(1, Integer.valueOf((String) id));
            if(ps.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when trying to delete a plan in the database\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            xcon.close_connection();
        }
        return false;
    }

    @Override
    public PlanVO read(Object code) {
        xcon = MySQLConnection.getInstance();
        PlanVO plan = new PlanVO();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_get_plan(?)}");
            ps.setString(1, (String)code);
            ResultSet rs = ps.executeQuery();
              
            while(rs.next()) {
                plan.setId(rs.getInt(1));
                plan.setCode(rs.getString(2));
                plan.setName(rs.getString(3));
                plan.setDescription(rs.getString(4));
                plan.setPrice(rs.getFloat(5));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Query error" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            xcon.close_connection();
        }
        return plan;
    }
}