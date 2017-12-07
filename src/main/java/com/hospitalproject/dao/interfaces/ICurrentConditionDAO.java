package com.hospitalproject.dao.interfaces;

import com.hospitalproject.model.PatientEntity;

import java.util.List;

/**
 * Created by kingm on 05.12.2017.
 */
public interface ICurrentConditionDAO {
    List<String> getAllCurrentCondition();

    String getCurrentConditionOfPatient(PatientEntity patientEntity);
}
