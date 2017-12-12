package com.hospitalproject.dao.interfaces;

import com.hospitalproject.model.DiognosisEntity;
import com.hospitalproject.model.DoctorEntity;
import com.hospitalproject.model.PatientEntity;

import java.util.List;

/**
 * Created by kingm on 26.11.2017.
 */
public interface IDoctorDAO {
    List<DoctorEntity> getAll();

    DoctorEntity getDoctorById(int idDoctor);

    void addDoctor(DoctorEntity doctorEntity);

    void updateDoctor(DoctorEntity doctorEntity);

    void deleteDoctor(DoctorEntity doctorEntity);

    List<String> getAllDoctorsNames();

    int getIdDoctorByName(String name);

    List<DiognosisEntity> getAllDiognosisByDoctor(DoctorEntity doctorEntity, PatientEntity patientEntity);

}
