package models.vo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlanVOTest {
    
    private PlanVO plan;
    
    public PlanVOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("*************************************************");
        System.out.println("* Test Planes inicializado");
        System.out.println("*************************************************");
        System.out.println();
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println();
        System.out.println("*************************************************");
        System.out.println("* Test Planes finalizado");
        System.out.println("*************************************************");
    }
    
    @Before
    public void setUp() {
        plan = new PlanVO();
    }
    
    @After
    public void tearDown() {
        plan = null;
        System.out.println("-------------------------------------------");
    }

    @Test
    public void testGetId() {
        System.out.println("Test getId - Valores numericos");
        plan.setId(1);
        assertEquals(1, plan.getId());
    }

    @Test
    public void testSetId() {
        System.out.println("Prueba setId - mayor a cero");
        plan.setId(1);
        assertTrue(plan.getId() > 0);
    }

    @Test
    public void testGetCode() {
        System.out.println("Test getCode - Debe ser igual al codigo PL10");
        plan.setCode("PL10");
        assertEquals("PL10", plan.getCode());
    }

    @Test
    public void testSetCode() {
        System.out.println("Test setCode - Debe contener el texto PL");
        plan.setCode("PL10");
        assertTrue(plan.getCode().contains("PL"));
    }

    @Test
    public void testGetName() {
        System.out.println("Test getName - Debe ser igual al nombre Diamond");
        plan.setName("Diamond");
        assertEquals("Diamond", plan.getName());
    }

    @Test
    public void testSetName() {
        System.out.println("Test - setName comprobar que el nombre no este vacío");
        plan.setName("Bienestar");
        assertFalse(plan.getName().isEmpty());
    }

    @Test
    public void testGetDescription() {
        System.out.println("Test - getDescription comprobar que la descripciónno este vacía");
        plan.setDescription("Este plan incluye beneficios del 50%");
        assertFalse(plan.getDescription().isEmpty());
    }

    @Test
    public void testSetDescription() {
        System.out.println("Test setDescription - comprobar que los caracteres sean menor a 255");
        plan.setDescription("Este plan incluye beneficios del 50%");
        assertTrue(plan.getDescription().length() < 255);
    }

    @Test
    public void testGetPrice() {
        System.out.println("Test - getPrice comprobar que el precio sea mayor que cero");
        plan.setPrice(1000f);
        assertTrue(plan.getPrice() > 0);
    }

    @Test
    public void testSetPrice() {
        System.out.println("Test - setPrice comprobar que el precio no esté vacío");
        plan.setPrice(1000f);
        assertFalse(Float.toString(plan.getPrice()).isEmpty());
    }    
}