package com.hospitalproject.services.interfaces;

import com.hospitalproject.model.UsersEntity;

/**
 * Created by kingm on 26.11.2017.
 */
public interface IUserService {
    UsersEntity getUserById(int idUser);

    void deleteUser(UsersEntity usersEntity);
}
