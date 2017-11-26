package com.hospitalproject.dao.impl;

import com.hospitalproject.dao.IUserDAO;
import com.hospitalproject.model.UsersEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

/**
 * Created by kingm on 26.11.2017.
 */
@Repository("UserDAOImpl")
public class UserDAOImpl implements IUserDAO {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    @PersistenceContext
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public UsersEntity getUserById(int idUser) {
        return entityManager.find(UsersEntity.class, idUser) ;
    }

    @Override
    public void deleteUser(UsersEntity usersEntity) {
        entityManager.remove(usersEntity);
    }

    @Override
    public UsersEntity getUserByName(String userName) {
        return null;
    }

    @Override
    public UsersEntity getUserByPassword(String userPassword) {
        return null;
    }
}
