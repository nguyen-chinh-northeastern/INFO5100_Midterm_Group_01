/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserInterface.WorkAreas.StudentRole;

import Business.CourseSchedule.CourseLoad;
import Business.CourseSchedule.SeatAssignment;
import Business.Persona.Transcript;
import Business.Profiles.StudentProfile;

/**
 * Shared layout utility to streamline shared functionality between multiple student JPanels
 *
 * @author rmacc
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
    
    
}
