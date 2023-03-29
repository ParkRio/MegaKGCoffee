package com.kgitbank.megakgcoffee;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent loginForm = loader.load();

        Scene scene = new Scene(loginForm);
        primaryStage.setTitle("로그인 화면");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
