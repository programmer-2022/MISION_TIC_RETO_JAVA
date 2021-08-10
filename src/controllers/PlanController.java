package controllers;

import java.util.LinkedList;
import models.dao.DAO_Plan;
import models.interfaces.ICrud;
import models.vo.PlanVO;

public class PlanController implements ICrud<PlanVO>{

    private final DAO_Plan dao;

    public PlanController() {
        dao = new DAO_Plan();
    }
    
    @Override
    public boolean create(PlanVO plan) {
        return dao.create(plan);
    }

    @Override
    public LinkedList<PlanVO> readAll() {
        return dao.readAll();
    }

    @Override
    public boolean update(PlanVO plan) {
        return dao.update(plan);
    }

    @Override
    public boolean delete(Object id) {
        return dao.delete(id);
    }

    @Override
    public PlanVO read(Object id) {
        return dao.read(id);
    }
}