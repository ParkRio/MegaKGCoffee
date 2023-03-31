package com.kgitbank.megakgcoffee.Controller.HomeView;

import com.kgitbank.megakgcoffee.Openner.HomeView.HomeViewOpenerFactory;
import com.kgitbank.megakgcoffee.Service.HomeView.HomeViewService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeViewMainController implements Initializable {

    @FXML
    private Button homeview_loginBtn;
    private HomeViewService service;
    private HomeViewOpenerFactory openerFactory;
    private Parent HomeForm;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        service = new HomeViewService();


    }




    public void setOpenerFactory(HomeViewOpenerFactory openerFactory) {
        this.openerFactory = openerFactory;
    }

    @FXML
    private void handleLoginBtn(ActionEvent event) {

        openerFactory.LoginOpen();
//        service.LoginButtonClick(homeview_loginBtn);

    }



}

