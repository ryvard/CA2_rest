package jsonmappers;

/**
 *
 * @author miaryvard
 */
public class ContactMapper
{
    long id;
    String name;
//    String email;
//    String phone;
    
    public ContactMapper(entity.Person p)
    {
        id = p.getId();
        name = p.getFirstName() + " "+ p.getLastName();
    }
    
}
