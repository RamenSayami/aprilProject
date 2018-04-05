/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.serviceImpl;

import com.mycompany.model.DTO.StudentDto;
import com.mycompany.service.StudentService;
import javax.inject.Inject;
import com.mycompany.DAO.StudentDAO;
import com.mycompany.model.entity.Student;
import com.mycompany.utils.StudentConverter;
/**
 *
 * @author ramen
 */
public class StudentServiceImpl implements StudentService{

    @Inject
    StudentDAO studentDAO;
    
    @Inject
    StudentConverter studentConverter;
    
    @Override
    public boolean addStudent(StudentDto studentDto) {
        System.out.println("Entered addStudent Service");
        Student student = studentConverter.convertToStudent(studentDto);
        return studentDAO.insertStudent(student);
    }
    
}
