/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.Persona.Person;

/**
 *
 * @author kal bugrara
 * @author Lee Wang (update)
 */
public abstract class Profile {

    Person person;

    public Profile(Person p) {
        person = p;

    }

    public abstract String getRole();

    public Person getPerson() {
        return person;
    }

    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

    /**
     * Gets the person's ID (their name) for display, or the role if no person is linked.
     */
    @Override
    public String toString() {
        if (person == null) {
            return getRole();
        }
        return person.getPersonId();
    }
}
