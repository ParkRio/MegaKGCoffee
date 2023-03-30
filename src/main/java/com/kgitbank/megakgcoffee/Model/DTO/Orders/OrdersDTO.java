package com.kgitbank.megakgcoffee.Model.DTO.Orders;

public class OrdersDTO {
    private String menu_category;
    private String menu_name;
    private String menu_img;
    private String menu_desc;
    private int menu_price;

    private String message;

    public OrdersDTO(){}

    public OrdersDTO(String menu_category, String menu_name, String menu_img, String menu_desc, int menu_price) {
        this.menu_category = menu_category;
        this.menu_name = menu_name;
        this.menu_img = menu_img;
        this.menu_desc = menu_desc;
        this.menu_price = menu_price;
    }

    public String getMenu_category() {
        return menu_category;
    }

    public String getMenu_name() {
        return menu_name;
    }

    public String getMenu_img() {
        return menu_img;
    }

    public String getMenu_desc() {
        return menu_desc;
    }

    public int getMenu_price() {
        return menu_price;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
