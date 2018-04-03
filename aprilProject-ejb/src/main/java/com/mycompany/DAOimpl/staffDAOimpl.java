/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAOimpl;

import com.mycompany.DAO.staffDAO;
import com.mycompany.model.entity.Staff;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ramen
 */
@Stateless
public class staffDAOimpl implements staffDAO {
    
    @PersistenceContext(unitName = "testDb")
    EntityManager entityManager;

    @Override
    public boolean insert(Staff staff) {
        System.out.println("Inserting to Database");
        try{
            entityManager.persist(staff);
            System.out.println("Done");
            return true;
        }catch(Exception e){
            System.out.println("failed");
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Staff getStaff(long id) {
        try{
            return entityManager.find(Staff.class, id);
        }catch(Exception e){
            return null;
        }
    }
    
}
