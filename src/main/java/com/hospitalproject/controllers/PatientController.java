package com.hospitalproject.controllers;

import com.hospitalproject.config.SpringConfig;
import com.hospitalproject.loaderProvider.SpringFXMLLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class PatientController {

    @Autowired
    SpringConfig springConfig;

    @Autowired
    MainController mainController;

    @FXML
    private TextField lastName;

    @FXML
    private ComboBox<?> cbCurrentCondition;

    @FXML
    private Button btnVisits;

    @FXML
    private Button btnLogout;

    @FXML
    private TableColumn<?, ?> colLastName;

    @FXML
    private Button btnDoctors;

    @FXML
    private TableColumn<?, ?> colDOB;

    @FXML
    private MenuItem deleteUsers;

    @FXML
    private TableColumn<?, ?> colUserId;

    @FXML
    private Label userId;

    @FXML
    private TableColumn<?, ?> colFirstName;

    @FXML
    private TableColumn<?, ?> colEdit;

    @FXML
    private TextField firstName;

    @FXML
    private Button btnQueue;

    @FXML
    private ComboBox<?> cbSocialStatus;

    @FXML
    private TableColumn<?, ?> colSocialStatus;

    @FXML
    private Button btnPatients;

    @FXML
    private DatePicker dob;

    @FXML
    private Button reset;

    @FXML
    private TableView<?> userTable;

    @FXML
    private TableColumn<?, ?> colCurrentCondition;

    @FXML
    private Button saveUser;

    @FXML
    void deletePatient(ActionEvent event) {

    }

    @FXML
    void reset(ActionEvent event) {

    }


    @FXML
    void savePatient(ActionEvent event) {

    }

    @FXML
    void exit(ActionEvent event) {

    }

    public void showStage() throws IOException {
    }

    @FXML
    public void toMenu(ActionEvent event) throws IOException {

    }
}
