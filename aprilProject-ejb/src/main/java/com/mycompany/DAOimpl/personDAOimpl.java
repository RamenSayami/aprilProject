/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAOimpl;

import com.mycompany.DAO.personDAO;
import com.mycompany.model.entity.Person;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

/**
 *
 * @author ramen
 */
@Stateless
public class personDAOimpl implements personDAO {

    @PersistenceContext(unitName = "testDb")
    EntityManager entityManager;

    @Override
    public boolean insertOne(Person person) {
        try {
            entityManager.persist(person);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Person getOne(long id) {
        try {
            Person person = entityManager.find(Person.class, id);
            return person;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
