package com.kgitbank.megakgcoffee.Model.DTO.Payment;

public class CartPaymentDTO {

    private int item_count = 0; // 선택한 수량
    private int item_price = 0; // 총 묶음 가격

    public CartPaymentDTO() {}


    public int getItem_count() {
        return item_count;
    }

    public void setItem_count(int item_count) {
        this.item_count += item_count;
    }

    public int getItem_price() {
        return item_price;
    }

    public void setItem_price(int item_price) {
        this.item_price += item_price;
    }
}
