package com.kgitbank.megakgcoffee.Controller.Orders;

import com.kgitbank.megakgcoffee.Service.Orders.OrderServiceFactory;
import com.kgitbank.megakgcoffee.Service.Orders.OrdersService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    @FXML public Label category_menu_name_one;
    @FXML public Label category_menu_price_one;
    @FXML public Label category_menu_name_two;
    @FXML public Label category_menu_price_two;
    @FXML public Label category_menu_name_three;
    @FXML public Label category_menu_price_three;
    public Button[] arrayButtons;
    public Circle[] arrayCircles;
    public Label[] arrayLabelNames;
    public Label[] arrayLabelPrices;

    @FXML public VBox vboxHideTest; // todo :: test


    private OrdersService ordersService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ordersService = OrderServiceFactory.getOrderService();
        initializeButtonArray();
        initializeCircleArray();
        initializeLabel();
        ordersService.searchMenu(category_menu, arrayCircles, arrayLabelNames, arrayLabelPrices);

    }

    public void initializeButtonArray() {
        arrayButtons = new Button[4];
        arrayButtons[0] = category_coffee_selected;
        arrayButtons[1] = category_smoothie_selected;
        arrayButtons[2] = category_ade_selected;
        arrayButtons[3] = category_Dessert_selected;
    }

    public void initializeCircleArray() {
        arrayCircles = new Circle[3];
        arrayCircles[0] = category_circle_one;
        arrayCircles[1] = category_circle_two;
        arrayCircles[2] = category_circle_three;
    }

    public void initializeLabel() {
        arrayLabelNames = new Label[3];
        arrayLabelNames[0] = category_menu_name_one;
        arrayLabelNames[1] = category_menu_name_two;
        arrayLabelNames[2] = category_menu_name_three;

        arrayLabelPrices = new Label[3];
        arrayLabelPrices[0] = category_menu_price_one;
        arrayLabelPrices[1] = category_menu_price_two;
        arrayLabelPrices[2] = category_menu_price_three;

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
                ordersService.searchMenu(category_menu, arrayCircles, arrayLabelNames, arrayLabelPrices);
            }
        }

    }
}
