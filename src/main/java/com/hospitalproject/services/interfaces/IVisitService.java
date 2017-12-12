package com.hospitalproject.services.interfaces;

import com.hospitalproject.model.*;

import java.util.Date;
import java.util.List;

/**
 * Created by kingm on 06.12.2017.
 */
public interface IVisitService {
    List<VisitEntity> getAllVisitsOfPatient(PatientEntity patientEntity);

    List<DiognosisEntity> getDiognosisOfPatient(PatientEntity patientEntity);

    QueueEntity getQueueByVisit(VisitEntity visitEntity);

    DoctorEntity getDoctorForQueue(QueueEntity queueEntity);

    VisitEntity getVisitByDate(Date date);

    List<DiognosisEntity> getAllDiognosisForVisit(VisitEntity visitEntity);

    List<String> getAllDiognosis();

    void addVisit(VisitEntity visitEntity);

    void deleteVisit(VisitEntity v);
}
