package com.kgitbank.megakgcoffee;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Register extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Register.fxml"));
        Parent registerForm = loader.load();

        Scene scene = new Scene(registerForm);
        primaryStage.setTitle("회원가입 화면");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
