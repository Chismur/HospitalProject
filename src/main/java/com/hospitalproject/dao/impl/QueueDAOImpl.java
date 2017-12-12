package com.hospitalproject.dao.impl;

import com.hospitalproject.dao.interfaces.IQueueDAO;
import com.hospitalproject.model.QueueEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kingm on 11.12.2017.
 */
@Repository("QueueDAOImpl")
@Transactional
public class QueueDAOImpl implements IQueueDAO {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HospitalPersistenceUnit");
    @PersistenceContext
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public List<String> getTime() {
        return null;
    }

    @Override
    public List<String> getDays() {
        return null;
    }

    @Override
    public Integer getTimeByName(String s) {
        return null;
    }

    @Override
    public Integer getDayByName(String s) {
        return null;
    }

    @Override
    public void addQueue(QueueEntity queueEntity) {
        entityManager.persist(queueEntity);
    }


}
