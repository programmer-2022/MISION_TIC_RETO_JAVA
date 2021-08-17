package models.vo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class CustomerVOTest {
    
    private CustomerVO customer;    
    
    public CustomerVOTest() {
    }
    
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
        customer = new CustomerVO();
    }
    
    @After
    public void tearDown() {
        customer = null;
        System.out.println("-------------------------------------------");
    }

    @Test
    public void testGetId() {
        System.out.println("Test getId - Valores numericos");
        customer.setId(123);
        assertEquals(123, customer.getId());
    }

    @Test
    public void testSetId() {
        System.out.println("Prueba setId - la identificacion debe ser mayor que cero");
        customer.setId(123);
        assertTrue(customer.getId() > 0);
    }

    @Test
    public void testGetName() {
        System.out.println("Test getName - Debe ser igual al nombre Cesar");
        customer.setName("Cesar");
        assertEquals("Cesar", customer.getName());
    }

    @Test
    public void testSetName() {
        System.out.println("Test - setName comprobar que el nombre no este vacío");
        customer.setName("Cesar");
        assertFalse(customer.getName().isEmpty());
    }

    @Test
    public void testGetLastname() {
        System.out.println("Test getLastName- Debe ser igual al nombre Cesar");
        customer.setName("Martinez");
        assertEquals("Martinez", customer.getName());
    }

    @Test
    public void testSetLastname() {
        System.out.println("Test - setLastName comprobar que el nombre no este vacío");
        customer.setName("Cesar");
        assertFalse(customer.getName().isEmpty());
    }

    @Test
    public void testGetAddress() {
        System.out.println("Test getAddress - la dirección debe ser CENTRO-15");
        customer.setAddress("CENTRO-15");
        assertEquals("CENTRO-15", customer.getAddress());
    }

    @Test
    public void testSetAddress() {
        System.out.println("Test getAddress - la dirección no debe estar vacía");
        customer.setAddress("CENTRO");
        assertFalse(customer.getAddress().isEmpty());
    }

    @Test
    public void testGetPhone() {
        System.out.println("Test getPhone - El teléfono debe ser 7207070");
        customer.setPhone("7207070");
        assertEquals("7207070", customer.getPhone());
    }

    @Test
    public void testSetPhone() {
        System.out.println("Test setPhone - el teléfono debe tener menos de 10 caracteres");
        customer.setPhone("7001144");
        assertTrue(customer.getPhone().length() < 10);
    }

    @Test
    public void testGetEmail() {
        System.out.println("Test getEmail - el email debe ser prueba@gmail.com");
        customer.setEmail("prueba@gmail.com");
        assertEquals("prueba@gmail.com", customer.getEmail());
    }

    @Test
    public void testSetEmail() {
        System.out.println("Test setEmail - El email debe contener el caracter @");
        customer.setEmail("prueba@gmail.com");
        assertTrue(customer.getEmail().contains("@"));
    }    
}