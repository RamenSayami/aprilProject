/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utils;

import com.mycompany.model.DTO.CourseDto;
import java.io.Serializable;
import com.mycompany.model.entity.Student;
import com.mycompany.model.DTO.StudentDto;
import com.mycompany.model.entity.Course;
import java.util.List;
import javax.inject.Inject;
import com.mycompany.DAO.CourseDAO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/**
 *
 * @author ramen
 */
public class StudentConverter implements Serializable {
    
    @Inject
    CourseDAO courseDAO;
    
    public Student convertToStudent(StudentDto studentDto){
        System.out.println("Converting studentDto to Entity...");
        Student student = new Student();
        
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        
        System.out.println("Converting first and lastName done!");
        
        if(studentDto.getCourses() != null){
            System.out.println("Found courses in dto");
            
            Set<Course> courses = new HashSet<>();
            for(CourseDto courseDto : studentDto.getCourses()){
                System.out.println("Finding course.. " + courseDto.getCourseName());
                
                Course course = courseDAO.findByCourseNameAndSemester(courseDto.getCourseName(), courseDto.getSemester());
                if(course == null){
                    courses.add(CourseConverter.convertToEntity(courseDto));
                }else{
                    courses.add(course);
                }
            }
            student.setCourses(courses);
        }
        System.out.println("Converted!");
        return student;
        
    }
    
 
}
