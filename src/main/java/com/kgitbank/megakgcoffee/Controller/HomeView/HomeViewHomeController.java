package com.kgitbank.megakgcoffee.Controller.HomeView;

import com.kgitbank.megakgcoffee.Opener.Opener;

import com.kgitbank.megakgcoffee.Service.HomeView.HomeViewHomeService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class HomeViewHomeController implements Initializable {

    @FXML Button coffeeBtn;
    @FXML Button menuBtn;
    @FXML Button homeBtn;
    @FXML Button BackBtn;
    @FXML Label nickLabel;
    private HomeViewHomeService homeService;
    private Parent HomeForm;
    private Opener opener;

    private Stage stage;

    public void setStage(Stage stage) {
        System.out.println(stage);
        this.stage = stage;
        System.out.println(stage);
    }

    public Opener getOpener() {
        return opener;
    }

    public void setOpener(Opener opener) {
        this.opener = opener;
    }


    public void setService(Parent homeForm) {
        HomeForm = homeForm;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        homeService = new HomeViewHomeService();
        homeService.NickName(nickLabel);
    }


    @FXML
    private void handleBackButton(ActionEvent event)  {   // 홈화면에서 메인화면으로
        Stage stage = (Stage) BackBtn.getScene().getWindow();
        opener.BackButton(stage);

    }

    @FXML
    private void handleCoffeeButton(ActionEvent event)  {   // 홈화면에서 메인화면으로
        Stage stage = (Stage) BackBtn.getScene().getWindow();
        opener.CoffeeButton(stage);

    }

}
