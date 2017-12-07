package com.hospitalproject.dao.interfaces;

import com.hospitalproject.model.DoctorEntity;
import com.hospitalproject.model.PatientEntity;
import com.hospitalproject.model.QueueEntity;
import com.hospitalproject.model.VisitEntity;

import java.util.Date;
import java.util.List;

/**
 * Created by kingm on 06.12.2017.
 */
public interface IVisitDAO {
    List<VisitEntity> getAllVisitsOfPatient(PatientEntity patientEntity);
    QueueEntity getQueueByVisit(VisitEntity visitEntity);
    DoctorEntity getDoctorForQueue(QueueEntity queueEntity);

    VisitEntity getVisitByDate(Date date);
}
