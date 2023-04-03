package com.kgitbank.megakgcoffee.Service.OrderDetailService;

import javafx.scene.control.Label;
import javafx.scene.shape.Circle;

public interface OrderDetailService {
    int selectedOrder(String menu_seq, Circle circle, Label[] label);
}
