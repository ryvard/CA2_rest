package facade;

import entity.Person;
import java.util.List;

/**
 *
 * @author miaryvard
 */
public interface IPersonFacade
{
    public Person addPerson(Person p);
    public Person editPerson(Person p);
    public Person deletePerson(int id);
    public Person getPerson(int id);
    public Person getPerson(String number);
    public List<Person> getPersons();
    public List<Person> getPersons(int zipCode);
    public List<Person> getPersons(String hobby);
    public int countPeople(String hobby);
    
}
