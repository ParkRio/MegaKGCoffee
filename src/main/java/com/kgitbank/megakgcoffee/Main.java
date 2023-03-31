package com.kgitbank.megakgcoffee;

import com.kgitbank.megakgcoffee.Controller.Register.LoginController;
import com.kgitbank.megakgcoffee.Model.DAO.Register.Opener;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void init() {

    }

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent loginForm = loader.load();

        Opener opener = new Opener();
        opener.setPrimaryStage(stage);

        LoginController loginCon = loader.getController();
        loginCon.setOpener(opener);

        Scene scene = new Scene(loginForm);
        stage.setTitle("로그인 화면");
        stage.setScene(scene);
        stage.show();

//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Test.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(),500,500);
//        stage.setScene(scene);
//        stage.setTitle("Connection Test");
//        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
