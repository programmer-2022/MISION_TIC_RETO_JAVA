package models.dao;

import models.vo.PlanVO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DAO_PlanTest {
    
    private DAO_Plan dao;
    
    public DAO_PlanTest() { }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("*************************************************");
        System.out.println("* Test Clientes inicializado");
        System.out.println("*************************************************");
        System.out.println();
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println();
        System.out.println("*************************************************");
        System.out.println("* Test Clientes finalizado");
        System.out.println("*************************************************");
    }
    
    @Before
    public void setUp() {
        dao = new DAO_Plan();
    }
    
    @After
    public void tearDown() {
        dao = null;
        System.out.println("-------------------------------------------");
    }

    @Test
    public void testCreate() {
        System.out.println("Test create() - el codigo del plan ya existe en la base de datos");
        PlanVO plan = new PlanVO();
        plan.setCode("PL01");
        plan.setName("Bienestar");
        plan.setDescription("El plan mas basico");
        plan.setPrice(1000f);
        assertFalse(dao.create(plan));
    }

    @Test
    public void testUpdate() {
        System.out.println("Test Update() - Actualizar el nombre, description y precio del plan con el id 18");
        PlanVO plan = new PlanVO();
        plan.setId(18);
        plan.setName("TEST PLAN");
        plan.setDescription("Descripcion de prueba del test");
        plan.setPrice(1000f);
        assertTrue(dao.update(plan));
    }

    @Test
    public void testDelete() {
        System.out.println("Test Delete() - Eliminar un ID inexistente en la base de datos");
        assertFalse(dao.delete("PL0001"));
    }

    @Test
    public void testRead() {
        System.out.println("Test Read() - Obtener un plan registrado en la base de datos");
        PlanVO plan = dao.read("PL01");
        assertTrue(plan != null);
    }
}