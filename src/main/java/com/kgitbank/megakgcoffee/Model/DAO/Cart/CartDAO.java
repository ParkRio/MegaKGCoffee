package com.kgitbank.megakgcoffee.Model.DAO.Cart;

import com.kgitbank.megakgcoffee.Model.DTO.Cart.CartDTO;
import javafx.collections.ObservableList;

import java.util.List;

public interface CartDAO {
    ObservableList<CartDTO> FindAllCartItems(int reg_seq);
}
