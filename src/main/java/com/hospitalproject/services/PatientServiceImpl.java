package com.hospitalproject.services;

import com.hospitalproject.dao.PatientDAOImpl;
import com.hospitalproject.model.PatientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kingm on 14.11.2017.
 */
@Service
public class PatientServiceImpl {
    @Autowired
    PatientDAOImpl patientDAO;

    public List<PatientEntity> getAll(){
        return patientDAO.getAll();
    }
}
