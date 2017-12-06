package com.hospitalproject.dao.impl;

import com.hospitalproject.dao.interfaces.IQualificationsDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kingm on 27.11.2017.
 */
@Repository("QualificationsDAOImpl")
public class QualificationsDAOImpl implements IQualificationsDAO {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    @PersistenceContext
    private EntityManager entityManager = entityManagerFactory.createEntityManager();


    @Override
    public List<String> getAllQualifications() {
        String s = "Select q.qualification From QualificationEntity q order by q.idQualification";
        return (List<String>)entityManager.createQuery(s).getResultList();
    }

    @Override
    public int getQualificationIdByName(String item) {
        String s ="select q.idQualification From QualificationEntity q where q.qualification = (?1)";
        Query query = entityManager.createQuery(s);
        query.setParameter(1,item);
        return (int)query.getResultList().get(0);
    }
}
