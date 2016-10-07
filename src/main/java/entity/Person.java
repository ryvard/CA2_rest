package entity;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author miaryvard
 */
@Entity
public class Person extends InfoEntity
{
    //@Id
    //@GeneratedValue (strategy = GenerationType.IDENTITY)
    //private Long id;
    
    private String firstName;
    private String lastName;
    
    @ManyToMany
    private List<Hobby> hobbies;

    public Person()
    {
    }

    public Person(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

//    public Hobby getHobby()
//    {
//        return hobby;
//    }
//
//    public void setHobby(Hobby hobby)
//    {
//        this.hobby = hobby;
//    }
    
    
    
    
    public void removePersonFromHobby(Person p)
    {
        for (int i = 0; i < hobbies.size(); i++) {
            hobbies.get(i).removePersonFromHobbyList(p);
        }
    }

    @Override
    public String toString()
    {
        return "Person{firstName=" + firstName + ", lastName=" + lastName + '}';
    }
    
}
