package facade;

import entity.Company;
import java.util.List;

/**
 *
 * @author miaryvard
 */
public interface ICompanyFacade
{
    public Company addCompany(Company c);
    public Company editCompany(Company c);
    public Company deleteCompany(int id);
    public Company getCompany(int cvr);
    public Company getCompany(String number);
    public Company getCompany(String table, String data);
    public List<Company> getCompanies();
    public List<Company> getCompanies(int numEmployees);
}
