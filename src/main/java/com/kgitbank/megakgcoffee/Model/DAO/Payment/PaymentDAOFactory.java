package com.kgitbank.megakgcoffee.Model.DAO.Payment;

import com.kgitbank.megakgcoffee.Controller.Payment.PaymentController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class PaymentDAOFactory {

    private Stage primayStage;

    public void setPrimayStage(Stage primayStage) {
        this.primayStage = primayStage;
    }

    public static PaymentDAO getPaymentDAO() {
        return new IPaymentDAO();
    }

//    // 주문하기 버튼
//    public void PaymentProc() {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("Payment2.fxml"));
//
//        Stage PaymentStage = new Stage();  // 홈 화면
//
//        // 주문하기 화면의 Stage에 Payment2.fxml 화면(결제완료)을 실행
//
//        Parent paymentForm = null;
//
//        try {
//            paymentForm = loader.load();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        PaymentController PaymentCon = loader.getController();
//        PaymentCon.setService(paymentForm);
//
//        Scene scene = new Scene(paymentForm);
//        PaymentStage.setTitle("결제하기");
//        PaymentStage.setScene(scene);
//        PaymentStage.show();
//    }

}
