package com.kgitbank.megakgcoffee.Service.Register;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class CommonService {

    public static void msg(String contentText) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("알림");
        alert.setContentText(contentText);
        alert.show();
    }

    public static void windowsClose(Parent form) {
        Stage stage = (Stage)form.getScene().getWindow();
        stage.close();
    }
}
