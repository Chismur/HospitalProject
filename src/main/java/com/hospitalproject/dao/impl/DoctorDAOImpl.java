package com.hospitalproject.dao.impl;

import com.hospitalproject.dao.interfaces.IDoctorDAO;
import com.hospitalproject.model.DiognosisEntity;
import com.hospitalproject.model.DoctorEntity;
import com.hospitalproject.model.PatientEntity;
import com.hospitalproject.model.QueueEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kingm on 26.11.2017.
 */
@Repository("DoctorDAOImpl")
@Transactional
//@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class DoctorDAOImpl implements IDoctorDAO {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HospitalPersistenceUnit");
    @PersistenceContext
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public List<DoctorEntity> getAll() {
        String s = "select de From DoctorEntity de order by de.idDoctor";
        return (List<DoctorEntity>)entityManager.createQuery(s).getResultList();
    }

    @Override
    public DoctorEntity getDoctorById(int idDoctor) {
        return entityManager.find(DoctorEntity.class, idDoctor);
    }

    @Override
    public void addDoctor(DoctorEntity doctorEntity) {
        entityManager.persist(doctorEntity);
    }

    @Override
    public void updateDoctor(DoctorEntity doctorEntity) {
        entityManager.merge(doctorEntity);
    }

    @Override
    public void deleteDoctor(DoctorEntity doctorEntity) {
        entityManager.remove(entityManager.merge(doctorEntity));
    }

    @Override
    public List<String> getAllDoctorsNames() {
        String s = "select de.specializationByIdSpecialization.specialization From DoctorEntity de order by de.idDoctor";
        return (List<String>)entityManager.createQuery(s).getResultList();
    }

    @Override
    public int getIdDoctorByName(String specialization) {
        Query query = entityManager.createQuery("select de.id from DoctorEntity de where de.specializationByIdSpecialization.specialization = :name");
        query.setParameter("name",specialization);
        return (int) query.getSingleResult();
    }

    @Override
    public List<DiognosisEntity> getAllDiognosisByDoctor(DoctorEntity doctorEntity, PatientEntity patientEntity) {
        Query query = entityManager.createQuery("select d from DiognosisEntity d join DiognosisHasVisitEntity dv on  d.id = dv.diognosisIdDiognosis join VisitEntity v on v.id = dv.visitIdVisit join QueueEntity q on q.idVisits = v.idVisit join DiognosisEntity doc on doc.id=q.idDoctor where doc.id=:doc and v.id=:p");
        query.setParameter("doc",doctorEntity.getIdDoctor());
        query.setParameter("p",patientEntity.getIdPatient());
        return (List<DiognosisEntity>) query.getResultList();
    }
}
