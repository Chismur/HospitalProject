package com.hospitalproject;

import com.hospitalproject.config.SpringConfig;
import com.hospitalproject.loaderProvider.FXMLLoaderProvider;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main extends Application {

    @Autowired
    SpringConfig springConfig;

    @Override
    public void start(Stage primaryStage) throws Exception{
        final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        FXMLLoader loader = ctx.getBean(FXMLLoaderProvider.class).getLoader("/fxml/main.fxml");
        Parent root = loader.load();
        primaryStage.setMinHeight(400);
        primaryStage.setMinWidth(600);
        primaryStage.setTitle("HospitalProject");
        primaryStage.setScene(new Scene(root, 400, 600));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
