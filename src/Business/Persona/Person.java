/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Persona;

/**
 *
 * @author kal bugrara
 * @author Chinh Nguyen (update)
 */
public class Person {

    private String id;
    private String nuid; // NUID is stored in Person and shared by associated profiles
    private String email;
    private String phone;
    private String department;

    public Person(String id) {

        this.id = id;
        this.nuid = "";
    }
    
    public Person(String nuid, String id) {
        this.nuid = nuid;
        this.id = id;
    }

    public String getPersonId() {
        return id;
    }
    
    public void setPersonId(String id) {
        this.id = id;
    }

    public boolean isMatch(String id) {
        if (getPersonId().equals(id)) {
            return true;
        }
        return false;
    }
    
    public String getNuid() {
        return nuid;
    }

    public void setNuid(String nuid) {
        this.nuid = nuid;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return getPersonId();
    }
}
