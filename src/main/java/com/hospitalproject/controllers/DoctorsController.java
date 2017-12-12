package com.hospitalproject.controllers;

import com.hospitalproject.config.StageManager;
import com.hospitalproject.model.DoctorEntity;
import com.hospitalproject.services.interfaces.IDoctorService;
import com.hospitalproject.view.FxmlView;
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
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by kingm on 26.11.2017.
 */
@Controller
public class DoctorsController implements Initializable {

    @Autowired
    IDoctorService iDoctorService;

    @Autowired
    @Lazy
    StageManager stageManager;

    private ObservableList<DoctorEntity> doctorsList = FXCollections.observableArrayList();
    private ObservableList<String> positions = FXCollections.observableArrayList();
    private ObservableList<String> qualifications = FXCollections.observableArrayList();
    private ObservableList<String> specialisations = FXCollections.observableArrayList();

    @FXML
    private Button refTab;

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
    private Button logout;

    @FXML
    private MenuItem deleteDoctor;

    @FXML
    private MenuItem refactorDoctor;

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

    @FXML
    void logout(ActionEvent event) {
        stageManager.switchScene(FxmlView.LOGIN);
    }

    private void clearFields() {
        firstName.clear();
        lastName.clear();
        cbPosition.getSelectionModel().clearSelection();
        cbSpecialisation.getSelectionModel().clearSelection();
        cbQualification.getSelectionModel().clearSelection();
    }

    @FXML
    void deleteDoctor(ActionEvent event) {
        DoctorEntity doctorEntity = doctorsTable.getFocusModel().getFocusedItem();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete selected?");
        Optional<ButtonType> action = alert.showAndWait();

        if (action.get() == ButtonType.OK) iDoctorService.deleteDoctor(doctorEntity);

        loadDoctorsDetails();
    }

    @FXML
    void refactorDoctor(ActionEvent event) {
        loadDoctorsDetails();
    }

    @FXML
    void refreshTab(ActionEvent event) {
        loadDoctorsDetails();
    }


    @FXML
    void save(ActionEvent event) {
        DoctorEntity doctorEntity = new DoctorEntity();
        doctorEntity.setdName(getFirstName());
        doctorEntity.setdSurname(getLastName());
        doctorEntity.setIdPosition(getPosition());
        doctorEntity.setIdSpecialization(getSpecialisation());
        doctorEntity.setIdQualification(getQualification());
        iDoctorService.addDoctor(doctorEntity);

        loadDoctorsDetails();
    }

    private void loadDoctorsDetails() {
        doctorsList.clear();
        doctorsList.addAll(iDoctorService.getAll());
        doctorsTable.getItems().setAll(doctorsList);
    }

    private int getSpecialisation() {
        String item = cbSpecialisation.getSelectionModel().getSelectedItem();
        return iDoctorService.getSpecialisationIdByName(item);
    }

    private int getQualification() {
        String item = cbQualification.getSelectionModel().getSelectedItem();
        return iDoctorService.getQualificationIdByName(item);
    }

    private int getPosition() {
        String item = cbPosition.getSelectionModel().getSelectedItem();
        return iDoctorService.getPositionIdByName(item);
    }

    private String getLastName() {
        return lastName.getText();
    }

    private String getFirstName() {
        return firstName.getText();
    }

    private void setColumnProperties() {
        colDoctorName.setCellValueFactory(new PropertyValueFactory<>("dName"));
        colDoctorSurname.setCellValueFactory(new PropertyValueFactory<>("dSurname"));
        colDoctorPosition.setCellValueFactory(new PropertyValueFactory<>("positionByIdPosition"));
        colDoctorQualification.setCellValueFactory(new PropertyValueFactory<>("qualificationByIdQualification"));
        colDoctorSpecialisation.setCellValueFactory(new PropertyValueFactory<>("specialisationByIdSpecialisation"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        positions.addAll(iDoctorService.getAllDoctorPositions());
        qualifications.addAll(iDoctorService.getAllDoctorQualifications());
        specialisations.addAll(iDoctorService.getAllDoctorSpecialisations());

        cbPosition.setItems(positions);
        cbQualification.setItems(qualifications);
        cbSpecialisation.setItems(specialisations);

        doctorsTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        setColumnProperties();
        loadDoctorsDetails();
    }


}
