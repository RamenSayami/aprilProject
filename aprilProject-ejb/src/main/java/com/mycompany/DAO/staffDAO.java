/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;

import com.mycompany.model.entity.Staff;
import com.mycompany.model.entity.Designation;
import java.util.List;

/**
 *
 * @author ramen
 */
public interface staffDAO {

    public boolean insert(Staff staff);

    public Staff getStaff(long id);

    public List<Staff> findByDesignationFK(Designation fk);

    public List<Staff> getAllStaffs();

    public List<Staff> hibernateGetAllStaffs();

}
