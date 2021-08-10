package controllers;

import java.util.LinkedList;
import models.dao.DAO_Payment;
import models.interfaces.ICrud;
import models.vo.PaymentVO;

public class PaymentController implements ICrud<PaymentVO> {

    private final DAO_Payment dao;
    
    public PaymentController() { 
        dao = new DAO_Payment();
    }
    
    @Override
    public boolean create(PaymentVO payment) {
        return dao.create(payment);
    }

    @Override
    public LinkedList<PaymentVO> readAll() {
        return dao.readAll();
    }

    @Override
    public boolean update(PaymentVO payment) {
        return dao.update(payment);
    }

    @Override
    public boolean delete(Object id) {
        return dao.delete(id);
    }

    @Override
    public PaymentVO read(Object id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}