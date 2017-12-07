package com.hospitalproject.dao.impl;

import com.hospitalproject.dao.interfaces.ICurrentConditionDAO;
import com.hospitalproject.model.PatientEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kingm on 05.12.2017.
 */
@Repository("CurrentConditionDAOImpl")
public class CurrentConditionDAOImpl implements ICurrentConditionDAO {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HospitalPersistenceUnit");
    @PersistenceContext
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public List<String> getAllCurrentCondition() {
        return entityManager.createQuery("select cc.currentCondition from CurrentConditionEntity cc").getResultList();
    }

    @Override
    public String getCurrentConditionOfPatient(PatientEntity patientEntity) {
        Query query = entityManager.createQuery("select pe.currentConditionByIdCurrentCondition.currentCondition from PatientEntity pe where pe.id = :p");
        query.setParameter("p",patientEntity.getIdPatient());
        return String.valueOf(query.getResultList());
    }
}
