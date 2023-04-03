package com.kgitbank.megakgcoffee.Service.Cart;

import com.kgitbank.megakgcoffee.Model.DTO.Cart.CartDTO;
import javafx.collections.ObservableList;

import java.util.List;

public interface CartService {
    ObservableList<CartDTO> findAllCartItems(int reg_seq);
}
