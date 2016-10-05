/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonmappers;

/**
 *
 * @author Jmach
 */
public class PersonMapper
{
    long id;
    String firstName;
    String street;
    String city;
    
   public PersonMapper(entity.Person p){
        id = p.getId();
        firstName = p.getFirstName();
        street = p.getAddress().getStreet();
    }
}
