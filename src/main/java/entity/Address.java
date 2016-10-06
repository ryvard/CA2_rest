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
public class Address
{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String additionalInfo;
    @ManyToOne
    private CityInfo cityInfo;
    
    @OneToMany(mappedBy = "address")
    private List<InfoEntity> InfoEntities;
    
    public Address() {
        
    }
    
    public Address(String street, String additionalInfo) {
        this.street = street;
        this.additionalInfo = additionalInfo;
    }
    
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }
    
    public String getStreet() {
        return street;
    }
    
    public void setStreet(String street) {
        this.street = street;
    }
    
    public String getAdditionalInfo() {
        return additionalInfo;
    }
    
    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    } 

    public CityInfo getCityInfo()
    {
        return cityInfo;
    }

    public void setCityInfo(CityInfo cityInfo)
    {
        this.cityInfo = cityInfo;
    }
    
    
}
