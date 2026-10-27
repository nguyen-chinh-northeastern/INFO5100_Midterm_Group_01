/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Persona;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 * @author Chinh Nguyen (update)
 */
public class PersonDirectory {
    
    ArrayList<Person> personlist ;
    
    public PersonDirectory (){
          
        personlist = new ArrayList();

    }

    public Person newPerson(String id) {

        Person p = new Person(id);
        personlist.add(p);
        return p;
    }
    
    /**
     * Finds a person by their existing person ID.
     *
     * @param id the person ID to search for
     * @return the matching person, or null if not found
     */
    public Person findPerson(String id) {

        for (Person p : personlist) {

            if (p.isMatch(id)) {
                return p;
            }
        }
        return null; //not found after going through the whole list
    }
    
    /**
     * Finds a person by their NUID.
     *
     * @param nuid the NUID to search for
     * @return the matching person, or null if not found
     */
    public Person findPersonByNuid(String nuid) {
        for (Person p : personlist) {
            if (p.getNuid().equals(nuid)) {
                return p;
            }
        }
        return null;
    }
    
}
