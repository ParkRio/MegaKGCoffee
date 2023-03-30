package com.kgitbank.megakgcoffee.Controller.Payment;

import com.kgitbank.megakgcoffee.Service.Payment.PaymentService;
import com.kgitbank.megakgcoffee.Service.Payment.PaymentServiceFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PaymentController implements Initializable {

    @FXML TextField paymentReg_style; // 결제 수단
    @FXML TextField paymentReg_comment; // 매장 요청사항
    @FXML TextField payment_CashReceipts; // 현금 영수증


    @FXML Button payment_button; // 주문하기 버튼

    private PaymentService paymentService;
    private Stage primaryStage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paymentService = PaymentServiceFactory.getPaymentService();
    }

    // 주문하기 버튼
    public void paymentMouseClicked(MouseEvent event) {

        // 주문하기 화면의 Stage에 Payment2.fxml 화면을 실행.

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Payment2.fxml"));
        Parent paymentForm = null;
        System.setOut(getClass().getResource());

        try {
            paymentForm = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(paymentForm);
        primaryStage.setTitle("결제하기");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


//    @FXML
//    public void paymentMouseClicked(MouseEvent event) {
//        paymentService.payment(paymentReg_style.getText(), paymentReg_comment.getText()
//        , payment_CashReceipts.getText());
//    }
}
