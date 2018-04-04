/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utils;

import java.io.Serializable;
import com.mycompany.model.entity.Student;
import com.mycompany.model.DTO.StudentDto;
import com.mycompany.model.entity.Course;
import java.util.List;
/**
 *
 * @author ramen
 */
public class StudentConverter implements Serializable {
    
    public static Student convertToStudent(StudentDto studentDto){
        Student student = new Student();
        
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        if(studentDto.getCourses() != null){
//            List<Course> courses = 
//            student.setCourses(studentDto.getCourses());
            
        }
        return student;
        
    }
    
 
}
