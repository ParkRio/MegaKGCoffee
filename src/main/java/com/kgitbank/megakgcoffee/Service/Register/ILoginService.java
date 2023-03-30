package com.kgitbank.megakgcoffee.Service.Register;

import com.kgitbank.megakgcoffee.Model.DAO.Register.ILoginDAO;

public class ILoginService implements LoginService {
    private ILoginDAO dao;

    public ILoginService() {
        dao = new ILoginDAO();
    }

    @Override
    public void loginProc(String id, String pw) {
        if(id.isEmpty() || pw.isEmpty()) {
            CommonService.msg("아이디 또는 비밀번호를 입력하세요.");
            return;
        }

        String dbPw = dao.loginProc(id);
        if(dbPw == null || dbPw.isEmpty()) {
            CommonService.msg("로그인 실패");
            return;
        }

        if(dbPw.equals(pw)) {
            dao.loginSuccess(id);
        }else {
            CommonService.msg("로그인 실패");
        }
    }

    @Override
    public String loginCheck(String id) {
        return dao.loginCheck(id);
    }
}
