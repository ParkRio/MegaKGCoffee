package com.kgitbank.megakgcoffee.Controller.Payment;

import com.kgitbank.megakgcoffee.Model.DAO.Payment.IPaymentDAO;
import com.kgitbank.megakgcoffee.Model.DAO.Payment.PaymentDAOFactory;
import com.kgitbank.megakgcoffee.Model.DTO.Payment.PaymentDTO;
import com.kgitbank.megakgcoffee.Service.Payment.PaymentService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class PaymentController implements Initializable {

    private Parent PaymentForm;
    private PaymentDAOFactory paymentDAOFactory;

    IPaymentDAO iPaymentDAO = new IPaymentDAO();
    PaymentDTO paymentDTO = new PaymentDTO();

    @FXML
    TextField payment_comment;



    @FXML private Button payment_button; // 주문하기 버튼

    public String menu_count = "예시) 1개";

//    @FXML public Label menu_count; // 메뉴 수량

    @FXML public TextField paymentReg_style; // 결제 수단
    @FXML public TextField paymentReg_comment; // 매장 요청사항
    @FXML public TextField payment_CashReceipts; // 현금 영수증

    private PaymentService paymentService;
    private Stage primaryStage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paymentService = new PaymentService() {
            @Override
            public void payment(String paymentReg_style, String paymentReg_comment, String payment_CashReceipts) {

            }

            @Override
            public void payment(int paymentReg_sysdate, String paymentReg_style, String paymentReg_comment, String payment_CashReceipts) {

            }
        };
        paymentDAOFactory = new PaymentDAOFactory();

    }

    public void setService(Parent paymentForm) {

        PaymentForm = paymentForm;
    }

    public void setFactory(PaymentDAOFactory paymentFactory) {
        this.paymentDAOFactory = paymentFactory;
    }

}
