package com.kgitbank.megakgcoffee.Service.Register;

import com.kgitbank.megakgcoffee.Model.DAO.Register.LoginDAO;
import com.kgitbank.megakgcoffee.Model.DAO.Register.RegisterDAO;
import com.kgitbank.megakgcoffee.Model.DTO.Register.RegisterDTO;
import com.kgitbank.megakgcoffee.Register;

public class RegisterService {
    public void regProc(RegisterDTO reg) {

        // 아이디 중복 검증
        LoginDAO loginDao = new LoginDAO();
        String dbPw = loginDao.loginProc(reg.getReg_id());
        if(dbPw != null) {
            CommonService.msg("아이디가 사용 중 입니다.");
            return;
        }

        if(reg.getReg_pwd().equals(reg.getConfirm()) == false){
            CommonService.msg("입력한 비밀번호가 다릅니다.");
            return;
        }

        // 회원 가입
        RegisterDAO regDao = new RegisterDAO();
        regDao.regProc(reg);

    }
}