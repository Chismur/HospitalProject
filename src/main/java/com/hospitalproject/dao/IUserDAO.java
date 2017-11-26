package com.hospitalproject.dao;

import com.hospitalproject.model.UsersEntity;

/**
 * Created by kingm on 26.11.2017.
 */
public interface IUserDAO {
    UsersEntity getUserById(int idUser );
    void deleteUser(UsersEntity usersEntity);
    UsersEntity getUserByName(String userName);
    UsersEntity getUserByPassword(String userPassword);
}
