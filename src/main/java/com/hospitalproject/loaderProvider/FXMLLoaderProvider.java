package com.hospitalproject.loaderProvider;

import javafx.fxml.FXMLLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by kingm on 14.11.2017.
 */
@Component
public class FXMLLoaderProvider {
    private AnnotationConfigApplicationContext ctx;

    public FXMLLoader getLoader(String path) {
        FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(param -> ctx.getBean(param));
        loader.setLocation(getClass().getResource(path));
        return loader;
    }

    @Autowired
    public void setCtx(AnnotationConfigApplicationContext ctx) {
        this.ctx = ctx;
    }
}
