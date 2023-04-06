package com.kgitbank.megakgcoffee.Controller.UserSetting;

import com.kgitbank.megakgcoffee.Model.DTO.OrderDetail.OrderDataSingleton;
import com.kgitbank.megakgcoffee.Opener.Opener;
import com.kgitbank.megakgcoffee.Service.UserSetting.UserSettingService;
import com.kgitbank.megakgcoffee.Service.UserSetting.UserSettingServiceFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class WithdrawalController implements Initializable {

    @FXML public PasswordField present_password;

    private Opener opener;
    UserSettingService userSettingService;
    OrderDataSingleton orderDataSingleton = OrderDataSingleton.getInstance();

    public void setOpener(Opener opener) {
        this.opener = opener;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userSettingService = UserSettingServiceFactory.getUserSettingService();
    }

    public void withdrawal_button(MouseEvent mouseEvent) {
        if (userSettingService.withdrawalMember(present_password.getText())) {
            orderDataSingleton.setYesOrNO("N");
            bach_to_login();
        }
    }

    public void bach_to_login() {
        Stage stage = (Stage) present_password.getScene().getWindow();
        Opener opener = new Opener();
        opener.loginOpen(stage);
    }
}
