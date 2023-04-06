package com.kgitbank.megakgcoffee.Controller.UserSetting;

import com.kgitbank.megakgcoffee.Model.DTO.OrderDetail.OrderDataSingleton;
import com.kgitbank.megakgcoffee.Model.DTO.UserSetting.UserSettingDTO;
import com.kgitbank.megakgcoffee.Service.Register.CommonService;
import com.kgitbank.megakgcoffee.Service.UserSetting.UserSettingService;
import com.kgitbank.megakgcoffee.Service.UserSetting.UserSettingServiceFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.File;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.ResourceBundle;

public class UserSettingController implements Initializable {
    @FXML public PieChart pie_chart;
    @FXML public BorderPane bp;
    @FXML public TextField change_nickname;
    @FXML public Button change_nickname_button;
    @FXML public AnchorPane ap;

    ObservableList<UserSettingDTO> userSettingDTOS = FXCollections.observableArrayList();
    ObservableList<PieChart.Data> pieData = FXCollections.observableArrayList();

    UserSettingService userSettingService;
    OrderDataSingleton orderDataSingleton = OrderDataSingleton.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        userSettingService  = UserSettingServiceFactory.getUserSettingService();
        setPie_chart();
    }

    public void setPie_chart() {
        userSettingDTOS = userSettingService.userPurchase(orderDataSingleton.getReg_seq());

        if (userSettingDTOS.size() == 0) {
            pieData.add(new PieChart.Data("현재 구매정보가 없습니다.", 1));
            pie_chart = new PieChart(pieData);
        }
        else if (userSettingDTOS != null) {
            for (UserSettingDTO dto : userSettingDTOS) {
                pieData.add(new PieChart.Data(dto.getMenu_name() + " (" + dto.getCount_purchase() + ")", dto.getCount_purchase()));
            }
            pie_chart = new PieChart(pieData);
        }

        pie_chart.setTitle("Your PurChase");
        pie_chart.setClockwise(true);
        pie_chart.setLabelLineLength(50);
        pie_chart.setStartAngle(180);

        bp.setBottom(pie_chart);
    }

    @FXML
    public void change_nickname_button(MouseEvent mouseEvent) {
        if (change_nickname.getText().isEmpty()) {
            CommonService.msg("닉네임을 입력해주세요.");
        } else {
            userSettingService.ChangeNickName(change_nickname.getText());
        }
    }

    private void loadPage(String page) {
        Parent root = null;
        try {
            URL fxmlPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Fxml/"+ page + ".fxml").toURI().toURL();
            FXMLLoader fxmlLoader = new FXMLLoader(fxmlPath);
            root = fxmlLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        bp.setCenter(root);
    }

    @FXML
    public void nickname_changed(MouseEvent mouseEvent) {
        bp.setCenter(ap);
    }

    @FXML
    public void password_changed(MouseEvent mouseEvent) {
        loadPage("PasswordChange");
    }

    @FXML
    public void withdrawal_button(MouseEvent mouseEvent) {
        loadPage("Withdrawal");
    }
}
