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
/**
 *
 * @author ramen
 */
public class StaffConverter {
    
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
    
    public static Staff convertToStaff(StaffDto staffDto){
        System.out.println("Converting staffDto to staff entity");
        Designation designation = new Designation();
        designation.setPosition(staffDto.getDesignation().getPosition());
        designation.setSalary(staffDto.getDesignation().getSalary());
        
        Staff staff = new Staff();
        staff.setFirstName(staffDto.getFirstName());
        staff.setLastName(staffDto.getLastName());
        staff.setDesignation(designation);
        
        if(staffDto.getPhoneNumber() == null){
            staff.setPhoneNumber("");
        }else{
            staff.setPhoneNumber(staffDto.getPhoneNumber());
        }
        
        System.out.println("Converted! " + staff.toString());
        return staff;
    }
}
