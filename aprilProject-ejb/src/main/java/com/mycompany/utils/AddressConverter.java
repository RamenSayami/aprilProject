/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.utils;

import com.mycompany.model.DTO.AddressDto;
import com.mycompany.model.entity.Address;

/**
 *
 * @author ramen    
 */
public class AddressConverter {
    public Address convertToEntity(AddressDto addressDto) {
        Address address = new Address();
        address.setId(addressDto.getId());
        address.setCountry(addressDto.getCountry());
        address.setCity(addressDto.getCity());
        address.setDistrict(addressDto.getDistrict());
        address.setStreet(addressDto.getStreet());

        return address;
    }

    public AddressDto convertToDto(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setCity(address.getCity());
        addressDto.setCountry(address.getCountry());
        addressDto.setDistrict(address.getDistrict());
        addressDto.setStreet(address.getStreet());

        return addressDto;
    }
}
