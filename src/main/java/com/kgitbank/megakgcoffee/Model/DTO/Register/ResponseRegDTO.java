package com.kgitbank.megakgcoffee.Model.DTO.Register;

public class ResponseRegDTO {

    private int reg_seq;
    private String reg_name;
    private String reg_nick;
    private String reg_id;
    private String reg_date;
    private String reg_tel;

    public ResponseRegDTO(){}

    public ResponseRegDTO(int reg_seq, String reg_name, String reg_nick, String reg_id, String reg_date,String reg_tel){
        this.reg_seq = reg_seq;
        this.reg_nick = reg_nick;
        this.reg_name = reg_name;
        this.reg_id = reg_id;
        this.reg_date = reg_date;
        this.reg_tel = reg_tel;

    }

    public String getReg_date() { return reg_date; }

    public String getReg_tel() { return reg_tel; }

    public int getReg_seq() {
        return reg_seq;
    }

    public String getReg_name() {
        return reg_name;
    }

    public String getReg_nick() {
        return reg_nick;
    }

    public String getReg_id() {
        return reg_id;
    }
}
