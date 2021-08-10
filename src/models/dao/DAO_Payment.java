package models.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import models.interfaces.ICrud;
import models.vo.MySQLConnection;
import models.vo.PaymentVO;

public class DAO_Payment implements ICrud<PaymentVO> {

    private static MySQLConnection xcon;

    public DAO_Payment() { }
    
    @Override
    public boolean create(PaymentVO payment) {
       xcon = MySQLConnection.getInstance();
        try {
            PreparedStatement ps = xcon.getConnection().prepareCall("{call sp_create_payment(?,?,?,?)}");
            //ps.setInt(1, payment.getId());
            ps.setInt(1, payment.getPet().getId());
            ps.setInt(2, payment.getPlan().getId());
            ps.setInt(3, payment.getSubscription());
            ps.setDate(4, payment.getDate());
                        
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
    public LinkedList<PaymentVO> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(PaymentVO payment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PaymentVO read(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }    
}
