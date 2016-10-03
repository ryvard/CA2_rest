package facade;

import entity.Company;
import java.util.List;

/**
 *
 * @author miaryvard
 */
public interface ICompanyFacade
{
    public Company getCompany(int cvr);
    public List<Company> getCompanies();
}
