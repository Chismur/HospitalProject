package com.hospitalproject.loaderProvider;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by kingm on 14.11.2017.
 */
@Component
public class SpringFXMLLoader {

    private ApplicationContext ctx;

    public Parent getLoader(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(param -> ctx.getBean(param));
        loader.setLocation(getClass().getResource(path));
        return loader.load();
    }

    @Autowired
    public void setCtx(AnnotationConfigApplicationContext ctx) {
        this.ctx = ctx;
    }
}
