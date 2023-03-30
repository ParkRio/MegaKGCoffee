package com.kgitbank.megakgcoffee.Controller.Register;

import com.kgitbank.megakgcoffee.Service.Register.ILoginService;
import com.kgitbank.megakgcoffee.Service.Register.LoginService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {
    @FXML
    TextField reg_id;
    @FXML
    PasswordField reg_pwd;
    private ILoginService service;
    private Parent Register1;

    public void setRegister1(Parent register) {
        Register1 = register;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        service = new ILoginService();
    }
    
    //회원가입 버튼
    public void regProc() {
        Stage regStage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Register.fxml"));
        Parent Register = null;
        try {
            Register1 = loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

        RegisterController regCon = loader.getController();
        regCon.setRegister(Register1);

        Scene scene = new Scene(Register1);
        regStage.setTitle("회원가입 화면");
        regStage.setScene(scene);
        regStage.show();
    }

    
}
