package controllers;

import java.util.LinkedList;
import models.dao.DAO_PetReport;
import models.vo.PetReportByPlanVO;
import models.vo.PetReportBySpecieVO;
import models.vo.PetVO;

public class PetReportController {

    private DAO_PetReport dao = null;
            
    public PetReportController() {
        dao = new DAO_PetReport();
    }
            
    public LinkedList<PetReportBySpecieVO> getAllPetsBySpecie() {
        return dao.getAllPetsBySpecie();
    }    
    
    public LinkedList<PetReportByPlanVO> getAllPetsByPlan() {
        return dao.getAllPetsByPlan();
    }    
    
    public LinkedList<PetVO> getAllPetsCustomers() {
        return dao.getAllPetsCustomers();
    }    
}