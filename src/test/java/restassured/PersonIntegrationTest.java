package restassured;

import entity.Person;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotNull;

public class PersonIntegrationTest
{    
    public PersonIntegrationTest()
    {
    }
    
    @BeforeClass
    public static void setUpBeforeAll()
    {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8084;
        RestAssured.basePath = "/CA2_rest/api/person";
        RestAssured.defaultParser = Parser.JSON;
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void serverIsRunning()
    {
        given().
        when().get().
        then().statusCode(200);
    }
    
    @Test
    public void postGetDeletePerson()
    {
        Person p = new Person("Michelle","Kvistgaard");
        Person newPerson =
        given()
        .contentType("application/json")
        .body(p)
        .when().post()
        .as(Person.class);
        
        assertNotNull(newPerson.getId());
    
        given()
        .contentType(ContentType.JSON)
        .when().get(""+newPerson.getId()).then()
        .body("id",notNullValue())
        .body("firstName", equalTo("Michelle"));
    
        given()
        .contentType(ContentType.JSON)
        .when().delete(""+newPerson.getId()).then()
        .body("firstName", equalTo("Michelle"));
    }
}