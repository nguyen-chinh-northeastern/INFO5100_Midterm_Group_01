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
 * @author Lee Wang (update)
 */
public class PersonDirectory {

    ArrayList<Person> personlist;

    public PersonDirectory() {
        personlist = new ArrayList();
    }

    public Person newPerson(String id) {
        Person p = new Person(id);
        personlist.add(p);
        return p;
    }

    /**
     * Finds people matching a person ID.
     *
     * @param id the person ID to search for
     * @return the matching people
     */
    public ArrayList<Person> findPerson(String id) {
        ArrayList<Person> matches = new ArrayList<>();
        for (Person p : personlist) {
            if (p.isMatch(id)) {
                matches.add(p);
            }
        }
        return matches;
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

    /**
     * Gets all persons in the directory.
     *
     * @return the list of persons
     */
    public ArrayList<Person> getPersonList() {
        return personlist;
    }

    /**
     * Remove person from directory.
     *
     * @param p
     */
    public void removePerson(Person p) {
        personlist.remove(p);
    }
}
