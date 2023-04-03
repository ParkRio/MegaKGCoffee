package com.kgitbank.megakgcoffee;

import com.kgitbank.megakgcoffee.Controller.Payment.PaymentController;
import com.kgitbank.megakgcoffee.Model.DAO.Payment.IPaymentDAO;
import com.kgitbank.megakgcoffee.Model.DTO.Payment.PaymentDTO;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class PaymentView extends Application {
    @FXML
    TextField payment_comment; // 매장 요청사항
    @FXML
    TextField payment_cashReceipts; // 현금영수증 - 개인소득공제용, 사업자증빙용 포함

    IPaymentDAO iPaymentDAO = new IPaymentDAO();
    PaymentDTO paymentDTO = new PaymentDTO();

    @Override
    public void init() {

    }

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Payment.fxml"));
        System.out.println(getClass().getResource(""));
        Scene scene = new Scene(fxmlLoader.load(),400,700);
        stage.setScene(scene);
        stage.setTitle("주문하기 화면");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    // 주문하기 버튼 클릭 메소드
    @FXML
    public void paymentClicked(MouseEvent mouseEvent) {
        Stage PaymentStage = new Stage();  // 홈 화면

        // paymentDTO에 inserrt 할거 적은 것들
        paymentDTO.setPayment_comment(payment_comment.getText());
        iPaymentDAO.insert(paymentDTO);

        paymentDTO.setPayment_cashReceipts(payment_cashReceipts.getText());
        iPaymentDAO.insert(paymentDTO);

        try {
            URL fxmlPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Payment2.fxml").toURI().toURL();
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlPath);
            Scene scene = new Scene(fxmlLoader.load(), 400, 500);
            PaymentStage.setTitle("결제하기 화면");
            PaymentStage.setScene(scene);
            PaymentStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // select 도 해야함
    // 결제수단, 매장 요청사항, 현금영수증 String 값 insert 되야 함

    // 주문하기 버튼
    @FXML
    public void orderClicked(MouseEvent mouseEvent) {
        Stage PaymentStage = new Stage();  // 홈 화면

        try {
            URL fxmlPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Payment3.fxml").toURI().toURL();
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlPath);
            Scene scene = new Scene(fxmlLoader.load(), 400, 500);
            PaymentStage.setTitle("홈으로 도착 !!");
            PaymentStage.setScene(scene);
            PaymentStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // select 도 해야함
        // 결제수단, 매장 요청사항, 현금영수증 String 값 insert 되야 함
    }

    // 뒤로가기 버튼
    @FXML
    public void Back_Clicked(MouseEvent mouseEvent) {
        Stage PaymentStage = new Stage();  // 홈 화면

        try {
            URL fxmlPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Payment3.fxml").toURI().toURL();
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlPath);
            Scene scene = new Scene(fxmlLoader.load(), 400, 500);
            PaymentStage.setTitle("주문하기 이전 화면");
            PaymentStage.setScene(scene);
            PaymentStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
