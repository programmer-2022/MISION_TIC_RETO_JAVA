package controllers;

import java.util.LinkedList;
import models.vo.CustomerVO;
import models.dao.DAO_Customer;
import models.interfaces.ICrud;

public class CustomerController implements ICrud<CustomerVO>  {

    private final DAO_Customer dao;
    
    public CustomerController() {
        dao = new DAO_Customer();
    }   

    @Override
    public boolean create(CustomerVO customer) {
        return dao.create(customer);
    }

    @Override
    public LinkedList<CustomerVO> readAll() {
        return dao.readAll();
    }

    @Override
    public boolean update(CustomerVO customer) {
        return dao.update(customer);
    }

    @Override
    public boolean delete(Object id) {
        return dao.delete(id);
    }

    @Override
    public CustomerVO read(Object id) {
        return dao.read(id);
    }
}