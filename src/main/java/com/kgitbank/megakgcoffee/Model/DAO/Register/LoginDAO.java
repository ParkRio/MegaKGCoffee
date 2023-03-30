package com.kgitbank.megakgcoffee.Model.DAO.Register;

public interface LoginDAO {
    String loginProc(String reg_id);
    void loginSuccess(String reg_id);
    String loginCheck(String reg_id);
}
