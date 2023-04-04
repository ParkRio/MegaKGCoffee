package com.kgitbank.megakgcoffee;

import com.kgitbank.megakgcoffee.Controller.HomeView.HomeViewMainController;
import com.kgitbank.megakgcoffee.Controller.Member.MemberController;
import com.kgitbank.megakgcoffee.Opener.Opener;
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

//        FXMLLoader loader = new FXMLLoader(getClass().getResource("Fxml/Login.fxml"));
//        Parent loginForm = loader.load();
//
//        Opener opener = new Opener();
//        opener.setPrimaryStage(stage);
//
//        LoginController loginCon = loader.getController();
//        loginCon.setOpener(opener);
//
//        Scene scene = new Scene(loginForm);
//        stage.setTitle("로그인 화면");
//        stage.setScene(scene);
//        stage.show();

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Fxml/HomeView_main2.fxml"));
        Parent mainForm = fxmlLoader.load();

        Opener opener = new Opener();
        opener.setPrimaryStage(stage);

        HomeViewMainController mainController = fxmlLoader.getController();
        mainController.setOpener(opener);
//        MemberController memberController = fxmlLoader.getController();
//        memberController.setOpener(opener);

        Scene scene = new Scene(mainForm);
        stage.setScene(scene);
        stage.setTitle("Connection Test");
        stage.show();


//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Test.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(),500,500);
//        stage.setScene(scene);
//        stage.setTitle("Connection Test");
//        stage.show();


//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Fxml/Orders.fxml"));
//        Parent orderForm = fxmlLoader.load();
//
//        Opener opener = new Opener();
//        opener.setPrimaryStage(stage);
//
////        CartController cartController = fxmlLoader.getController();
////        cartController.setOpener(opener);
//
//        OrdersController ordersController = fxmlLoader.getController();
//        ordersController.setOpener(opener);
//
//        Scene scene = new Scene(orderForm);
//        stage.setTitle("Order Page");
//        stage.setScene(scene);
//        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
