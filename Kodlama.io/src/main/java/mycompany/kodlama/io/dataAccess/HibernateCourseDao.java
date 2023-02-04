/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mycompany.kodlama.io.dataAccess;

import mycompany.kodlama.io.entities.Course;

/**
 *
 * @author x555u
 */
public class HibernateCourseDao implements CourseDao{

    @Override
    public void add(Course course) {
        System.out.println("Hibernate ile veritabanına eklendi: " + course.getName());
    }

    @Override
    public void delete(Course course) {
        System.out.println("Hibernate ile veritabanından silindi: " + course.getName());
    }
    
}
