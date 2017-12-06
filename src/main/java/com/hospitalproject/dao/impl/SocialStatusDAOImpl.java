package com.hospitalproject.dao.impl;

import com.hospitalproject.dao.ISocialStatusDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kingm on 05.12.2017.
 */
@Repository("SocialStatusDAOImpl")
public class SocialStatusDAOImpl implements ISocialStatusDAO{

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    @PersistenceContext
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public List<String> getAllSocialStatus() {
        return entityManager.createQuery("select ss.socialStatus from SocialStatusEntity ss").getResultList();
    }
}
