package com.kgitbank.megakgcoffee.Service.HomeView;

import com.kgitbank.megakgcoffee.Model.DAO.HomeView.HomeViewDAO;
import com.kgitbank.megakgcoffee.Model.DTO.HomeView.HomeViewDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class HomeViewService {

    private HomeViewDAO homeViewDAO;

    public HomeViewService() {
        homeViewDAO = new HomeViewDAO();

    }

    public void LoginButtonClick(Button homeview_login) {
        homeview_login.setOnMouseClicked(e -> {
            System.out.println("click");
        });
    }

    public void MenuButtonClick(Label label){

    }
    public void BackButtonSave(HomeViewDTO dto, URL path, Scene scene, Parent parent){
        // button 은 눌릴 버튼 , // path 는 이전 패쓰가 들어가야함
        // scene 는 이전 씬 들어가야함, // stage 는 이전 스테이지 들어가야함
        dto.setUrl(path); // 뒤로 갈 경로 등록
        dto.setBackScene(scene); // 뒤로 갈 Scene 등록
        dto.setParent(parent);
        System.out.println("dto BackButtonSave에 있음"+dto);


//        System.out.println(dto.getParent());
//        System.out.println(dto.getUrl());
//        System.out.println(dto.getBackScene());

    }




}
