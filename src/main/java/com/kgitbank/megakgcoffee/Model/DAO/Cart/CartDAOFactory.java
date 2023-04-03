package com.kgitbank.megakgcoffee.Model.DAO.Cart;

public class CartDAOFactory {

    public static CartDAO getCartDAO() {
        return new ICartDAO();
    }
}
