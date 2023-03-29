package com.kgitbank.megakgcoffee.Controller.Test;

import com.kgitbank.megakgcoffee.Service.Test.TestService;
import com.kgitbank.megakgcoffee.Service.Test.TestServiceFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class TestController implements Initializable {

    @FXML TextField test_id;
    @FXML TextField test_password;
    @FXML Button test_button;

    private TestService testService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        testService = TestServiceFactory.getTestService();
    }


    @FXML
    public void testMouseClicked(MouseEvent event) {
        testService.register(test_id.getText(), test_password.getText());
    }
}
