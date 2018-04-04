/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.model.DTO.CourseDto;

/**
 *
 * @author ramen
 */
public interface CourseService {
    
    public boolean insertCourse(CourseDto courseDto);
    
}
