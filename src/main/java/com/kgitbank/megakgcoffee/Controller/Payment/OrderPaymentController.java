package com.kgitbank.megakgcoffee.Controller.Payment;

import com.kgitbank.megakgcoffee.Model.DTO.Cart.CartDTO;
import com.kgitbank.megakgcoffee.Model.DTO.OrderDetail.OrderDataSingleton;
import com.kgitbank.megakgcoffee.Model.DTO.Payment.CartPaymentDTO;
import com.kgitbank.megakgcoffee.Model.DTO.Payment.FindOrderPaymentDTO;
import com.kgitbank.megakgcoffee.Opener.Opener;
import com.kgitbank.megakgcoffee.Service.Payment.OrderPaymentService;
import com.kgitbank.megakgcoffee.Service.Payment.OrderPaymentServiceFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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

    @FXML public ListView menu_list;

    private ObservableList<CartPaymentDTO> items;
    private ObservableList<FindOrderPaymentDTO> items_order_now;

    OrderDataSingleton orderDataSingleton = OrderDataSingleton.getInstance();

    private Opener opener;
    private OrderPaymentService orderPaymentService;
    FindOrderPaymentDTO findOrderPaymentDTO;

    int total_price = 0;

    public void setOpener(Opener opener) {
        this.opener = opener;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        orderPaymentService = OrderPaymentServiceFactory.getOrderPaymentService();
        if (orderDataSingleton.getCheckOrder() == 2) { // 바로 주문에서 접근
            findOrderNowMenu(orderDataSingleton.getOrder_item_seq(), orderDataSingleton.getReg_seq()); // todo :: 테스트회원 1
            menu_list.setItems(items_order_now);
            payment_total_price.setText(String.valueOf(total_price));
        } else if (orderDataSingleton.getCheckOrder() == 0) { // 장바구니에서 접근

            System.out.println("12321321321321321");
            System.out.println(orderDataSingleton.getReg_seq());
            System.out.println(orderDataSingleton.getArrayList().get(0).getMenu_name());

            AllCartOrdersToPaymentList(orderDataSingleton.getArrayList(), orderDataSingleton.getReg_seq()); // todo :: 테스트회원 1
            menu_list.setItems(items);
            payment_total_price.setText(String.valueOf(total_price));
        }
    }

    // 바로 주문 리스트
    public void findOrderNowMenu(int order_item_seq, int checkReg_seq) {
        findOrderPaymentDTO = orderPaymentService.findByOrderNow(order_item_seq, checkReg_seq);
        items_order_now = FXCollections.observableArrayList();
        items_order_now.add(findOrderPaymentDTO);
        menu_list.setCellFactory(listView -> new ListCell<FindOrderPaymentDTO>() {
            private ImageView imageView = new ImageView();
            @Override
            public void updateItem(FindOrderPaymentDTO menu_lists, boolean empty) {
                super.updateItem(menu_lists, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    Image image = new Image(menu_lists.getMenu_img());
                    imageView.setImage(image);
                    imageView.setFitHeight(100);
                    imageView.setFitWidth(100);
                    imageView.setEffect(new DropShadow(+25d, 0d, +2d, Color.YELLOW));

                    HBox hBox = new HBox();
                    hBox.maxWidthProperty().bind(menu_list.widthProperty());
                    hBox.setAlignment(Pos.CENTER_LEFT);
                    hBox.setSpacing(50);
                    hBox.getChildren().addAll(
                            imageView,
                            new Label(menu_lists.getMenu_name()),
                            new Label("단품 가격 :" + menu_lists.getMenu_price()),
                            new Label("선택 수량 :" + menu_lists.getItem_count()),
                            new Label("총 가격 :" + menu_lists.getItem_price())
                    );
                    setGraphic(hBox);
                }
            }
        });
        total_price = findOrderPaymentDTO.getItem_price();
    }

    // 카트 리스트
    public void AllCartOrdersToPaymentList(ArrayList<CartDTO> cartDTOArrayList, int checkReg_seq) {
        items = orderPaymentService.AllCartItems(cartDTOArrayList, checkReg_seq);

        System.out.println("======asddssaddasadasd");
        // System.out.println(items.get(0).getMenu_name());
        System.out.println(items.size());

        menu_list.setCellFactory(listView -> new ListCell<CartPaymentDTO>() {
            private ImageView imageView = new ImageView();
            @Override
            public void updateItem(CartPaymentDTO menu_lists, boolean empty) {
                super.updateItem(menu_lists, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {

                    Image image = new Image(menu_lists.getMenu_img());
                    imageView.setImage(image);
                    imageView.setFitHeight(100);
                    imageView.setFitWidth(100);
                    imageView.setEffect(new DropShadow(+25d, 0d, +2d, Color.YELLOW));

                    HBox hBox = new HBox();
                    hBox.maxWidthProperty().bind(menu_list.widthProperty());
                    hBox.setAlignment(Pos.CENTER_LEFT);
                    hBox.setSpacing(50);
                    hBox.getChildren().addAll(
                            imageView,
                            new Label(menu_lists.getMenu_name()),
                            new Label("단품 가격 :" + menu_lists.getMenu_price()),
                            new Label("선택 수량 :" + menu_lists.getItem_count()),
                            new Label("총 가격 :" + menu_lists.getItem_price())
                    );
                    setGraphic(hBox);
                }
            }
        });
        for (CartPaymentDTO cart : items) {
            total_price += cart.getItem_price();
        }
    }

    public void payment_back_to_orders(MouseEvent mouseEvent) {
        if (orderDataSingleton.getCheckOrder() == 2) {
            orderPaymentService.deleteOrderNow(findOrderPaymentDTO.getCheck_seq());
        }
        Stage stage = (Stage) payment_menu_img.getScene().getWindow();
        Opener opener = new Opener();
        opener.PaymentForBackToOrderPage(stage);
    }

    public void finish_payment(MouseEvent mouseEvent) {
        if (orderDataSingleton.getCheckOrder() == 2) { // 바로주문이다.
            orderPaymentService.updateOrderNowFinished(findOrderPaymentDTO.getCheck_seq(), orderDataSingleton.getReg_seq());
        } else if(orderDataSingleton.getCheckOrder() == 0) {
            orderPaymentService.updateCartOrderFinished(orderDataSingleton.getArrayList(), orderDataSingleton.getReg_seq());
        }
    }
}
