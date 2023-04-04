package com.kgitbank.megakgcoffee.Service.Register;

import com.kgitbank.megakgcoffee.Model.DAO.Register.LoginDAO;
import com.kgitbank.megakgcoffee.Model.DAO.Register.RegisterDAO;
import com.kgitbank.megakgcoffee.Model.DTO.Register.RegisterDTO;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

public class RegisterService {

    LoginDAO loginDao = new LoginDAO();
    RegisterDAO registerDAO = new RegisterDAO();

    public void regProc(RegisterDTO reg, Label confirm_check, PasswordField confirm) {
        // 아이디 중복 검증
//        String dbPw = loginDao.loginProc(reg.getReg_id());
//        if(dbPw != null) {
//            CommonService.msg("아이디가 사용 중 입니다.");
//            return;
//        }

        // 비밀번호와 비밀번호 확인이 일치하는지 검사
        if(reg.getReg_pwd().equals(reg.getConfirm()) == false){
            CommonService.msg("비밀번호가 일치하지 않습니다.");
            confirm.setStyle("-fx-border-color: red; -fx-border-width: 2px; -fx-background-color: rgb(255,198,198)");
            confirm_check.setText("비밀번호가 일치하지 않습니다.");
            confirm_check.setStyle("-fx-text-fill: red");
            return;
        }

        // 이름 입력 검사
        String nameStr = reg.getReg_name();
        if(nameStr.isEmpty()){
            CommonService.msg("이름을 입력해주세요.");
            return;
        }

        // 아이디 입력 검사
        String idStr = reg.getReg_id();
        if(idStr.isEmpty()){
            CommonService.msg("아이디를 입력해주세요.");
            return;
        }

        // 닉네임 입력 검사
        String nickStr = reg.getReg_nick();
        if(nickStr.isEmpty()){
            CommonService.msg("닉네임을 입력해주세요.");
            return;
        }

        // 비밀번호 입력 검사
        String pwStr = reg.getReg_pwd();
        if(pwStr.isEmpty()){
            CommonService.msg("비밀번호를 입력해주세요.");
            return;
        }

        // 전화번호 입력 검사
        String telStr = reg.getReg_tel();
        if(telStr.isEmpty()){
            CommonService.msg("전화번호를 입력해주세요.");
            return;
        }

        // 생년월일 입력 검사
        String birthStr = reg.getReg_birth();
        if(birthStr.isEmpty()){
            CommonService.msg("생년월일을 입력해주세요.");
            return;
        }

        // 회원 가입
//        RegisterDAO regDao = new RegisterDAO();
//        regDao.regProc(reg);

    }

    public boolean ExistId(String id) {
        return registerDAO.sameIdExist(id);
    }
}