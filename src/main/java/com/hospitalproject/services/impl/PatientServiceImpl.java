package com.hospitalproject.services.impl;

import com.hospitalproject.dao.interfaces.ICurrentConditionDAO;
import com.hospitalproject.dao.interfaces.IPatientDAO;
import com.hospitalproject.dao.interfaces.ISocialStatusDAO;
import com.hospitalproject.model.PatientEntity;
import com.hospitalproject.services.interfaces.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kingm on 14.11.2017.
 */
@Service
public class PatientServiceImpl implements IPatientService {
    @Autowired
    IPatientDAO patientDAO;

    @Autowired
    ISocialStatusDAO iSocialStatusDAO;

    @Autowired
    ICurrentConditionDAO iCurrentConditionDAO;

    @Override
    public List<PatientEntity> getAll() {
        return patientDAO.getAll();
    }

    @Override
    public void addPatient(PatientEntity patientEntity) {
        patientDAO.addPatient(patientEntity);
    }

    @Override
    public List<String> getAllSocialStatus() {
        return iSocialStatusDAO.getAllSocialStatus();
    }

    @Override
    public List<String> getAllCurrentCondition() {
        return iCurrentConditionDAO.getAllCurrentCondition();
    }

    @Override
    public void deletePatient(PatientEntity patientEntity) {
        patientDAO.deletePatient(patientEntity);
    }

    @Override
    public PatientEntity getPatientById(int id) {
        return patientDAO.getPatientById(id);
    }


}
