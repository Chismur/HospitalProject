package com.hospitalproject.dao.impl;

import com.hospitalproject.dao.interfaces.ICurrentConditionDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kingm on 05.12.2017.
 */
@Repository("CurrentConditionDAOImpl")
public class CurrentConditionDAOImpl implements ICurrentConditionDAO {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    @PersistenceContext
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public List<String> getAllCurrentCondition() {
        return entityManager.createQuery("select cc.currentCondition from CurrentConditionEntity cc").getResultList();
    }
}
