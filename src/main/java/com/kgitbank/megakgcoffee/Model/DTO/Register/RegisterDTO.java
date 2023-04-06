package com.kgitbank.megakgcoffee.Model.DTO.Register;

import javafx.scene.control.DatePicker;

import java.util.Date;

public class RegisterDTO {
    private String reg_name;
    private String reg_id;
    private String reg_nick;
    private String reg_pwd;
    private String confirm;
    private String reg_tel;
    private String reg_birth;

    public RegisterDTO(){}

    public RegisterDTO(String reg_name, String reg_id, String reg_nick, String reg_pwd, String confirm, String reg_tel, String reg_birth){
        this.reg_name = reg_name;
        this.reg_id = reg_id;
        this.reg_nick = reg_nick;
        this.reg_pwd = reg_pwd;
        this.confirm = confirm;
        this.reg_tel = reg_tel;
        this.reg_birth = reg_birth;
    }

    public String getReg_name() {
        return reg_name;
    }

    public void setReg_name(String reg_name) {
        this.reg_name = reg_name;
    }

    public String getReg_id() {
        return reg_id;
    }

    public void setReg_id(String reg_id) {
        this.reg_id = reg_id;
    }

    public String getReg_nick() {
        return reg_nick;
    }

    public void setReg_nick(String reg_nick) {
        this.reg_nick = reg_nick;
    }

    public String getReg_pwd() {
        return reg_pwd;
    }

    public void setReg_pwd(String reg_pwd) {
        this.reg_pwd = reg_pwd;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getReg_tel() {
        return reg_tel;
    }

    public void setReg_tel(String reg_tel) {
        this.reg_tel = reg_tel;
    }

    public String getReg_birth() {
        return reg_birth;
    }

    public void setReg_birth(String reg_birth) {
        this.reg_birth = reg_birth;
    }
}
