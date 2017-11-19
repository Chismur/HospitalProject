package com.hospitalproject.controllers;

/**
 * Created by kingm on 19.11.2017.
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import org.springframework.stereotype.Component;

@Component
public class PatientController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane idAnchorPane;

    @FXML
    private TableColumn<?, ?> idBirthDPatient;

    @FXML
    private TableColumn<?, ?> idCurrentConditionPatient;

    @FXML
    private TableColumn<?, ?> idMedCaedPatient;

    @FXML
    private TableColumn<?, ?> idNamePatient;

    @FXML
    private TableColumn<?, ?> idPatient;

    @FXML
    private TableColumn<?, ?> idSocialStatusPatient;

    @FXML
    private TableColumn<?, ?> idSurnamePatient;

    @FXML
    private TableView<?> idTableViewPatient;


    @FXML
    void initialize() {
        assert idAnchorPane != null : "fx:id=\"idAnchorPane\" was not injected: check your FXML file 'showPatient.fxml'.";
        assert idBirthDPatient != null : "fx:id=\"idBirthDPatient\" was not injected: check your FXML file 'showPatient.fxml'.";
        assert idCurrentConditionPatient != null : "fx:id=\"idCurrentConditionPatient\" was not injected: check your FXML file 'showPatient.fxml'.";
        assert idMedCaedPatient != null : "fx:id=\"idMedCaedPatient\" was not injected: check your FXML file 'showPatient.fxml'.";
        assert idNamePatient != null : "fx:id=\"idNamePatient\" was not injected: check your FXML file 'showPatient.fxml'.";
        assert idPatient != null : "fx:id=\"idPatient\" was not injected: check your FXML file 'showPatient.fxml'.";
        assert idSocialStatusPatient != null : "fx:id=\"idSocialStatusPatient\" was not injected: check your FXML file 'showPatient.fxml'.";
        assert idSurnamePatient != null : "fx:id=\"idSurnamePatient\" was not injected: check your FXML file 'showPatient.fxml'.";
        assert idTableViewPatient != null : "fx:id=\"idTableViewPatient\" was not injected: check your FXML file 'showPatient.fxml'.";


    }
}

