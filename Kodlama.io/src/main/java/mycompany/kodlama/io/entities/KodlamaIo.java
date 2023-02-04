package mycompany.kodlama.io.entities;


import java.util.LinkedList;
import java.util.Map;
import mycompany.kodlama.io.business.CourseManager;
import mycompany.kodlama.io.core.logging.DatabaseLogger;
import mycompany.kodlama.io.core.logging.FileLogger;
import mycompany.kodlama.io.core.logging.Logger;
import mycompany.kodlama.io.core.logging.MailLogger;
import mycompany.kodlama.io.dataAccess.HibernateCourseDao;
import mycompany.kodlama.io.dataAccess.JdbcCourseDao;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
/**
 *
 * @author x555u
 */
public class KodlamaIo {

    public static void main(String[] args) throws Exception {
        LinkedList <Logger> loggers = new LinkedList<>();
        loggers.add(new DatabaseLogger());
        loggers.add(new FileLogger());
        loggers.add(new MailLogger());
        CourseManager manager2 = new CourseManager(new HibernateCourseDao(), loggers);
        CourseManager manager1 = new CourseManager(new JdbcCourseDao(), loggers);

        Lecturer lecturer1 = new Lecturer("Engin Demiroğ", 101);
        Lecturer lecturer2 = new Lecturer("Murat İspir", 102);
        Lecturer lecturer3 = new Lecturer("Yılmaz Kötekçi", 103);

        Course course1 = new Course("Java Kampı", 1, Category.PROGRAMLAMA, 100);
        Course course2 = new Course("Siber Tehdit İstihbaratı", 2, Category.SİBER_GÜVENLİK, 200);
        Course course3 = new Course("Linux işletim sistemine giriş", 3, Category.İŞLETİM_SİSTEMLERİ, 150);

        manager2.add(course1);
        manager1.add(course2);
        manager2.add(course3);

        manager2.assignToLecturer(course1, lecturer1);
        manager2.assignToLecturer(course2, lecturer2);
        manager2.assignToLecturer(course3, lecturer3);
        System.out.println("--------------------------------------");
        manager2.delete(course3);

        manager2.assignToLecturer(course2, lecturer3);
        manager2.assignToLecturer(course3, lecturer2); // it cannot assign course3 because the course is deleted in row 50.
        manager2.assignToLecturer(course1, lecturer1);
        System.out.println("--------------------------------------");
        for (Logger logger: loggers){
            for(Map.Entry<String,Integer> set : manager1.getCourses().entrySet()){
                logger.log(set.getKey());
            }
            
            
        
        }
    }
}
