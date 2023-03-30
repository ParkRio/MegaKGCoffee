package com.kgitbank.megakgcoffee.Model.DAO.Orders;

public class OrderDAOFactory {

    public static OrdersDAO getOrdersDAO() {
        return new IOrdersDAO();
    }
}
