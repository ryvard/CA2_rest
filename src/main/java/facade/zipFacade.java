/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.CityInfo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Jmach
 */
public class zipFacade implements IzipFacade
{
    EntityManagerFactory emf;
    EntityManager em = emf.createEntityManager();

    @Override
    public List<CityInfo> getZipcodes()
    {
        List<CityInfo> zipCodes = null;
        
        try
        {
            em.getTransaction().begin();
            zipCodes = em.createQuery("Select z from CityInfo z where z.zip").getResultList();
            em.getTransaction().commit();
            return zipCodes;
        }
        finally
        {
            em.close();
        }
    }
    
}
