/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Profiles;

import Business.CourseSchedule.CourseLoad;
import Business.CourseSchedule.SeatAssignment;
import Business.Persona.EmploymentHistory.EmploymentHistory;
import Business.Persona.Person;
import Business.Persona.Transcript;
import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 * @author Chinh Nguyen (update)
 * @author Lee Wang (update)
 */
public class StudentProfile extends Profile {

    Transcript transcript;
    EmploymentHistory employmenthistory;
    private String hobbies;
    private String interests;

    public StudentProfile(Person p) {

        super(p);
        transcript = new Transcript(this);
        employmenthistory = new EmploymentHistory();
    }

    @Override
    public String getRole() {
        return "Student";
    }

    public boolean isMatch(String id) {
        return person.getPersonId().equals(id);
    }

    public Transcript getTranscript() {
        return transcript;
    }

    public CourseLoad getCourseLoadBySemester(String semester) {

        return transcript.getCourseLoadBySemester(semester);
    }

    public CourseLoad getCurrentCourseLoad() {

        return transcript.getCurrentCourseLoad();
    }

    public CourseLoad newCourseLoad(String s) {

        return transcript.newCourseLoad(s);
    }

    public ArrayList<SeatAssignment> getCourseList() {

        return transcript.getCourseList();

    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }
}
