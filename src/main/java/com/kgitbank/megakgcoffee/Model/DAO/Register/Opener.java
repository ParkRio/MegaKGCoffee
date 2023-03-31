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
        Stage regStage = new Stage();
        try {
            URL fxmlPath = new File("src/main/resources/com/kgitbank/megakgcoffee/HomeView_home.fxml").toURI().toURL();
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlPath);
            Scene scene = new Scene(fxmlLoader.load());
            regStage.setTitle("메인 화면");
            regStage.setScene(scene);
            regStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }
}
