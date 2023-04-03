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

    public void NickName(Label nickLabel) {
        HomeViewDTO dto = new HomeViewDTO();
        homeViewDAO.Nickname(dto);
        String nick = dto.getTestId();
        nickLabel.setText(nick);

    }

}
