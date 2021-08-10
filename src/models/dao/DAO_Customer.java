package models.dao;

import models.interfaces.ICrud;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import models.vo.CustomerVO;
import models.vo.MySQLConnection;

public class DAO_Customer implements ICrud<CustomerVO> {

    private static MySQLConnection xcon;

    public DAO_Customer() { }
    
    @Override
    public boolean create(CustomerVO customer) {
        xcon = MySQLConnection.getInstance();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_create_customer(?,?,?,?,?,?)}");
            ps.setInt(1, customer.getId());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getLastname());
            ps.setString(4, customer.getAddress());
            ps.setString(5, customer.getPhone());
            ps.setString(6, customer.getEmail());
            
            if(ps.executeUpdate() > 0) return true;
                        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when trying to register a customer in the database\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            xcon.close_connection();
        }
        return false;
    }

    @Override
    public LinkedList<CustomerVO> readAll() {
        xcon = MySQLConnection.getInstance();
        LinkedList<CustomerVO> customer_list = new LinkedList<>();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_get_all_customers}");
            ResultSet rs = ps.executeQuery();
              
            while(rs.next()) {
                CustomerVO customer = new CustomerVO();
                customer.setId(rs.getInt(1));
                customer.setName(rs.getString(2));
                customer.setLastname(rs.getString(3));
                customer.setAddress(rs.getString(4));
                customer.setPhone(rs.getString(5));
                customer.setEmail(rs.getString(6));
                customer_list.add(customer);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Query error" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            xcon.close_connection();
        }
        return customer_list;
    }

    @Override
    public boolean update(CustomerVO customer) {
        xcon = MySQLConnection.getInstance();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_edit_customer(?,?,?,?,?,?)}");
            ps.setInt(1, customer.getId());
            ps.setString(2, customer.getName());
            ps.setString(3, customer.getLastname());
            ps.setString(4, customer.getAddress());
            ps.setString(5, customer.getPhone());
            ps.setString(6, customer.getEmail());
            if(ps.executeUpdate() > 0); return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when trying to register a customer in the database\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_delete_customer(?)}");
            ps.setInt(1, (Integer)id);
            if(ps.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when trying to delete a customer in the database\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            xcon.close_connection();
        }
        return false;
    }

    @Override
    public CustomerVO read(Object id) {
        xcon = MySQLConnection.getInstance();
        CustomerVO customer = new CustomerVO();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_get_customer(?)}");
            ps.setInt(1, (Integer)id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                customer.setId(rs.getInt(1));
                customer.setName(rs.getString(2));
                customer.setLastname(rs.getString(3));
                customer.setAddress(rs.getString(4));
                customer.setPhone(rs.getString(5));
                customer.setEmail(rs.getString(6));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Query error" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            xcon.close_connection();
        }
        return customer;
    }
}
