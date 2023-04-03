package com.kgitbank.megakgcoffee.Model.DAO.Payment;

import com.kgitbank.megakgcoffee.Model.DTO.Cart.CartDTO;
import com.kgitbank.megakgcoffee.Model.DTO.Payment.CartPaymentDTO;
import com.kgitbank.megakgcoffee.Model.DTO.Payment.FindOrderPaymentDTO;

import java.util.ArrayList;

public interface OrderPaymentDAO {

    FindOrderPaymentDTO findByOrderNow(int order_item_seq, int checkReg_seq);
    void deleteCheckOrder(int check_seq);
    CartPaymentDTO AllByCartOrder(ArrayList<CartDTO> cartDTOArrayList, int checkReg_seq);

}
