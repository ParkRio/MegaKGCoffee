package com.kgitbank.megakgcoffee.Controller.Register;

import com.kgitbank.megakgcoffee.Model.DTO.Register.RegisterDTO;
import com.kgitbank.megakgcoffee.Service.Register.CommonService;
import com.kgitbank.megakgcoffee.Service.Register.RegisterService;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
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
    private String id_okay = "";

    public void setRegForm(Parent regForm) {
        RegForm = regForm;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        service = new RegisterService();

        reg_name.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue.length() > 0) {
                reg_name.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
            }
        });

        reg_nick.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue.length() > 0) {
                reg_nick.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
            }
        });

        reg_pwd.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue.length() > 0) {
                reg_pwd.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
            }
        });

        confirm.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue.length() > 0) {
                confirm.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
            }
        });

        reg_tel.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue.length() > 0) {
                reg_tel.setStyle("-fx-border-color: black; -fx-border-width: 2px;");
            }
        });

        reg_id.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                id_check_result.setText("아이디 중복체크를 해주세요.");
                id_check_result.setStyle("-fx-text-fill: red");
                id_check_count = 0;
            }
        });
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

        LocalDate myDate = reg_birth.getValue();
        if (myDate == null) {
            CommonService.msg("생년월일을 입력해주세요.");

        } else {

            String birth = myDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            if (id_check_count > 0 && service.ExistId(reg_id.getText())) {

                RegisterDTO reg = new RegisterDTO(
                        reg_name.getText(),
                        reg_id.getText(),
                        reg_nick.getText(),
                        reg_pwd.getText(),
                        confirm.getText(),
                        reg_tel.getText(),
                        birth
                );

                if(service.regProc(reg, confirm_check_result, confirm)) {
                    successRegister();
                }

            } else {
                CommonService.msg("모든 사항을 입력해주시고 아이디 중복체크를 선택해주세요.");
            }
        }
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

    public void successRegister() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("정보");
        alert.setHeaderText("회원가입을 축하합니다.");
        alert.setContentText("로그인 이후 서비스를 이용하실 수 있습니다.");
        Optional<ButtonType> click = alert.showAndWait();
        if (click.get() == ButtonType.OK) {
            Stage stage = (Stage) reg_name.getScene().getWindow();
            stage.close();
        }
    }
}
