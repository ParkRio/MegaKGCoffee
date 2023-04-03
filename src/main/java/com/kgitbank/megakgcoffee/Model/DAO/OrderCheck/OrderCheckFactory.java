package com.kgitbank.megakgcoffee.Model.DAO.OrderCheck;

public class OrderCheckFactory {

    public static OrderCheckDAO createOrderCheck() {
        return new IOrderCheckDAO();
    }
}
