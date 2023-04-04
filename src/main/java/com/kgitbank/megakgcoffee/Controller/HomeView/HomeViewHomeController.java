package com.kgitbank.megakgcoffee.Controller.HomeView;

import com.kgitbank.megakgcoffee.Model.DTO.OrderDetail.OrderDataSingleton;
import com.kgitbank.megakgcoffee.Opener.Opener;

import com.kgitbank.megakgcoffee.Service.HomeView.HomeViewHomeService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class HomeViewHomeController implements Initializable {

    @FXML public Label nickname;
    @FXML public BorderPane bp;
    @FXML public AnchorPane ap;

    private Opener opener;

    OrderDataSingleton orderDataSingleton = OrderDataSingleton.getInstance();

    public void setOpener(Opener opener) {
        this.opener = opener;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nickname.setText(orderDataSingleton.getReg_nickname());
    }


    @FXML
    public void home(MouseEvent mouseEvent) {
        bp.setCenter(ap);
    }

    @FXML
    public void order(MouseEvent mouseEvent) {
        Stage stage = (Stage) nickname.getScene().getWindow();
        Opener opener = new Opener();
        opener.OrderPageOpen(stage);
    }

    @FXML
    public void setting(MouseEvent mouseEvent) {
        loadPage("register");
    }

    private void loadPage(String page) {
        Parent root = null;
        try {
            URL fxmlPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Fxml/"+ page + ".fxml").toURI().toURL();
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlPath);
            root = fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        bp.setCenter(root);
    }


}
