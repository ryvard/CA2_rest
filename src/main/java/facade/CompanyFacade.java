package facade;

import entity.Company;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author miaryvard
 */
public class CompanyFacade implements ICompanyFacade
{

    EntityManagerFactory emf;
    EntityManager em = emf.createEntityManager();

    public CompanyFacade()
    {
    }

    public CompanyFacade(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

    @Override
    public Company addCompany(Company c)
    {
        try
        {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            return c;
        } finally
        {
            em.close();
        }
    }

    @Override
    public Company editCompany(Company company)
    {
        try
        {
            em.getTransaction().begin();
            Company c = em.find(Company.class, company.getId());
            if (c != null)
            {
                c = company;
                em.merge(c);
                em.getTransaction().commit();
            }
            return c;
        } finally
        {
            em.close();
        }
    }

    @Override
    public Company deleteCompany(int id)
    {
        try
        {
            em.getTransaction().begin();
            Company c = em.find(Company.class, id);
            em.remove(c);
            em.getTransaction().commit();
            return c;
        } finally
        {
            em.close();
        }
    }

    @Override
    public Company getCompany(int cvr)
    {

        try
        {
            em.getTransaction().begin();
            Company c = (Company) em.createQuery("Select c from Company c where c.cvr =:" + cvr).getSingleResult();
            em.getTransaction().commit();
            return c;
        } finally
        {
            em.close();
        }
    }

    @Override
    public Company getCompany(String number)
    {
        try
        {
            em.getTransaction().begin();
            Company c = (Company) em.createQuery("Select c from Company c where c.number =:" + number).getSingleResult();
            em.getTransaction().commit();
            return c;
        } finally
        {
            em.close();
        }
    }

    @Override
    public Company getCompany(String table, String data)
    {

        try
        {
            em.getTransaction().begin();
            Company c = (Company) em.createQuery("Select c from Company c where c." + table + " =:" + data).getSingleResult();
            em.getTransaction().commit();
            return c;
        } finally
        {
            em.close();
        }
    }

    @Override
    public List<Company> getCompanies()
    {
        List<Company> companies = null;

        try
        {
            em.getTransaction().begin();
            companies = em.createQuery("Select c from Company c").getResultList();
            em.getTransaction().commit();
            return companies;
        } finally
        {
            em.close();
        }
    }

    @Override
    public List<Company> getCompanies(int numEmployees)
    {
        List<Company> companies = null;

        try
        {
            em.getTransaction().begin();
            companies = em.createQuery("Select c from Company c where c.numEmployees > " + numEmployees).getResultList();
            em.getTransaction().commit();
            return companies;
        } finally
        {
            em.close();
        }
    }

}
