package com.hospitalproject.services.impl;

import com.hospitalproject.dao.interfaces.IVisitDAO;
import com.hospitalproject.model.DiognosisEntity;
import com.hospitalproject.model.DoctorEntity;
import com.hospitalproject.model.PatientEntity;
import com.hospitalproject.model.VisitEntity;
import com.hospitalproject.services.interfaces.IVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<DoctorEntity> getAllDoctorsForVisit(List<VisitEntity> visitEntities) {

        return null;
    }
}
