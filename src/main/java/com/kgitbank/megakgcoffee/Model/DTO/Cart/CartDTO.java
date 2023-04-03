package com.kgitbank.megakgcoffee.Model.DTO.Cart;

import javafx.scene.control.CheckBox;

public class CartDTO {

    private int check_seq; // 체크테이블 PK
    private String menu_name;
    private int item_count;
    private int item_price;
    private CheckBox select;

    public CartDTO(int check_seq, String menu_name, int item_count, int item_price, CheckBox select) {
        this.check_seq = check_seq;
        this.menu_name = menu_name;
        this.item_count = item_count;
        this.item_price = item_price;
        this.select = select;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public int getItem_count() {
        return item_count;
    }

    public int getItem_price() {
        return item_price;
    }

    public int getCheck_seq() {
        return check_seq;
    }

    public CheckBox getSelect() {
        return select;
    }
}
