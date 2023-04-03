package com.kgitbank.megakgcoffee.Service.OrderItem;

public class OrderItemServiceFactory {

    public static OrderItemService getOrderItemService() {
        return new IOrderItemService();
    }
}
