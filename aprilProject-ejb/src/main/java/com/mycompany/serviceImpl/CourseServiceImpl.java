/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.serviceImpl;

import com.mycompany.DAO.CourseDAO;
import com.mycompany.model.DTO.CourseDto;
import com.mycompany.service.CourseService;
import javax.inject.Inject;
import com.mycompany.model.entity.Course;
import com.mycompany.utils.CourseConverter;
/**
 *
 * @author ramen
 */
public class CourseServiceImpl implements CourseService{

    @Inject
    CourseDAO courseDao;
    
    @Override
    public boolean insertCourse(CourseDto courseDto) {
        Course course = CourseConverter.convertToEntity(courseDto);
        
        return courseDao.insertOne(course);
              
    }
    
}
