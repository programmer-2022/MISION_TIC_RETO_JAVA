package controllers;

import java.util.LinkedList;
import models.dao.DAO_Pet;
import models.interfaces.ICrud;
import models.vo.PetVO;

public class PetController implements ICrud<PetVO>{

    private final DAO_Pet dao;
    
    public PetController() {
        dao = new DAO_Pet();
    }
    
    @Override
    public boolean create(PetVO pet) {
        return dao.create(pet);
    }

    @Override
    public LinkedList<PetVO> readAll() {
        return dao.readAll();
    }

    @Override
    public boolean update(PetVO pet) {
        return dao.update(pet);
    }

    @Override
    public boolean delete(Object id) {
        return dao.delete(id);
    }

    @Override
    public PetVO read(Object code) {
        return dao.read(code);
    }
    
    public LinkedList<PetVO> readPetsByCustomerID(int customerID) {
        return dao.readPetsByCustomerID(customerID);
    }
}