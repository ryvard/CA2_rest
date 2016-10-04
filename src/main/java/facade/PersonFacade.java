package facade;

import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


public class PersonFacade implements IPersonFacade
{
    EntityManagerFactory emf;
    EntityManager em = emf.createEntityManager();
    
    public PersonFacade()
    {
    }
    
    public PersonFacade(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    
    @Override
    public Person addPerson(Person p)
    {
        try{
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        return p;
        }
        finally{
            em.close();
        }
    }
    
    @Override
    public Person getPerson(int id)
    {
                
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
    public Person getPerson(String number)
    {
                
        try
        {
            em.getTransaction().begin();
            Person p = em.find(Person.class, number);
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
    public int countPeople(String hobby)
    {
        try
        {
            em.getTransaction().begin();
            int count = em.createQuery("Select COUNT(hobby) from Person p where p.hobby =:"+hobby).getFirstResult();
            em.getTransaction().commit();
            return count;
        } finally
        {
            em.close();
        }
    }

    @Override
    public List<Person> getPersons()
    {
        
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
    public List<Person> getPersons(int zip)
    {
        
        List<Person> persons = null;
        
        try
        {
            em.getTransaction().begin();
            persons = em.createQuery("Select p from Person p where p.zip =:"+zip).getResultList();
            em.getTransaction().commit();
            return persons;
        }
        finally
        {
            em.close();
        }
    }

    @Override
    public List<Person> getPersons(String hobby)
    {
        List<Person> persons = null;
        try
        {
            em.getTransaction().begin();
            persons = em.createQuery("Select p from Person p where p.hobby =:"+hobby).getResultList();
            return persons;
        } finally
        {
            em.close();
        }
    }    

}
