package com.kgitbank.megakgcoffee.Service.Orders;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import org.w3c.dom.Text;

public interface OrdersService {
    void searchMenu(String category_menu, Circle[] arrayCircles, Label[] arrayLabelNames, Label[] arrayLabelPrices, VBox[] arrayVBoxes, Label how_many_items);
    int countMenus(String category_menu);
}
