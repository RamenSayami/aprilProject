/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.serviceImpl;

import com.mycompany.DAO.UserDAO;
import com.mycompany.model.entity.User;
import com.mycompany.service.UserService;
import javax.inject.Inject;

/**
 *
 * @author ramen
 */
public class UserServiceImpl implements UserService {

    @Inject
    UserDAO userDao;
    
    @Override
    public boolean login(User user) {
        return userDao.checkInDatabase(user);
    }
    
    
}
