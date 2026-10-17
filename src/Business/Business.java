/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Department.Department;
import Business.Faculty.FacultyDirectory;
import Business.Persona.PersonDirectory;
import Business.Profiles.EmployeeDirectory;
import Business.Profiles.StudentDirectory;

import Business.UserAccounts.UserAccountDirectory;

/**
 *
 * @author kal bugrara
 */
public class Business {

    String name;
    Department department;
    EmployeeDirectory employeedirectory;
    UserAccountDirectory useraccountdirectory;
    
    public Business(String n) {
        
        name = n;
        department = new Department(n);
        employeedirectory = new EmployeeDirectory(this);
        useraccountdirectory = new UserAccountDirectory();

    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public PersonDirectory getPersonDirectory() {
        return department.getPersonDirectory();
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return useraccountdirectory;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeedirectory;
    }

    public StudentDirectory getStudentDirectory() {
        return department.getStudentDirectory();
    }

    public FacultyDirectory getFacultyDirectory() {
        return department.getFacultydirectory();
    }

}
