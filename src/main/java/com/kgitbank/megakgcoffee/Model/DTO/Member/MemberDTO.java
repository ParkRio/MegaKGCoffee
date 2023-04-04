package com.kgitbank.megakgcoffee.Model.DTO.Member;

public class MemberDTO {

    /*
    reg_seq NUMBER -- 회원 식별번호
    reg_name VARCHAR2(20) -- 이름
    reg_id VARCHAR2(20) -- 아이디 (중복안됨)
    reg_nick VARCHAR2(20)  -- 닉네임
    reg_pwd VARCHAR2(20) -- 비밀번호
    reg_tel VARCHAR2(20) -- 전화번호
    reg_birth VARCHAR2(20) -- 생년월일
    */

    private int reg_seq;
    private String reg_name;
    private String reg_id;
    private String reg_nick;
    private String reg_pwd;
    private String reg_tel;
    private String reg_birth;

    public MemberDTO(){}

    public MemberDTO(int reg_seq, String reg_name, String reg_nick, String reg_id,String reg_pwd,String reg_tel,String reg_birth){
        this.reg_seq = reg_seq;
        this.reg_nick = reg_nick;
        this.reg_name = reg_name;
        this.reg_id = reg_id;
        this.reg_pwd = reg_pwd;
        this.reg_tel = reg_tel;
        this.reg_birth = reg_birth;
    }


    public int getReg_seq() {
        return reg_seq;
    }

    public void setReg_seq(int reg_seq) {
        this.reg_seq = reg_seq;
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
