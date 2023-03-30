package com.kgitbank.megakgcoffee.Service.Payment;

public class PaymentServiceFactory {

    public static PaymentService getPaymentService() {
        return new IPaymentService();
    }
}
