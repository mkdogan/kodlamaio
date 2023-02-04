/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mycompany.kodlama.io.business;

import java.util.HashMap;
import java.util.LinkedList;
import mycompany.kodlama.io.core.logging.Logger;
import mycompany.kodlama.io.dataAccess.CourseDao;
import mycompany.kodlama.io.entities.Course;
import mycompany.kodlama.io.entities.Lecturer;

/**
 *
 * @author x555u
 */
public class CourseManager {

    CourseDao courseDao;
    LinkedList<Logger> loggers;
    static private HashMap<String,Integer> courses; // different course managers should hold the same courses

    public CourseManager(CourseDao courseDao, LinkedList<Logger> loggers) {
        this.courseDao = courseDao;
        this.loggers = loggers;
        courses = new HashMap<>();
        
    }
    public void assignToLecturer(Course course, Lecturer lecturer) {
        if (courses.containsKey(course.getName())){ // if courses contains the course to be assigned the method assigns to lecturer.
            lecturer.setCourses(course);
        }
        else {
            System.out.println(course.getName() + " is no longer exists");
        }
    }        

    public void delete(Course course) {
        if (courses.containsKey(course.getName())) { // if the course exists, the method removes it from courses and from database.
            courses.remove(course.getName(), course.getId());
            courseDao.delete(course);
        }
    }

    public void add(Course course) throws Exception {
        if (course.getPrice() < 0) {
            throw new Exception("Kursun fiyatı 0 'dan küçük olamaz");
        }
        if (courses.containsKey(course.getName())) {
            throw new Exception("Aynı isimli iki kurs olamaz");
        }
        courses.put(course.getName(), course.getId());
        courseDao.add(course);
        
    }

    public HashMap<String,Integer> getCourses() {
        return courses;
    }

    public void setCourses(HashMap<String,Integer> courses) {
        this.courses = courses;
    }

   
}
