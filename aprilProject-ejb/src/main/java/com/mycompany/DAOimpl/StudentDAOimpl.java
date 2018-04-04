/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAOimpl;

import com.mycompany.DAO.StudentDAO;
import com.mycompany.model.entity.Student;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ramen
 */
public class StudentDAOimpl implements StudentDAO{

    @PersistenceContext(unitName = "testDb")
    EntityManager entityManager;
    
    @Override
    public boolean insertStudent(Student student) {
        try{
            entityManager.merge(student);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
}