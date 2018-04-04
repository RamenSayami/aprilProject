/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.DTO.CourseDto;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import com.mycompany.service.CourseService;
import javax.ws.rs.POST;
/**
 *
 * @author ramen
 */

@Path("/course")
public class CourseController {
    
    @Inject
    CourseService courseService;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean addCourse(CourseDto courseDto){
        return courseService.insertCourse(courseDto);
        
    }
}
