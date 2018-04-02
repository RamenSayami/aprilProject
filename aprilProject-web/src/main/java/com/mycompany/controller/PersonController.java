/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.DTO.PersonDto;
import com.mycompany.service.PersonService;
import javax.inject.Inject;
import javax.validation.Valid;
//import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ramen
 */
@Path("/person")
public class PersonController {
    
    @Inject
    PersonService personService;
    
    @Inject
    StaffController staffController;
    
    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean addPersonToDatabase(@Valid PersonDto personDto){
        return personService.insertIntoDatabase(personDto);
    }
 
    @GET
    @Path("age/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response displayAge(@PathParam("id") long id){
        return personService.returnAgeOfPerson(id);
    }
    
    @Path("/staff")
    public StaffController getStaff(){
//        StaffController staffs = new StaffController();
        return staffController;
    }
}
