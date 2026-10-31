/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserInterface.WorkAreas.StudentRole;

import Business.Business;
import Business.CourseCatalog.Course;
import Business.CourseCatalog.CourseCatalog;
import Business.CourseSchedule.CourseLoad;
import Business.CourseSchedule.CourseOffer;
import Business.CourseSchedule.CourseSchedule;
import Business.CourseSchedule.SeatAssignment;
import Business.Department.Department;
import Business.Profiles.StudentProfile;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author rachel macaulay
 * @author Lee Wang (update)
 */
public class StudentDataInitializer {
    
    // Course progress metrics
    
    private static final Map<String, Integer> totalAssignmentsPerCourse = new HashMap<>();
    private static final Map<SeatAssignment, Integer> submittedAssignments = new HashMap<>();
    
    private static final Map<String, String> assignmentStatusMap = new HashMap<>();
    
    static{
        // course assignments per MSIS course
        totalAssignmentsPerCourse.put("INFO 5100", 15);
        totalAssignmentsPerCourse.put("INFO 6120", 15);
        totalAssignmentsPerCourse.put("INFO 6250", 5);
        totalAssignmentsPerCourse.put("INFO 7250", 5);
        totalAssignmentsPerCourse.put("INFO 7390", 10);
        totalAssignmentsPerCourse.put("CSYE 7280", 10);
    }
    
    // populate data for MSIS courses - opportunity to input actual values from faculty in future
    public static void populateMSISData(Business business, StudentProfile studentProfile){
        Department dept = business.getDepartment();
        if(dept == null || studentProfile == null) return;
        
        // check for completed courses to see if all assignments expected
        for(SeatAssignment sa : studentProfile.getCourseList()){
            if(sa.getAssociatedCourse() != null){
                String courseNum = sa.getAssociatedCourse().getCourseNumber();
                int totalExpected = totalAssignmentsPerCourse.getOrDefault(sa.getAssociatedCourse().getCourseNumber(), 12);
                submittedAssignments.put(sa, totalExpected);
                for(int i = 1; i<= totalExpected; i++){
                    assignmentStatusMap.put(sa.hashCode() + "_Assignment " + i, "Submitted");
                    
                   
                }
            }
        
        //skip if profile is populated w/courses
        if(!studentProfile.getCourseList().isEmpty()){
            return;
        }
        

        }
        
        
        
        CourseCatalog catalog = dept.getCourseCatalog();
        
        // add courses
        Course aed = catalog.getCourseByNumber("INFO 5100");
        if(aed == null) aed = catalog.newCourse("Application Engineering & Development", "INFO 5100", 4);
        
        Course db = catalog.getCourseByNumber("INFO 6120");
        if(db == null) db = catalog.newCourse("Data Management and Database Design", "INFO 6120", 4);
        
        Course web = catalog.getCourseByNumber("INFO 6250");
        if(web == null) web = catalog.newCourse("Web Development Tools and Methods", "INFO 6250", 4);
        
        Course bd = catalog.getCourseByNumber("INFO 7250");
        if(bd == null) bd = catalog.newCourse("Engineering of Big-Data Systems", "INFO 7250", 4);
        
        Course dsa = catalog.getCourseByNumber("INFO 7390");
        if(dsa == null) dsa = catalog.newCourse("Advances in Data Sciences and Architecture", "INFO 7390", 4);
        
        Course ux = catalog.getCourseByNumber("CSYE 7280");
        if(ux == null) ux = catalog.newCourse("User Experience Design and Testing", "CSYE 7280", 4);
        
       if(dept.getCourseCatalog().getCourseList().size() <2){
            dept.addCoreCourse(aed);
            dept.addCoreCourse(db);
            dept.addCoreCourse(web);

            dept.addElectiveCourse(bd);
            dept.addElectiveCourse(dsa);
            dept.addElectiveCourse(ux);
       } 
        
        
        // Establish semesters - past
        String pastSemester = "Fall 2025";
        CourseSchedule pastSchedule = dept.getCourseSchedule(pastSemester);
        boolean isPast = false;
        if(pastSchedule == null){
            pastSchedule = dept.newCourseSchedule(pastSemester);
            isPast = true;
        }
        
        CourseOffer aedOffer = pastSchedule.getCourseOfferByNumber("INFO 5100");
        if(aedOffer == null) aedOffer = pastSchedule.newCourseOffer("INFO 5100");
        CourseOffer dbOffer = pastSchedule.getCourseOfferByNumber("INFO 6120");
        if(dbOffer == null) dbOffer = pastSchedule.newCourseOffer("INFO 6120");
        
        if(isPast){
            if(aedOffer != null) aedOffer.generateSeats(10);
            if(dbOffer != null) dbOffer.generateSeats(10);
        }
        
        CourseLoad pastLoad = studentProfile.getCourseLoadBySemester(pastSemester);
        if(pastLoad == null){
            pastLoad = studentProfile.newCourseLoad(pastSemester);
        }
        // Establish grades and submissions - past
        
        // Skips aed if the student is already enrolled (Laura in ConfigureABusiness)
        SeatAssignment sa1 = null;
        boolean hasAed = false;
        for(SeatAssignment sa : studentProfile.getCourseList()){
            if(sa.getAssociatedCourse() == aed){
                hasAed = true;
            }
        }
        if (!hasAed)
            sa1 = aedOffer.assignEmptySeat(pastLoad);
        SeatAssignment sa2 = dbOffer.assignEmptySeat(pastLoad);
        
        if(sa1 != null){
            setGrade(sa1, 4.0f);
            submittedAssignments.put(sa1, 15);
            
        }
        
       if(sa2 != null){
            setGrade(sa2, 4.0f);
            submittedAssignments.put(sa2, 15);
            
        }
       
       // Establish semesters - current
        String currentSemester = "Fall 2026";
        CourseSchedule currentSchedule = dept.getCourseSchedule(currentSemester);
        boolean isCurrent = false;
        
        if(currentSchedule == null){
            currentSchedule = dept.newCourseSchedule(currentSemester);
        isCurrent = true;
        }
        
        CourseOffer webOffer = currentSchedule.getCourseOfferByNumber("INFO 6250");
        if(webOffer == null) webOffer = currentSchedule.newCourseOffer("INFO 6250");
        CourseOffer uxOffer = currentSchedule.getCourseOfferByNumber("CSYE 7280");
        if(uxOffer == null) uxOffer = currentSchedule.newCourseOffer("CSYE 7280");
        
        if(isCurrent){
            if(webOffer != null) webOffer.generateSeats(10);
            if(uxOffer != null) uxOffer.generateSeats(10);
        }
        
        CourseLoad currentLoad = studentProfile.getCourseLoadBySemester(currentSemester);
        
        // Establish grades and submissions - current
        if(currentLoad == null){
            currentLoad = studentProfile.newCourseLoad(currentSemester);
        }
        
        SeatAssignment saCurrent1 = webOffer.assignEmptySeat(currentLoad);
        SeatAssignment saCurrent2 = uxOffer.assignEmptySeat(currentLoad);
        
        if(saCurrent1 != null){
            setGrade(saCurrent1, 0.0f);
            submittedAssignments.put(saCurrent1, 2);
            assignmentStatusMap.put(saCurrent1.hashCode() + "_Assignment 1", "Submitted");
            assignmentStatusMap.put(saCurrent1.hashCode() + "_Assignment 2", "Submitted");
            
            
        }
        
       if(saCurrent2 != null){
            setGrade(saCurrent2, 0.0f);
            submittedAssignments.put(saCurrent2, 4);
            assignmentStatusMap.put(saCurrent2.hashCode() + "_Assignment 1", "Submitted");
            assignmentStatusMap.put(saCurrent2.hashCode() + "_Assignment 2", "Submitted");
            assignmentStatusMap.put(saCurrent2.hashCode() + "_Assignment 3", "Submitted");
            assignmentStatusMap.put(saCurrent2.hashCode() + "_Assignment 4", "Submitted");
            
        }
       
        
       
    }
    
    // Assign Grade
    
    private static void setGrade(SeatAssignment sa, float gradeValue){
        sa.setGrade(gradeValue);
    }
    
    public static int getTotalAssignments(SeatAssignment sa) {
        if (sa == null || sa.getAssociatedCourse() == null) return 0;
        return totalAssignmentsPerCourse.getOrDefault(sa.getAssociatedCourse().getCourseNumber(), 12);
    }

    public static int getSubmittedCount(SeatAssignment sa) {
        return submittedAssignments.getOrDefault(sa, 0);
    }

    public static void submitAssignment(SeatAssignment sa, String assignmentName) {
        String key = sa.hashCode() + "_" + assignmentName;
        if (!"Submitted".equals(assignmentStatusMap.get(key))) {
            assignmentStatusMap.put(key, "Submitted");
            submittedAssignments.put(sa, getSubmittedCount(sa) + 1);
        }
    }

    public static String getAssignmentStatus(SeatAssignment sa, String assignmentName) {
        return assignmentStatusMap.getOrDefault(sa.hashCode() + "_" + assignmentName, "Pending Submission");
    }
    
    // Assignment Scores
    public static String getAssignmentScore(SeatAssignment sa, String assignmentName){
        String status = getAssignmentStatus(sa, assignmentName);
        if(!"Submitted".equals(status)){    //if not yet submitted, no score
            return "-";
        }
        
        float courseGrade = sa.getGrade();
        // Ensure that course grade reflects data elsewhere in project
        if(courseGrade >= 4.0f){
            return"100";
        }else if(courseGrade > 0.0f){
            return String.valueOf(Math.round(courseGrade * 25));
        }
        
        // Default dummy score
        int dummyScore = 85 + (Math.abs(assignmentName.hashCode()) % 15);
        return String.valueOf(dummyScore);
    }
    
    
   // Calculate Progress
    public static double getCourseProgressPercentage(SeatAssignment sa){
        if (sa == null || sa.getAssociatedCourse() == null) return 0.0;
        String courseNo = sa.getAssociatedCourse().getCourseNumber();
        
        int totalExpected = totalAssignmentsPerCourse.getOrDefault(courseNo, 12);
        int completedSubmissions = submittedAssignments.getOrDefault(sa, 0);
        
        return ((double) completedSubmissions / totalExpected) * 100;
    
        
    }
    
    public static String getProgressString(SeatAssignment sa){
        if(sa == null || sa.getAssociatedCourse() == null) return "0/0 Assignments";
        String courseNo = sa.getAssociatedCourse().getCourseNumber();
        
        int totalExpected = totalAssignmentsPerCourse.getOrDefault(courseNo, 12);
        int completedSubmissions = submittedAssignments.getOrDefault(sa, 0);
        
        return String.format("%d of %d Submitted (%.1f%%)", completedSubmissions, totalExpected, getCourseProgressPercentage(sa));
    
    }
    
    
    
    
}
