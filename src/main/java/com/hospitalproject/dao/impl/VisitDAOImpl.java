package com.hospitalproject.dao.impl;

import com.hospitalproject.dao.interfaces.IVisitDAO;
import com.hospitalproject.model.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by kingm on 06.12.2017.
 */
@Repository("IVisitDAO")
@Transactional
public class VisitDAOImpl implements IVisitDAO {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HospitalPersistenceUnit");
    @PersistenceContext
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public List<VisitEntity> getAllVisitsOfPatient(PatientEntity patientEntity) {
        Query q = entityManager.createQuery("select ve from VisitEntity ve where ve.patientByIdPatient.idPatient =:patientID");
        q.setParameter("patientID", patientEntity.getIdPatient());
        return (List<VisitEntity>) q.getResultList();
    }

    @Override
    public QueueEntity getQueueByVisit(VisitEntity visitEntity) {
        Query query = entityManager.createQuery("select qe from QueueEntity qe where qe.id =:visitId");
        query.setParameter("visitId",visitEntity.getIdVisit());
        return (QueueEntity) query.getSingleResult();
    }

    @Override
    public DoctorEntity getDoctorForQueue(QueueEntity queueEntity) {
        Query query = entityManager.createQuery("select de from DoctorEntity de where de.id =:queueDocId");
        query.setParameter("queueDocId",queueEntity.getIdDoctor());
        return (DoctorEntity) query.getSingleResult();
    }

    @Override
    public VisitEntity getVisitByDate(Date date) {
        Query query = entityManager.createQuery("select ve from VisitEntity ve where ve.dateCured =:date");
        query.setParameter("date",date);
        return (VisitEntity) query.getSingleResult();
    }

    @Override
    public List<DiognosisEntity> getAllDiognosisForVisit(VisitEntity visitEntity) {
        Query query = entityManager.createQuery("select de.diognosisByDiognosisIdDiognosis from  DiognosisHasVisitEntity de where de.visitIdVisit =:id");
        query.setParameter("id",visitEntity.getIdVisit());
        List<DiognosisEntity> result = query.getResultList();
        return result;
    }

    @Override
    public List<String> getAllDiognosis() {
        String s = "select d.diognosis From DiognosisEntity d order by d.idDiognosis";
        return (List<String>)entityManager.createQuery(s).getResultList();
    }

    @Override
    public void save(VisitEntity visitEntity) {
        entityManager.persist(visitEntity);
    }

    @Override
    public void deleteVisit(VisitEntity v) {
        entityManager.remove(entityManager.merge(v));
    }


}
