package com.hospitalproject.dao.impl;

import com.hospitalproject.dao.IDoctorDAO;
import com.hospitalproject.model.DoctorEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kingm on 26.11.2017.
 */
@Repository("DoctorDAOImpl")
public class DoctorDAOImpl implements IDoctorDAO {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NewPersistenceUnit");
    @PersistenceContext
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public List<DoctorEntity> getAll() {
        String s = "From DoctorEntity de order by de.idDoctor";
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
}
