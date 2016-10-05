/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Person;
import java.util.HashMap;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PersonFacadeTest {
    EntityManagerFactory emf;
    PersonFacade facade;
        
    public PersonFacadeTest() {
        facade = new PersonFacade();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("Setup");
        HashMap<String, Object> puproperties = new HashMap();
        puproperties.put("javax.persistence.sql-load-script-source", "scripts/ClearDB.sql");
        Persistence.generateSchema("PU_CA2", puproperties);
        Persistence.generateSchema("PU_CA2", null);
        emf = Persistence.createEntityManagerFactory("PU_CA2");
        facade.setEmf(emf);
        System.out.println("DB: " + facade.getPersons().size());
    }
    
    @After
    public void tearDown() {
        System.out.println("TearDown");
        emf.close();
        HashMap<String, Object> puproperties = new HashMap();
        puproperties.put("javax.persistence.sql-load-script-source", "scripts/ClearDB.sql");
        Persistence.generateSchema("PU_CA2", puproperties);
        Persistence.generateSchema("PU_CA2", null);
    }

    /**
     * Test of getPerson method, of class PersonFacade.
     */
    @Test
    public void testGetPerson() {
        
        System.out.println("getPerson");
        int id = 1;
        Person expResult = new Person("Emma", "Blomsterberg");
        Person result = facade.getPerson(id);
        assertEquals(expResult.getFirstName(), result.getFirstName());
    }

    /**
     * Test of getPersons method, of class PersonFacade.
     */
//    @Test
//    public void testGetPersons_0args() {
//        System.out.println("getPersons");
//        List<Person> expResult = null;
//        List<Person> result = facade.getPersons();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPersons method, of class PersonFacade.
//     */
//    @Test
//    public void testGetPersonsByZipcode() {
//        System.out.println("getPersons");
//        int zipCode = 0;
//        List<Person> expResult = null;
//        List<Person> result = facade.getPersons(zipCode);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
