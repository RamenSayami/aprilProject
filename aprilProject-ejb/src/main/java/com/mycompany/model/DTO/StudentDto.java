/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.DTO;

import java.util.List;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ramen
 */
public class StudentDto {
    
    @NotNull
    String firstName;
    
    @NotNull
    String lastName;
  
    List<CourseDto> courses;
    
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

    public List<CourseDto> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDto> courses) {
        this.courses = courses;
    }

}