/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAOimpl;

import com.mycompany.DAO.UserDAO;
import com.mycompany.model.entity.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author ramen
 */
@Stateless
public class UserDAOImpl implements UserDAO{

    @PersistenceContext(unitName = "testDb")
    EntityManager em;
    
    @Override
    public boolean checkInDatabase(User user) {
        try{
            System.out.println("Trying to hit query... username: "+ user.getUserName() + " password: "+ user.getPassword());
            Query query = em.createNamedQuery("User.findByUserNameAndPassword").setParameter("uname", user.getUserName()).setParameter("pass", user.getPassword());
            System.out.println("query result: " + query);
            User result = (User) query.getSingleResult();
            return (result != null);
        }catch(Exception e){
            e.printStackTrace();    
            return false;
        }
    }
    
}
