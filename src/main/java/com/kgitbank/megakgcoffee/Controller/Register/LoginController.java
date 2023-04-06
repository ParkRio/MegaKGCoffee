package com.kgitbank.megakgcoffee.Controller.Register;

import com.kgitbank.megakgcoffee.Model.DTO.OrderDetail.OrderDataSingleton;
import com.kgitbank.megakgcoffee.Model.DTO.Register.ResponseRegDTO;
import com.kgitbank.megakgcoffee.Opener.Opener;
import com.kgitbank.megakgcoffee.Service.Register.CommonService;
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
    @FXML public Button find_button;
    @FXML public Button register_button;
    @FXML Button backBtn;
    @FXML TextField reg_id;
    @FXML PasswordField reg_pwd;

    OrderDataSingleton orderDataSingleton = OrderDataSingleton.getInstance();

    private LoginService service;
    private Opener opener;

    private Stage stage;
    private Stage findIdAndPasswordStage = null;
    private Stage RegisterStage = null;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setOpener(Opener opener) {
        this.opener = opener;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        service = new LoginService();
        //findProc();
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

        String result = service.loginCheck(reg_id.getText()); // 회원삭제 Y / N 인지 판별

        if (result == null) {
            CommonService.msg("회원정보가 존재하지 않습니다.");
        }
        else if (result.equals("Y")) {
            CommonService.msg("탈퇴한 회원입니다." + System.lineSeparator() + "관리자에게 문의주세요.");
        }
        else {

            service.loginProc(reg_id.getText(), reg_pwd.getText());

            if (orderDataSingleton.getYesOrNO().equals("Y") && result.equals("N")) {
                ResponseRegDTO responseRegDTO = service.registerInfo(reg_id.getText(), reg_pwd.getText());
                orderDataSingleton.setReg_seq(responseRegDTO.getReg_seq());
                orderDataSingleton.setReg_name(responseRegDTO.getReg_name()); // todo :: 현재는 아무곳도 쓰는 곳이 없음 삭제할꺼면 싱글톤도 삭제
                orderDataSingleton.setReg_nickname(responseRegDTO.getReg_nick());
                Stage stage = (Stage) reg_id.getScene().getWindow();
                opener.menuOpen(stage);
            }
        }

    }
    // 가입 버튼
    public void regProc(){
        register_button.setOnAction(actionEvent -> {
            if (RegisterStage == null) {
                RegisterStage = new Stage();
                opener.regOpen(RegisterStage);
            } else {
                RegisterStage.close();
                RegisterStage = null;
            }
        });
        //opener.regOpen();
    }

    @FXML
    public void findProc() {
        find_button.setOnAction(actionEvent -> {
            if (findIdAndPasswordStage == null) {
                findIdAndPasswordStage = new Stage();
                opener.findOpen(findIdAndPasswordStage);
            } else {
                findIdAndPasswordStage.close();
                findIdAndPasswordStage = null;
            }
        });
    }


}

