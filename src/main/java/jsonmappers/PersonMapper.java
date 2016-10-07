/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonmappers;

import entity.Hobby;
import java.util.List;

/**
 *
 * @author Jmach
 */
public class PersonMapper
{
    private long id;
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private int zipCode;
    
   public PersonMapper(entity.Person p){
        id = p.getId();
        firstName = p.getFirstName();
        lastName = p.getLastName();
        street = p.getAddress().getStreet();
        city = p.getAddress().getCityInfo().getCity();
        zipCode = p.getAddress().getCityInfo().getZipCode();
    }
}
