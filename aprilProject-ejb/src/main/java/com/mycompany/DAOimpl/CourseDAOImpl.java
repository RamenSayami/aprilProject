/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAOimpl;

import com.mycompany.DAO.CourseDAO;
import com.mycompany.model.entity.Course;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ramen
 */
@Stateless
public class CourseDAOImpl implements CourseDAO{

    @PersistenceContext(unitName = "testDb")
    EntityManager entityManager;
    
    @Override
    public boolean insertOne(Course course) {
        try{
            entityManager.persist(course);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public Course findByCourseNameAndSemester(String courseName, int sem) {
        System.out.println("findByCourseNameAndSemester ... ");
        Query query = entityManager.createNamedQuery("Course.findByCourseNameAndSemester").setParameter("courseName", courseName).setParameter("sem", sem);
        List<Course> courses = query.getResultList();
        if(courses.isEmpty()){
            System.out.println("Not Found!");
            return null;
        }
        else{
            System.out.println("Found!");
            return courses.get(0);
        }
    }
    
}
