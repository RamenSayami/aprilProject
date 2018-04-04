/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.DTO.StudentDto;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import com.mycompany.service.StudentService;
import javax.ws.rs.POST;
/**
 *
 * @author ramen
 */
@Path("/student")
public class StudentController {
    
    @Inject
    StudentService studentService;
    
    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean addStudent(StudentDto studentDto){
        System.out.println("Entered rest controller Student/Add");
        return studentService.addStudent(studentDto);
    }
}
