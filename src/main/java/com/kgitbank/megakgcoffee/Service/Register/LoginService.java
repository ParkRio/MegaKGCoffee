package com.kgitbank.megakgcoffee.Service.Register;

import com.kgitbank.megakgcoffee.Model.DAO.Register.LoginDAO;
import com.kgitbank.megakgcoffee.Model.DTO.OrderDetail.OrderDataSingleton;
import com.kgitbank.megakgcoffee.Model.DTO.Register.ResponseRegDTO;
import javafx.scene.control.Button;

public class LoginService {

    private LoginDAO loginDAO;
    OrderDataSingleton orderDataSingleton = OrderDataSingleton.getInstance();

    public LoginService() {
        loginDAO = new LoginDAO();
    }

    public void loginProc(String reg_id, String reg_pwd) {

        if(reg_id.isEmpty() || reg_pwd.isEmpty()) {
            CommonService.msg("아이디 또는 비밀번호를 입력하세요.");
            return;
        }

        String dbPw = loginDAO.loginProc(reg_id);

        if(dbPw == null || dbPw.isEmpty()) {
            CommonService.msg("아이디 또는 비밀번호를 한번 더 확인해주세요.");
            return;
        }

        if(dbPw.equals(reg_pwd)) {
            CommonService.msg("환영합니다!");
            orderDataSingleton.setYesOrNO("Y");
            //loginDAO.loginSuccess(reg_id);

        }else {
            CommonService.msg("비밀번호를 한번 더 확인해주세요.");
        }
    }

    public String loginCheck(String id) {
        return loginDAO.loginCheck(id);
    }

    public ResponseRegDTO registerInfo(String id, String pw) {
        return loginDAO.registerInfo(id, pw);
    }
}
