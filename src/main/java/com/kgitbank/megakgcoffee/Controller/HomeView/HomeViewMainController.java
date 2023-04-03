package com.kgitbank.megakgcoffee.Controller.HomeView;

import com.kgitbank.megakgcoffee.Opener.Opener;
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
    private Opener opener;
    private Parent HomeForm;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        service = new HomeViewService();


    }

    public void setOpener(Opener opener) {
        this.opener = opener;
    }

    @FXML
    private void handleLoginBtn(ActionEvent event) {
        opener.LoginOpen();
//        service.LoginButtonClick(homeview_loginBtn);

    }



}

