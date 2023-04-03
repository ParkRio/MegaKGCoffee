package com.kgitbank.megakgcoffee.Controller.OrderDetail;

import com.kgitbank.megakgcoffee.Controller.Payment.OrderPaymentController;
import com.kgitbank.megakgcoffee.Model.DTO.OrderDetail.OrderDataSingleton;
import com.kgitbank.megakgcoffee.Opener.Opener;
import com.kgitbank.megakgcoffee.Service.OrderDetailService.OrderDetailService;
import com.kgitbank.megakgcoffee.Service.OrderDetailService.OrderDetailServiceFactory;
import com.kgitbank.megakgcoffee.Service.OrderItem.OrderItemService;
import com.kgitbank.megakgcoffee.Service.OrderItem.OrderItemServiceFactory;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class OrderDetailController implements Initializable {

    OrderDataSingleton orderDataSingleton = OrderDataSingleton.getInstance();
    private OrderDetailService orderDetailService;
    private OrderItemService orderItemService;

    @FXML public Circle menu_detail;
    @FXML public Label menu_name;
    @FXML public Label menu_desc;
    @FXML public Label menu_count;
    @FXML public Label menu_price;
    @FXML public Label base_menu_price;

    private Opener opener;

    public void setOpener(Opener opener) {
        this.opener = opener;
    }

    Label[] labels;

    int cnt = 1;
    int price;
    int total_price;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orderDetailService = OrderDetailServiceFactory.getOrderDetailService();
        orderItemService = OrderItemServiceFactory.getOrderItemService();
        initializeLabel();
        menu_count.setText(String.valueOf(cnt));
        price = orderDetailService.selectedOrder(orderDataSingleton.getMenu_seq(), menu_detail, labels);
        total_price = price;
    }

    public void initializeLabel() {
        labels = new Label[4];
        labels[0] = menu_name;
        labels[1] = base_menu_price;
        labels[2] = menu_desc;
        labels[3] = menu_price;
    }

    public void plus_count_button(MouseEvent mouseEvent) {
        cnt++; menu_count.setText(String.valueOf(cnt));
        menu_price.setText(String.valueOf(price*cnt));
        total_price = price*cnt;
        System.out.println(total_price);
    }

    public void minus_count_button(MouseEvent mouseEvent) {
        if (cnt <= 1) {
            if (mouseEvent.getClickCount() >= 10) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INFORMATION");
                alert.setHeaderText("정보");
                alert.setContentText("주문 상품의 개수는 1 이하로 내려가지 않습니다.");
                alert.showAndWait();
            }
        } else {
            cnt--; menu_count.setText(String.valueOf(cnt));
            menu_price.setText(String.valueOf(total_price-price));
            total_price = total_price-price;
            System.out.println(total_price);
        }
    }
    
    // 장바구니에 담기
    public void add_to_cart(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("CONFIRMATION");
        alert.setHeaderText("장바구니 추가 여부 확인");
        alert.setContentText("선택하는 사항을 장바구니에 추가하시겠습니까?");
        Optional<ButtonType> click = alert.showAndWait();
        if (click.get() == ButtonType.OK) {
            orderItemService.insertOrderItem(orderDataSingleton.getMenu_seq(), cnt, total_price);
            Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
            alertInfo.setTitle("INFORMATION");
            alertInfo.setHeaderText("감사합니다.");
            alertInfo.setContentText("장바구니에 상품이 추가되었습니다.");
            Optional<ButtonType> clickInfo = alertInfo.showAndWait();
            if (clickInfo.get() == ButtonType.OK) {
                back_to_orders(mouseEvent);
            } else {
                back_to_orders(mouseEvent);
            }

        } else {
            System.out.println("상품 등록 안됨"); // todo :: 다른 좋은 방법있나 확인해보자.
        }
    }

    // 바로 주문
    public void order_now(MouseEvent mouseEvent) {
        orderItemService.orderNow(orderDataSingleton.getMenu_seq(), cnt, total_price);
        orderDataSingleton.setCheckOrder(2);
        Stage stage = (Stage) menu_detail.getScene().getWindow();
        Opener opener = new Opener();
        opener.OrderPayment(stage);

        // todo :: Alert 추후 삭제
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("CONFIRMATION");
//        alert.setHeaderText("즉시 주문");
//        alert.setContentText("결제 창으로 연결되면 Alert 삭제");
//        alert.showAndWait();

    }

    // 주문 페이지 뒤로 가기
    public void back_to_orders(MouseEvent mouseEvent) {
        Stage stage = (Stage) menu_detail.getScene().getWindow();
        Opener opener = new Opener();
        opener.BackToOrderPage(stage);
    }


}
