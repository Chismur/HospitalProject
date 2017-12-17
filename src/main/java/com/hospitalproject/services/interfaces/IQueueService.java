package com.hospitalproject.services.interfaces;

import com.hospitalproject.model.QueueEntity;

import java.util.List;

/**
 * Created by kingm on 11.12.2017.
 */
public interface IQueueService {

    List<String> getTime();

    List<String> getDays();

    Integer getTimeByName(String s);

    Integer getDayByName(String s);

    void save(QueueEntity queueEntity);
}
