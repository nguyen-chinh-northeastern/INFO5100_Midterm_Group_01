/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

*/
package Business;

import Business.CourseCatalog.Course;
import Business.CourseCatalog.CourseCatalog;
import Business.CourseSchedule.CourseLoad;
import Business.CourseSchedule.CourseOffer;
import Business.CourseSchedule.CourseSchedule;
import Business.CourseSchedule.SeatAssignment;
import Business.Department.Department;
import Business.Faculty.FacultyDirectory;
import Business.Faculty.FacultyProfile;
import Business.Persona.Person;
import Business.Persona.PersonDirectory;
import Business.Profiles.EmployeeDirectory;
import Business.Profiles.EmployeeProfile;
import Business.Profiles.StudentDirectory;
import Business.Profiles.StudentProfile;

import Business.UserAccounts.UserAccount;
import Business.UserAccounts.UserAccountDirectory;


/**
 *
 * @author kal bugrara
 * @author Chinh Nguyen (update)
 */
class ConfigureABusiness {

    static Business initialize() {
        Business business = new Business("Information Systems");

        // Create Persons
        PersonDirectory persondirectory = business.getPersonDirectory();
        // person representing sales organization        
        Person person001 = persondirectory.newPerson("John Smith");
        initializePerson(person001, "110000001", "john.smith@northeastern.edu",
                "617-555-0101", "Administration");
        
        Person person002 = persondirectory.newPerson("Gina Montana");
        initializePerson(person002, "110000002", "gina.montana@northeastern.edu",
                "617-555-0102", "Human Resources");
        
        Person person003 = persondirectory.newPerson("Adam Rollen");
        initializePerson(person003, "110000003", "adam.rollen@northeastern.edu",
                "617-555-0103", "Information Systems");
        
        Person person004 = persondirectory.newPerson("Sarah Mitchell");
        initializePerson(person004, "001000004", "sarah.mitchell@northeastern.edu",
                "617-555-0104", "Computer Science");
 
        Person person005 = persondirectory.newPerson("Jim Dellon");
        initializePerson(person005, "001000005", "jim.dellon@northeastern.edu",
                "617-555-0105", "Finance");
        
        Person person006 = persondirectory.newPerson("Anna Shnider");
        initializePerson(person006, "001000006", "anna.shnider@northeastern.edu",
                "617-555-0106", "Computer Science");

        Person person007 = persondirectory.newPerson("Laura Brown");
        initializePerson(person007, "220000007", "laura.brown@northeastern.edu",
                "617-555-0107", "Student Services");
        
        Person person008 = persondirectory.newPerson("Jack While");
        initializePerson(person008, "220000008", "jack.while@northeastern.edu",
                "617-555-0108", "Information Systems");
        
        Person person009 = persondirectory.newPerson("Fidelity"); //we use this as customer
        initializePerson(person009, "220000009", "contact@fidelity.example",
                "", "External Organization");

        // Create Admins to manage the business
        EmployeeDirectory employeedirectory = business.getEmployeeDirectory();
        EmployeeProfile employeeprofile0 = employeedirectory.newEmployeeProfile(person001);
        
        StudentDirectory studentdirectory = business.getStudentDirectory();
        // Adam Rollen
        StudentProfile studentprofile0 = studentdirectory.newStudentProfile(person003);
        // Sarah Mitchell
        StudentProfile studentprofile1 = studentdirectory.newStudentProfile(person004);
        
        FacultyDirectory facultydirectory = business.getFacultyDirectory();
        FacultyProfile facultyprofile0 = facultydirectory.newFacultyProfile(person007);
        facultyprofile0.setAcademicRank("Associate Teaching Professor");
        facultyprofile0.setOfficeLocation("Snell Engineering 410");
   
        // Create User accounts that link to specific profiles
        UserAccountDirectory uadirectory = business.getUserAccountDirectory();
        UserAccount ua3 = uadirectory.newUserAccount(employeeprofile0, "admin", "****"); /// order products for one of the customers and performed by a sales person
        UserAccount ua4 = uadirectory.newUserAccount(studentprofile0, "adam", "****"); /// order products for one of the customers and performed by a sales person
        UserAccount ua5 = uadirectory.newUserAccount(facultyprofile0, "laura", "****");
        
        Department department = business.getDepartment();
        CourseCatalog courseCatalog = department.getCourseCatalog();
        Course course1 = courseCatalog.newCourse("Application Engineering & Development", "INFO 5100", 4);
        Course course2 = courseCatalog.newCourse("User Experience Design & Testing", "CSYE 7280", 4);
        
        // Create Course Schedule for Fall 2026
        CourseSchedule fall2026 = department.newCourseSchedule("Fall 2026");
        
        // Create Course Offerings for Laura's classes
        CourseOffer offer1 = fall2026.newCourseOffer(course1.getCourseNumber());
        if (offer1 != null) {
            offer1.generateSeats(25);
            offer1.AssignAsTeacher(facultyprofile0);
            facultyprofile0.AssignAsTeacher(offer1);
        }
        
        CourseOffer offer2 = fall2026.newCourseOffer(course2.getCourseNumber());
        if (offer2 != null) {
            offer2.generateSeats(25);
            offer2.AssignAsTeacher(facultyprofile0);
            facultyprofile0.AssignAsTeacher(offer2);
        }
        
        // Register students and assign grades
        // Adam Rollen
        CourseLoad load1 = studentprofile0.getTranscript().newCourseLoad("Fall 2026");
        SeatAssignment sa1 = load1.newSeatAssignment(offer1);
        if (sa1 != null) {
            sa1.setGrade(3.8f);
        }

        // Sarah Mitchell
        CourseLoad load2 = studentprofile1.getTranscript().newCourseLoad("Fall 2026");
        SeatAssignment sa2 = load2.newSeatAssignment(offer1);
        if (sa2 != null) {
            sa2.setGrade(4.0f);
        }

        return business;

    }

    /**
     * Initializes the contact and department details of a person.
     *
     * @param person the person to initialize
     * @param nuid the person's NUID
     * @param email the person's email address
     * @param phone the person's phone number
     * @param department the person's department
     */
    private static void initializePerson(Person person, String nuid, String email, String phone, String department) {
        person.setNuid(nuid);
        person.setEmail(email);
        person.setPhone(phone);
        person.setDepartment(department);
    }

}
