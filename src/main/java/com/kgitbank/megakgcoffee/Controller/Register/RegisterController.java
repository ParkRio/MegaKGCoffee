package com.kgitbank.megakgcoffee.Controller.Register;

import com.kgitbank.megakgcoffee.Model.DTO.Register.RegisterDTO;
import com.kgitbank.megakgcoffee.Service.Register.CommonService;
import com.kgitbank.megakgcoffee.Service.Register.IRegisterService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML TextField reg_id;
    @FXML TextField reg_nick;
    @FXML PasswordField reg_pwd;
    @FXML PasswordField confirm;
    @FXML TextField reg_tel;
    @FXML DatePicker reg_birth;

    private IRegisterService service;
    private Parent Register;

    public void setRegister(Parent register) {
        Register = register;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        service = new IRegisterService();
    }

    public void regProc() {
        RegisterDTO reg = new RegisterDTO();

        reg.setReg_id(reg_id.getText());
        reg.setReg_nick(reg_nick.getText());
        reg.setReg_pwd(reg_pwd.getText());
        reg.setConfirm(confirm.getText());
        reg.setReg_tel(reg_tel.getText());
        reg.setReg_birth(String.valueOf(reg_birth));

        service.regProc(reg);

        CommonService.windowsClose(Register);
    }

}
