package com.kgitbank.megakgcoffee.Service.Payment;

import com.kgitbank.megakgcoffee.Model.DTO.Cart.CartDTO;
import com.kgitbank.megakgcoffee.Model.DTO.Payment.CartPaymentDTO;
import com.kgitbank.megakgcoffee.Model.DTO.Payment.FindOrderPaymentDTO;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public interface OrderPaymentService {
    FindOrderPaymentDTO findByOrderNow(int order_item_seq, int checkReg_seq);
    void deleteOrderNow(int check_seq);
    ObservableList<CartPaymentDTO> AllCartItems(ArrayList<CartDTO> cartDTOArrayList, int checkReg_seq);
    void updateOrderNowFinished(int order_item_seq, int checkReg_seq);
    void updateCartOrderFinished(ArrayList<CartDTO> cartDTOArrayList, int checkReg_seq);
}
