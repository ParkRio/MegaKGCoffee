package com.kgitbank.megakgcoffee.Controller.Register;

import com.kgitbank.megakgcoffee.Opener.Opener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class FindController implements Initializable {
    @FXML private TextField reg_name;
    @FXML private TextField reg_id;
    @FXML private TextField reg_nick;
    @FXML private TextField reg_pwd;

    private Opener opener;

    public void setOpener(Opener opener) {
        this.opener = opener;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    void idFind(ActionEvent event) {

    }

    @FXML
    void pwFind(ActionEvent event) {

    }
}
