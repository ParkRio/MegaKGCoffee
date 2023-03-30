package com.kgitbank.megakgcoffee;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PaymentView extends Application {

    @Override
    public void init() {

    }

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Payment.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),300,500);
        stage.setScene(scene);
        stage.setTitle("주문하기");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
