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

    @Override
    public Designation findOne(String position) {
        Query query = em.createNamedQuery("Designation.findByPosition").setParameter("pos", position);
        List<Designation> designationList = query.getResultList();
        if(designationList.isEmpty()){
            return null;
        }else{
            return designationList.get(0);
        }
        
    }
    
    
    
    
}
