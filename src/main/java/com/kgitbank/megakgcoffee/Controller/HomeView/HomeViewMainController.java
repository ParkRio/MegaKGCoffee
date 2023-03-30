package com.kgitbank.megakgcoffee.Controller.HomeView;

import com.kgitbank.megakgcoffee.Model.DAO.HomeView.HomeViewOpenerFactory;
import com.kgitbank.megakgcoffee.Service.HomeView.HomeViewService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class HomeViewMainController implements Initializable {

    @FXML
    private Button homeview_loginBtn;
    private HomeViewService service;
    private HomeViewOpenerFactory factory;
    private Parent HomeForm;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        service = new HomeViewService();
        factory = new HomeViewOpenerFactory();
    }
    // 어떤 서비스로 보낼것인가  크게 많은 코드는  X  , 어떤 메소드에 따라서 어떤 메소드 인자값,  이니셜이 처음시작될떄!
    // 팩토리 =>  서비스 이데이오  랑 연결을 할때 팩토리에서 가져오는데, 디에오 임플리먼트는 재정의 필욯니까! 디에오로 반환값이 테스트디에오
    //



    public void setFactory(HomeViewOpenerFactory factory) {
        this.factory = factory;
    }

    @FXML
    private void handleLoginBtn(ActionEvent event) {
        factory.LoginOpenProc();
        service.LoginButtonClick(homeview_loginBtn);
    }



}

