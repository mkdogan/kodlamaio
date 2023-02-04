/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mycompany.kodlama.io.core.logging;

import mycompany.kodlama.io.entities.Course;

/**
 *
 * @author x555u
 */
public class MailLogger implements Logger{
    
    @Override
    public void log(String data){
        System.out.println("Mail gönderildi: " + data);
    }
}
