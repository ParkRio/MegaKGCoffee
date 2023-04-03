package com.kgitbank.megakgcoffee.Service.OrderCheck;

import com.kgitbank.megakgcoffee.Model.DAO.OrderCheck.OrderCheckDAO;
import com.kgitbank.megakgcoffee.Model.DAO.OrderCheck.OrderCheckFactory;
import com.kgitbank.megakgcoffee.Model.DTO.OrderCheck.OrderCheckDTO;

public class IOrderCheckService implements OrderCheckService{

    OrderCheckDAO orderCheckDAO = OrderCheckFactory.createOrderCheck();

    @Override
    public void createOrderCheckToCart(int checkItem_seq, int checkReg_seq) {
        OrderCheckDTO orderCheckDTO = OrderCheckDTO.insertOrderCheck(checkItem_seq, checkReg_seq, 0); // todo :: 0번은 장바구니 추가
        orderCheckDAO.createOrderCheck(orderCheckDTO);
    }

    @Override
    public void createOrderNow(int checkItem_Seq, int checkReg_seq) {
        OrderCheckDTO orderCheckDTO = OrderCheckDTO.insertOrderCheck(checkItem_Seq, checkReg_seq, 2); // todo :: 2번은 바로 주문
        orderCheckDAO.createOrderCheck(orderCheckDTO);
    }

    @Override
    public int findItemsInTheCart(int checkReg_seq) {
        OrderCheckDTO orderCheckDTO = OrderCheckDTO.findItemsInTheCart(checkReg_seq);
        return orderCheckDAO.howManyInTheCart(orderCheckDTO);
    }

    @Override
    public void deleteOrderCheck(int check_seq) {
        orderCheckDAO.deleteOrderCheck(check_seq);
    }
}
