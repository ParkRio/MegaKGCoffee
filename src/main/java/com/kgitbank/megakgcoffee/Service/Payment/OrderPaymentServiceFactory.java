package com.kgitbank.megakgcoffee.Service.Payment;

public class OrderPaymentServiceFactory {

    public static OrderPaymentService getOrderPaymentService() {
        return new IOrderPaymentService();
    }
}
