package com.kgitbank.megakgcoffee.Service.Cart;

import com.kgitbank.megakgcoffee.Model.DAO.Cart.CartDAO;
import com.kgitbank.megakgcoffee.Model.DAO.Cart.CartDAOFactory;
import com.kgitbank.megakgcoffee.Model.DTO.Cart.CartDTO;
import javafx.collections.ObservableList;

import java.util.List;

public class ICartService implements CartService{

    CartDAO cartDAO = CartDAOFactory.getCartDAO();

    @Override
    public ObservableList<CartDTO> findAllCartItems(int reg_seq) {
        return cartDAO.FindAllCartItems(reg_seq);
    }
}
