package com.kgitbank.megakgcoffee.Model.DTO.Payment;

public class PaymentDTO {

//    create table payment_view(
//            payment_seq int,
//            payment_style varchar2(20),
//    payment_comment varchar2(20),
//    payment_CashReceipts varchar2(20),
//    PRIMARY KEY(payment_seq)
//);
//
//    SELECT * FROM payment_view;



    private int payment_seq;   // 결제 식별번호
    private int paymentReg_seq;   // 회원 식별번호
    private int paymentReg_sysdate;   // 결제 날짜
    private String paymentReg_style;   //  결제 수단
    private String paymentReg_comment;   //  매장 요청사항
    private String payment_CashReceipts;   //  현금 영수증


    public PaymentDTO(String paymentReg_style, String paymentReg_comment, String payment_CashReceipts) {
        this.paymentReg_style = paymentReg_style;
        this.paymentReg_comment = paymentReg_comment;
        this.payment_CashReceipts = payment_CashReceipts;


    }

    public static PaymentDTO paymentUser(String paymentReg_style, String paymentReg_comment, String payment_CashReceipts) {
        return new PaymentDTO(paymentReg_style, paymentReg_comment, payment_CashReceipts);
    }

    public int getPayment_seq() {
        return payment_seq;
    }

    public int getPaymentReg_sysdate() {
        return paymentReg_sysdate;
    }

    public String getPaymentReg_style() {
        return paymentReg_style;
    }

    public String getPaymentReg_comment() {
        return paymentReg_comment;
    }

    public String getPayment_CashReceipts() { return payment_CashReceipts; }


}
