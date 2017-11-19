package com.hospitalproject.config;


import com.hospitalproject.loaderProvider.FXMLLoaderProvider;
import javafx.stage.Stage;

public class StageManager {
    private final Stage primaryStage;
    private final FXMLLoaderProvider fxmlLoaderProvider;

    public StageManager(FXMLLoaderProvider springFXMLLoader, Stage stage) {
        this.fxmlLoaderProvider = springFXMLLoader;
        this.primaryStage = stage;
    }

}
