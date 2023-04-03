package com.kgitbank.megakgcoffee.Controller.HomeView;

import com.kgitbank.megakgcoffee.Opener.Opener;
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

    @FXML
    private Button homeview_loginBtn;
    private HomeViewMainService service;
    private Opener opener;
    private Parent HomeForm;

    public void setOpener(Opener opener) {
        this.opener = opener;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        service = new HomeViewMainService();
    }

    @FXML
    private void handleLoginBtn(ActionEvent event) {
        Stage stage = (Stage) homeview_loginBtn.getScene().getWindow();
        opener.BeforeLoginOpen(stage);
    }
}

