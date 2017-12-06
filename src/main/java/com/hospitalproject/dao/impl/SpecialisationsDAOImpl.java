package com.hospitalproject.dao.impl;

import com.hospitalproject.dao.interfaces.ISpecialisationsDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kingm on 27.11.2017.
 */
@Repository("SpecialisationsDAOImpl")
public class SpecialisationsDAOImpl implements ISpecialisationsDAO {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HospitalPersistenceUnit");
    @PersistenceContext
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public List<String> getAllSpecialisations() {
        String s = "Select s.specialization From SpecializationEntity s order by s.idSpecialization";
        return (List<String>)entityManager.createQuery(s).getResultList();
    }

    @Override
    public int getSpecialisationIdByName(String item) {
        String s ="select s.idSpecialization From SpecializationEntity s where s.specialization = (?1)";
        Query query = entityManager.createQuery(s);
        query.setParameter(1,item);
        return (int)query.getResultList().get(0);
    }
}
