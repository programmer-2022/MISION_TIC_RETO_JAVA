package models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.interfaces.ICrud;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import models.vo.CustomerVO;
import models.vo.MySQLConnection;
import models.vo.PetVO;

public class DAO_Pet implements ICrud<PetVO> {

    private static MySQLConnection xcon;

    public DAO_Pet() { }
    
    @Override
    public boolean create(PetVO pet) {
       xcon = MySQLConnection.getInstance();
       try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_create_pet(?,?,?,?,?,?)}");
            ps.setString(1, pet.getCode());
            ps.setString(2, pet.getName());
            ps.setInt(3, pet.getAge());
            ps.setFloat(4, pet.getWeight());
            ps.setString(5, pet.getSpecie());
            ps.setInt(6, pet.getCustomer().getId());

            if(ps.executeUpdate() > 0) return true;
                        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when trying to register a pet in the database\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            xcon.close_connection();
        }
        return false;
    }

    @Override
    public LinkedList<PetVO> readAll() {
        xcon = MySQLConnection.getInstance();
        LinkedList<PetVO> pet_list = new LinkedList<>();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_get_all_pets_customer}");
            ResultSet rs = ps.executeQuery();
              
            while(rs.next()) {
                PetVO pet = new PetVO();
                CustomerVO customer = new CustomerVO();
                pet.setId(rs.getInt(1));
                pet.setCode(rs.getString(2));
                pet.setName(rs.getString(3));
                pet.setAge(rs.getInt(4));
                pet.setWeight(rs.getFloat(5));
                pet.setSpecie(rs.getString(6));
                customer.setId(rs.getInt(7));
                customer.setName(rs.getString(8));
                customer.setLastname(rs.getString(9));
                pet.setCustomer(customer);
                pet_list.add(pet);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Query error" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            xcon.close_connection();
        }
        return pet_list;
    }

    @Override
    public boolean update(PetVO pet) {
        xcon = MySQLConnection.getInstance();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_edit_pet(?,?,?,?,?,?,?)}");
            ps.setInt(1, pet.getId());
            ps.setString(2, pet.getCode());
            ps.setString(3, pet.getName());
            ps.setInt(4, pet.getAge());
            ps.setFloat(5, pet.getWeight());
            ps.setString(6, pet.getSpecie());
            ps.setInt(7, pet.getCustomer().getId());

            if(ps.executeUpdate() > 0) return true;
                        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when trying to update a pet in the database\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_delete_pet(?)}");
            ps.setInt(1, Integer.valueOf((String) id));
            if(ps.executeUpdate() > 0) return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error when trying to delete a pet in the database\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            xcon.close_connection();
        }
        return false;
    }

    @Override
    public PetVO read(Object code) {
        xcon = MySQLConnection.getInstance();
        PetVO pet = new PetVO();
        CustomerVO customer = new CustomerVO();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_get_pet(?)}");
            ps.setString(1, (String)code);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                pet.setId(rs.getInt(1));
                pet.setCode(rs.getString(2));
                pet.setName(rs.getString(3));
                pet.setAge(rs.getInt(4));
                pet.setWeight(rs.getFloat(5));
                pet.setSpecie(rs.getString(6));
                customer.setId(rs.getInt(7));
                customer.setName(rs.getString(8));
                customer.setLastname(rs.getString(9));
                pet.setCustomer(customer);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Query error" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            xcon.close_connection();
        }
        return pet;
    }  
    
    public LinkedList<PetVO> readPetsByCustomerID(int customerID) {
        xcon = MySQLConnection.getInstance();
        LinkedList<PetVO> pet_list = new LinkedList<>();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_get_pet_customerID(?)}");
            ps.setInt(1, customerID);
            ResultSet rs = ps.executeQuery();
              
            while(rs.next()) {
                PetVO pet = new PetVO();
                pet.setId(rs.getInt(1));
                pet.setCode(rs.getString(2));
                pet.setName(rs.getString(3));
                pet.setAge(rs.getInt(4));
                pet.setWeight(rs.getFloat(5));
                pet.setSpecie(rs.getString(6));
                pet_list.add(pet);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Query error" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            xcon.close_connection();
        }
        return pet_list;
    }    
}
