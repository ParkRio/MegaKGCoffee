package com.kgitbank.megakgcoffee.Controller.HomeView;

import com.kgitbank.megakgcoffee.Model.DTO.OrderDetail.OrderDataSingleton;
import com.kgitbank.megakgcoffee.Opener.Opener;

import com.kgitbank.megakgcoffee.Service.HomeView.HomeViewHomeService;
import com.kgitbank.megakgcoffee.Service.UserSetting.UserSettingService;
import com.kgitbank.megakgcoffee.Service.UserSetting.UserSettingServiceFactory;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


public class HomeViewHomeController implements Initializable {

    @FXML public Label nickname;
    @FXML public BorderPane bp;
    @FXML public AnchorPane ap;

    private Opener opener;

    OrderDataSingleton orderDataSingleton = OrderDataSingleton.getInstance();
    UserSettingService userSettingService;



    public void setOpener(Opener opener) {
        this.opener = opener;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userSettingService = UserSettingServiceFactory.getUserSettingService();
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
        loadPage("UserSetting");
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


    public void change_nickname(MouseEvent mouseEvent) {
        nickname.setText(orderDataSingleton.getReg_nickname());
    }

    public void logout(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("CONFIRMATION");
        alert.setHeaderText("로그아웃");
        alert.setContentText("로그아웃 하시겠습니까?");
        Optional<ButtonType> click = alert.showAndWait();
        if (click.get() == ButtonType.OK) {
            orderDataSingleton.setYesOrNO("N");
            Stage stage = (Stage) nickname.getScene().getWindow();
            Opener opener = new Opener();
            opener.loginOpen(stage);
        }
    }
}
