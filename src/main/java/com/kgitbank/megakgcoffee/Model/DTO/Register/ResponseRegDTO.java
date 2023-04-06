package com.kgitbank.megakgcoffee.Model.DTO.Register;

public class ResponseRegDTO {

    private int reg_seq;
    private String reg_name;
    private String reg_nick;
    private String reg_id;

    public ResponseRegDTO(){}

    public ResponseRegDTO(int reg_seq, String reg_name, String reg_nick, String reg_id){
        this.reg_seq = reg_seq;
        this.reg_name = reg_name;
        this.reg_nick = reg_nick;
        this.reg_id = reg_id;
    }

    public ResponseRegDTO(String reg_id) {
        this.reg_id = reg_id;
    }

    public static ResponseRegDTO FindId(String reg_id) {
        return new ResponseRegDTO(reg_id);
    }


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
