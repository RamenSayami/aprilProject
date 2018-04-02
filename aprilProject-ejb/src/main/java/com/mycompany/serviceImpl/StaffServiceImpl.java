package com.mycompany.serviceImpl;


import com.mycompany.model.DTO.StaffDto;
import com.mycompany.service.StaffService;
import javax.inject.Inject;
import com.mycompany.DAO.staffDAO;
import com.mycompany.model.entity.Staff;
import com.mycompany.utils.StaffConverter;
import javax.ws.rs.core.Response;
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
        Staff staff;
        staff = StaffConverter.convertToStaff(staffDto);
        
        return staffDao.insert(staff);
    }
    
}
