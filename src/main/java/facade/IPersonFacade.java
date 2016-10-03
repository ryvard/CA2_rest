package facade;

import entity.Person;
import java.util.List;

/**
 *
 * @author miaryvard
 */
public interface IPersonFacade
{
    public Person getPerson(int id);
    public List<Person> getPersons();
    public List<Person> getPersons(int zipCode);
}
