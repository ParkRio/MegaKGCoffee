package com.kgitbank.megakgcoffee.Service.Payment;

public interface PaymentService {
    // 결제 수단, 매장 요청사항, 현금영수증
    void payment(String paymentReg_style, String paymentReg_comment, String payment_CashReceipts);
}
