package com.kgitbank.megakgcoffee.Service.Orders;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

public interface OrdersService {
    void searchMenu(String category_menu, Circle[] arrayCircles, Label[] arrayLabelNames, Label[] arrayLabelPrices);
}
