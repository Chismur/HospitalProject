package com.hospitalproject.dao.interfaces;

import com.hospitalproject.model.PatientEntity;

import java.util.List;

/**
 * Created by kingm on 05.12.2017.
 */
public interface ISocialStatusDAO {
    List<String> getAllSocialStatus();

    String getSocialStatusOfPatient(PatientEntity patientEntity);

}
