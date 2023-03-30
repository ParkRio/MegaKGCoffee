package com.kgitbank.megakgcoffee.Service.Register;

public interface LoginService {
    void loginProc(String id, String pw);
    String loginCheck(String id);
}
