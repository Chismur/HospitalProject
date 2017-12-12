package com.hospitalproject.dao.interfaces;

import com.hospitalproject.model.PatientEntity;

import java.sql.Date;
import java.util.List;

/**
 * Created by kingm on 23.11.2017.
 */
public interface IPatientDAO {
    List<PatientEntity> getAll();

    PatientEntity getPatientById(int id);

    void addPatient(PatientEntity patientEntity);

    void updatePatient(PatientEntity patientEntity);

    void deletePatient(PatientEntity patientEntity);

    int getPatientId(String name, String surname, Date bDate);

}
