package com.kgitbank.megakgcoffee.Model.DTO.OrderItem;

import com.kgitbank.megakgcoffee.Model.DTO.OrderDetail.OrderDetailDTO;

public class OrderItemDTO {

    private int itemMenu_seq;
    private int item_count;
    private int item_total_price;

    public OrderItemDTO(){}

    public OrderItemDTO(int itemMenu_seq, int item_count, int item_total_price) {
        this.itemMenu_seq = itemMenu_seq;
        this.item_count = item_count;
        this.item_total_price = item_total_price;
    }

    public static OrderItemDTO addToCart(int itemMenu_seq, int item_count, int item_total_price) {
        return new OrderItemDTO(itemMenu_seq, item_count, item_total_price);
    }

    public static OrderItemDTO OrderNow(int itemMenu_seq, int item_count, int item_total_price) {
        return new OrderItemDTO(itemMenu_seq, item_count, item_total_price);
    }

    public int getItem_count() {
        return item_count;
    }

    public int getItemMenu_seq() {
        return itemMenu_seq;
    }

    public int getItem_total_price() {
        return item_total_price;
    }
}
