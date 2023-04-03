package com.kgitbank.megakgcoffee.Service.OrderCheck;

public interface OrderCheckService {
    void createOrderCheckToCart(int checkItem_seq, int checkReg_seq);
    void createOrderNow(int checkItem_Seq, int checkReg_seq);
    int findItemsInTheCart(int checkReg_seq);
    void deleteOrderCheck(int check_seq);
}
