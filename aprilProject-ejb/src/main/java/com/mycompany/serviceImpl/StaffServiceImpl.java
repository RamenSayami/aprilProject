package com.mycompany.serviceImpl;


import com.mycompany.model.DTO.StaffDto;
import com.mycompany.service.StaffService;
import javax.inject.Inject;
import com.mycompany.DAO.staffDAO;
import com.mycompany.model.DTO.DesignationDto;
import com.mycompany.model.entity.Staff;
import com.mycompany.utils.StaffConverter;
import java.util.List;
import javax.ws.rs.core.Response;
import com.mycompany.DAO.DesignationDAO;
import com.mycompany.model.entity.Designation;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ramen
 */
public class StaffServiceImpl implements StaffService{

    @Inject
    staffDAO staffDao;
    
    @Inject
    DesignationDAO designationDAO;
    
    @Inject
    StaffConverter staffConverter;
    
    @Override
    public Response retrieveStaff(long id) {
        Staff staff = staffDao.getStaff(id);
        if(staff == null){
            return Response.status(Response.Status.NO_CONTENT).build();
        }else{
            return Response.ok(StaffConverter.convertToDto(staff)).build();
        }
    }

    @Override
    public boolean addNewStaff(StaffDto staffDto) {
        System.out.println("Adding new staff service entered");
        Staff staff;
        staff = staffConverter.convertToStaff(staffDto);
        
        return staffDao.insert(staff);
    }

    @Override
    public Response findStaffForDesignation(DesignationDto designationDto) {
        try{
            Designation designation = designationDAO.findByPositionAndSalary(designationDto.getPosition(), designationDto.getSalary());
            List<Staff> listOfStaffs = staffDao.findByDesignationFK(designation.getId());
            List<StaffDto> lisfOfStaffDto = staffConverter.convertListToDtoNoDesignation(listOfStaffs);
            return Response.ok(lisfOfStaffDto).build();
        }catch(Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        
    }
    
}
