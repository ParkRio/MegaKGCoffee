package com.kgitbank.megakgcoffee.Controller.HomeView;

import com.kgitbank.megakgcoffee.Service.HomeView.HomeViewService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

import java.net.URL;
import java.util.ResourceBundle;


public class HomeViewHomeController implements Initializable {

    private HomeViewService service;
    private Parent LogForm;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        service = new HomeViewService();
    }

    public HomeViewService getService() {

        return service;
    }

    public void setService(Parent logForm) {

        LogForm = logForm;
    }
}
