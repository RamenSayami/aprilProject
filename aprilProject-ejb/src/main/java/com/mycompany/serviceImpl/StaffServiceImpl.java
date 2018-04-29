package com.mycompany.serviceImpl;

import com.mycompany.model.DTO.StaffDto;
import com.mycompany.service.StaffService;
import javax.inject.Inject;
import com.mycompany.model.DTO.DesignationDto;
import com.mycompany.model.entity.Staff;
import com.mycompany.utils.StaffConverter;
import java.util.List;
import javax.ws.rs.core.Response;
import com.mycompany.DAO.DesignationDAO;
import com.mycompany.model.entity.Designation;
import javax.ws.rs.core.GenericEntity;
import com.mycompany.utils.DesignationConverter;
import com.mycompany.DAO.StaffDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ramen
 */
public class StaffServiceImpl implements StaffService {

    @Inject
    StaffDAO staffDao;

    @Inject
    DesignationDAO designationDAO;

    @Inject
    StaffConverter staffConverter;
    
    @Inject
    DesignationConverter designationConverter;

    @Override
    public Response retrieveStaff(long id) {
        Staff staff = staffDao.getStaff(id);
        if (staff == null) {
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.ok(staffConverter.convertToDto(staff)).build();
        }
    }

    @Override
    public Response addNewStaff(StaffDto staffDto) {
        System.out.println("Adding new staff service entered");
        Staff staff;
        staff = staffConverter.convertToStaff(staffDto);
        try{
            Staff addedStaff = staffDao.insert(staff);
            return Response.ok(addedStaff).build();
        }catch(Exception e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public Response findStaffForDesignation(DesignationDto designationDto) {

        System.out.println("Trying to find designation!");
        System.out.println("designation: "+ designationDto.getPosition() + " salary:" + designationDto.getSalary());
        try {
            Designation designation = designationDAO.findByPositionAndSalary(designationDto.getPosition(), designationDto.getSalary());
            System.out.println("Designation found: " + designation);
            System.out.println("Finging staffs of same designation...");
            List<Staff> listOfStaffs = staffDao.findByDesignationFK(designation);

            System.out.println("Converting list to Dto: ");
            List<StaffDto> lisfOfStaffDto = staffConverter.convertListToDtoWithDesignationAndAddress(listOfStaffs);
            System.out.println("Converted!" + lisfOfStaffDto);
            GenericEntity<List<StaffDto>> entity = new GenericEntity<List<StaffDto>>(lisfOfStaffDto) {
            };

            return Response.ok(entity).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }

    @Override
    public List<StaffDto> getAllStaffs() {
        
        System.out.println("GetAllStaff HIT!");
        List<Staff> staffList = staffDao.getAllStaffs();

        List<StaffDto> staffDtoList = staffConverter.convertListToDtoWithDesignationAndAddress(staffList);

        return staffDtoList;
    }

    @Override
    public List<DesignationDto> getAllJobs() {
        List<Designation> jobList = designationDAO.hibernateGetAllJobs();

        List<DesignationDto> jobListDtos = designationConverter.convertDesignationToDto(jobList);
        
        return jobListDtos;

    }

    @Override
    public List<StaffDto> getAllStaffsHibernate() {
        List<Staff> staffList = staffDao.hibernateGetAllStaffs();
        List<StaffDto> staffListDto = staffConverter.convertListToDtoNoDesignation(staffList);
        return staffListDto;
    }

    @Override
    public Response findStaffWithDesHibernate(DesignationDto designationDto) {
        Designation des = designationDAO.findByPosAndSalHibernate(designationDto.getPosition(), designationDto.getSalary());

        if (des == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        } else {

            List<Staff> staffList = staffDao.findByDesignationFK(des);
            List<StaffDto> staffListDto = staffConverter.convertListToDtoNoDesignation(staffList);

            GenericEntity<List<StaffDto>> entity = new GenericEntity<List<StaffDto>>(staffListDto){};

            return Response.ok(entity).build();
        }
    }

    @Override
    public boolean deleteStaffWithId(long id) {
        Staff staffToDelete = staffDao.getStaff(id);
        staffToDelete = checkForManyRelations(staffToDelete);
        System.out.println("Staff To Delete: " + staffToDelete);
        return staffDao.delete(staffToDelete);
    }
    
    Staff checkForManyRelations(Staff checkThisStaff){
        List<Staff> staffs = staffDao.findByDesignationFK(checkThisStaff.getDesignation());
        Staff checkedStaff = checkThisStaff;
        if(staffs.size()>1){
            checkedStaff.setDesignation(null);
        }
        return checkedStaff;
    }
    
}