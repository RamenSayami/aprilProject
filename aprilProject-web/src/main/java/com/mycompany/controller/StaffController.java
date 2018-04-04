///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mycompany.controller;
//
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import com.mycompany.model.DTO.StudentDto;
//import javax.inject.Inject;
//import javax.ws.rs.Consumes;
//import javax.ws.rs.POST;
//import javax.ws.rs.core.MediaType;
//import com.mycompany.service.StaffService;
//import javax.ws.rs.core.Response;
///**
// * Sub Resource for Staff data
// * @author ramen
// */
//public class StaffController {
//    
//    @Inject
//    StaffService staffService;
//            
//    @GET
//    @Path("/{id}")
//    public Response getStaffInfo(@PathParam("id") long id){
//        System.out.println("id "+id);
//        System.out.println("Service "+staffService);
//        return staffService.retrieveStaff(id);
//    }
//    
//    @POST
//    @Path("/add")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public boolean newStaff(StudentDto staffDto){
//        return staffService.addNewStaff(staffDto);
//    }
//}
