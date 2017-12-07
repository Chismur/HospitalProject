package com.hospitalproject.services.interfaces;


import com.hospitalproject.model.PatientEntity;

import java.util.Collection;
import java.util.List;

public interface IPatientService {
    PatientEntity getPatientById(int id);

    List<PatientEntity> getAll();

    void addPatient(PatientEntity patientEntity);

    List<String> getAllSocialStatus();

    List<String> getAllCurrentCondition();

    void deletePatient(PatientEntity patientEntity);

    String getSocialStatusOfPatient(PatientEntity patientEntity);

    String getCurrentConditionOfPatient(PatientEntity patientEntity);
}
