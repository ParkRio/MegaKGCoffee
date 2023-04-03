package com.kgitbank.megakgcoffee.Service.Cart;

public class CartServiceFactory {

    public static CartService getCartService() {
        return new ICartService();
    }
}
