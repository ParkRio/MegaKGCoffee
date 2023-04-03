package com.kgitbank.megakgcoffee.Model.DTO.OrderDetail;

import com.kgitbank.megakgcoffee.Model.DTO.Cart.CartDTO;

import java.util.ArrayList;

public class OrderDataSingleton {

    private static final OrderDataSingleton instance = new OrderDataSingleton();

    private String menu_seq; // 오더에서 상세 주문으로 넘어가기 위해

    private int order_item_seq; // 바로 주문 클릭시 결제화면으로 데이터 넘기기 위함으로

    private ArrayList<CartDTO> arrayList; // 장바구니에서 결제화면으로 데이터 넘김
    
    private int checkOrder; // 장바구니에 들어왔을 떄 바로주문인지 장바구니 주문인지 확인

    private int reg_seq; // 회원 PK 값

    private OrderDataSingleton(){}

    public static OrderDataSingleton getInstance(){
        return instance;
    }

    public String getMenu_seq() {
        return menu_seq;
    }

    public void setMenu_seq(String menu_seq) {
        this.menu_seq = menu_seq;
    }

    public int getOrder_item_seq() {
        return order_item_seq;
    }

    public void setOrder_item_seq(int order_item_seq) {
        this.order_item_seq = order_item_seq;
    }

    public ArrayList<CartDTO> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<CartDTO> arrayList) {
        this.arrayList = arrayList;
    }

    public int getCheckOrder() {
        return checkOrder;
    }

    public void setCheckOrder(int checkOrder) {
        this.checkOrder = checkOrder;
    }

    public int getReg_seq() {
        return reg_seq;
    }

    public void setReg_seq(int reg_seq) {
        this.reg_seq = reg_seq;
    }
}
