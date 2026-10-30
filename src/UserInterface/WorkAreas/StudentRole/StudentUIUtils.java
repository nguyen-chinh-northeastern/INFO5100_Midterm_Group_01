/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserInterface.WorkAreas.StudentRole;

import Business.CourseCatalog.Course;
import Business.CourseSchedule.CourseLoad;
import Business.CourseSchedule.SeatAssignment;
import Business.Department.Department;
import Business.Persona.Transcript;
import Business.Profiles.StudentProfile;

/**
 * Shared layout utility to streamline shared functionality between multiple student JPanels
 *
 * @author rachel macaulay
 * @author Lee Wang (update)
 */
public class StudentUIUtils {
    
    public static String getSemesterForSeatAssignment(StudentProfile studentProfile, SeatAssignment sa){
        if(studentProfile == null) return "Unknown";
        Transcript transcript = studentProfile.getTranscript();
        if(transcript == null) return "Unknown";
        
        try{
            java.lang.reflect.Field field = transcript.getClass().getDeclaredField("courseloadlist");
            field.setAccessible(true);
            java.util.HashMap<String, CourseLoad> courseloadlist = (java.util.HashMap<String, CourseLoad>) field.get(transcript);
            
            if(courseloadlist !=null){
                for(java.util.Map.Entry<String, CourseLoad> entry : courseloadlist.entrySet()){
                    if (entry.getValue() != null && entry.getValue().getSeatAssignments().contains(sa)) {
                        return entry.getKey();
                    }
                }
            }
        }catch (Exception e){

        }

            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return "Unknown";
    }
    
    public static boolean isPastYearSemester(String semesterStr){
        if (semesterStr == null || semesterStr.isEmpty()){
            return false;
        }
        
        //assumes 3 semesters per year
        try{
            
            int semesterYear = Integer.parseInt(semesterStr.substring(semesterStr.length()-4));
           
            java.time.LocalDate today = java.time.LocalDate.now();
            int currentYear = today.getYear();
          
            return semesterYear < currentYear;
            
        } catch (Exception e){
            return true;
        }
    }
    
    // calculate GPA
    public static float calculateGPA(StudentProfile profile){
        if (profile == null || profile.getCourseList() == null) return 0.0f;
        
        float totalPoints = 0;
        int gradedCredits = 0;
        
        for (SeatAssignment sa : profile.getCourseList()){
            String semester = getSemesterForSeatAssignment(profile, sa);
            if(!semester.equals("Unknown") && isPastYearSemester(semester)){
                totalPoints += sa.GetCourseStudentScore();
                gradedCredits += sa.getCreditHours();
            }
        }
        
        return (gradedCredits > 0) ? (totalPoints / gradedCredits) : 00f;
    }
    
    // set grade to letter value
    public static String convertGpaToLetterGrade(SeatAssignment sa){
        if(sa == null) return "N/A";
        
        float gradeValue = sa.getGrade();
        
        if(gradeValue >= 4.0f) return "A";
        if(gradeValue >= 3.7f) return "A-";
        if(gradeValue >= 3.3f) return "B+";
        if(gradeValue >= 3.0f) return "B";
        if(gradeValue >= 2.7f) return "B-";
        if(gradeValue >= 2.3f) return "C+";
        if(gradeValue >= 2.0f) return "C";
        if(gradeValue >= 1.7f) return "C-";
        if(gradeValue >= 1.3f) return "D+";
        if(gradeValue >= 1.0f) return "D";
        if(gradeValue >= 0.7f) return "D-";
        if(gradeValue > 0.0f) return "F";
        // 0.0 is value reserved for ongoing courses
        return "In Progress";
        
    }
    
    // track metrics
    
    
     public static int calculateCreditsEarned(StudentProfile student){
        if (student == null || student.getCourseList() == null) return 0;
        int totalEarned = 0;
        
        for (SeatAssignment sa : student.getCourseList()){
            if(sa == null || sa.getAssociatedCourse() == null) {
                continue;
            }
            
            float gradeValue = sa.getGrade();
            
            if(gradeValue > 0.0f){
                totalEarned += sa.getCreditHours();
            }
        }
        return totalEarned;
    }
    
    public static int calculateCreditsPlanned(StudentProfile student){
        if (student == null || student.getCourseList() == null) return 0;
        int totalPlanned = 0;
        
        for (SeatAssignment sa : student.getCourseList()){
            if(sa.getAssociatedCourse() == null) continue;
            
            float gradeValue = sa.getGrade();
            
            if(gradeValue == 0.0f){
                totalPlanned += sa.getCreditHours();
            }
        }
        return totalPlanned;
    }
    
   
    public static String getCourseType(Department dept, Course course){
        if(dept == null || course == null) return "Elective";
        
        if(dept.getCourseCatalog() != null){
            String courseNo = course.getCourseNumber();
            if ("INFO 5100".equals(courseNo) || "INFO 6120".equals(courseNo) || "INFO 6250".equals(courseNo)) {
                return "Core";
            }
        }
        return "Elective";
    }
    
    
    
    
    
}
