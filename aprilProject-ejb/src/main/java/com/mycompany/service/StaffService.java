/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;
import com.mycompany.model.DTO.DesignationDto;
import com.mycompany.model.DTO.StaffDto;
import com.mycompany.model.entity.Designation;
import java.util.List;
import javax.ws.rs.core.Response;
/**
 *
 * @author ramen
 */
public interface StaffService {
    
    public Response retrieveStaff(long id);
    
    public boolean addNewStaff(StaffDto staffDto);
    
    public Response findStaffForDesignation(DesignationDto designationDto);
    
    public Response findStaffWithDesHibernate(DesignationDto designationDto);
    
    public List<StaffDto> getAllStaffs();
    
    public List<DesignationDto> getAllJobs();
    
    public List<StaffDto> getAllStaffsHibernate();
}
