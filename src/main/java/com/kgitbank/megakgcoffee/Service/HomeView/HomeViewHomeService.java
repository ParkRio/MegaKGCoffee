package com.kgitbank.megakgcoffee.Service.HomeView;

import com.kgitbank.megakgcoffee.Model.DAO.HomeView.HomeViewDAO;
import com.kgitbank.megakgcoffee.Model.DTO.HomeView.HomeViewDTO;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;

public class HomeViewHomeService {

    private HomeViewDAO homeViewDAO;

    public HomeViewHomeService() {
        homeViewDAO = new HomeViewDAO();

    }

    public void NickName(Label nickLabel) {  //homeview에서 home 화면에 ㅇㅇ님 안녕하세요 변경되는 코드
        HomeViewDTO dto = new HomeViewDTO();
        dto.setTestId("dd");
        homeViewDAO.Nickname(dto);

        String nick = dto.getTestId();
        System.out.println("nick"+nick);
        nickLabel.setText(nick);

    }

}
