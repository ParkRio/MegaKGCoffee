package com.kgitbank.megakgcoffee.Service.Payment;

import com.kgitbank.megakgcoffee.Model.DAO.Payment.OrderPaymentDAO;
import com.kgitbank.megakgcoffee.Model.DAO.Payment.OrderPaymentDAOFactory;
import com.kgitbank.megakgcoffee.Model.DTO.Cart.CartDTO;
import com.kgitbank.megakgcoffee.Model.DTO.Payment.CartPaymentDTO;
import com.kgitbank.megakgcoffee.Model.DTO.Payment.FindOrderPaymentDTO;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class IOrderPaymentService implements OrderPaymentService{

    OrderPaymentDAO orderPaymentDAO = OrderPaymentDAOFactory.getOrderPaymentDAO();

    @Override
    public FindOrderPaymentDTO findByOrderNow(int order_item_seq, int checkReg_seq) {
        return orderPaymentDAO.findByOrderNow(order_item_seq, checkReg_seq);
    }

    @Override
    public void deleteOrderNow(int check_seq) {
        orderPaymentDAO.deleteCheckOrder(check_seq);
    }

    @Override
    public ObservableList<CartPaymentDTO> AllCartItems(ArrayList<CartDTO> cartDTOArrayList, int checkReg_seq) {
        return orderPaymentDAO.AllByCartOrder(cartDTOArrayList, checkReg_seq);
    }

    @Override
    public void updateOrderNowFinished(int order_item_seq, int checkReg_seq) {
        orderPaymentDAO.updateOrderNow(order_item_seq, checkReg_seq);
    }

    @Override
    public void updateCartOrderFinished(ArrayList<CartDTO> cartDTOArrayList, int checkReg_seq) {
        orderPaymentDAO.updateCartOrder(cartDTOArrayList, checkReg_seq);
    }
}
