package com.kgitbank.megakgcoffee.Model.DAO.Register;

import com.kgitbank.megakgcoffee.Controller.Register.RegisterController;
import com.kgitbank.megakgcoffee.Register;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Opener {
    private Stage primaryStage;
    private Parent regForm;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    // 회원 가입 화면 실행
    public void regOpen() {
        Stage regStage = new Stage();
        try {
            URL fxmlPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Register.fxml").toURI().toURL();
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlPath);
            Scene scene = new Scene(fxmlLoader.load());
            regStage.setTitle("회원가입 화면");
            regStage.setScene(scene);
            regStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 메뉴 화면 실행
    public void menuOpen() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        Parent menuForm = null;

        try {
            menuForm = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(menuForm);
        primaryStage.setTitle("메인 화면");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
