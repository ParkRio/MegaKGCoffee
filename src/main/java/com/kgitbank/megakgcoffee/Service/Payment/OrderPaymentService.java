package com.kgitbank.megakgcoffee.Service.Payment;

import com.kgitbank.megakgcoffee.Model.DTO.Cart.CartDTO;
import com.kgitbank.megakgcoffee.Model.DTO.Payment.CartPaymentDTO;
import com.kgitbank.megakgcoffee.Model.DTO.Payment.FindOrderPaymentDTO;

import java.util.ArrayList;

public interface OrderPaymentService {
    FindOrderPaymentDTO findByOrderNow(int order_item_seq, int checkReg_seq);
    void deleteOrderNow(int check_seq);
    CartPaymentDTO AllCartItems(ArrayList<CartDTO> cartDTOArrayList, int checkReg_seq);
}
