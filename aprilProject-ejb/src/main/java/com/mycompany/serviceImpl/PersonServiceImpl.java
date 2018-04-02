/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.serviceImpl;

import com.mycompany.model.DTO.PersonDto;
import com.mycompany.DAO.personDAO;
import com.mycompany.service.PersonService;
import javax.inject.Inject;
import com.mycompany.model.entity.Person;
import com.mycompany.utils.PersonConverter;
import java.util.Date;
import javax.ws.rs.core.Response;

/**
 *
 * @author ramen
 */
public class PersonServiceImpl implements PersonService {

    @Inject
    personDAO personDao;

    @Override
    public boolean insertIntoDatabase(PersonDto personDto) {
        //calculate date here, and then convert to entity... 

        Person person = PersonConverter.convertToEntity(personDto);

        return personDao.insertOne(person);
    }

    @Override
    public Response returnAgeOfPerson(long id) {
        Person person = personDao.getOne(id);

        if (person != null) {
            PersonDto personWithAge = PersonConverter.convertToDto(person);

            long today = (new Date().getTime()) / 1000;
            long bday = (person.getDateOfBirth().getTime()) / 1000;
            int age = Math.round(today - bday) / 31536000;
            personWithAge.setAge(age);
            
            return Response.ok(personWithAge).build();
            
        } else {
            System.out.println("Hello ==========");
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
