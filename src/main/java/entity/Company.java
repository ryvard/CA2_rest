package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author miaryvard
 */
@Entity
public class Company
{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String description;
    private String cvr;
    private String numEmployees;
    private String marketValue;

    public Company()
    {
    }

    public Company(String name, String description, String cvr, String numEmployees, String marketValue)
    {
        this.name = name;
        this.description = description;
        this.cvr = cvr;
        this.numEmployees = numEmployees;
        this.marketValue = marketValue;
    }
            

    
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getCvr()
    {
        return cvr;
    }

    public void setCvr(String cvr)
    {
        this.cvr = cvr;
    }

    public String getNumEmployees()
    {
        return numEmployees;
    }

    public void setNumEmployees(String numEmployees)
    {
        this.numEmployees = numEmployees;
    }

    public String getMarketValue()
    {
        return marketValue;
    }

    public void setMarketValue(String marketValue)
    {
        this.marketValue = marketValue;
    }

    @Override
    public String toString()
    {
        return "Company{" + "id=" + id + ", name=" + name + ", description=" + description + ", cvr=" + cvr + ", numEmployees=" + numEmployees + ", marketValue=" + marketValue + '}';
    }
    
}
