package com.kgitbank.megakgcoffee.Controller.HomeView;

import com.kgitbank.megakgcoffee.Opener.Opener;
import com.kgitbank.megakgcoffee.Openner.HomeView.HomeViewOpenerFactory;
import com.kgitbank.megakgcoffee.Service.HomeView.HomeViewHomeService;
import com.kgitbank.megakgcoffee.Service.HomeView.HomeViewMainService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeViewMainController implements Initializable {

    @FXML Button homeview_loginBtn;
    private HomeViewMainService mainService;
    private HomeViewOpenerFactory openerFactory;
    private Parent HomeForm;
    private Opener opener;
    private Stage stage;

    public Opener getOpener() { return opener; }


    public void setOpener(Opener opener) { this.opener = opener; }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainService = new HomeViewMainService();


    }




    public void setOpenerFactory(HomeViewOpenerFactory openerFactory) {
        this.openerFactory = openerFactory;
    }

    @FXML
    private void handleLoginBtn(ActionEvent event) {

        opener.LoginOpen(stage);
//        mainService.LoginButtonClick(homeview_loginBtn);

    }



}

