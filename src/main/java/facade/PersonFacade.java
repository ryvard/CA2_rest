package facade;

import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author miaryvard
 */
public class PersonFacade implements IPersonFacade
{
    EntityManagerFactory emf;

    public PersonFacade()
    {
    }
    
    public PersonFacade(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    
    @Override
    public Person getPerson(int id)
    {
        EntityManager em = emf.createEntityManager();
        
        try
        {
            em.getTransaction().begin();
            Person p = em.find(Person.class, id);
            em.remove(em);
            em.getTransaction().commit();
            return p;
        }
        finally
        {
            em.close();
        }
            
    }

    @Override
    public List<Person> getPersons()
    {
        EntityManager em = emf.createEntityManager();
        List<Person> persons = null;
        
        try
        {
            em.getTransaction().begin();
            persons = em.createQuery("Select p from Person p").getResultList();
            em.getTransaction().commit();
            return persons;
        }
        finally
        {
            em.close();
        }
    }

    @Override
    public List<Person> getPersons(int zipCode)
    {
        EntityManager em = emf.createEntityManager();
        List<Person> persons = null;
        
        try
        {
            em.getTransaction().begin();
            //persons = em.createQuery("Select p from Person p where p.address").getResultList();
            em.getTransaction().commit();
            return persons;
        }
        finally
        {
            em.close();
        }
    }
    
}
