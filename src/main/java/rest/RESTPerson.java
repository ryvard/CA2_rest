/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import RestException.NotFoundEx;
import entity.Person;
import facade.PersonFacade;
import java.util.List;
import com.google.gson.*;
import java.util.ArrayList;
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
import jsonmappers.ContactMapper;
import jsonmappers.PersonMapper;

/**
 * REST Web Service
 *
 * @author emmablomsterberg
 */
@Path("person")
public class RESTPerson
{

    static Gson gson = new Gson();
    @Context
    private UriInfo context;

    @Context
    private HttpHeaders headers;

    PersonFacade pf;

    /**
     * Creates a new instance of RESTPerson
     */
    public RESTPerson()
    {
        pf = new PersonFacade(Persistence.createEntityManagerFactory("PU_CA2"));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("complete")
    public String getAllPerson()
    {

        List<Person> persons = pf.getPersons();
        List<PersonMapper> pMappers = new ArrayList<PersonMapper>();
        for (Person p : persons)
        {
            pMappers.add(new PersonMapper(p));
        }
        return new Gson().toJson(pMappers);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("complete/{id}")
    public String getPerson(@PathParam("id") long id) throws NotFoundEx
    {

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>FØR P NULLPOINTER");
        Person p = pf.getPerson(id);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Efter ");
        if (p == null)
        {
            System.out.println("-----------inde i if--------------");
            throw new NotFoundEx("Person with id:" + id + " doesn't exist");
        }
        System.out.println("Json :" + new Gson().toJson(new PersonMapper(p)));

        return new Gson().toJson(new PersonMapper(p));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("contactinfo")
    public String getContactInfos()
    {
        List<Person> pcontacts = pf.getContactInfos();
        List<ContactMapper> pcMappers = new ArrayList<ContactMapper>();
        for (Person p : pcontacts)
        {            
            pcMappers.add(new ContactMapper(p));            
        }
        return new Gson().toJson(pcMappers);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String postPerson(String content)
    {
        
        Person p = pf.addPerson(new Gson().fromJson(content, Person.class));
        return new Gson().toJson(p);
    }
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
