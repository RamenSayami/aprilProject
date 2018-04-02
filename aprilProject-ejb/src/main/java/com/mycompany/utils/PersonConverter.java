/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utils;

import com.mycompany.model.entity.Person;
import com.mycompany.model.DTO.PersonDto;
import java.util.Date;

/**
 *
 * @author ramen
 */
public class PersonConverter {
    
    public static Person convertToEntity(PersonDto personDto){
        Person personEntity = new Person();
        personEntity.setFirstName(personDto.getFirstName());
        personEntity.setLastName(personDto.getLastName());
        
        long dateOfBirthInMs = personDto.getBirthUnixTime();
        Date dob = new Date(dateOfBirthInMs);
        personEntity.setDateOfBirth(dob);
        System.out.println(""+ dob);
        return personEntity;
    }
    
    public static PersonDto convertToDto(Person person){
        
        PersonDto personDto = new PersonDto();
        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());
        personDto.setDateOfBirth(person.getDateOfBirth());
        
        return personDto;
    }
}
