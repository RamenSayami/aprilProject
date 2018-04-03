/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.model.entity.Student;
/**
 *
 * @author ramen
 */
public interface personDAO {
    
    public boolean insertOne(Student person);
    
    public Student getOne(long id);
}
