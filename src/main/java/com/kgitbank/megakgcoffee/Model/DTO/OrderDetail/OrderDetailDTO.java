package com.kgitbank.megakgcoffee.Model.DTO.OrderDetail;

public class OrderDetailDTO {

    private int menu_seq;
    private String menuName;
    private String menuImg;
    private String menuDesc;
    private int itemCount;
    private int menuPrice;

    public OrderDetailDTO(){}

    public OrderDetailDTO(String menuName, String menuImg, String menuDesc, int menuPrice) {
        this.menuName = menuName;
        this.menuImg = menuImg;
        this.menuDesc = menuDesc;
        this.menuPrice = menuPrice;
    }

    public OrderDetailDTO (int menu_seq, int itemCount, int menuPrice) {
        this.menu_seq = menu_seq;
        this.itemCount = itemCount;
        this.menuPrice = menuPrice;
    }

    public static OrderDetailDTO setDataOrderDetail(int menu_seq, int itemCount, int menuPrice) {
        return new OrderDetailDTO(menu_seq, itemCount, menuPrice);
    }



    public String getMenuName() {
        return menuName;
    }

    public String getMenuImg() {
        return menuImg;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public int getItemCount() {
        return itemCount;
    }

    public int getMenuPrice() {
        return menuPrice;
    }
}
