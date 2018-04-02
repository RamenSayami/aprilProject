/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.model.entity.Person;
/**
 *
 * @author ramen
 */
public interface personDAO {
    
    public boolean insertOne(Person person);
    
    public Person getOne(long id);
}
