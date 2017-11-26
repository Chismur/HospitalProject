package com.hospitalproject.controllers;

import com.hospitalproject.config.StageManager;
import com.hospitalproject.model.DoctorEntity;
import com.hospitalproject.services.IDoctorService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import javafx.fxml.FXML;

import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by kingm on 26.11.2017.
 */
@Controller
public class DoctorsController{ //implements Initializable {

    @Autowired
    IDoctorService iDoctorService;

    private ObservableList<DoctorEntity> doctorsList = FXCollections.observableArrayList();
   // private ObservableList<String> positions = FXCollections.observableArrayList(iDoctorService.getAllDoctorPositions());
//    private ObservableList<String> qualifications = FXCollections.observableArrayList(iDoctorService.getAllDoctorQualifications());
//    private ObservableList<String> specialisations = FXCollections.observableArrayList(iDoctorService.getAllDoctorSpecialisations());

    @Autowired @Lazy
    StageManager stageManager;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private ComboBox<String> cbPosition;

    @FXML
    private ComboBox<String> cbSpecialisation;

    @FXML
    private ComboBox<String> cbQualification;

    @FXML
    private Button save;

    @FXML
    private Button reset;

    @FXML
    private MenuItem deleteItem;

    @FXML
    private Label userId;

    @FXML
    private TableView<DoctorEntity> doctorsTable;

    @FXML
    private TableColumn<DoctorEntity, String> colDoctorName;

    @FXML
    private TableColumn<DoctorEntity, String> colDoctorSurname;

    @FXML
    private TableColumn<DoctorEntity, String> colDoctorPosition;

    @FXML
    private TableColumn<DoctorEntity, String> colDoctorSpecialisation;

    @FXML
    private TableColumn<DoctorEntity, String> colDoctorQualification;

    @FXML
    void reset(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        firstName.clear();
        lastName.clear();
        cbPosition.getSelectionModel().clearSelection();
        cbSpecialisation.getSelectionModel().clearSelection();
        cbQualification.getSelectionModel().clearSelection();
    }

    @FXML
    void save(ActionEvent event) {
//        DoctorEntity doctorEntity = new DoctorEntity();
//        doctorEntity.setdName(getFirstName());
//        doctorEntity.setdSurname(getLastName());
//        doctorEntity.setIdPosition(getPosition());
//        doctorEntity.setIdSpecialization(getSpecialisation());
//        doctorEntity.setIdQualification(getQualification());

       // loadDoctorsDetails();
    }

//    private void loadDoctorsDetails() {
//        doctorsList.clear();
//        doctorsList.addAll(iDoctorService.getAll());
//
//        doctorsTable.setItems(doctorsList);
//    }

    private int getSpecialisation() {
        String item = cbSpecialisation.getSelectionModel().getSelectedItem();
        return iDoctorService.getSpecialisationIdByName(item);
    }

    private int getQualification() {
        String item = cbQualification.getSelectionModel().getSelectedItem();
        return iDoctorService.getQualificationIdByName(item);
    }

    private int getPosition() {
       String item =  cbPosition.getSelectionModel().getSelectedItem();
        return iDoctorService.getPositionIdByName(item);
    }

    private String getLastName() {
        return lastName.getText();
    }

    public String getFirstName() {
        return firstName.getText();
    }

    private void setColumnProperties() {
        colDoctorName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colDoctorSurname.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colDoctorPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        colDoctorQualification.setCellValueFactory(new PropertyValueFactory<>("qualification"));
        colDoctorSpecialisation.setCellValueFactory(new PropertyValueFactory<>("specialisation"));
    }

//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//        cbPosition.setItems(positions);
//        cbQualification.setItems(qualifications);
//        cbSpecialisation.setItems(specialisations);
//
//        doctorsTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
//        setColumnProperties();
//        loadDoctorsDetails();
//    }
}
