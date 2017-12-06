package com.hospitalproject.dao.impl;

import com.hospitalproject.dao.interfaces.IPositionsDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by kingm on 27.11.2017.
 */
@Repository("PositionsDAOImpl")
public class PositionsDAOImpl implements IPositionsDAO {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HospitalPersistenceUnit");
    @PersistenceContext
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public ArrayList<String> getAllPositions() {
        String s = "Select p.position From PositionEntity p order by p.idPosition";
        return (ArrayList<String>)entityManager.createQuery(s).getResultList();
    }

    @Override
    public int getPositionIdByName(String item) {
        String s ="select pose.idPosition From PositionEntity pose where pose.position = (?1)";
        Query query = entityManager.createQuery(s);
        query.setParameter(1,item);
        return (int)query.getResultList().get(0);
    }
}
