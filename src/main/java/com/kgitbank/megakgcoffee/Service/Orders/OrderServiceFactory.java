package com.kgitbank.megakgcoffee.Service.Orders;

public class OrderServiceFactory {

    public static OrdersService getOrderService() {
        return new IOrderService();
    }
}
