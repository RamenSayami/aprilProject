/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model.DTO;

import javax.validation.constraints.NotNull;

/**
 *
 * @author ramen
 */
public class DesignationDto {
    
    @NotNull
    String position;
    @NotNull
    float salary;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    
}
