package com.kgitbank.megakgcoffee.Model.DAO.OrderCheck;

import com.kgitbank.megakgcoffee.Model.DTO.OrderCheck.OrderCheckDTO;

public interface OrderCheckDAO {
    void createOrderCheck(OrderCheckDTO orderCheckDTO);
    int howManyInTheCart(OrderCheckDTO orderCheckDTO);
    void deleteOrderCheck(int check_seq);
}
