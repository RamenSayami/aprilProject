/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.DTO;

import java.util.Date;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ramen
 */
public class PersonDto {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private long birthUnixTime;
    private Date dateOfBirth;
    private int age;

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

    public long getBirthUnixTime() {
        return birthUnixTime;
    }

    public void setBirthUnixTime(long birthUnixTime) {
        this.birthUnixTime = birthUnixTime;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
