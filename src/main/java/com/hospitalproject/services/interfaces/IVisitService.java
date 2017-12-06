package com.hospitalproject.services.interfaces;

import com.hospitalproject.model.DiognosisEntity;
import com.hospitalproject.model.DoctorEntity;
import com.hospitalproject.model.PatientEntity;
import com.hospitalproject.model.VisitEntity;

import java.util.List;

/**
 * Created by kingm on 06.12.2017.
 */
public interface IVisitService {
    List<VisitEntity> getAllVisitsOfPatient(PatientEntity patientEntity);
    List<DiognosisEntity> getDiognosisOfPatient(PatientEntity patientEntity);
    List<DoctorEntity> getAllDoctorsForVisit(List<VisitEntity> visitEntities);
}
