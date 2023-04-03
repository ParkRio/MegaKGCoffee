package com.kgitbank.megakgcoffee.Service.OrderItem;

import com.kgitbank.megakgcoffee.Model.DTO.OrderItem.OrderItemDTO;
import javafx.scene.control.Label;

public interface OrderItemService {
    void insertOrderItem(String itemMenu_seq, int menu_count, int total_price);
    void orderNow(String itemMenu_seq, int menu_count, int total_price);
}
