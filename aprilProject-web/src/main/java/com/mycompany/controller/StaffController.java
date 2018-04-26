/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.DTO.DesignationDto;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import com.mycompany.service.StaffService;
import java.util.List;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import com.mycompany.model.DTO.StaffDto;
import javax.ws.rs.DELETE;

/**
 * Sub Resource for Staff data
 *
 * @author ramen
 */
@Path("/worker")
public class StaffController {

    @Inject
    StaffService staffService;

    @GET
    @Path("/{id}")
    public Response getStaffInfo(@PathParam("id") long id) {
        System.out.println("id " + id);
        System.out.println("Service " + staffService);
        return staffService.retrieveStaff(id);
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newStaff(StaffDto staffDto) {
        System.out.println("Entered adding new staff controller, REST api is hit!");
        System.out.println("StaffDto -> Address"+ staffDto.getAddress().getCity());
        return staffService.addNewStaff(staffDto);
    }

    @POST
    @Path("/getStaff")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findStaff(DesignationDto designationDto) {
        System.out.println("Entered finding staffs according to designations");
        return staffService.findStaffForDesignation(designationDto);
    }

    @POST
    @Path("/hibernate/getStaff")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findStaffHibernate(DesignationDto designationDto) {
        System.out.println("Entered finding staffs according to designations with hibernate criterions");
        return staffService.findStaffWithDesHibernate(designationDto);
    }

    @GET
    @Path("/getAllStaffs")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StaffDto> getAllStaff() {
        return staffService.getAllStaffs();
    }

    @GET
    @Path("/getAllJobs")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DesignationDto> getAllJobs() {
        return staffService.getAllJobs();
    }

    @GET
    @Path("/hibernate/getAllStaffs")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StaffDto> getAllStaffsHibernate() {
        return staffService.getAllStaffsHibernate();
    }
    
    @DELETE
    @Path("/delete/{id}")
    public boolean deleteStaff(@PathParam("id") long id){
        System.out.println("Delete staff hit!");
        return staffService.deleteStaffWithId(id);
    }
}
