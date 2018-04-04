/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;
import com.mycompany.model.entity.Designation;

/**
 *
 * @author ramen
 */
public interface DesignationDAO {
    
    public Designation findByPosition(String position);
    
    public Designation findByPositionAndSalary(String position, float salary) throws Exception;

}