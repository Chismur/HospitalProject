package com.hospitalproject.services.impl;

import com.hospitalproject.dao.interfaces.IQueueDAO;
import com.hospitalproject.model.QueueEntity;
import com.hospitalproject.services.interfaces.IQueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public List<String> getDays() {
        return null;
    }

    @Override
    public Integer getTimeByName(String s) {
        return null;
    }

    @Override
    public Integer getDayByName(String s) {
        return null;
    }

    @Override
    public void addQueue(QueueEntity queueEntity) {
        iQueueDAO.addQueue(queueEntity);
    }

}
