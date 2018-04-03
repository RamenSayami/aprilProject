/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.DTO;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 *
 * @author ramen
 */
public class StaffDto {

    @NotNull
    String firstName;
    @NotNull
    String lastName;

    @NotNull
    DesignationDto designation;

    @Pattern(regexp = "\\d{10}", message = "InvalidPhonenumber")
    String phoneNumber;

    public String getFirstName() {
        return firstName;
        
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DesignationDto getDesignation() {
        return designation;
    }

    public void setDesignation(DesignationDto designation) {
        this.designation = designation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
