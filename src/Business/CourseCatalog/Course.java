/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.CourseCatalog;

/**
 *
 * @author kal bugrara
 */
public class Course {

    String number;
    String name;
    int credits;
    int price = 1500; //per credit hour

    /**
     * Constructs a new Course instance with the specified name, course number,
     * and credit hours.
     *
     * @param n the name of the course (e.g., "Application Engineering & Development")
     * @param numb the catalog number of the course (e.g., "INFO 5100")
     * @param ch the number of credit hours for the course (e.g., 4)
     */
    public Course(String n, String numb, int ch) {
        name = n;
        number = numb;
        credits = ch;

    }

    /**
     * Retrieves the name of the course.
     *
     * @return the course name
     */
    public String getName() {
        return name;
    }

    /**
     * Updates the name of the course.
     *
     * @param name the new course name to set
     */    
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Retrieves the course number.
     *
     * @return the course number (e.g., "INFO 5100")
     */
    public String getCourseNumber() {
        return number;
    }

    /**
     * Updates the course number.
     *
     * @param number the new course number to set
     */
    public void setCourseNumber(String number) {
        this.number = number;
    }
    
    /**
     * Gets the base tuition rate per credit hour
     * 
     * @return the price per single credit hour
     */    
    public int getPrice() {
        return price;
    }

    /**
     * Sets the base tuition rate per credit hour
     * 
     * @param price the tuition price per credit hour to set
     */
    public void setPrice(int price) {
        this.price = price;
    }
    
    /**
     * Calculates the total tuition cost for the entire course.
     * 
     * Note: this is different from getPrice(), which returns the unit rate per credit hour.
     * 
     * @return the total course tuition price (e.g., 6000 for a 4-credit course)
     */    
    public int getCoursePrice() {
        return price * credits;
    }

    /**
     * Retrieves the credit hours allocated to this course.
     *
     * @return the number of credit hours
     */
    public int getCredits() {
        return credits;
    }

    /**
     * Sets the credit hours allocated to this course.
     *
     * @param credits the number of credit hours to set
     */    
    public void setCredits(int credits) {
        this.credits = credits;
    }
    
    @Override
    public String toString() {
        return number;
    }
}