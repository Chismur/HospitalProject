package com.hospitalproject.dao.interfaces;

import com.hospitalproject.model.DiognosisEntity;
import com.hospitalproject.model.PatientEntity;

import java.util.List;

/**
 * Created by kingm on 06.12.2017.
 */
public interface IDiognosisDAO {
    List<DiognosisEntity> getAllDiognosisOfPatient(PatientEntity patientEntity);
}
