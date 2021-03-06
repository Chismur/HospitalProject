package com.hospitalproject.controllers;

import com.hospitalproject.config.StageManager;
import com.hospitalproject.model.*;
import com.hospitalproject.services.interfaces.IDoctorService;
import com.hospitalproject.services.interfaces.IPatientService;
import com.hospitalproject.services.interfaces.IVisitService;
import com.hospitalproject.view.FxmlView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;
import java.util.stream.IntStream;

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

    @Autowired
    IVisitService iVisitService;

    private ObservableList<DoctorEntity> doctorsList = FXCollections.observableArrayList();
    private ObservableList<DiognosisEntity> diognosisList = FXCollections.observableArrayList();
    private ObservableList<PatientEntity> patientList = FXCollections.observableArrayList();
    private ObservableList<String> socialStatus = FXCollections.observableArrayList();
    private ObservableList<String> currentCondition = FXCollections.observableArrayList();
    private ObservableList<Date> dateList = FXCollections.observableArrayList();

    @FXML
    private Button logOut;

    @FXML
    private Label lbSocialStatus;

    @FXML
    private Label lbCurrentCondition;

    @FXML
    private MenuItem deletePatient;

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
    void showInfo(MouseEvent mouseEvent) throws FileNotFoundException {

        clearcb();
        clearObsLists();
        doctorsList.clear();
        doctorsTable.refresh();
        diognosisList.clear();
        diognosisTable.refresh();

        PatientEntity patientEntity = patientTable.getFocusModel().getFocusedItem();

        setInfoPatient(patientEntity);
        Image iv = new Image(new FileInputStream("src/main/resources/img/putin.jpg"));
        imagePatient.setImage(iv);

        List<VisitEntity> visitEntityList = iVisitService.getAllVisitsOfPatient(patientEntity);
        List<QueueEntity> qList = new ArrayList<>();
        List<DiognosisEntity> de = new ArrayList<>();

        for (VisitEntity v : visitEntityList) {
            dateList.add(v.getDateCured());
            qList.add(iVisitService.getQueueByVisit(v));
        }
        for (QueueEntity q:qList) {
            doctorsList.add(iVisitService.getDoctorForQueue(q));
        }


        diognosisTable.getItems().setAll(diognosisList);
        doctorsTable.getItems().setAll(doctorsList);
    }

    private void setInfoPatient(PatientEntity patientEntity) {

        firstName.setText(patientEntity.getpName());
        lastName.setText(patientEntity.getpSurname());
        bDate.setValue(patientEntity.getbDate().toLocalDate());
        lbCurrentCondition.setText(iPatientService.getCurrentConditionOfPatient(patientEntity));
        lbSocialStatus.setText(iPatientService.getSocialStatusOfPatient(patientEntity));

        socialStatus.addAll(iPatientService.getAllSocialStatus());
        currentCondition.addAll(iPatientService.getAllCurrentCondition());

        cbSocialStatus.setItems(socialStatus);
        cbCurrentCondition.setItems(currentCondition);
    }

    @FXML
    void showInfoDoc(MouseEvent mouseEvent) {
        diognosisList.clear();
        diognosisTable.getItems().clear(); //diognosisTable.refresh();

        PatientEntity patientEntity = patientTable.getFocusModel().getFocusedItem();
        DoctorEntity doctorEntity = doctorsTable.getFocusModel().getFocusedItem();

        diognosisList.addAll(iDoctorService.getAllDiognosisByDoctor(doctorEntity,patientEntity));
        diognosisTable.getItems().setAll(diognosisList);
    }


    @FXML
    void logout(ActionEvent event) {
        stageManager.switchScene(FxmlView.LOGIN);
    }

    @FXML
    void change(ActionEvent event) {

    }

    @FXML
    void deletePatient(ActionEvent event) {
        PatientEntity patientEntity = patientTable.getFocusModel().getFocusedItem();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete selected?");
        Optional<ButtonType> action = alert.showAndWait();

        if (action.get() == ButtonType.OK) iPatientService.deletePatient(patientEntity);

        loadPatientDetails();
    }

    @FXML
    void apply(ActionEvent event) {
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        doctorsTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        patientTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        diognosisTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        setColumnPropertiesForPatient();
        setColumnPropertiesForDoctors();
        setColumnPropertiesForDiognosis();
        loadPatientDetails();


    }

    private void clearcb() {
        //cbVisit.getItems().clear();
        cbSocialStatus.getItems().clear();
        cbCurrentCondition.getItems().clear();
    }

    private void clearObsLists() {
        //visitsList.clear();
        socialStatus.clear();
        currentCondition.clear();
        doctorsList.clear();
        bDate.getEditor().clear();
    }

    private void clearFields() {
        firstName.clear();
        lastName.clear();
    }

    private void setColumnPropertiesForDoctors() {
        colSpecializationDoc.setCellValueFactory(new PropertyValueFactory<>("specializationByIdSpecialization"));
        colFirstNameDoc.setCellValueFactory(new PropertyValueFactory<>("dName"));
        colLastNameDoc.setCellValueFactory(new PropertyValueFactory<>("dSurname"));
    }

    private void setColumnPropertiesForPatient() {
        colLastNamePatient.setCellValueFactory(new PropertyValueFactory<>("pSurname"));
        colFirstNamePatient.setCellValueFactory(new PropertyValueFactory<>("pName"));
    }


    private void setColumnPropertiesForDiognosis() {
        colDiognosis.setCellValueFactory(new PropertyValueFactory<>("diognosis"));
    }


    private void loadPatientDetails() {
        patientList.clear();
        patientList.addAll(iPatientService.getAll());
        patientTable.getItems().setAll(patientList);
    }

    private void loadDoctorsDetails() {
        doctorsList.clear();
        doctorsList.addAll(iDoctorService.getAll());
        doctorsTable.getItems().setAll(doctorsList);
    }

    private void loadDiognosisDetails() {
        diognosisList.clear();
        // diognosisList.addAll(iVisitService.getDiognosisOfPatient());
        diognosisTable.getItems().setAll(diognosisList);
    }


    @FXML
    void findDoctors(MouseEvent mouseEvent) {
    }

}

