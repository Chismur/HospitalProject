//package com.hospitalproject.controllers;
//
//import com.hospitalproject.config.SpringConfig;
//import javafx.fxml.FXML;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.awt.event.ActionEvent;
//import java.net.URL;
//import java.util.ResourceBundle;
//
//@Component
//public class Controller {
//    @Autowired
//    SpringConfig springConfig;
//
//    public void getAll(){
//        springConfig.getAll();
//    }
//
//
//    @FXML
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;
//
//
//    @FXML
//    void showAll(ActionEvent event) {
//    }
//
//    @FXML
//    void initialize() {
//
//
//    }
//
////    public SpringConfig(@Autowired PatientServiceImpl patientService){
////        System.out.println(patientService.getAll());
////    }
//
//}

package com.hospitalproject.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.hospitalproject.config.SpringConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Controller {
    @Autowired
    SpringConfig springConfig;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    void showAll(ActionEvent event) {
        springConfig.getAll();
    }

    @FXML
    void initialize() {


    }

}

