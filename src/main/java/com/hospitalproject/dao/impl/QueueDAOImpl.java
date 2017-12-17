package com.hospitalproject.dao.impl;

import com.hospitalproject.dao.interfaces.IQueueDAO;
import com.hospitalproject.model.QueueEntity;
import com.hospitalproject.model.TimeEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kingm on 11.12.2017.
 */
@Repository("QueueDAOImpl")
@Transactional
public class QueueDAOImpl implements IQueueDAO {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HospitalPersistenceUnit");
    @PersistenceContext
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public List<String> getTime() {
        List<String> strings = new ArrayList<>();
        Query query = entityManager.createQuery("select t.timeStart from TimeEntity t ");
        for (Object t:query.getResultList()) {
            Time time = (Time) t;
            time.toString();
            strings.add(time.toString());
        }
        return strings;
    }

    @Override
    public List<String> getDays() {
        Query query = entityManager.createQuery("select d.name from DateEntity d ");
        return query.getResultList();
    }

    @Override
    public Integer getTimeByName(String s) {
        Time t = Time.valueOf(s);
        Query query = entityManager.createQuery("select t.id from TimeEntity t where t.timeStart = :n ");
        query.setParameter("n",t);
        return (Integer) query.getSingleResult();
    }

    @Override
    public Integer getDayByName(String s) {
        Query query = entityManager.createQuery("select d.id from DateEntity d where d.name = :n ");
        query.setParameter("n",s);
        return (Integer) query.getSingleResult();
    }

    @Override
    public void save(QueueEntity queueEntity) {
        entityManager.persist(queueEntity);
    }

    @Override
    public void save(Date curDate, int cab, int vhs, int doc, int time, int day, int visis) {
        //  Query query = entityManager.createNativeQuery("INSERT INTO queue_table (current_date,cab_num,visit_h_s_id_visit_h_s,)");

    }
}
