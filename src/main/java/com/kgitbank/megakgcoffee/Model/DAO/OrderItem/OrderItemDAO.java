package com.kgitbank.megakgcoffee.Model.DAO.OrderItem;

import com.kgitbank.megakgcoffee.Model.DTO.OrderItem.OrderItemDTO;

public interface OrderItemDAO {
    int insertOrderItem(OrderItemDTO orderItemDTO);
}
