package com.hospitalproject.controllers;

import com.hospitalproject.config.StageManager;
import com.hospitalproject.services.impl.AuthenticationServiceImpl;
import com.hospitalproject.view.FxmlView;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

@Controller
public class LoginController {

    @FXML
    private Button loginBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    private PasswordField password;

    @FXML
    private TextField username;

    private final StageManager stageManager;
    private final AuthenticationServiceImpl authenticationService;

    @Autowired @Lazy
    public LoginController(StageManager stageManager, AuthenticationServiceImpl authenticationService) {
        this.stageManager = stageManager;
        this.authenticationService = authenticationService;
    }

    @FXML
    private void usernameTextFieldMouseClicked(MouseEvent event) {
        username.clear();
    }

    @FXML
    private void passwordTextFieldMouseClicked(MouseEvent event) {
        password.clear();
    }


    @FXML
    void cancel(ActionEvent event) {

    }

    @FXML
    void login(ActionEvent event) {
        final Authentication proposedAuthenticationToken = createAuthenticationToken(getUsername(), getPassword());
        try {
            authenticationService.authenticate(proposedAuthenticationToken);
            stageManager.switchScene(FxmlView.MAIN);
        }
        catch (AuthenticationException authenticationException) {
            System.out.println(authenticationException.getMessage());
            clearCredentials();
        }
    }

    private Authentication createAuthenticationToken(String username, String password) {
        return new UsernamePasswordAuthenticationToken(username, password);
    }

    private void clearCredentials() {
        password.clear();
        username.clear();
    }

    public TextField getUserField() {
        return username;
    }

    public TextField getPasswordField() {
        return password;
    }

    public String getUsername() {
        return username.getText();
    }

    public String getPassword() {
        return password.getText();
    }

}
