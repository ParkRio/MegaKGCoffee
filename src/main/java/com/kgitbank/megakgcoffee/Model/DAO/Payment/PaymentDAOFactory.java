package com.kgitbank.megakgcoffee.Model.DAO.Payment;

public class PaymentDAOFactory {

    public static PaymentDAO getPaymentDAO() {
        return new IPaymentDAO();
    }
}
