package com.kgitbank.megakgcoffee.Controller.Orders;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class TestController implements Initializable {
    @FXML
    public Button button;
    @FXML
    public Label label1;

    @FXML
    public void proc() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

//        button.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                label1.setText("Sent!");
//            }
//        });

        button.setOnAction(actionEvent -> label1.setText("Sent! Two!"));
    }
}
