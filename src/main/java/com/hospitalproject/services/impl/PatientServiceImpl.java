package com.hospitalproject.services.impl;

import com.hospitalproject.dao.IPatientDAO;
import com.hospitalproject.dao.impl.PatientDAOImpl;
import com.hospitalproject.model.PatientEntity;
import com.hospitalproject.services.IPatientService;
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

    @Override
    public List<PatientEntity> getAll(){
        return patientDAO.getAll();
    }

    @Override
    public void addPatient(PatientEntity patientEntity) {
        patientDAO.addPatient(patientEntity);
    }

    @Override
    public PatientEntity getPatientById(int id){
        return patientDAO.getPatientById(id);
    }
}
