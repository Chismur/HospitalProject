package com.hospitalproject.services;

import com.hospitalproject.model.DoctorEntity;

import java.util.List;

/**
 * Created by kingm on 26.11.2017.
 */
public interface IDoctorService {
    List<DoctorEntity> getAll();

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
}
