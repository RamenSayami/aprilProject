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
import javax.ws.rs.core.GenericEntity;
import com.mycompany.utils.DesignationConverter;
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
        
        System.out.println("Trying to find designation!");
        try{
            Designation designation = designationDAO.findByPositionAndSalary(designationDto.getPosition(), designationDto.getSalary());
            System.out.println("Designation found: "+ designation);
            System.out.println("Finging staffs of same designation...");
            List<Staff> listOfStaffs = staffDao.findByDesignationFK(designation);
            
            System.out.println("Converting list to Dto: ");
            List<StaffDto> lisfOfStaffDto = staffConverter.convertListToDtoNoDesignation(listOfStaffs);
            System.out.println("Converted!" + lisfOfStaffDto);
            GenericEntity<List<StaffDto>> entity = new GenericEntity<List<StaffDto>>(lisfOfStaffDto) {};

            return Response.ok(entity).build();
        }catch(Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        
    }

    @Override
    public List<StaffDto> getAllStaffs() {
        List<Staff> staffList =  staffDao.getAllStaffs();
        
        List<StaffDto> staffDtoList = staffConverter.convertListToDtoNoDesignation(staffList);
        
        return staffDtoList;
    }

    @Override
    public List<DesignationDto> getAllJobs() {
        List<Designation> jobList =  designationDAO.hibernateGetAllJobs();
        
        List<DesignationDto> jobListDtos = DesignationConverter.convertDesignationToDto(jobList);
        
        return jobListDtos;
        
    }
    
}
