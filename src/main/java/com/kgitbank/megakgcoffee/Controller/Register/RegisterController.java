package com.kgitbank.megakgcoffee.Controller.Register;

import com.kgitbank.megakgcoffee.Model.DTO.Register.RegisterDTO;
import com.kgitbank.megakgcoffee.Service.Register.CommonService;
import com.kgitbank.megakgcoffee.Service.Register.RegisterService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML TextField reg_name;
    @FXML TextField reg_id;
    @FXML TextField reg_nick;
    @FXML PasswordField reg_pwd;
    @FXML PasswordField confirm;
    @FXML TextField reg_tel;
    @FXML DatePicker reg_birth;

    @FXML private Button closeBtn;
    @FXML private Button close;



    private RegisterService service;
    private Parent RegForm;

    public void setRegForm(Parent regForm) {
        RegForm = regForm;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        service = new RegisterService();
    }

    // 회원 가입 버튼
    public void regProc() {
        RegisterDTO reg = new RegisterDTO();

        reg.setReg_name(reg_name.getText());
        reg.setReg_id(reg_id.getText());
        reg.setReg_nick(reg_nick.getText());
        reg.setReg_pwd(reg_pwd.getText());
        reg.setConfirm(confirm.getText());
        reg.setReg_tel(reg_tel.getText());
        reg.setReg_birth(((TextField)reg_birth.getEditor()).getText());

        service.regProc(reg);

        CommonService.msg("회원가입이 완료되었습니다.");

        Stage stage = (Stage)close.getScene().getWindow();
        stage.close();

    }

    // 회원 화면에서 취소 버튼
    public void regCancelProc() {
        Stage stage = (Stage)closeBtn.getScene().getWindow();
        stage.close();
    }

}
