package com.kgitbank.megakgcoffee.Controller.Register;

import com.kgitbank.megakgcoffee.Model.DAO.Register.Opener;
import com.kgitbank.megakgcoffee.Service.Register.LoginService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {

    @FXML
    private Button register_button;
    @FXML TextField reg_id;
    @FXML PasswordField reg_pwd;
    private LoginService service;
    private Opener opener;

    public void setOpener(Opener opener) {
        this.opener = opener;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        service = new LoginService();
        opener = new Opener();
    }
    // 로그인 버튼
    public void loginProc(){
        service.loginProc(reg_id.getText(), reg_pwd.getText());
        String result = service.loginCheck(reg_id.getText());
        if(result != null && result.equals("Y")) {
            opener.menuOpen();
        }
    }

    // 가입 버튼
    public void regProc(){
        opener.regOpen();
        service.RegisterButtonClick(register_button);
    }


}
