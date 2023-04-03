package com.kgitbank.megakgcoffee.Model.DAO.OrderItem;

public class OrderItemDAOFactory {

    public static OrderItemDAO getOrderItemDAO() {
        return new IOrderItemDAO();
    }
}
