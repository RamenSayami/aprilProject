/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.model.DTO.MailDto;

/**
 *
 * @author ramen
 */
public interface MailService {
    
    public void sendEmail(MailDto mailDto);
}
