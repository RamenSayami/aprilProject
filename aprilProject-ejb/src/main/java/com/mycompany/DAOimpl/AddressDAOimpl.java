/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAOimpl;

import com.mycompany.DAO.AddressDAO;
import com.mycompany.model.entity.Address;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

/**
 *
 * @author ramen
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class AddressDAOimpl implements AddressDAO{

    @PersistenceContext(unitName = "testDb")
    EntityManager entityManager;
    
    @Resource
    UserTransaction transaction;
    
    @Override
    public boolean insertIntoDB(Address address) {
        try{
            transaction.begin();
            entityManager.persist(address);
            transaction.commit();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        
    }
    
}
