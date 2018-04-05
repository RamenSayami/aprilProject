/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;
import com.mycompany.model.entity.Course;
/**
 *
 * @author ramen
 */
public interface CourseDAO {
    public boolean insertOne(Course course);
    
    public Course findByCourseNameAndSemester(String courseName, int sem);
}
