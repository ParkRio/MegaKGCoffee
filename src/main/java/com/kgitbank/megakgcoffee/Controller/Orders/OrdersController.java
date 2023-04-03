package com.kgitbank.megakgcoffee.Controller.Orders;

import com.kgitbank.megakgcoffee.Model.DTO.OrderDetail.OrderDataSingleton;
import com.kgitbank.megakgcoffee.Opener.Opener;
import com.kgitbank.megakgcoffee.Service.OrderCheck.OrderCheckServiceFactory;
import com.kgitbank.megakgcoffee.Service.OrderCheck.OrderCheckService;
import com.kgitbank.megakgcoffee.Service.Orders.OrderServiceFactory;
import com.kgitbank.megakgcoffee.Service.Orders.OrdersService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class OrdersController implements Initializable {

    public Button back_to_main;
    public Text order_text;
    public String category_menu = "coffee";

    @FXML public Button category_coffee_selected;
    @FXML public Button category_smoothie_selected;
    @FXML public Button category_ade_selected;
    @FXML public Button category_Dessert_selected;

    @FXML public Circle category_circle_one;
    @FXML public Circle category_circle_two;
    @FXML public Circle category_circle_three;
    @FXML public Circle category_circle_four;
    @FXML public Circle category_circle_five;
    @FXML public Circle category_circle_six;

    @FXML public Label category_menu_name_one;
    @FXML public Label category_menu_price_one;
    @FXML public Label category_menu_name_two;
    @FXML public Label category_menu_price_two;
    @FXML public Label category_menu_name_three;
    @FXML public Label category_menu_price_three;
    @FXML public Label category_menu_name_four;
    @FXML public Label category_menu_price_four;
    @FXML public Label category_menu_name_five;
    @FXML public Label category_menu_price_five;
    @FXML public Label category_menu_name_six;
    @FXML public Label category_menu_price_six;

    @FXML public VBox order_vbox_one;
    @FXML public VBox order_vbox_two;
    @FXML public VBox order_vbox_three;
    @FXML public VBox order_vbox_four;
    @FXML public VBox order_vbox_five;
    @FXML public VBox order_vbox_six;

    @FXML public Label how_many_items;
    @FXML public Button cart_items;

    public Button[] arrayButtons;
    public Circle[] arrayCircles;
    public Label[] arrayLabelNames;
    public Label[] arrayLabelPrices;
    public VBox[] arrayVBoxes;

    private OrdersService ordersService;
    private OrderCheckService orderCheckService;
    private Opener opener;
    private OrderDataSingleton orderDataSingleton;

    public void setOpener(Opener opener) {
        this.opener = opener;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ordersService = OrderServiceFactory.getOrderService();
        orderCheckService = OrderCheckServiceFactory.getOrderCheckService();
        orderDataSingleton = OrderDataSingleton.getInstance();
        initializeVBoxArray();
        initializeButtonArray();
        initializeCircleArray();
        initializeLabel();
        category_coffee_selected.setStyle("-fx-background-radius: 15px;\n" +
                "    -fx-background-color: black;\n" +
                "    -fx-text-fill: white;");
        ordersService.searchMenu(category_menu, arrayCircles, arrayLabelNames, arrayLabelPrices, arrayVBoxes, how_many_items);
        cart_items.setText(String.valueOf(orderCheckService.findItemsInTheCart(1))); // todo :: 회원번호 1번으로 실험

    }

    public void initializeButtonArray() {
        arrayButtons = new Button[4];
        arrayButtons[0] = category_coffee_selected;
        arrayButtons[1] = category_smoothie_selected;
        arrayButtons[2] = category_ade_selected;
        arrayButtons[3] = category_Dessert_selected;
    }

    public void initializeVBoxArray() {
        arrayVBoxes = new VBox[6]; // VBox 추후 6개로 고정
        arrayVBoxes[0] = order_vbox_one;
        arrayVBoxes[1] = order_vbox_two;
        arrayVBoxes[2] = order_vbox_three;
        arrayVBoxes[3] = order_vbox_four;
        arrayVBoxes[4] = order_vbox_five;
        arrayVBoxes[5] = order_vbox_six;
    }

    public void initializeCircleArray() {
        arrayCircles = new Circle[6]; // 추후 6개로 고정
        arrayCircles[0] = category_circle_one;
        arrayCircles[1] = category_circle_two;
        arrayCircles[2] = category_circle_three;
        arrayCircles[3] = category_circle_four;
        arrayCircles[4] = category_circle_five;
        arrayCircles[5] = category_circle_six;
    }

    public void initializeLabel() { // 추후 6개씩 고정
        arrayLabelNames = new Label[6];
        arrayLabelNames[0] = category_menu_name_one;
        arrayLabelNames[1] = category_menu_name_two;
        arrayLabelNames[2] = category_menu_name_three;
        arrayLabelNames[3] = category_menu_name_four;
        arrayLabelNames[4] = category_menu_name_five;
        arrayLabelNames[5] = category_menu_name_six;

        arrayLabelPrices = new Label[6];
        arrayLabelPrices[0] = category_menu_price_one;
        arrayLabelPrices[1] = category_menu_price_two;
        arrayLabelPrices[2] = category_menu_price_three;
        arrayLabelPrices[3] = category_menu_price_four;
        arrayLabelPrices[4] = category_menu_price_five;
        arrayLabelPrices[5] = category_menu_price_six;
    }

    @FXML
    public void categoryPressed(ActionEvent event) {
        for (Button button : arrayButtons) {
            button.setStyle("-fx-background-color: white;\n");

        }
        for (Button arrayButton : arrayButtons) {
            if (event.getSource().equals(arrayButton)) {
                arrayButton.setStyle("-fx-background-radius: 15px;\n" +
                        "    -fx-background-color: black;\n" +
                        "    -fx-text-fill: white;");
                category_menu = arrayButton.getText().toLowerCase();
                ordersService.searchMenu(category_menu, arrayCircles, arrayLabelNames, arrayLabelPrices, arrayVBoxes, how_many_items);
            }
        }
    }


    // 주문 상세 화면으로 넘어가는 클릭 이벤트
    public void goOrderDetails(MouseEvent mouseEvent) {
        Node node = (Node) mouseEvent.getSource(); // 이벤트를 발생시킨 객체 정보를 받아온다.
        opener.OrderDetailPageOpen(node.getId());
    }

    // 장바구니 화면으로 넘어가는 클릭 이벤트
    public void go_to_cart(MouseEvent mouseEvent) {
        opener.CartPageOpen();
    }
}
