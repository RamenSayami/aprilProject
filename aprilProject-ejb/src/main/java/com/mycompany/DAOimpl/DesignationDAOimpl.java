/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAOimpl;

import com.mycompany.DAO.DesignationDAO;
import com.mycompany.model.entity.Designation;
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
public class DesignationDAOimpl implements DesignationDAO{
    
    @PersistenceContext(unitName = "testDb")
    EntityManager em;

//    @Override
//    public Designation findOne(String position) {
//        Query query = em.createNamedQuery("Designation.findByPosition").setParameter("pos", position);
//        Designation designationList = (Designation)query.getSingleResult();
//        if(designationList.isEmpty()){
//            return null;
//        }else{
//            return designationList.get(0);
//        }
//        
//    }

    @Override
    public Designation findByPosition(String position) {
        Query query = em.createNamedQuery("Designation.findByPosition").setParameter("pos", position);
        try{
            Designation designation =  (Designation) query.getSingleResult();
            return designation;
        }catch(Exception e){
            System.out.println("No entitiy found");
            return null;
        }
    }

    @Override
    public Designation findByPositionAndSalary(String position, float salary) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
