package com.kgitbank.megakgcoffee.Controller.HomeView;

import com.kgitbank.megakgcoffee.Openner.HomeView.HomeViewOpenerFactory;
import com.kgitbank.megakgcoffee.Service.HomeView.HomeViewService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HomeViewHomeController implements Initializable {

    @FXML
    private Button BackBtn;
    private HomeViewService service;
    private Parent HomeForm;
    private HomeViewOpenerFactory openerFactory;

    private Stage primaryStage;

    public HomeViewOpenerFactory getOpenerFactory() {
        return openerFactory;
    }

    public void setOpenerFactory(HomeViewOpenerFactory openerFactory) {
        this.openerFactory = openerFactory;
    }


    public void setService(Parent homeForm) {
        HomeForm = homeForm;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        service = new HomeViewService();

    }


    @FXML
    private void handleBackButton(ActionEvent event)  {   // 홈화면에서 메인화면으로
        openerFactory.BackButton();

    }

}
