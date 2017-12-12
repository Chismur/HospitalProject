package com.hospitalproject.services.interfaces;

import com.hospitalproject.model.DiognosisEntity;
import com.hospitalproject.model.DoctorEntity;
import com.hospitalproject.model.PatientEntity;

import java.util.List;

/**
 * Created by kingm on 26.11.2017.
 */
public interface IDoctorService {
    List<DoctorEntity> getAll();

    List<String> getAllDoctorsNames();

    List<String> getAllDoctorPositions();

    List<String> getAllDoctorSpecialisations();

    List<String> getAllDoctorQualifications();

    DoctorEntity getDoctorById(int idDoctor);

    void addDoctor(DoctorEntity doctorEntity);

    void updateDoctor(DoctorEntity doctorEntity);

    int getPositionIdByName(String item);

    int getSpecialisationIdByName(String item);

    int getQualificationIdByName(String item);

    void deleteDoctor(DoctorEntity doctorEntity);

    int getIdDoctorByName(String name);

    List<DiognosisEntity> getAllDiognosisByDoctor(DoctorEntity doctorEntity, PatientEntity patientEntity);
}
