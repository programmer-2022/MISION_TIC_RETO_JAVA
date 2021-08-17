package models.dao;

import java.sql.Date;
import models.vo.PaymentVO;
import models.vo.PetVO;
import models.vo.PlanVO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;


public class DAO_PaymentTest {
    
    private DAO_Payment daoPayment;
    
    public DAO_PaymentTest() { }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("*************************************************");
        System.out.println("* Test Modelo-Pagos inicializado");
        System.out.println("*************************************************");
        System.out.println();
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println();
        System.out.println("*************************************************");
        System.out.println("* Test Modelo-Pagos finalizado");
        System.out.println("*************************************************");
    }
    
    @Before
    public void setUp() {
        daoPayment = Mockito.mock(DAO_Payment.class);
    }
    
    @After
    public void tearDown() {
        daoPayment = null;
        System.out.println("-------------------------------------------");
    }
    
    @Test
    public void createPayment() {
        System.out.println("Test - Creando el pago de una mascota con toda su información");
        PaymentVO payment = new PaymentVO();
        PetVO pet = new PetVO();
        PlanVO plan = new PlanVO();
        
        pet.setCode("COD-100");
        pet.setName("Bruno");
        pet.setAge(5);
        pet.setWeight(15.5f);
        pet.setSpecie("Canine");        
        
        plan.setCode("PL100");
        plan.setName("BIENESTAR");
        plan.setDescription("NONE");
        plan.setPrice(15000f);        
                
        payment.setPet(pet);
        payment.setPlan(plan);
        payment.setSubscription(5);
        payment.setDate(Date.valueOf("2021-08-17"));
        
        Mockito.when(daoPayment.create(payment)).thenReturn(Boolean.TRUE);
        assertTrue(daoPayment.create(payment));
    }
}