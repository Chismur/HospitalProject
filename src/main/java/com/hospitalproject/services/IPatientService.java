package com.hospitalproject.services;


import com.hospitalproject.model.PatientEntity;

import java.util.List;

public interface IPatientService {
    PatientEntity getPatientById(int id);

    List<PatientEntity> getAll();

    void addPatient(PatientEntity patientEntity);

    List<String> getAllSocialStatus();

    List<String> getAllCurrentCondition();
}
