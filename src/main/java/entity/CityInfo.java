/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author miaryvard
 */
@Entity
public class CityInfo
{

    @Id
    private Long id;
    
    private int zipCode;
    private String city;

    public CityInfo()
    {
    }
    
    
    public CityInfo(int zipCode, String city)
    {
        this.zipCode = zipCode;
        this.city = city;
    }   
    
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public int getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(int zipCode)
    {
        this.zipCode = zipCode;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }    
}
