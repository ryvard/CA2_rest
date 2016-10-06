/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonmappers;

import entity.Company;

/**
 *
 * @author Jmach
 */
public class CompanyMappers
{
    private String name;
    private String description;
    private int cvr;
    private String numEmployees;
    private String marketValue;
    private String street;

    public CompanyMappers(Company c)
    {
       name = c.getName();
       description = c.getDescription();
       cvr = c.getCvr();
       numEmployees = c.getNumEmployees();
       marketValue = c.getMarketValue();
       street = c.getAddress().getStreet();
    }    
}
