package com.kgitbank.megakgcoffee.Controller.Payment;

import com.kgitbank.megakgcoffee.Model.DTO.Cart.CartDTO;
import com.kgitbank.megakgcoffee.Model.DTO.OrderDetail.OrderDataSingleton;
import com.kgitbank.megakgcoffee.Model.DTO.Payment.CartPaymentDTO;
import com.kgitbank.megakgcoffee.Model.DTO.Payment.FindOrderPaymentDTO;
import com.kgitbank.megakgcoffee.Opener.Opener;
import com.kgitbank.megakgcoffee.Service.Payment.OrderPaymentService;
import com.kgitbank.megakgcoffee.Service.Payment.OrderPaymentServiceFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OrderPaymentController implements Initializable {

    @FXML public Circle payment_menu_img;
    @FXML public Label payment_menu_name;
    @FXML public Label payment_how_many;
    @FXML public Label payment_total_price;
    @FXML public Label payment_one_price;
    OrderDataSingleton orderDataSingleton = OrderDataSingleton.getInstance();

    private Opener opener;
    private OrderPaymentService orderPaymentService;
    FindOrderPaymentDTO findOrderPaymentDTO;
    CartPaymentDTO cartPaymentDTO;

    public void setOpener(Opener opener) {
        this.opener = opener;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orderPaymentService = OrderPaymentServiceFactory.getOrderPaymentService();
        if (orderDataSingleton.getCheckOrder() == 2) {
            findOrderNowMenu(orderDataSingleton.getOrder_item_seq(), 1); // todo :: 테스트회원 1
        } else if (orderDataSingleton.getCheckOrder() == 0) {
            AllCartOrdersToPayment(orderDataSingleton.getArrayList(), 1); // todo :: 테스트회원 1
        }
    }

    public void findOrderNowMenu(int order_item_seq, int checkReg_seq) {
        findOrderPaymentDTO = orderPaymentService.findByOrderNow(order_item_seq, checkReg_seq);
        Image img = new Image(findOrderPaymentDTO.getMenu_img());
        payment_menu_img.setFill(new ImagePattern(img));
        payment_menu_img.setEffect(new DropShadow(+25d, 0d, +2d, Color.YELLOW));
        payment_menu_name.setText(findOrderPaymentDTO.getMenu_name());
        payment_one_price.setText(String.valueOf(findOrderPaymentDTO.getMenu_price()));
        payment_how_many.setText(String.valueOf(findOrderPaymentDTO.getItem_count()) + " 개");
        payment_total_price.setText(String.valueOf(findOrderPaymentDTO.getItem_price()));
    }

    public void AllCartOrdersToPayment(ArrayList<CartDTO> cartDTOArrayList, int checkReg_seq) {
        cartPaymentDTO = orderPaymentService.AllCartItems(cartDTOArrayList, checkReg_seq);
        Image img = new Image("https://img.79plus.co.kr/megahp/common/img/menu01_1_product.jpg?ver=202211170800");
        payment_menu_img.setFill(new ImagePattern(img));
        payment_menu_img.setEffect(new DropShadow(+25d, 0d, +2d, Color.YELLOW));
        payment_menu_name.setText("전체 상품");
        payment_one_price.setText("");
        payment_how_many.setText(String.valueOf(cartPaymentDTO.getItem_count()));
        payment_total_price.setText(String.valueOf(cartPaymentDTO.getItem_price()));
    }

    public void payment_back_to_orders(MouseEvent mouseEvent) {
        if (orderDataSingleton.getCheckOrder() == 2) {
            orderPaymentService.deleteOrderNow(findOrderPaymentDTO.getCheck_seq());
        }
        Stage stage = (Stage) payment_menu_img.getScene().getWindow();
        Opener opener = new Opener();
        opener.PaymentForBackToOrderPage(stage);
    }
}
