package com.hospitalproject.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.hospitalproject.config.SpringConfig;
import com.hospitalproject.model.PatientEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

        import java.net.URL;
        import java.util.ResourceBundle;
        import javafx.fxml.FXML;
        import javafx.scene.control.MenuButton;
        import javafx.scene.control.MenuItem;
        import javafx.scene.layout.Pane;

@Component
public class MainController {
    @Autowired
    SpringConfig springConfig;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Pane RightPane;

    @FXML
    private MenuButton doctors;

    @FXML
    private MenuButton patients;

    @FXML
    private MenuButton queue;

    @FXML
    private MenuItem refactorDoctors;

    @FXML
    private MenuItem refactorPatients;

    @FXML
    private MenuItem refactorQueue;

    @FXML
    private MenuItem refactorVisits;

    @FXML
    private MenuItem showDoctors;

    @FXML
    private MenuItem showPatients;

    @FXML
    private MenuItem showQueue;

    @FXML
    private MenuItem showVisits;

    @FXML
    private MenuButton visits;


    @FXML
    void initialize() {
        assert RightPane != null : "fx:id=\"RightPane\" was not injected: check your FXML file 'main.fxml'.";
        assert doctors != null : "fx:id=\"doctors\" was not injected: check your FXML file 'main.fxml'.";
        assert patients != null : "fx:id=\"patients\" was not injected: check your FXML file 'main.fxml'.";
        assert queue != null : "fx:id=\"queue\" was not injected: check your FXML file 'main.fxml'.";
        assert refactorDoctors != null : "fx:id=\"refactorDoctors\" was not injected: check your FXML file 'main.fxml'.";
        assert refactorPatients != null : "fx:id=\"refactorPatients\" was not injected: check your FXML file 'main.fxml'.";
        assert refactorQueue != null : "fx:id=\"refactorQueue\" was not injected: check your FXML file 'main.fxml'.";
        assert refactorVisits != null : "fx:id=\"refactorVisits\" was not injected: check your FXML file 'main.fxml'.";
        assert showDoctors != null : "fx:id=\"showDoctors\" was not injected: check your FXML file 'main.fxml'.";
        assert showPatients != null : "fx:id=\"showPatients\" was not injected: check your FXML file 'main.fxml'.";
        assert showQueue != null : "fx:id=\"showQueue\" was not injected: check your FXML file 'main.fxml'.";
        assert showVisits != null : "fx:id=\"showVisits\" was not injected: check your FXML file 'main.fxml'.";
        assert visits != null : "fx:id=\"visits\" was not injected: check your FXML file 'main.fxml'.";
    }

    @FXML
    void refactorQueue(ActionEvent event) {
    }

    @FXML
    void refactorDoctors(ActionEvent event) {
    }

    @FXML
    void refactorPatients(ActionEvent event) {

    }

    @FXML
    void refactorVisits(ActionEvent event) {
    }

    @FXML
    void showDoctors(ActionEvent event) {
    }

    @FXML
    void showPatients(ActionEvent event) {

    }

    @FXML
    void showQueue(ActionEvent event) {
    }

    @FXML
    void showVisits(ActionEvent event) {
    }

}


