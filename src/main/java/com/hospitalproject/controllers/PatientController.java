package com.hospitalproject.controllers;

/**
 * Created by kingm on 19.11.2017.
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.hospitalproject.config.SpringConfig;
import com.hospitalproject.loaderProvider.FXMLLoaderProvider;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

@Component
public class PatientController {
    @Autowired
    SpringConfig springConfig;

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
    private ComboBox<?> idCurrentConditionPatientButton;

    @FXML
    private TextField idFirstNameTextField;

    @FXML
    private TextField idSecondNameTextField;

    @FXML
    private ComboBox<?> idSocialStatusPatientButton;


    @FXML
    void chooseSS(ActionEvent event) {
    }

    @FXML
    void showCC(ActionEvent event) throws IOException {
        //try {

        //}
//        catch (Exception e){
//            e.printStackTrace();
//        }
    }

    @FXML
    void initialize()  {
        assert idAnchorPane != null : "fx:id=\"idAnchorPane\" was not injected: check your FXML file 'showPatient.fxml'.";
        assert idBirthDPatient != null : "fx:id=\"idBirthDPatient\" was not injected: check your FXML file 'showPatient.fxml'.";
        assert idCurrentConditionPatient != null : "fx:id=\"idCurrentConditionPatient\" was not injected: check your FXML file 'showPatient.fxml'.";
        assert idMedCaedPatient != null : "fx:id=\"idMedCaedPatient\" was not injected: check your FXML file 'showPatient.fxml'.";
        assert idNamePatient != null : "fx:id=\"idNamePatient\" was not injected: check your FXML file 'showPatient.fxml'.";
        assert idPatient != null : "fx:id=\"idPatient\" was not injected: check your FXML file 'showPatient.fxml'.";
        assert idSocialStatusPatient != null : "fx:id=\"idSocialStatusPatient\" was not injected: check your FXML file 'showPatient.fxml'.";
        assert idSurnamePatient != null : "fx:id=\"idSurnamePatient\" was not injected: check your FXML file 'showPatient.fxml'.";
        assert idTableViewPatient != null : "fx:id=\"idTableViewPatient\" was not injected: check your FXML file 'showPatient.fxml'.";


        assert idCurrentConditionPatientButton != null : "fx:id=\"idCurrentConditionPatientButton\" was not injected: check your FXML file 'refactorPatient.fxml'.";
        assert idFirstNameTextField != null : "fx:id=\"idFirstNameTextField\" was not injected: check your FXML file 'refactorPatient.fxml'.";
        assert idSecondNameTextField != null : "fx:id=\"idSecondNameTextField\" was not injected: check your FXML file 'refactorPatient.fxml'.";
        assert idSocialStatusPatientButton != null : "fx:id=\"idSocialStatusPatientButton\" was not injected: check your FXML file 'refactorPatient.fxml'.";



    }

    public void showStage() throws IOException {
        final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        FXMLLoader loader =ctx.getBean(FXMLLoaderProvider.class).getLoader("/fxml/refactorPatient.fxml");
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setMinWidth(100);
        stage.setMinHeight(100);
        stage.setScene(new Scene(root));
        // stage.initModality(Modality.WINDOW_MODAL);
        stage.show();
    }

    public void showPatientTableView(){
        try {
            final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
            FXMLLoader loader =ctx.getBean(FXMLLoaderProvider.class).getLoader("/fxml/showPatient.fxml");
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setMinWidth(100);
            stage.setMinHeight(100);
            stage.setScene(new Scene(root));
            // stage.initModality(Modality.WINDOW_MODAL);
            stage.show();
        }
        catch (Exception e){
            System.out.println("Stage exception");
        }
    }
}

