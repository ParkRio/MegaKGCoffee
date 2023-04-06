package com.kgitbank.megakgcoffee.Controller.Find;

import com.kgitbank.megakgcoffee.Service.Find.FindService;
import com.kgitbank.megakgcoffee.Service.Find.FindServiceFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class FindPwdController implements Initializable {

    @FXML public AnchorPane ap_pwd;
    @FXML public TextField insert_id;
    @FXML public TextField insert_phone;
    @FXML public Label result_label;
    @FXML public DatePicker find_birth;

    FindService findService;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        findService = FindServiceFactory.getFindService();
    }

    public void find_pwd(MouseEvent mouseEvent) {
        LocalDate myDate = find_birth.getValue();
        String birth = myDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        findService.FindPwd(insert_id.getText(), insert_phone.getText(), birth, result_label);
    }
}
