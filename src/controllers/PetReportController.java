package controllers;

import java.util.LinkedList;
import models.dao.DAO_Report;
import models.vo.PetReportVO;

public class PetReportController {

    private DAO_Report dao = null;
            
    public PetReportController() {
        dao = new DAO_Report();
    }
            
    public LinkedList<PetReportVO> getPetSpecie() {
        return dao.getPetSpecie();
    }    
}