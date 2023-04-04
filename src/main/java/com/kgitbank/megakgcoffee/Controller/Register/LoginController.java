package com.kgitbank.megakgcoffee.Controller.Register;

import com.kgitbank.megakgcoffee.Model.DTO.OrderDetail.OrderDataSingleton;
import com.kgitbank.megakgcoffee.Model.DTO.Register.ResponseRegDTO;
import com.kgitbank.megakgcoffee.Opener.Opener;
import com.kgitbank.megakgcoffee.Service.Register.LoginService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {
    @FXML Button backBtn;
    @FXML TextField reg_id;
    @FXML PasswordField reg_pwd;

    OrderDataSingleton orderDataSingleton = OrderDataSingleton.getInstance();

    private LoginService service;
    private Opener opener;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setOpener(Opener opener) {
        this.opener = opener;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        service = new LoginService();
    }

    public void loginProc(){

        if(reg_id.getText().length() == 0) {
            reg_id.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-background-color: rgb(255,198,198)");
        } else {
            reg_id.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        }
        if (reg_pwd.getText().length() == 0) {
            reg_pwd.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-background-color: rgb(255,198,198)");
        } else {
            reg_pwd.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        }

        service.loginProc(reg_id.getText(), reg_pwd.getText());
        //String result = service.loginCheck(reg_id.getText()); // 회원 Y / N 인지 판별
        if (orderDataSingleton.getYesOrNO().equals("Y")) {
            ResponseRegDTO responseRegDTO = service.registerInfo(reg_id.getText(), reg_pwd.getText());
            orderDataSingleton.setReg_seq(responseRegDTO.getReg_seq());
            orderDataSingleton.setReg_name(responseRegDTO.getReg_name());
            Stage stage = (Stage) reg_id.getScene().getWindow();
            opener.menuOpen(stage);
        }
    }
    // 가입 버튼
    public void regProc(){
        opener.regOpen();
    }

}

