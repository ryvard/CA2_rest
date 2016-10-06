package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author miaryvard
 */
@Entity
public class Phone
{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String phone;
    private String description;
    @ManyToOne
    private InfoEntity infoEntity;

    public Phone()
    {
    }

    public Phone(String phone, String description)
    {
        this.phone = phone;
        this.description = description;
    }

    
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public InfoEntity getInfoEntity()
    {
        return infoEntity;
    }

    public void setInfoEntity(InfoEntity infoEntity)
    {
        this.infoEntity = infoEntity;
    }
    
    

    @Override
    public String toString()
    {
        return "Phone{" + "id=" + id + ", phone=" + phone + ", description=" + description + '}';
    }
 
    
    
}
