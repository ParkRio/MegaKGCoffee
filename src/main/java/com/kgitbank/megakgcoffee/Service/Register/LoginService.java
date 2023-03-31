package com.kgitbank.megakgcoffee.Service.Register;

import com.kgitbank.megakgcoffee.Model.DAO.Register.LoginDAO;
import javafx.scene.control.Button;

public class LoginService {
    private LoginDAO loginDAO;

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
            CommonService.msg("로그인 실패");
            return;
        }

        if(dbPw.equals(reg_pwd)) {
            loginDAO.loginSuccess(reg_id);
        }else {
            CommonService.msg("로그인 실패");
        }
    }

    public String loginCheck(String id) {
        return loginDAO.loginCheck(id);
    }
}
