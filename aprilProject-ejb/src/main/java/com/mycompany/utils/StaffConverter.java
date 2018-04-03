/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utils;
import com.mycompany.model.entity.Course;
import com.mycompany.model.DTO.StaffDto;
/**
 *
 * @author ramen
 */
public class StaffConverter {
    
    public static StaffDto convertToDto(Course staff){
        StaffDto staffDto = new StaffDto();
        staffDto.setFirstName(staff.getFirstName());
        staffDto.setLastName(staff.getLastName());
        staffDto.setPosition(staff.getPosition());
        
        return staffDto;
    }
    
    public static Course convertToStaff(StaffDto staffDto){
        Course staff = new Course();
        staff.setFirstName(staffDto.getFirstName());
        staff.setLastName(staffDto.getLastName());
        staff.setPosition(staffDto.getPosition());
        
        return staff;
    }
}
