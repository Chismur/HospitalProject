package com.hospitalproject.dao.impl;

import com.hospitalproject.dao.interfaces.IVisitDAO;
import com.hospitalproject.model.DoctorEntity;
import com.hospitalproject.model.PatientEntity;
import com.hospitalproject.model.VisitEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kingm on 06.12.2017.
 */
@Repository("IVisitDAO")
public class VisitDAOImpl implements IVisitDAO {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    @PersistenceContext
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public List<VisitEntity> getAllVisitsOfPatient(PatientEntity patientEntity) {
//        Query q = entityManager.createQuery("SELECT c FROM Customer c WHERE c.login.username = :username");
//        q.setParameter("username", username);
//        return (Customer) q.getSingleResult();
        Query q = entityManager.createQuery("select ve from VisitEntity ve where ve.patientByIdPatient.idPatient =:patientID");
        q.setParameter("patientID",patientEntity.getIdPatient());
        return (List<VisitEntity>) q.getResultList();
    }

    @Override
    public List<DoctorEntity> getAllDoctorsForCurrentVisit(VisitEntity visitEntities) {
        return null;
    }
}
