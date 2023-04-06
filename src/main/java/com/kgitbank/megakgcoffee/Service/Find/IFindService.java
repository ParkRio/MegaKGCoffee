package com.kgitbank.megakgcoffee.Service.Find;

import com.kgitbank.megakgcoffee.Model.DAO.Find.FindDAO;
import com.kgitbank.megakgcoffee.Model.DAO.Find.FindDAOFactory;
import com.kgitbank.megakgcoffee.Model.DTO.Register.ResponseRegDTO;
import javafx.scene.control.Label;

public class IFindService implements FindService{

    FindDAO findDAO = FindDAOFactory.getFindDAO();


    @Override
    public void FindId(String name, String phone, Label label) {

        if (name == null || phone == null) {
            label.setStyle("-fx-text-fill: red");
            label.setText("입력창이 비워져있습니다.");
        } else {
            ResponseRegDTO responseRegDTO = findDAO.findId(name, phone);
            if (responseRegDTO == null) {
                label.setStyle("-fx-text-fill: red");
                label.setText("등록된 회원정보가 없습니다.");
            } else {
                label.setStyle("-fx-text-fill: green");
                label.setText(findDAO.findId(name,phone).getReg_id());
            }
        }
    }

    @Override
    public void FindPwd(String id, String Phone, String Birthday, Label label) {
        if (id == null || Phone == null || Birthday == null) {
            label.setStyle("-fx-text-fill: red");
            label.setText("입력창이 비워져있습니다.");
        } else {
            String pwd = findDAO.findPwd(id, Phone, Birthday);
            if (pwd == null) {
                label.setStyle("-fx-text-fill: red");
                label.setText("등록된 회원정보가 없습니다.");
            } else {
                label.setStyle("-fx-text-fill: green");
                label.setText(pwd);
            }
        }
    }
}
