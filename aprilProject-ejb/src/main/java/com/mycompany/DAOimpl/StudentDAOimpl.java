/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAOimpl;

import com.mycompany.DAO.StudentDAO;
import com.mycompany.model.entity.Student;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ramen
 */
@Stateless
public class StudentDAOimpl implements StudentDAO{

    @PersistenceContext(unitName = "testDb")
    EntityManager entityManager;
    
    @Override
    public boolean insertStudent(Student student) {
        System.out.println("Inserting into database ...");
        try{
            entityManager.refresh(student);
            System.out.println("Success!");
            return true;
        }catch(Exception e){
            System.out.println("Failed!");
            e.printStackTrace();
            return false;
        }
    }
    
}
