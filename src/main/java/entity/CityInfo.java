/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author miaryvard
 */
@Entity
public class CityInfo
{

//    @GeneratedValue (strategy = GenerationType.IDENTITY)
//    private Long id;
    @Id
    private int zip;
    private String city;
    
    
    @OneToMany(mappedBy = "cityInfo")
    private List<Address> addresses;
    

    public CityInfo()
    {
    }
    
    
    public CityInfo(int zipCode, String city)
    {
        this.zip = zipCode;
        this.city = city;
    }   
    
//    public Long getId()
//    {
//        return id;
//    }
//
//    public void setId(Long id)
//    {
//        this.id = id;
//    }

    public int getZipCode()
    {
        return zip;
    }

    public void setZipCode(int zipCode)
    {
        this.zip = zipCode;
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
