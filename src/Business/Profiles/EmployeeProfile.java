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
public class EmployeeProfile extends Profile {

    private boolean telework;
    private int workingHoursPerWeek;

    public EmployeeProfile(Person p) {
        super(p);
    }

    /**
     * Gets whether the employee teleworks.
     */
    public boolean isTelework() {
        return telework;
    }

    /**
     * Sets whether the employee teleworks.
     */
    public void setTelework(boolean telework) {
        this.telework = telework;
    }

    /**
     * Gets the employee's working hours per week.
     */
    public int getWorkingHoursPerWeek() {
        return workingHoursPerWeek;
    }

    /**
     * Sets the employee's working hours per week.
     */
    public void setWorkingHoursPerWeek(int workingHoursPerWeek) {
        this.workingHoursPerWeek = workingHoursPerWeek;
    }

    @Override
    public String getRole() {
        return "Admin";
    }
}
