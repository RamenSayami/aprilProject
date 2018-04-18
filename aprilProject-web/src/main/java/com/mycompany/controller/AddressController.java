package com.mycompany.controller;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import com.mycompany.model.DTO.AddressDto;
import com.mycompany.service.AddressService;
import javax.inject.Inject;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ramen
 */
@Path("/address")
public class AddressController {
    
    @Inject
    AddressService addressService;
    
    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean addAddress(AddressDto addressDto){
        return  addressService.addAddress(addressDto);
    }
}
