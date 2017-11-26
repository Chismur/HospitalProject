package com.hospitalproject.dao.impl;

import com.hospitalproject.dao.IPatientDAO;
import com.hospitalproject.model.PatientEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kingm on 14.11.2017.
 */
@Repository("PatientDAOImpl")
public class PatientDAOImpl implements IPatientDAO {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    @PersistenceContext
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public List<PatientEntity> getAll(){
        String s = "From PatientEntity pe order by pe.idPatient";
        return (List<PatientEntity>)entityManager.createQuery(s).getResultList();
    }

    @Override
    public PatientEntity getPatientById(int id) {
        return entityManager.find(PatientEntity.class,id);
    }

    @Override
    public void addPatient(PatientEntity patientEntity){
        entityManager.persist(patientEntity);
    }

    @Override
    public void updatePatient(PatientEntity patientEntity) {
        entityManager.merge(patientEntity);
    }
}
