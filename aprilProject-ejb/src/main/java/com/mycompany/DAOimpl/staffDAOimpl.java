/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAOimpl;

import com.mycompany.DAO.DesignationDAO;
import com.mycompany.DAO.staffDAO;
import com.mycompany.model.entity.Staff;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.mycompany.model.entity.Designation;
/**
 *
 * @author ramen
 */
@Stateless
public class staffDAOimpl implements staffDAO {
    
    @PersistenceContext(unitName = "testDb")
    EntityManager entityManager;
    
    private DesignationDAO designationDAO;

    @Override
    public boolean insert(Staff staff) {
        System.out.println("Inserting to Database");
        try{
                entityManager.merge(staff);
                
////            staff.setDesignation(designationDAO.findOne("1"));
//            Designation d = designationDAO.findOne(staff.getDesignation().getPosition(), staff.getDesignation().getSalary());
//            if(d == null) {
//            }else{
//                staff.getDesignation().setId(d.getId());
//            }
//            
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
