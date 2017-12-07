package com.hospitalproject.dao.interfaces;

import com.hospitalproject.model.*;

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

    List<DiognosisEntity> getAllDiognosisForVisit(VisitEntity visitEntity);
}
