package com.kgitbank.megakgcoffee.Controller.Find;

import com.kgitbank.megakgcoffee.Opener.Opener;
import com.kgitbank.megakgcoffee.Service.Find.FindService;
import com.kgitbank.megakgcoffee.Service.Find.FindServiceFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class FindController implements Initializable {

    @FXML public TextField insert_name;
    @FXML public TextField insert_phone;
    @FXML public Label result_label;
    @FXML public BorderPane bp;
    @FXML public Button find_id_button;
    @FXML public AnchorPane ap;


    FindService findService;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        findService = FindServiceFactory.getFindService();
    }


    @FXML
    public void find_id(MouseEvent mouseEvent) {
        findService.FindId(insert_name.getText(), insert_phone.getText(), result_label);
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

    public void find_id_button(MouseEvent mouseEvent) {
        bp.setCenter(ap);
    }

    public void find_pwd_open(MouseEvent mouseEvent) {
        loadPage("FindPwd");
    }
}
