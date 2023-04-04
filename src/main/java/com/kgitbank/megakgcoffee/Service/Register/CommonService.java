package com.kgitbank.megakgcoffee.Service.Register;

import javafx.scene.control.Alert;

public class CommonService {

    public static void msg(String contentText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("알림");
        alert.setContentText(contentText);
        alert.show();
    }
}
