package com.hospitalproject.dao.impl;

import com.hospitalproject.dao.interfaces.ISocialStatusDAO;
import com.hospitalproject.model.PatientEntity;
import com.hospitalproject.model.QueueEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kingm on 05.12.2017.
 */
@Repository("SocialStatusDAOImpl")
public class SocialStatusDAOImpl implements ISocialStatusDAO{

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HospitalPersistenceUnit");
    @PersistenceContext
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public List<String> getAllSocialStatus() {
        return entityManager.createQuery("select ss.socialStatus from SocialStatusEntity ss").getResultList();
    }

    @Override
    public String getSocialStatusOfPatient(PatientEntity patientEntity) {
        Query query = entityManager.createQuery("select pe.socialStatusByIdSocialStatus.socialStatus from PatientEntity pe where pe.id = :p");
        query.setParameter("p",patientEntity.getIdPatient());
        return String.valueOf(query.getResultList());
    }


}
