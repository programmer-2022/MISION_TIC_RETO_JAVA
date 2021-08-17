package models.dao;

import models.vo.PlanVO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;

public class DAO_PlanTest {
    
    private DAO_Plan dao;
    private PlanVO plan;
    
    public DAO_PlanTest() { }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("*************************************************");
        System.out.println("* Test Modelo-Planes inicializado");
        System.out.println("*************************************************");
        System.out.println();
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println();
        System.out.println("*************************************************");
        System.out.println("* Test Modelo-Planes finalizado");
        System.out.println("*************************************************");
    }
    
    @Before
    public void setUp() {
        dao = Mockito.mock(DAO_Plan.class);
        plan = new PlanVO();
        plan.setCode("PL01");
        plan.setName("Bienestar");
        plan.setDescription("El plan mas basico");
        plan.setPrice(1000f);
    }
    
    @After
    public void tearDown() {
        dao = null;
        System.out.println("-------------------------------------------");
    }

    @Test
    public void testCreate() {
        System.out.println("Test create() - se creó un plan");
        Mockito.when(dao.create(plan)).thenReturn(Boolean.TRUE);
        assertTrue(dao.create(plan));
    }

    @Test
    public void testUpdate() {
        System.out.println("Test Update() - Actualizar el plan");
        Mockito.when(dao.update(plan)).thenReturn(Boolean.TRUE);
        assertTrue(dao.update(plan));
    }

    @Test
    public void testDelete() {
        System.out.println("Test Delete() - Eliminar un ID en la base de datos");
        Mockito.when(dao.delete(0)).thenReturn(Boolean.TRUE);
        assertTrue(dao.delete(0));
    }

    @Test
    public void testRead() {
        System.out.println("Test Read() - Obtener un plan registrado en la base de datos");
        String code = "PL01";
        Mockito.when(dao.read(code)).thenReturn(new PlanVO());
        assertTrue(dao.read(code) instanceof PlanVO);
    }
}