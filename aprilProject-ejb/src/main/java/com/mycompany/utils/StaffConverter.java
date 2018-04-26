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
import com.mycompany.model.DTO.AddressDto;
import com.mycompany.model.entity.Address;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ramen
 */
public class StaffConverter {

    @Inject
    DesignationDAO designationDAO;

    @Inject
    AddressConverter addressConverter;
    
    @Inject
    DesignationConverter designationConverter;

    public StaffDto convertToDto(Staff staff) {
        StaffDto staffDto = new StaffDto();
        staffDto.setId(staff.getId());
        staffDto.setFirstName(staff.getFirstName());
        staffDto.setLastName(staff.getLastName());
        if(staff.getPhoneNumber()!= null){
            staffDto.setPhoneNumber(staff.getPhoneNumber());
        }

        DesignationDto designationDto = new DesignationDto();
        designationDto.setPosition(staff.getDesignation().getPosition());
        designationDto.setSalary(staff.getDesignation().getSalary());
        staffDto.setDesignation(designationDto);
        
        if (staff.getAddress() != null) {
            AddressDto addressDto = addressConverter.convertToDto(staff.getAddress());
            staffDto.setAddress(addressDto);
        }
        

        return staffDto;
    }

    public Staff convertToStaff(StaffDto staffDto) {
        System.out.println("Converting staffDto to staff entity");

        Staff staff = new Staff();
        staff.setFirstName(staffDto.getFirstName());
        staff.setLastName(staffDto.getLastName());

        try {
            Designation designation;
            designation = designationDAO.findByPositionAndSalary(staffDto.getDesignation().getPosition(), staffDto.getDesignation().getSalary());
            
            staff.setDesignation(designation);
        } catch (Exception ex) {
            Designation d = new Designation();
            d.setPosition(staffDto.getDesignation().getPosition());
            d.setSalary(staffDto.getDesignation().getSalary());
            
            staff.setDesignation(d);
        }
        
        if (staffDto.getAddress() != null) {
            AddressDto addressDto = new AddressDto();
            addressDto.setCity(staffDto.getAddress().getCity());
            addressDto.setCountry(staffDto.getAddress().getCountry());
            addressDto.setDistrict(staffDto.getAddress().getDistrict());
            addressDto.setStreet(staffDto.getAddress().getStreet());

            Address address = addressConverter.convertToEntity(addressDto);
            staff.setAddress(address);
        }

        if (staffDto.getPhoneNumber() == null) {
            staff.setPhoneNumber("");
        } else {
            staff.setPhoneNumber(staffDto.getPhoneNumber());
        }
        
        if(staffDto.getPhoneNumber() != null){
            staff.setId(staffDto.getId());
        }

        System.out.println("Converted! " + staff.toString());
        return staff;
    }

    public List<StaffDto> convertListToDtoNoDesignation(List<Staff> staffList) {
        List<StaffDto> staffDtoList = new ArrayList<>();
        for (Staff staff : staffList) {
            StaffDto staffDto = new StaffDto();
            staffDto.setId(staff.getId());
            staffDto.setFirstName(staff.getFirstName());
            staffDto.setLastName(staff.getLastName());
            staffDto.setPhoneNumber(staff.getPhoneNumber());
            staffDtoList.add(staffDto);
        }

        return staffDtoList;
    }

    public List<StaffDto> convertListToDtoWithDesignation(List<Staff> staffList) {
        List<StaffDto> staffDtoList = new ArrayList<>();
        for (Staff staff : staffList) {
            StaffDto staffDto = new StaffDto();
            staffDto.setId(staff.getId());
            staffDto.setFirstName(staff.getFirstName());
            staffDto.setLastName(staff.getLastName());
            staffDto.setPhoneNumber(staff.getPhoneNumber());
            staffDto.setDesignation(designationConverter.convertToDto(staff.getDesignation()));
            staffDtoList.add(staffDto);
        }

        return staffDtoList;
    }
    
    public List<StaffDto> convertListToDtoWithDesignationAndAddress(List<Staff> staffList) {
        List<StaffDto> staffDtoList = new ArrayList<>();
        for (Staff staff : staffList) {
            StaffDto staffDto = new StaffDto();
            staffDto.setId(staff.getId());
            staffDto.setFirstName(staff.getFirstName());
            staffDto.setLastName(staff.getLastName());
            staffDto.setPhoneNumber(staff.getPhoneNumber());
            staffDto.setDesignation(designationConverter.convertToDto(staff.getDesignation()));
            if(staff.getAddress()!=null)
                staffDto.setAddress(addressConverter.convertToDto(staff.getAddress()));
            staffDtoList.add(staffDto);
        }

        return staffDtoList;
    }
}
