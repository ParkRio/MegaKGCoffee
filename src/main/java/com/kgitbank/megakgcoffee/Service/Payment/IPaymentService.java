package com.kgitbank.megakgcoffee.Service.Payment;

import com.kgitbank.megakgcoffee.Model.DAO.Payment.PaymentDAO;
import com.kgitbank.megakgcoffee.Model.DAO.Payment.PaymentDAOFactory;

//import static com.kgitbank.megakgcoffee.Model.DTO.Payment.PaymentDTO.paymentUser;

public class IPaymentService implements PaymentService {
    PaymentDAO paymentDAO = PaymentDAOFactory.getPaymentDAO();
    private int paymentRegSysdate;
    private String paymentRegStyle;
    private String paymentRegComment;
    private String paymentCashReceipts;

//    @Override
//    public void payment(String paymentReg_style, String paymentReg_comment, String payment_CashReceipts) {
//        paymentDAO.insert(PaymentDTO.paymentUser(paymentReg_style, paymentReg_comment, payment_CashReceipts));
//    }

    @Override
    public void payment(String paymentReg_style, String paymentReg_comment, String payment_CashReceipts) {

    }

    @Override
    public void payment(int paymentReg_sysdate, String paymentReg_style, String paymentReg_comment, String payment_CashReceipts) {

    }

//    @Override
//    public void payment(int paymentReg_sysdate, String paymentReg_style, String paymentReg_comment, String payment_CashReceipts) {
//        paymentDAO.insert(paymentUser(paymentReg_sysdate, paymentReg_style, paymentReg_comment, payment_CashReceipts));
//    }
}
