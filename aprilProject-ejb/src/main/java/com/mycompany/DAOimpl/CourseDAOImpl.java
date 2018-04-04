/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAOimpl;

import com.mycompany.DAO.CourseDAO;
import com.mycompany.model.entity.Course;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ramen
 */
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
    
}
