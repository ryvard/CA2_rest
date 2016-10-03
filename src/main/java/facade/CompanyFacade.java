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

    public CompanyFacade()
    {
    }

    public CompanyFacade(EntityManagerFactory emf)
    {
        this.emf = emf;
    }
    
    @Override
    public Company getCompany(int cvr)
    {
        EntityManager em = emf.createEntityManager();
        
        try
        {
            em.getTransaction().begin();
            Company c  = (Company)em.createQuery("Select c from Company c where c.cvr =:"+cvr).getSingleResult();
            em.getTransaction().commit();
            return c;
        }
        finally
        {
            em.close();
        }
    }

    @Override
    public List<Company> getCompanies()
    {
        EntityManager em = emf.createEntityManager();
        List<Company> companies = null;
        
        try
        {
            em.getTransaction().begin();
            companies  = em.createQuery("Select c from Company c").getResultList();
            em.getTransaction().commit();
            return companies;
        }
        finally
        {
            em.close();
        }
    }
    
}
