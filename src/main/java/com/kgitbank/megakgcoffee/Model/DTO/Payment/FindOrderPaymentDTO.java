package com.kgitbank.megakgcoffee.Model.DTO.Payment;

public class FindOrderPaymentDTO {

    private int check_seq; // 주문체크 PK 값
    private String menu_name; // 메뉴 이름
    private String menu_img; // 메뉴 이미지
    private int item_count; // 선택한 수량
    private int item_price; // 선택한 가격
    private int menu_price; // 1개의 가격
    private int checkOrder; // 주문체크 몇번인지 0,1,2,3

    public FindOrderPaymentDTO(){}

    public FindOrderPaymentDTO(int check_seq, String menu_name, String menu_img, int item_count, int item_price, int menu_price, int checkOrder) {
        this.check_seq = check_seq;
        this.menu_name = menu_name;
        this.menu_img = menu_img;
        this.item_count = item_count;
        this.item_price = item_price;
        this.menu_price = menu_price;
        this.checkOrder = checkOrder;
    }


    public String getMenu_name() {
        return menu_name;
    }

    public String getMenu_img() {
        return menu_img;
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

    public int getCheckOrder() {
        return checkOrder;
    }

    public int getMenu_price() {
        return menu_price;
    }
}
