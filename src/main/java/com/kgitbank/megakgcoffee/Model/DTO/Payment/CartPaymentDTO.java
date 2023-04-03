package com.kgitbank.megakgcoffee.Model.DTO.Payment;

public class CartPaymentDTO {

    private String menu_img; // 메뉴 이미지
    private String menu_name; // 메뉴 이름
    private int menu_price; // 메뉴 1개당 가격
    private int item_count = 0; // 선택한 수량
    private int item_price = 0; // 총 묶음 가격

    public CartPaymentDTO() {}

    public CartPaymentDTO(String menu_img, String menu_name, int menu_price, int item_count, int item_price) {
        this.menu_img = menu_img;
        this.menu_name = menu_name;
        this.menu_price = menu_price;
        this.item_count = item_count;
        this.item_price = item_price;
    }


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

    public String getMenu_img() {
        return menu_img;
    }

    public int getMenu_price() {
        return menu_price;
    }

    public String getMenu_name() {
        return menu_name;
    }
}
