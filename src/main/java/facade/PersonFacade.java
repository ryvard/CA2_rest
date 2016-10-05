package facade;

import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
    
    public void setEmf(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

    @Override
    public Person addPerson(Person p)
    {
        EntityManager em = emf.createEntityManager();
        
        try
        {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return p;
        } finally
        {
            em.close();
        }
    }

    @Override
    public Person editPerson(Person person)
    {
        EntityManager em = emf.createEntityManager();
        
        try
        {
            em.getTransaction().begin();
            Person p = em.find(Person.class, person.getId());
            if (p != null)
            {
                p = person;
                em.merge(p);
                em.getTransaction().commit();
            }
            return p;
        } finally
        {
            em.close();
        }
    }

    @Override
    public Person deletePerson(long id)
    {
        EntityManager em = emf.createEntityManager();
        
        try
        {
            em.getTransaction().begin();
            Person p = em.find(Person.class, id);
            //System.out.println("Personen som er fundet i databasen "+p);
            p.removePersonFromHobby(p);
            em.remove(p);
            em.getTransaction().commit();
            return p;
        } finally
        {
            em.close();
        }
    }

    @Override
    public Person getPerson(long id)
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            Person p = em.find(Person.class, id);
            //em.remove(em);
            em.getTransaction().commit();
            System.out.println("person" + p.getFirstName());
            return p;
        } finally
        {
            em.close();
        }

    }

    @Override
    public Person getPerson(String number)
    {
        EntityManager em = emf.createEntityManager();

        try
        {
            em.getTransaction().begin();
            Person p = em.find(Person.class, number);
            //em.remove(em);
            em.getTransaction().commit();
            return p;
        } finally
        {
            em.close();
        }

    }

    @Override
    public int countPeople(String hobby)
    {
        EntityManager em = emf.createEntityManager();
        
        try
        {
            em.getTransaction().begin();
            int count = em.createQuery("Select COUNT(hobby) from Person p where p.hobby =:" + hobby).getFirstResult();
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
        EntityManager em = emf.createEntityManager();
        List<Person> persons = null;

        try
        {
            em.getTransaction().begin();
            persons = em.createQuery("Select p from Person p").getResultList();
            em.getTransaction().commit();
            return persons;
        } finally
        {
            em.close();
        }
    }

    @Override
    public List<Person> getPersons(int zip)
    {
        EntityManager em = emf.createEntityManager();
        List<Person> persons = null;

        try
        {
            em.getTransaction().begin();
            persons = em.createQuery("Select p from Person p where p.zip =:" + zip).getResultList();
            em.getTransaction().commit();
            return persons;
        } finally
        {
            em.close();
        }
    }

    @Override
    public List<Person> getPersons(String hobby)
    {
        EntityManager em = emf.createEntityManager();
        List<Person> persons = null;
        try
        {
            em.getTransaction().begin();
            persons = em.createQuery("Select p from Person p where p.hobby =:" + hobby).getResultList();
            return persons;
        } finally
        {
            em.close();
        }
    }

}
