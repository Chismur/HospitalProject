package com.hospitalproject.controllers;

import com.hospitalproject.config.StageManager;
import com.hospitalproject.model.*;
import com.hospitalproject.services.IDoctorService;
import com.hospitalproject.services.IPatientService;
import com.hospitalproject.view.FxmlView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by kingm on 04.12.2017.
 */
@Controller
public class PatientInfoController implements Initializable {

    @Autowired
    @Lazy
    StageManager stageManager;

    @Autowired
    IDoctorService iDoctorService;

    @Autowired
    IPatientService iPatientService;

    private ObservableList<DoctorEntity> doctorsList = FXCollections.observableArrayList();
    private ObservableList<String> specialisations = FXCollections.observableArrayList();
    private ObservableList<PatientEntity> patientEntities = FXCollections.observableArrayList();
    private ObservableList<DiognosisEntity> diognosisEntities = FXCollections.observableArrayList();
    private ObservableList<SocialStatusEntity> socialStatusEntities = FX

    @FXML
    private Button logOut;

    @FXML
    private TextField lastName;

    @FXML
    private AnchorPane patients;

    @FXML
    private TextField firstName;

    @FXML
    private DatePicker bDate;

    @FXML
    private ImageView imagePatient;

    @FXML
    private ComboBox<String> cbCurrentCondition;

    @FXML
    private ComboBox<String> cbSocialStatus;

    @FXML
    private TableView<DiognosisEntity> diognosisTable;

    @FXML
    private TableView<DoctorEntity> doctorsTable;

    @FXML
    private TableView<PatientEntity> patientTable;

    @FXML
    private TableColumn<SpecializationEntity, String> colSpecializationDoc;

    @FXML
    private TableColumn<PatientEntity, String> colLastNamePatient;

    @FXML
    private TableColumn<DoctorEntity, String> colLastNameDoc;

    @FXML
    private TableColumn<DoctorEntity, String> colFirstNameDoc;

    @FXML
    private TableColumn<PatientEntity, String> colFirstNamePatient;

    @FXML
    private TableColumn<DiognosisEntity, String> colDiognosis;

    @FXML
    void showInfo(MouseEvent mouseEvent) {
    }

    @FXML
    void logout(ActionEvent event) {
        stageManager.switchScene(FxmlView.LOGIN);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void clearFields() {
        firstName.clear();
        lastName.clear();
        cbSocialStatus.getSelectionModel().clearSelection();
        cbCurrentCondition.getSelectionModel().clearSelection();
        bDate.getEditor().clear();
    }

    private void setColumnProperties() {
        colDiognosis.setCellValueFactory(new PropertyValueFactory<DiognosisEntity, String>("diognosis"));
        colSpecializationDoc.setCellValueFactory(new PropertyValueFactory<SpecializationEntity, String>("specialization"));
        colLastNamePatient.setCellValueFactory(new PropertyValueFactory<PatientEntity, String>("pSurname"));
        colFirstNamePatient.setCellValueFactory(new PropertyValueFactory<PatientEntity, String>("pName"));
        colFirstNameDoc.setCellValueFactory(new PropertyValueFactory<DoctorEntity, String>("dName"));
        colLastNameDoc.setCellValueFactory(new PropertyValueFactory<DoctorEntity, String>("dSurname"));
    }


}
