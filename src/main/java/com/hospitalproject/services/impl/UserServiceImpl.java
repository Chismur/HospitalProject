package com.hospitalproject.services.impl;

import com.hospitalproject.dao.interfaces.IUserDAO;
import com.hospitalproject.model.UsersEntity;
import com.hospitalproject.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kingm on 26.11.2017.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserDAO iUserDAO;

    @Override
    public UsersEntity getUserById(int idUser) {
        return iUserDAO.getUserById(idUser);
    }

    @Override
    public void deleteUser(UsersEntity usersEntity) {
        iUserDAO.deleteUser(usersEntity);
    }

}
