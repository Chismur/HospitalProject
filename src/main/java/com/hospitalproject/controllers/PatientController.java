package com.hospitalproject.controllers;

import com.hospitalproject.config.StageManager;
import com.hospitalproject.model.*;
import com.hospitalproject.services.interfaces.IDoctorService;
import com.hospitalproject.services.interfaces.IPatientService;
import com.hospitalproject.services.interfaces.IQueueService;
import com.hospitalproject.services.interfaces.IVisitService;
import com.hospitalproject.view.FxmlView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;

@Controller
public class PatientController implements Initializable {

    private ObservableList<PatientEntity> patientsList = FXCollections.observableArrayList();
    private ObservableList<String> socialStatusList = FXCollections.observableArrayList();
    private ObservableList<String> currentConditionList = FXCollections.observableArrayList();
    private ObservableList<String> diognosisList = FXCollections.observableArrayList();
    private ObservableList<String> doctorsList = FXCollections.observableArrayList();
    private ObservableList<String> timeList = FXCollections.observableArrayList();
    private ObservableList<String> dayList = FXCollections.observableArrayList();

    @Autowired
    @Lazy
    StageManager stageManager;

    @Autowired
    IPatientService iPatientService;
    @Autowired
    IDoctorService iDoctorService;
    @Autowired
    IVisitService iVisitService;

    @Autowired
    IQueueService iQueueService;

    @FXML
    private Button refreshPatientTab;

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private DatePicker dob;

    @FXML
    private ComboBox<String> cbSocialStatus;

    @FXML
    private ComboBox<String> cbCurrentCondition;

    @FXML
    private ComboBox<String> cbDay;

    @FXML
    private ComboBox<String> cbTime;

    @FXML
    private DatePicker dov;

    @FXML
    private ComboBox<String> cbDiognosis;

    @FXML
    private ComboBox<String> cbDoctor;

    @FXML
    private TextField cabNumber;

    @FXML
    private TableView<PatientEntity> patientTableInfo;
    @FXML
    private TableColumn<PatientEntity, String> colFirstName;
    @FXML
    private TableColumn<PatientEntity, String> colLastName;
    @FXML
    private TableColumn<PatientEntity, String> colDOB;
    @FXML
    private TableColumn<PatientEntity, String> colCurrentCondition;
    @FXML
    private TableColumn<PatientEntity, String> colSocialStatus;

    @FXML
    private Button btnLogout;

    @FXML
    private Button savePatient;

    @FXML
    private Button reset;

    @FXML
    private AnchorPane patients;

    @FXML
    private MenuItem deleteUsers;
    private int idDoctor;

    @FXML
    void deletePatient(ActionEvent event) {
        PatientEntity patientEntity = patientTableInfo.getFocusModel().getFocusedItem();
        List<VisitEntity> list = iVisitService.getAllVisitsOfPatient(patientEntity);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure you want to delete selected?");
        Optional<ButtonType> action = alert.showAndWait();

        if (action.get() == ButtonType.OK) {
            for (VisitEntity v : list) {
                iVisitService.deleteVisit(v);
            }
            iPatientService.deletePatient(patientEntity);
        }

        loadPatientsDetails();
    }

    @FXML
    void refresh(ActionEvent event) {
        loadPatientsDetails();
        clearFields();
    }

    @FXML
    void logout(ActionEvent event) {
        stageManager.switchScene(FxmlView.LOGIN);
    }

    @FXML
    void savePatient(ActionEvent event) {
        PatientEntity patientEntity = new PatientEntity();
        patientEntity.setpName(getFirstName());
        patientEntity.setpSurname(getLastName());
        patientEntity.setbDate(getBDate());
        patientEntity.setIdCurrentCondition(getIdCurrentCondition());
        patientEntity.setIdSocialStatus(getIdSocialStatus());
        iPatientService.addPatient(patientEntity);

        loadPatientsDetails();

        VisitEntity visitEntity = new VisitEntity();
        visitEntity.setIdPatient(iPatientService.getPatientId(patientEntity.getpName(), patientEntity.getpSurname(), patientEntity.getbDate()));
        visitEntity.setStartDateTreatment(getVDate());
        visitEntity.setDateCured(getVDate());
        System.out.println(getVDate().toString());
        iVisitService.addVisit(visitEntity);

        QueueEntity queueEntity = new QueueEntity();
        queueEntity.setCabNum(getCabNumber());
        queueEntity.setCurrentDate(getVDate());
        queueEntity.setIdDoctor(getIdDoctor());
        queueEntity.setIdVisits(iVisitService.getVisitByDate(getVDate()).getIdVisit());
        //todo make it right
        queueEntity.setIdTimetable(2);
        // todo make it right
        queueEntity.setIdWeekday(2);
        // iQueueService.addQueue(queueEntity);
        System.out.println("cab" + queueEntity.getCabNum());
        System.out.println("dateq" + queueEntity.getCurrentDate());
        System.out.println("doc" + queueEntity.getIdDoctor());
        System.out.println("vis" + queueEntity.getIdVisits());
        System.out.println("time" + queueEntity.getIdTimetable());
        System.out.println("date" + queueEntity.getIdWeekday());


    }

    @FXML
    void reset(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        firstName.clear();
        lastName.clear();
        dob.getEditor().clear();
        dov.getEditor().clear();
        cbCurrentCondition.getSelectionModel().clearSelection();
        cbSocialStatus.getSelectionModel().clearSelection();
        cbDiognosis.getSelectionModel().clearSelection();
        cbDoctor.getSelectionModel().clearSelection();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        socialStatusList.addAll(iPatientService.getAllSocialStatus());
        currentConditionList.addAll(iPatientService.getAllCurrentCondition());
        doctorsList.addAll(iDoctorService.getAllDoctorsNames());
        diognosisList.addAll(iVisitService.getAllDiognosis());
        //timeList.addAll(iQueueService.getTime());
        // dayList.addAll(iQueueService.getDays());

        cbSocialStatus.setItems(socialStatusList);
        cbCurrentCondition.setItems(currentConditionList);
        cbDoctor.setItems(doctorsList);
        cbDiognosis.setItems(diognosisList);
        //cbDay.setItems(dayList);
        // cbTime.setItems(timeList);

        patientTableInfo.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        setColumnProperties();
        loadPatientsDetails();
    }

    private void loadPatientsDetails() {
        patientsList.clear();
        patientsList.addAll(iPatientService.getAll());
        patientTableInfo.getItems().setAll(patientsList);
    }

    private Integer getCabNumber() {
        return Integer.parseInt(cabNumber.getText());
    }

    private String getLastName() {
        return lastName.getText();
    }

    private String getFirstName() {
        return firstName.getText();
    }

    private void setColumnProperties() {
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("pName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("pSurname"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("bDate"));
        colCurrentCondition.setCellValueFactory(new PropertyValueFactory<>("currentConditionByIdCurrentCondition"));
        colSocialStatus.setCellValueFactory(new PropertyValueFactory<>("socialStatusByIdSocialStatus"));
    }

    public Date getBDate() {
        Date date = Date.valueOf(dob.getValue());
        return date;
    }

    public int getIdCurrentCondition() {
        String s = cbCurrentCondition.getSelectionModel().getSelectedItem();
        return iPatientService.getCurrentConditionByName(s);
    }

    public int getIdSocialStatus() {
        String s = cbSocialStatus.getSelectionModel().getSelectedItem();
        return iPatientService.getSocialStatusByName(s);
    }

    public Date getVDate() {
        Date date = Date.valueOf(dov.getValue());
        return date;
    }

    //TO DO make find by name,surname and another param
    public int getIdDoctor() {
        String s = cbDoctor.getSelectionModel().getSelectedItem();
        return iDoctorService.getIdDoctorByName(s);
    }

    public Integer getTime() {
        String s = cbTime.getSelectionModel().getSelectedItem();
        return iQueueService.getTimeByName(s);
    }

    public Integer getDay() {
        String s = cbDay.getSelectionModel().getSelectedItem();
        return iQueueService.getDayByName(s);
    }
}
