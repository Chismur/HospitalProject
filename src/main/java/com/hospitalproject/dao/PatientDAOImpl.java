package com.hospitalproject.dao;

import com.hospitalproject.model.PatientEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kingm on 14.11.2017.
 */
@Repository("PatientDAOImpl")
public class PatientDAOImpl {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    @PersistenceContext
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    public List<PatientEntity> getAll(){
        String s = "From PatientEntity pe order by pe.idPatient";
        return (List<PatientEntity>)entityManager.createQuery(s).getResultList();
    }

}
