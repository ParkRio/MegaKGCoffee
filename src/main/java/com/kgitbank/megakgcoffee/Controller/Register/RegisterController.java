package com.kgitbank.megakgcoffee.Controller.Register;

import com.kgitbank.megakgcoffee.Model.DTO.Register.RegisterDTO;
import com.kgitbank.megakgcoffee.Service.Register.CommonService;
import com.kgitbank.megakgcoffee.Service.Register.RegisterService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML public Label id_check_result;
    @FXML public Label confirm_check_result;
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

    private int id_check_count = 0;

    public void setRegForm(Parent regForm) {
        RegForm = regForm;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        service = new RegisterService();
    }

    // 회원 가입 버튼
    public void regProc() {

        if (reg_name.getText().length() == 0) {
            reg_name.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-background-color: rgb(255,198,198)");
        } else {
            reg_name.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        }

        if (reg_id.getText().length() == 0) {
            reg_id.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-background-color: rgb(255,198,198)");
        } else {
            reg_id.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        }

        if (reg_nick.getText().length() == 0) {
            reg_nick.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-background-color: rgb(255,198,198)");
        } else {
            reg_nick.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        }

        if (reg_pwd.getText().length() == 0) {
            reg_pwd.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-background-color: rgb(255,198,198)");
        } else {
            reg_pwd.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        }

        if (confirm.getText().length() == 0) {
            confirm.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-background-color: rgb(255,198,198)");
        } else {
            confirm.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        }

        if (reg_tel.getText().length() == 0) {
            reg_tel.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-background-color: rgb(255,198,198)");
        } else {
            reg_tel.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
        }

        if (id_check_count > 0) {

            RegisterDTO reg = new RegisterDTO(
                    reg_name.getText(),
                    reg_id.getText(),
                    reg_nick.getText(),
                    reg_pwd.getText(),
                    confirm.getText(),
                    reg_tel.getText(),
                    reg_birth.getEditor().getText()
            );

            service.regProc(reg, confirm_check_result, confirm);

        } else {
            CommonService.msg("모든 사항을 입력해주시고 아이디 중복체크를 선택해주세요.");
        }

//        CommonService.msg("회원가입이 완료되었습니다.");

//        Stage stage = (Stage)close.getScene().getWindow();
//        stage.close();

    }

    // 회원 화면에서 취소 버튼
    public void regCancelProc() {
        Stage stage = (Stage)closeBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void id_check(MouseEvent mouseEvent) {
        id_check_count = mouseEvent.getClickCount();
        if (service.ExistId(reg_id.getText())) {
            CommonService.msg("사용가능한 아이디입니다.");
            reg_id.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
            id_check_result.setText("사용가능한 아이디입니다.");
            id_check_result.setStyle("-fx-text-fill: green");
        } else {
            CommonService.msg("중복된 아이디가 존재합니다.");
            reg_id.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-background-color: rgb(255,198,198)");
            id_check_result.setText("중복된 아이디가 존재합니다.");
            id_check_result.setStyle("-fx-text-fill: red");
            id_check_count = 0;
        }
    }
}
