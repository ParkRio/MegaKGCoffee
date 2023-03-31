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

    @FXML TextField reg_id;
    @FXML PasswordField reg_pwd;
    private LoginService service;
    private Opener opener;

    public void setOpener(Opener opener) {
        this.opener = opener;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        opener = new Opener();
    }

    // 가입 버튼
    public void regProc(){
        opener.regOpen();
    }


}
