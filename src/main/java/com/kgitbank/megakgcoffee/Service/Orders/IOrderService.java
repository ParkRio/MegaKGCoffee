package com.kgitbank.megakgcoffee.Service.Orders;

import com.kgitbank.megakgcoffee.Model.DAO.Orders.OrderDAOFactory;
import com.kgitbank.megakgcoffee.Model.DAO.Orders.OrdersDAO;
import com.kgitbank.megakgcoffee.Model.DTO.Orders.OrdersDTO;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class IOrderService implements OrdersService{

    OrdersDAO ordersDAO = OrderDAOFactory.getOrdersDAO();


    @Override
    public void searchMenu(String category_menu, Circle[] arrayCircles, Label[] arrayLabelNames, Label[] arrayLabelPrices) {
        if (category_menu.equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("뜻하지 않은 오류로 에러가 발생했습니다.");
            alert.show();
        } else {
            List<OrdersDTO> ordersDTOS = ordersDAO.selectMenu(category_menu);
            if(!ordersDTOS.isEmpty()) {
                for (int i = 0; i < ordersDTOS.size(); i++) { // todo :: 지금 데이터 3개
                    Image img = new Image(ordersDTOS.get(i).getMenu_img());
                    arrayCircles[i].setFill(new ImagePattern(img));
                    arrayCircles[i].setEffect(new DropShadow(+25d, 0d, +2d, Color.YELLOW));
                    arrayLabelNames[i].setText(ordersDTOS.get(i).getMenu_name());
                    arrayLabelPrices[i].setText(String.valueOf(ordersDTOS.get(i).getMenu_price()));
                }
//                for (int k = ordersDTOS.size()+1; k <= arrayCircles.length; k++) {
//
//                }

            }
        }
    }
}
