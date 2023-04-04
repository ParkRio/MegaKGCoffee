package com.kgitbank.megakgcoffee.Model.DAO.Register;

import com.kgitbank.megakgcoffee.Connection.ConnectionFactory;
import com.kgitbank.megakgcoffee.Connection.ConnectionMaker;
import com.kgitbank.megakgcoffee.Model.DTO.HomeView.HomeViewDTO;
import com.kgitbank.megakgcoffee.Model.DTO.Register.RegisterDTO;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RegisterDAO {
    private ConnectionMaker connectionMaker = ConnectionFactory.getOracleInstance();
    Connection connection;

    {
        try {
            connection = connectionMaker.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void regProc(RegisterDTO reg) {

        LocalDate myDate = LocalDate.parse(reg.getReg_birth());
        Date birthday = Date.valueOf(myDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        
        // todo :: 회원테이블에서 생성일은 지울것

        PreparedStatement ps = null;
        String sql = "INSERT INTO tb_register(reg_seq, reg_name, reg_id, reg_nick, reg_pwd, reg_tel, reg_birth, reg_date) VALUES(register_seq.NEXTVAL,?,?,?,?,?,?,?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, reg.getReg_name());
            ps.setString(2, reg.getReg_id());
            ps.setString(3, reg.getReg_nick());
            ps.setString(4, reg.getReg_pwd());
            ps.setString(5, reg.getReg_tel());
            ps.setDate(6, birthday);
            ps.setDate(7, getCurrentDate());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String Nickname(RegisterDTO registerDTO) {

        String NicknameSQL = "SELECT reg_nick FROM tb_register where reg_id = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        String reg_nick = null;
        try {
            ps= connection.prepareStatement(NicknameSQL);
//            System.out.println("쿼리문 : "+registerDTO.getReg_nick());
            ps.setString(1, registerDTO.getReg_id());
            rs = ps.executeQuery();
            if(rs.next()) {
                reg_nick = rs.getString("reg_nick");
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reg_nick;
    }

    public boolean sameIdExist(String id) {

        String sameIdExistSQL = "SELECT * FROM tb_register WHERE reg_id = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sameIdExistSQL);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    private java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

}
