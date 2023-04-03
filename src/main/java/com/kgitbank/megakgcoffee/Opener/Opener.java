package com.kgitbank.megakgcoffee.Opener;

import com.kgitbank.megakgcoffee.Controller.OrderDetail.OrderDetailController;
import com.kgitbank.megakgcoffee.Controller.Orders.OrdersController;
import com.kgitbank.megakgcoffee.Controller.Payment.OrderPaymentController;
import com.kgitbank.megakgcoffee.Model.DTO.OrderDetail.OrderDataSingleton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class Opener {

    private Stage primaryStage;

    OrderDataSingleton data = OrderDataSingleton.getInstance();

    // opener 가 생성할 화면 구성
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    // 주문 페이지 화면 실행
    public void OrderPageOpen() {

    }

    // 주문 상세 페이지 화면 실행
    public void OrderDetailPageOpen(String menu_seq) {
        
        data.setMenu_seq(menu_seq); // 어떤 메뉴인지 확인하기 위함

        try {
            URL fxmlPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Fxml/OrderDetail.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(fxmlPath);
            Parent orderDetailForm = null;
            orderDetailForm = loader.load();
            Scene scene = new Scene(orderDetailForm);
            primaryStage.setTitle("Order Detail");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 장바구니 페이지 화면 실행
    public void CartPageOpen() {

        try {
            URL fxmlPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Fxml/Cart.fxml").toURI().toURL();
            FXMLLoader loader = new FXMLLoader(fxmlPath);
            Parent cartForm = null;
            cartForm = loader.load();
            Scene scene = new Scene(cartForm);
            primaryStage.setTitle("cart");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 바로 주문 클릭시 결제화면 실행
    public void OrderPayment(Stage stage) {
        try {
            URL fxmlPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Fxml/OrderPayment.fxml").toURI().toURL();
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlPath);
            Parent paymentForm = fxmlLoader.load();
            Opener opener = new Opener();
            opener.setPrimaryStage(stage);
            OrderPaymentController orderPaymentController = fxmlLoader.getController();
            orderPaymentController.setOpener(opener);
            Scene scene = new Scene(paymentForm);
            stage.setTitle("Payment");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void CartToOrderPayment(Stage stage) {
        try {
            URL fxmlPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Fxml/OrderPayment.fxml").toURI().toURL();
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlPath);
            Parent CartToPaymentForm = fxmlLoader.load();
            Opener opener = new Opener();
            opener.setPrimaryStage(stage);
            OrderPaymentController orderPaymentController = fxmlLoader.getController();
            orderPaymentController.setOpener(opener);
            Scene scene = new Scene(CartToPaymentForm);
            stage.setTitle("Payment");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 결제화면에서 다시 주문 페이지 화면 실행
    public void PaymentForBackToOrderPage(Stage stage) {
        try {
            URL fxmlPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Fxml/Orders.fxml").toURI().toURL();
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlPath);
            Parent paymentToOrderForm = fxmlLoader.load();
            Opener opener = new Opener();
            opener.setPrimaryStage(stage);
            OrdersController ordersController = fxmlLoader.getController();
            ordersController.setOpener(opener);
            Scene scene = new Scene(paymentToOrderForm);
            stage.setTitle("Orders");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // 주문 페이지로 돌아가는 화면 실행
    public void BackToOrderPage(Stage stage) {

        try {
            URL fxmlPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Fxml/Orders.fxml").toURI().toURL();
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlPath);
            Parent orderForm = fxmlLoader.load();
            Opener opener = new Opener();
            opener.setPrimaryStage(stage);
            OrdersController ordersController = fxmlLoader.getController();
            ordersController.setOpener(opener);
            Scene scene = new Scene(orderForm);
            stage.setTitle("Order Page");
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
