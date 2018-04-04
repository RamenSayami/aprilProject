/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utils;

import com.mycompany.model.entity.Course;
import com.mycompany.model.DTO.CourseDto;

/**
 *
 * @author ramen
 */
public class CourseConverter {

    public static Course convertToEntity(CourseDto courseDto) {
        Course course = new Course();
        course.setCourseName(courseDto.getCourseName());
        course.setSemester(courseDto.getSemester());

        return course;
    }
}
