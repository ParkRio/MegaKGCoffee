package com.kgitbank.megakgcoffee.Model.DTO.OrderCheck;

public class OrderCheckDTO {

    private int checkItem_seq; // 주문상품 식별번호
    private int checkReg_seq; // 회원식별번호
    private int checkOrder; // 상품 등록 상태 식별번호

    public OrderCheckDTO(){}

    public OrderCheckDTO(int checkItem_seq, int checkReg_seq, int checkOrder) {
        this.checkItem_seq = checkItem_seq;
        this.checkReg_seq = checkReg_seq;
        this.checkOrder = checkOrder;
    }

    public OrderCheckDTO(int checkItem_seq, int checkReg_seq) {
        this.checkItem_seq = checkItem_seq;
        this.checkReg_seq = checkReg_seq;
    }

    public OrderCheckDTO(int checkReg_seq) {
        this.checkReg_seq = checkReg_seq;
    }

    public static OrderCheckDTO insertOrderCheck(int checkItem_seq, int checkReg_seq, int checkOrder) {
        return new OrderCheckDTO(checkItem_seq, checkReg_seq, checkOrder);
    }

    public static OrderCheckDTO findItemsInTheCart(int checkReg_seq) {
        return new OrderCheckDTO(checkReg_seq);
    }

    public int getCheckItem_seq() {
        return checkItem_seq;
    }

    public int getCheckReg_seq() {
        return checkReg_seq;
    }

    public int getCheckOrder() {
        return checkOrder;
    }
}
