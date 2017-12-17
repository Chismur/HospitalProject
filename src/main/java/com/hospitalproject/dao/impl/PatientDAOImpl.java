package com.hospitalproject.dao.impl;

import com.hospitalproject.dao.interfaces.IPatientDAO;
import com.hospitalproject.model.PatientEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kingm on 14.11.2017.
 */
@Repository("PatientDAOImpl")
@Transactional
public class PatientDAOImpl implements IPatientDAO {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HospitalPersistenceUnit");
    @PersistenceContext
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public List<PatientEntity> getAll(){
        String s = "select pe From PatientEntity pe order by pe.idPatient";
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

    @Override
    public void deletePatient(PatientEntity patientEntity) {
        entityManager.remove(entityManager.merge(patientEntity));
    }

    @Override
    public int getPatientId(String name, String surname, Date bDate) {
        Query query = entityManager.createQuery("select pe.id from PatientEntity pe where pe.pName = :n and pe.pSurname = :s and pe.bDate = :d");
        query.setParameter("n",name);
        query.setParameter("s",surname);
        query.setParameter("d",bDate);
        return (int) query.getSingleResult();
    }

    @Override
    public List<PatientEntity> getAllThird() {
        List<PatientEntity> result = new ArrayList<>();
        String s = "select pe From PatientEntity pe order by pe.idPatient";
        List<PatientEntity> p = (List<PatientEntity>)entityManager.createQuery(s).getResultList();
        for (PatientEntity pe:p) {
            char ch = pe.getpName().charAt(0);
            if ((ch >= 'q' && ch <= 'z') || (ch >= 'Q' && ch <= 'Z')){
                result.add(pe);
            }
        }
        return result;
    }

    @Override
    public List<PatientEntity> getAllSecond() {
        List<PatientEntity> result = new ArrayList<>();
        String s = "select pe From PatientEntity pe order by pe.idPatient";
        List<PatientEntity> p = (List<PatientEntity>)entityManager.createQuery(s).getResultList();
        for (PatientEntity pe:p) {
            char ch = pe.getpName().charAt(0);
            if ((ch >= 'h' && ch <= 'p') || (ch >= 'H' && ch <= 'P')){
                result.add(pe);
            }
        }
        return result;
    }

    @Override
    public List<PatientEntity> getAllFirst() {
        List<PatientEntity> result = new ArrayList<>();
        String s = "select pe From PatientEntity pe order by pe.idPatient";
        List<PatientEntity> p = (List<PatientEntity>)entityManager.createQuery(s).getResultList();
        for (PatientEntity pe:p) {
            char ch = pe.getpName().charAt(0);
            if ((ch >= 'a' && ch <= 'g') || (ch >= 'A' && ch <= 'G')){
                result.add(pe);
            }
        }
        return result;
    }
}
