package com.hospitalproject.services.impl;

import com.hospitalproject.dao.IDoctorDAO;
import com.hospitalproject.dao.IPositionsDAO;
import com.hospitalproject.dao.IQualificationsDAO;
import com.hospitalproject.dao.ISpecialisationsDAO;
import com.hospitalproject.model.DoctorEntity;
import com.hospitalproject.services.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kingm on 26.11.2017.
 */
@Service
public class DoctorServiceImpl implements IDoctorService {

    @Autowired
    IDoctorDAO iDoctorDAO;

    @Autowired
    IPositionsDAO iPositionsDAO;
    @Autowired
    IQualificationsDAO iQualificationsDAO;
    @Autowired
    ISpecialisationsDAO iSpecialisationsDAO;

    @Override
    public List<DoctorEntity> getAll() {
        return iDoctorDAO.getAll();
    }

    @Override
    public List<String> getAllDoctorPositions() {
        return iPositionsDAO.getAllPositions();
    }

    @Override
    public List<String> getAllDoctorSpecialisations() {
        return null;
    }

    @Override
    public List<String> getAllDoctorQualifications() {
        return null;
    }

    @Override
    public DoctorEntity getDoctorById(int idDoctor) {
        return iDoctorDAO.getDoctorById(idDoctor);
    }

    @Override
    public void addDoctor(DoctorEntity doctorEntity) {
        iDoctorDAO.addDoctor(doctorEntity);
    }

    @Override
    public void updateDoctor(DoctorEntity doctorEntity) {
        iDoctorDAO.updateDoctor(doctorEntity);
    }

    @Override
    public int getPositionIdByName(String item) {
        return iPositionsDAO.getPositionIdByName(item);
    }

    @Override
    public int getSpecialisationIdByName(String item) {
        return iSpecialisationsDAO.getSpecialisationIdByName(item);
    }

    @Override
    public int getQualificationIdByName(String item) {
        return iQualificationsDAO.getQualificationIdByName(item);
    }
}
