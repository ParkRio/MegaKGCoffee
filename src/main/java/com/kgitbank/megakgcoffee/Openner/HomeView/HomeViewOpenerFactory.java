package com.kgitbank.megakgcoffee.Openner.HomeView;

import com.kgitbank.megakgcoffee.Model.DTO.HomeView.HomeViewDTO;
import com.kgitbank.megakgcoffee.Service.HomeView.HomeViewHomeService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class HomeViewOpenerFactory {

    HomeViewDTO dto = new HomeViewDTO();
    private Stage primaryStage;
    private HomeViewHomeService service;



    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
        service = new HomeViewHomeService();
    }


    public void LoginOpen() { //로그인 버튼 눌르면 // 로그인 창으로 이동 // 지금은 홈으로 이동 되게끔
//        main.
        //같은 창에서 fxml만 교체해서 열어야함.
        try{
            URL homePath = new File("src/main/resources/com/kgitbank/megakgcoffee/Fxml/HomeView_home.fxml").toURI().toURL();
            FXMLLoader fxmlLoader = new FXMLLoader(homePath);
            Parent form = fxmlLoader.load();
            primaryStage.setScene(new Scene(form));
            primaryStage.show();
        }catch (Exception e){
            e.printStackTrace();;
        }


        //되는 코드!!  ## 새창으로 열려서 다음 페이지로 이동
//        Stage homeStage = new Stage();  // 홈 화면
//        try {
//            URL homePath = new File("src/main/resources/com/kgitbank/megakgcoffee/Fxml/HomeView_home.fxml").toURI().toURL();
//            FXMLLoader homeLoader = new FXMLLoader(homePath);
//            Parent homeForm = homeLoader.load();
//            Scene homeScene = new Scene(homeForm);
//            homeStage.setTitle("홈 화면");
//            homeStage.setScene(homeScene);
//            homeStage.show();
//
//            service.BackButtonSave(dto,homePath,homeScene,homeForm);
//            System.out.println("login버튼에 있는 "+dto);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public void BackButton() {

        try {
            Stage backStage = new Stage();
            System.out.println("OpenerFactory에 있는 "+dto);
//            URL backPath = dto.getUrl();
            System.out.println("테스트 dto.getUrl : "+ dto.getUrl());
//            System.out.println("테스트 backpath : "+ backPath);
            URL backPath = new File("src/main/resources/com/kgitbank/megakgcoffee/Fxml/HomeView_main.fxml").toURI().toURL();
            FXMLLoader currentLoader = new FXMLLoader(backPath);

            Parent backForm = currentLoader.load();
            Scene backScene = new Scene(backForm);
            backStage.setTitle("test");
            backStage.setScene(backScene);
            backStage.show();
        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
