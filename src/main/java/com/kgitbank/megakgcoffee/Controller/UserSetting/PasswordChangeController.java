package com.kgitbank.megakgcoffee.Controller.UserSetting;

import com.kgitbank.megakgcoffee.Service.UserSetting.UserSettingService;
import com.kgitbank.megakgcoffee.Service.UserSetting.UserSettingServiceFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class PasswordChangeController implements Initializable {

    @FXML public PasswordField present_password;
    @FXML public PasswordField change_password;

    UserSettingService userSettingService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userSettingService = UserSettingServiceFactory.getUserSettingService();
    }

    @FXML
    public void change_password_button(MouseEvent mouseEvent) {
        userSettingService.changePassword(present_password.getText(), change_password.getText());
    }
}
