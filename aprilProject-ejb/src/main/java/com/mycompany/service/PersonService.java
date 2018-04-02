/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.service;

import com.mycompany.model.DTO.PersonDto;
import javax.ws.rs.core.Response;

/**
 *
 * @author ramen
 */
public interface PersonService {
    
    public boolean insertIntoDatabase(PersonDto personDto);
    
    public Response returnAgeOfPerson(long id);
}
