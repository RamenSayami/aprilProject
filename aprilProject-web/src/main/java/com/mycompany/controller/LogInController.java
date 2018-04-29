/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.entity.User;
import com.mycompany.service.UserService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ramen
 */
@Path("/logger")
public class LogInController {
    
    @Inject
    UserService userService;
    
    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean logIn(User user) {
        System.out.println("Login hit!");
        return userService.login(user);
    }
}
