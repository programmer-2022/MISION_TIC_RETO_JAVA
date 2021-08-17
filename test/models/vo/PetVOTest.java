package models.vo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PetVOTest {
    
    private PetVO pet;
    
    public PetVOTest() { }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("*************************************************");
        System.out.println("* Test Mascotas inicializado");
        System.out.println("*************************************************");
        System.out.println();
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println();
        System.out.println("*************************************************");
        System.out.println("* Test Mascotas finalizado");
        System.out.println("*************************************************");
    }
    
    @Before
    public void setUp() {
        pet = new PetVO();
    }
    
    @After
    public void tearDown() {
        pet = null;
        System.out.println("-------------------------------------------");
    }

    @Test
    public void testGetId() {
        System.out.println("Test getId - Valores numericos");
        pet.setId(123);
        assertEquals(123, pet.getId());
    }

    @Test
    public void testSetId() {
        System.out.println("Prueba setId - mayor a cero");
        pet.setId(123);
        assertTrue(pet.getId() > 0);
    }

    @Test
    public void testGetCode() {
        System.out.println("Test getCode - Debe ser igual al codigo COD-01");
        pet.setCode("COD-01");
        assertEquals("COD-01", pet.getCode());
    }

    @Test
    public void testSetCode() {
        System.out.println("Test setCode - Debe contener el texto COD-");
        pet.setCode("COD-01");
        assertTrue(pet.getCode().contains("COD-"));
    }

    @Test
    public void testGetName() {
        System.out.println("Test getName - Debe ser igual al nombre Bruno");
        pet.setName("Bruno");
        assertEquals("Bruno", pet.getName());
    }

    @Test
    public void testSetName() {
        System.out.println("Test - setName comprobar que el nombre no este vacío");
        pet.setName("Bruno");
        assertFalse(pet.getName().isEmpty());
    }

    @Test
    public void testGetAge() {
        System.out.println("Test getAge - comprobar que la edad sea de tipo entero");
        pet.setAge(10);
        assertEquals(10, pet.getAge());
    }

    @Test
    public void testSetAge() {
        System.out.println("Test setAge - Comprobar que la edad sea mayor a cero");
        pet.setAge(1);
        assertTrue(pet.getAge() > 0);
    }

    @Test
    public void testGetWeight() {
        System.out.println("Test getWeight - Comprobar que el peso sea igual a 15.5");
        pet.setWeight(15.5f);
        assertEquals(15.5f, pet.getWeight(), 0.1);
    }

    @Test
    public void testSetWeight() {
        System.out.println("Test setWeight - comprobar que se ingrese un peso mayor a cero");
        pet.setWeight(1.0f);
        assertTrue(pet.getWeight() > 0);
    }

    @Test
    public void testGetSpecie() {
        System.out.println("Test getSpecie - Comprobar que la especie sea Canine");
        pet.setSpecie("Canine");
        assertEquals("Canine", pet.getSpecie());
    }

    @Test
    public void testSetSpecie() {
        System.out.println("Test setSpecie Validar que la especie sea Canine o Feline");
        pet.setSpecie("Feline");
        assertTrue(pet.getSpecie().equals("Canine") || pet.getSpecie().equals("Feline"));
    }

    @Test
    public void testGetCustomer() {
        System.out.println("Test getCustomer - Obtener al cliente con id: 123");
        CustomerVO customer = new CustomerVO();
        customer.setId(123);
        pet.setCustomer(customer);
        assertEquals(123, pet.getCustomer().getId());
    }

    @Test
    public void testSetCustomer() {
        System.out.println("Test setCustomer - Comprobar que el cliente no sea null");
        CustomerVO customer = new CustomerVO();
        pet.setCustomer(customer);
        assertTrue(pet.getCustomer() != null);
    } 
}