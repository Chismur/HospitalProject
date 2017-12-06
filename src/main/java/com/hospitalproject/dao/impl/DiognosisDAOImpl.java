package com.hospitalproject.dao.impl;

import com.hospitalproject.dao.interfaces.IDiognosisDAO;
import com.hospitalproject.model.DiognosisEntity;
import com.hospitalproject.model.PatientEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kingm on 06.12.2017.
 */
@Repository("IDiognosisDAO")
public class DiognosisDAOImpl implements IDiognosisDAO {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HospitalPersistenceUnit");
    @PersistenceContext
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public List<DiognosisEntity> getAllDiognosisOfPatient(PatientEntity patientEntity) {
        return null;
    }
}
