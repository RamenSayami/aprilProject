/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utils;
import com.mycompany.model.DTO.DesignationDto;
import com.mycompany.model.entity.Staff;
import com.mycompany.model.DTO.StaffDto;
import com.mycompany.model.entity.Designation;
import javax.inject.Inject;
import com.mycompany.DAO.DesignationDAO;
/**
 *
 * @author ramen
 */
public class StaffConverter {
    
    @Inject
    DesignationDAO designationDAO;
         
    
    public static StaffDto convertToDto(Staff staff){
        DesignationDto designationDto = new DesignationDto();
        designationDto.setPosition(staff.getDesignation().getPosition());
        designationDto.setSalary(staff.getDesignation().getSalary());
        
        StaffDto staffDto = new StaffDto();
        staffDto.setFirstName(staff.getFirstName());
        staffDto.setLastName(staff.getLastName());
        staffDto.setDesignation(designationDto);
        
        return staffDto;
    }
    
    public Staff convertToStaff(StaffDto staffDto){
        System.out.println("Converting staffDto to staff entity");
        
        Staff staff = new Staff();
        staff.setFirstName(staffDto.getFirstName());
        staff.setLastName(staffDto.getLastName());
        
        Designation designation = designationDAO.findByPosition(staffDto.getDesignation().getPosition());
        
        if(designation == null){
            Designation d = new Designation();
            d.setPosition(staffDto.getDesignation().getPosition());
            d.setSalary(staffDto.getDesignation().getSalary());
            staff.setDesignation(d);
        }else{
            staff.setDesignation(designation);
        }
        
        if(staffDto.getPhoneNumber() == null){
            staff.setPhoneNumber("");
        }else{
            staff.setPhoneNumber(staffDto.getPhoneNumber());
        }
        
        System.out.println("Converted! " + staff.toString());
        return staff;
    }
}
