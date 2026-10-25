/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Faculty;

import Business.CourseSchedule.CourseOffer;
import Business.Persona.Person;
import Business.Profiles.Profile;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 * @author Chinh Nguyen (update)
 */
public class FacultyProfile extends Profile {

    ArrayList <FacultyAssignment> facultyassignments; 
    private String academicRank;
    private String officeLocation;
    
    public FacultyProfile(Person p) {

        super(p);
        facultyassignments = new ArrayList();
    }

    @Override
    public String getRole() {
        return "Faculty";
    }
    
    public String getAcademicRank() {
        return academicRank;
    }

    public void setAcademicRank(String academicRank) {
        this.academicRank = academicRank;
    }

    public String getOfficeLocation() {
        return officeLocation;
    }

    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }
    
    public  double getProfAverageOverallRating(){
        
        double sum = 0.0;
        //for each facultyassignment extract class rating
        //add them up and divide by the number of teaching assignmnet;
        for(FacultyAssignment fa: facultyassignments){
            
            sum = sum + fa.getRating();
            
        }
        //divide by the total number of faculty assignments
        
        return sum/(facultyassignments.size()*1.0); //this ensure we have double/double
        
    }

    public FacultyAssignment AssignAsTeacher(CourseOffer co){
        
        FacultyAssignment fa = new FacultyAssignment(this, co);
        facultyassignments.add(fa);
        
        return fa;
    }
    
    public FacultyProfile getCourseOffer(String courseid){
        return null; //complete it later
    }

    public boolean isMatch(String id) {
        Person person = getPerson();
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }

}
