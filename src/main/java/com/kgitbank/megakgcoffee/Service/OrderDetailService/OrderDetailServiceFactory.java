package com.kgitbank.megakgcoffee.Service.OrderDetailService;

public class OrderDetailServiceFactory {

    public static OrderDetailService getOrderDetailService() {
        return new IOrderDetailService();
    }
}
