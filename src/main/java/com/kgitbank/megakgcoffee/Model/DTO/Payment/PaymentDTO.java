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
    private String paymentReg_style;   //  결제 수단
    private String payment_comment;   //  매장 요청사항
    private String payment_CashReceipts;   //  현금 영수증

    //    private int paymentReg_sysdate;   // 결제 날짜



    public void setPayment_seq(int payment_seq) {
        this.payment_seq = payment_seq;
    }

    public int getPaymentReg_seq() {
        return paymentReg_seq;
    }

    public void setPaymentReg_seq(int paymentReg_seq) {
        this.paymentReg_seq = paymentReg_seq;
    }

//    public void setPaymentReg_sysdate(int paymentReg_sysdate) {
//        this.paymentReg_sysdate = paymentReg_sysdate;
//    }

    public void setPaymentReg_style(String paymentReg_style) {
        this.paymentReg_style = paymentReg_style;
    }

    public void setPayment_CashReceipts(String payment_CashReceipts) {
        this.payment_CashReceipts = payment_CashReceipts;
    }

    public String getPayment_CashReceipts() { return payment_CashReceipts; }

    public void  setPayment_comment(String payment_comment){
        this.payment_comment = payment_comment;
    }

    public String getPayment_comment() { return payment_comment; }

//    public static PaymentDTO paymentUser(int paymentReg_sysdate, String paymentReg_style, String paymentReg_comment, String payment_CashReceipts) {
//        return new PaymentDTO(paymentReg_sysdate, paymentReg_style, paymentReg_comment, payment_CashReceipts);
//    }

//    public PaymentDTO(){
//    }
//    public PaymentDTO(int paymentReg_sysdate, String paymentReg_style, String paymentReg_comment, String payment_CashReceipts) {
//        this.paymentReg_sysdate = paymentReg_sysdate;
//        this.paymentReg_style = paymentReg_style;
//        this.paymentReg_comment = paymentReg_comment;
//        this.payment_CashReceipts = payment_CashReceipts;
//    }
//
//

//
//    public int getPayment_seq() {
//        return payment_seq;
//    }
//
//    public int getPaymentReg_sysdate() { return paymentReg_sysdate; }
//
//    public String getPaymentReg_style() { return paymentReg_style; }
//
//    public String getPaymentReg_comment() { return paymentReg_comment; }

}
