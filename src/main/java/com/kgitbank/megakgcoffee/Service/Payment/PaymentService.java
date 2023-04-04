package com.kgitbank.megakgcoffee.Service.Payment;

import javafx.scene.control.Button;

public interface PaymentService {
    // 결제 수단, 매장 요청사항, 현금영수증
    void payment(String paymentReg_style, String paymentReg_comment, String payment_CashReceipts);

    void payment(int paymentReg_sysdate, String paymentReg_style, String paymentReg_comment, String payment_CashReceipts);



}


