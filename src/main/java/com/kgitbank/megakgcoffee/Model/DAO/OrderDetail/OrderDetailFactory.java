package com.kgitbank.megakgcoffee.Model.DAO.OrderDetail;

public class OrderDetailFactory {

    public static OrderDetailDAO getOrderDetailDAO() {
        return new IOrderDetailDAO();
    }
}
