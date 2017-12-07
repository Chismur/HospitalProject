package com.hospitalproject.services.impl;

import com.hospitalproject.dao.interfaces.IVisitDAO;
import com.hospitalproject.model.*;
import com.hospitalproject.services.interfaces.IVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by kingm on 06.12.2017.
 */
@Service
public class VisitServiceImpl implements IVisitService {

    @Autowired
    IVisitDAO iVisitDAO;

    @Override
    public List<VisitEntity> getAllVisitsOfPatient(PatientEntity patientEntity) {
        return iVisitDAO.getAllVisitsOfPatient(patientEntity);
    }

    @Override
    public List<DiognosisEntity> getDiognosisOfPatient(PatientEntity patientEntity) {
        return null;
    }

    @Override
    public QueueEntity getQueueByVisit(VisitEntity visitEntity) {
        return iVisitDAO.getQueueByVisit(visitEntity);
    }

    @Override
    public DoctorEntity getDoctorForQueue(QueueEntity queueEntity) {
        return iVisitDAO.getDoctorForQueue(queueEntity);
    }

    @Override
    public VisitEntity getVisitByDate(Date date) {
        return iVisitDAO.getVisitByDate(date);
    }

    @Override
    public List<DiognosisEntity> getAllDiognosisForVisit(VisitEntity visitEntity) {
        return iVisitDAO.getAllDiognosisForVisit(visitEntity);
    }


}
