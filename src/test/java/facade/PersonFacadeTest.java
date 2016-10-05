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
//        Persistence.generateSchema("PU_CA2", null);
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
//        Persistence.generateSchema("PU_CA2", null);
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
    @Test
    public void testGetPersons() {
        System.out.println("getPersons");
        List<Person> expResult = null;
        List<Person> result = facade.getPersons();
        assertEquals(expResult, result);
       
    }

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

    /**
     * Test of setEmf method, of class PersonFacade.
     */
    @Test
    public void testSetEmf() {
        System.out.println("setEmf");
        EntityManagerFactory emf = null;
        PersonFacade instance = new PersonFacade();
        instance.setEmf(emf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPerson method, of class PersonFacade.
     */
    @Test
    public void testAddPerson() {
        System.out.println("addPerson");
        Person p = null;
        PersonFacade instance = new PersonFacade();
        Person expResult = null;
        Person result = instance.addPerson(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editPerson method, of class PersonFacade.
     */
    @Test
    public void testEditPerson() {
        System.out.println("editPerson");
        Person person = null;
        PersonFacade instance = new PersonFacade();
        Person expResult = null;
        Person result = instance.editPerson(person);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePerson method, of class PersonFacade.
     */
    @Test
    public void testDeletePerson() {
        System.out.println("deletePerson");
        long id = 0L;
        PersonFacade instance = new PersonFacade();
        Person expResult = null;
        Person result = instance.deletePerson(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPerson method, of class PersonFacade.
     */
    @Test
    public void testGetPerson_long() {
        System.out.println("getPerson");
        long id = 0L;
        PersonFacade instance = new PersonFacade();
        Person expResult = null;
        Person result = instance.getPerson(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPerson method, of class PersonFacade.
     */
    @Test
    public void testGetPerson_String() {
        System.out.println("getPerson");
        String number = "";
        PersonFacade instance = new PersonFacade();
        Person expResult = null;
        Person result = instance.getPerson(number);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of countPeople method, of class PersonFacade.
     */
    @Test
    public void testCountPeople() {
        System.out.println("countPeople");
        String hobby = "";
        PersonFacade instance = new PersonFacade();
        int expResult = 0;
        int result = instance.countPeople(hobby);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersons method, of class PersonFacade.
     */
    @Test
    public void testGetPersons_0args() {
        System.out.println("getPersons");
        PersonFacade instance = new PersonFacade();
        List<Person> expResult = null;
        List<Person> result = instance.getPersons();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersons method, of class PersonFacade.
     */
    @Test
    public void testGetPersons_int() {
        System.out.println("getPersons");
        int zip = 0;
        PersonFacade instance = new PersonFacade();
        List<Person> expResult = null;
        List<Person> result = instance.getPersons(zip);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPersons method, of class PersonFacade.
     */
    @Test
    public void testGetPersons_String() {
        System.out.println("getPersons");
        String hobby = "";
        PersonFacade instance = new PersonFacade();
        List<Person> expResult = null;
        List<Person> result = instance.getPersons(hobby);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
