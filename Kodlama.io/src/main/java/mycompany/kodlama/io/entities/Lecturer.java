/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mycompany.kodlama.io.entities;

import java.util.HashMap;

/**
 *
 * @author x555u
 */
public class Lecturer {
    private String fullName;
    private int id;
    private HashMap<String,Integer> courses;

    public Lecturer(String fullName, int id) {
        this.fullName = fullName;
        this.id = id;
        courses = new HashMap<>();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<String,Integer> getCourses() {
        return courses;
    }

    public void setCourses(Course course) {
        courses.put(course.getName(), course.getId());
    }
}
