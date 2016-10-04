
package facade;

import entity.Person;

/**
 *
 * Denne klasse er kun lavet for at forstå polimorfi og interface
 */
public class OuterFacade {
    private IPersonFacade facade;
    
    public OuterFacade(IPersonFacade facade){
        this.facade = facade;
    }
    public void whatever(){
        facade.addPerson(new Person());
    }
    
}
