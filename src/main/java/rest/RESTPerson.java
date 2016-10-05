/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import entity.Person;
import facade.PersonFacade;
import java.util.List;
import com.google.gson.*;
import javax.persistence.Persistence;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author emmablomsterberg
 */
@Path("person")
public class RESTPerson {

    @Context
    private UriInfo context;
    
    @Context
    private HttpHeaders headers;

    PersonFacade pf;

    /**
     * Creates a new instance of RESTPerson
     */
    public RESTPerson() {
        pf = new PersonFacade( Persistence.createEntityManagerFactory("PU_CA2") );
    }
    
    

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("complete")
    public String getAllPerson() {

        List<Person> persons = pf.getPersons();
        String jsonString = " ";

        for (int i = 0; i < persons.size(); i++) {
            Person p = persons.get(i);

//            JsonObject jo = new JsonObject();
//
//            jo.addProperty("id", persons.get(i).getId());
//            jo.addProperty("firstName", persons.get(i).getFirstName());
//            jo.addProperty("lastName", persons.get(i).getLastName());
//
//            jsonString += new Gson().toJson(jo);
              jsonString += new Gson().toJson(p);

        }

        return jsonString;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("complete/{id}")
    public String getPerson(@PathParam("id") int id) {

        Person p = pf.getPerson(id);
//        JsonObject jo = new JsonObject();
//        jo.addProperty("id", p.getId());
//        jo.addProperty("fistName", p.getFirstName());
//        jo.addProperty("lastName", p.getLastName());
//
//        String jsonStr = new Gson().toJson(jo);
        String jsonStr = new Gson().toJson(p);
        return jsonStr;

    }
    
//    @POST
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    public String postPerson(String content) {
//       // Person p = 
//    }

    /**
     * Retrieves representation of an instance of entity.RESTPerson
     *
     * @return an instance of java.lang.String
     */
//    @GET
//    @Produces(MediaType.APPLICATION_XML)
//    public String getXml() {
//        //TODO return proper representation object
//        throw new UnsupportedOperationException();
//    }
//
//    /**
//     * PUT method for updating or creating an instance of RESTPerson
//     *
//     * @param content representation for the resource
//     */
//    @PUT
//    @Consumes(MediaType.APPLICATION_XML)
//    public void putXml(String content) {
//    }
}
