/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.DAO;
import com.mycompany.model.entity.Address;
/**
 *
 * @author ramen
 */
public interface AddressDAO {
    
    public boolean insertIntoDB(Address address);

    public Address insetAddress(Address address);
}
