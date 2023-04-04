package com.kgitbank.megakgcoffee.Controller.Member;


import com.kgitbank.megakgcoffee.Model.DTO.OrderDetail.OrderDataSingleton;
import com.kgitbank.megakgcoffee.Model.DTO.Register.ResponseRegDTO;
import com.kgitbank.megakgcoffee.Opener.Opener;
import com.kgitbank.megakgcoffee.Service.Member.IMemberService;
import com.kgitbank.megakgcoffee.Service.Register.LoginService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class MemberController implements Initializable {

    @FXML private Label nickLabel;
    @FXML private Label birthLabel;
    @FXML private Label phoneLabel;
    private LoginService loginService;
    Opener opener;
    OrderDataSingleton orderDataSingleton = OrderDataSingleton.getInstance();  //싱글톤을 가져옴.

    public void setOpener(Opener opener) {
        this.opener = opener;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        loginService = new LoginService(); 새롭게 로그인 서비스를 하면 안될것 같음.
    }

    public void MemberLoadProc() {
        String reg_id;
        String reg_pw;

        reg_id = orderDataSingleton.getReg_id();
//        reg_pw = orderDataSingleton.getReg_pw();
        nickLabel.setText(reg_id);


    }


}
