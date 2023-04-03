package com.kgitbank.megakgcoffee.Model.DAO.Payment;

public class OrderPaymentDAOFactory {

    public static OrderPaymentDAO getOrderPaymentDAO() {
        return new IOrderPaymentDAO();
    }
}
