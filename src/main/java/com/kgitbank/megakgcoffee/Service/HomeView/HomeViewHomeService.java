package com.kgitbank.megakgcoffee.Service.HomeView;

import com.kgitbank.megakgcoffee.Model.DAO.HomeView.HomeViewDAO;
import com.kgitbank.megakgcoffee.Model.DAO.Register.RegisterDAO;
import com.kgitbank.megakgcoffee.Model.DTO.HomeView.HomeViewDTO;
import com.kgitbank.megakgcoffee.Model.DTO.Register.RegisterDTO;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;

public class HomeViewHomeService {

//    private HomeViewDAO homeViewDAO;
    private RegisterDAO registerDAO;

    public HomeViewHomeService() {
//        homeViewDAO = new HomeViewDAO();
        registerDAO = new RegisterDAO();

    }

//    public void NickName(Label nickLabel) {  //homeview에서 home 화면에 ㅇㅇ님 안녕하세요 변경되는 코드
//        RegisterDTO dto = new RegisterDTO();
//        //set 을 넣고,
//        dto.setReg_id();
//        registerDAO.Nickname(dto);
//        String nick = dto.setReg_id(dto.getReg_id());
//        dto.setReg_nick(nick);
//
////
//
////        System.out.println("nick"+nick);
//        nickLabel.setText(nick);
//
//    }

}
