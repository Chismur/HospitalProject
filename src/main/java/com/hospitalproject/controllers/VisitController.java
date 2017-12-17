package com.hospitalproject.controllers;

import com.hospitalproject.dao.interfaces.IQueueDAO;
import com.hospitalproject.model.*;
import com.hospitalproject.services.interfaces.IDoctorService;
import com.hospitalproject.services.interfaces.IPatientService;
import com.hospitalproject.services.interfaces.IQueueService;
import com.hospitalproject.services.interfaces.IVisitService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.util.*;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import javafx.event.ActionEvent;

/**
 * Created by kingm on 13.12.2017.
 */
@Controller
public class VisitController implements Initializable {

    @Autowired
    IPatientService iPatientService;

    @Autowired
    IQueueService iQueueService;

    @Autowired
    IVisitService iVisitService;

    @Autowired
    IDoctorService iDoctorService;

    private ObservableList<PatientEntity> patientsList = FXCollections.observableArrayList();
    private ObservableList<String> socialStatusList = FXCollections.observableArrayList();
    private ObservableList<String> currentConditionList = FXCollections.observableArrayList();
    private ObservableList<String> diognosList = FXCollections.observableArrayList();
    private ObservableList<String> timeList = FXCollections.observableArrayList();
    private ObservableList<String> dayList = FXCollections.observableArrayList();
    private ObservableList<String> doctorList = FXCollections.observableArrayList();


    @FXML
    private AnchorPane visits;

    @FXML
    private TableView<PatientEntity> patientTable;
    @FXML
    private TableColumn<PatientEntity, String> colFirstName;
    @FXML
    private TableColumn<PatientEntity, String> colLastName;
    @FXML
    private TableColumn<PatientEntity, String> colDOB;
    @FXML
    private TableColumn<PatientEntity, String> colSocialStatus;
    @FXML
    private TableColumn<PatientEntity, String> colCurrentCondition;

    @FXML
    private ComboBox<String> cbTime;
    @FXML
    private ComboBox<String> cbDiognosis;
    @FXML
    private ComboBox<String> cbDoctor;
    @FXML
    private ComboBox<String> cbDay;
    @FXML
    private DatePicker dov;
    @FXML
    private TextField cabNumber;

    @FXML
    private Button refreshPatientTab;
    @FXML
    private Button reset;
    @FXML
    private Button save;
    @FXML
    private Button firstSort;
    @FXML
    private Button secondSort;
    @FXML
    private Button trirdSort;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        socialStatusList.addAll(iPatientService.getAllSocialStatus());
        currentConditionList.addAll(iPatientService.getAllCurrentCondition());
        timeList.addAll(iQueueService.getTime());
        dayList.addAll(iQueueService.getDays());
        diognosList.addAll(iVisitService.getAllDiognosis());
        doctorList.addAll(iDoctorService.getAllDoctorsNames());

        cbDay.setItems(dayList);
        cbTime.setItems(timeList);
        cbDiognosis.setItems(diognosList);
        cbDoctor.setItems(doctorList);

        patientTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        setColumnProperties();
        loadPatientsDetails();
    }

    private void loadPatientsDetails() {
        patientsList.clear();
        patientsList.addAll(iPatientService.getAll());
        patientTable.getItems().setAll(patientsList);
    }

    private void setColumnProperties() {
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("pName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("pSurname"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("bDate"));
        colCurrentCondition.setCellValueFactory(new PropertyValueFactory<>("currentConditionByIdCurrentCondition"));
        colSocialStatus.setCellValueFactory(new PropertyValueFactory<>("socialStatusByIdSocialStatus"));
    }

    @FXML
    void first(ActionEvent event) {
//        patientsList.clear();
//        patientsList.addAll(iPatientService.getAllFirst());
//        patientTable.getItems().setAll(patientsList);
    }

    @FXML
    void second(ActionEvent event) {
//        patientsList.clear();
//        patientsList.addAll(iPatientService.getAllSecond());
//        patientTable.getItems().setAll(patientsList);
    }

    @FXML
    void third(ActionEvent event) {
//        patientsList.clear();
//        patientsList.addAll(iPatientService.getAllThird());
//        patientTable.getItems().setAll(patientsList);
    }

    @FXML
    void save(ActionEvent event) {
        PatientEntity patientEntity = new PatientEntity();
        patientEntity = patientTable.getFocusModel().getFocusedItem();

        DiognosisEntity diognosisEntity = new DiognosisEntity();
        diognosisEntity = getDiognosis();

        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setDateCured(getDate());
        visitEntity.setIdPatient(patientEntity.getIdPatient());
        visitEntity.setStartDateTreatment(getDate());
        //visitEntity.setDiognosisHasVisitsByIdVisit();
        iVisitService.addVisit(visitEntity);


        //Make it right
        List<VisitEntity> ve = iVisitService.getVisitByPatient(patientEntity);
        QueueEntity queueEntity = new QueueEntity();
        for (VisitEntity v : ve) {

            queueEntity.setIdVisits(v.getIdVisit());
            queueEntity.setIdWeekday(getWeekday());
            queueEntity.setIdDoctor(getDoctorId());
            queueEntity.setIdTimetable(getTime());
            queueEntity.setCabNum(getCabNumber());
            queueEntity.setCurrentDate(getDate());
            queueEntity.setVisitHasSpecializationIdVisitHasSpecialization(null);
        }

        iQueueService.save(queueEntity);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Visit successfully added!");

        alert.showAndWait();

    }

    @FXML
    void reset(ActionEvent event) {

    }

    @FXML
    void refresh(ActionEvent event) {
        loadPatientsDetails();
        clearFields();
    }

    private void clearFields() {

    }

    @FXML
    void showInfo(MouseEvent mouseEvent) {

    }

    public Date getDate() {
        Date date = Date.valueOf(dov.getValue());
        return date;
    }


    public Integer getWeekday() {
        String s = cbDay.getSelectionModel().getSelectedItem();
        return iQueueService.getDayByName(s);
    }

    //Make it right
    public int getDoctorId() {
        String s = cbDoctor.getSelectionModel().getSelectedItem();
        return iDoctorService.getIdDoctorByName(s);
    }

    public Integer getTime() {
        String s = cbTime.getSelectionModel().getSelectedItem();
        return iQueueService.getTimeByName(s);
    }

    public Integer getCabNumber() {
        return Integer.valueOf(cabNumber.getText());
    }

    public DiognosisEntity getDiognosis() {
        String s = cbDiognosis.getSelectionModel().getSelectedItem();
        return iVisitService.getDiognosisByName(s);
    }
}
