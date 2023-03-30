package com.kgitbank.megakgcoffee.Service.HomeView;

import com.kgitbank.megakgcoffee.Model.DAO.HomeView.HomeViewDAO;
import javafx.scene.control.Button;

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
//아이디 비번 입력했다면, 컨트롤러에서 서비스로 아디가 중복된게있는지 똑같은지


}
