package com.kgitbank.megakgcoffee.Model.DAO.HomeView;

import com.kgitbank.megakgcoffee.Controller.HomeView.HomeViewHomeController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeViewOpenerFactory {
    private Stage primayStage;

    public void setPrimayStage(Stage primayStage) {
        this.primayStage = primayStage;
    }

    public void LoginOpenProc(){ //로그인 버튼 누르면 Home 버튼이 열리게 끔 되는것.
        Stage HomeStage = new Stage();  // 홈 화면
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml")); // 홈 화면 FXML
        Parent HomeForm = null;  // Parent 객체 생성
        try {
            HomeForm = loader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        HomeViewHomeController HomeCon = loader.getController();
        HomeCon.setService(HomeForm);

        Scene scene = new Scene(HomeForm);
        HomeStage.setTitle("회원가입 화면");
        HomeStage.setScene(scene);
        HomeStage.show();
    }
}
