package com.kgitbank.megakgcoffee.Service.OrderCheck;

public class OrderCheckServiceFactory {

    public static OrderCheckService getOrderCheckService() {
        return new IOrderCheckService();
    }
}
