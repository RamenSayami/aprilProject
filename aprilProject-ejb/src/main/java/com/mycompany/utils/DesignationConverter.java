/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utils;
import com.mycompany.model.DTO.DesignationDto;
import com.mycompany.model.entity.Designation;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author ramen
 */
public class DesignationConverter {
    
    public List<DesignationDto> convertDesignationToDto(List<Designation> designations){
        List<DesignationDto> jobListDtos = new ArrayList<>();
        
        for(Designation des: designations){
            DesignationDto designationDto = new DesignationDto();
            designationDto.setId(des.getId());
            designationDto.setPosition(des.getPosition());
            designationDto.setSalary(des.getSalary());
            
            jobListDtos.add(designationDto);
        }
        return jobListDtos;
    }

    public DesignationDto convertToDto(Designation designation) {
        DesignationDto des = new DesignationDto();
        des.setId(designation.getId());
        des.setPosition(designation.getPosition());
        des.setSalary(designation.getSalary());
        return des;
    }
    
}
