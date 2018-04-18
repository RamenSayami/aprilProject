/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.model.DTO.MailDto;
import com.mycompany.service.MailService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author ramen
 */
@Path("/sendMail")
public class MailController {
    
    @Inject
    MailService mailService;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void sendMail(MailDto mailDto){
        mailService.sendEmail(mailDto);
    }
}
