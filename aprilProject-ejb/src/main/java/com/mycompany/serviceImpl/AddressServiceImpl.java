/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.serviceImpl;

import com.mycompany.DAO.AddressDAO;
import com.mycompany.model.DTO.AddressDto;
import com.mycompany.model.entity.Address;
import com.mycompany.service.AddressService;
import com.mycompany.utils.AddressConverter;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

/**
 *
 * @author ramen
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class AddressServiceImpl implements AddressService{

    @Inject
    AddressDAO addressDAO;
    
    @Inject
    AddressConverter addressConverter;
    
    @Override
    public boolean addAddress(AddressDto addressDto) {
        Address address = addressConverter.convertToEntity(addressDto);
        return addressDAO.insertIntoDB(address);
    }
    
}
