package com.hospitalproject.config;

import com.hospitalproject.model.PatientEntity;
import com.hospitalproject.services.PatientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.util.List;

/**
 * Created by kingm on 14.11.2017.
 */
@Configuration
@ComponentScan("com.hospitalproject")
@ImportResource("classpath:spring.xml")
public class SpringConfig {

    @Autowired
    PatientServiceImpl patientService;

    public List<PatientEntity> getAll(){
        return patientService.getAll();
    }
}
