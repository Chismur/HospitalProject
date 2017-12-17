package com.hospitalproject.services.impl;

import com.hospitalproject.dao.interfaces.IQueueDAO;
import com.hospitalproject.model.QueueEntity;
import com.hospitalproject.services.interfaces.IQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by kingm on 11.12.2017.
 */
@Service
public class QueueServiceImpl implements IQueueService {

    @Autowired
    IQueueDAO iQueueDAO;

    @Override
    public List<String> getTime() {
        return iQueueDAO.getTime();
    }

    @Override
    public List<String> getDays() {
        return iQueueDAO.getDays();
    }

    @Override
    public Integer getTimeByName(String s) {
        return iQueueDAO.getTimeByName(s);
    }

    @Override
    public Integer getDayByName(String s) {
        return iQueueDAO.getDayByName(s);
    }

    @Override
    public void save(QueueEntity queueEntity) {
        iQueueDAO.save(queueEntity);
    }

}
