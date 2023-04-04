package com.kgitbank.megakgcoffee.Model.DAO.Register;

import com.kgitbank.megakgcoffee.Connection.ConnectionFactory;
import com.kgitbank.megakgcoffee.Connection.ConnectionMaker;
import com.kgitbank.megakgcoffee.Model.DTO.Register.ResponseRegDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
    private ConnectionMaker connectionMaker = ConnectionFactory.getOracleInstance();
    Connection connection;

    {
        try {
            connection = connectionMaker.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String loginProc(String reg_id) {
        String sql = "SELECT reg_pwd FROM tb_register WHERE reg_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        String reg_pwd = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, reg_id);
            rs = ps.executeQuery();
            if(rs.next()) {
                reg_pwd = rs.getString("reg_pwd");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reg_pwd;
    }

    public void loginSuccess(String reg_id) {
        String sql = "UPDATE tb_register SET reg_login='Y' WHERE reg_id=?";
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, reg_id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String loginCheck(String id) {
        String sql = "SELECT reg_login FROM tb_register WHERE reg_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        String regLogin = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                regLogin = rs.getString("reg_login");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regLogin;
    }

    public ResponseRegDTO registerInfo(String id, String pw) {

        ResponseRegDTO responseRegDTO = null;

        String registerInfoSQL = "SELECT reg_seq, reg_name, reg_id, reg_nick, reg_date, reg_tel FROM tb_register"
                + " WHERE reg_id = ? AND reg_pwd = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(registerInfoSQL);
            ps.setString(1, id);
            ps.setString(2, pw);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                 responseRegDTO = new ResponseRegDTO(
                        rs.getInt("reg_seq"),
                        rs.getString("reg_name"),
                         rs.getString("reg_id"),
                        rs.getString("reg_nick"),
                         rs.getString("reg_date"),
                         rs.getString("reg_tel")
                );
            }
            rs.close();
            ps.close();
            return responseRegDTO;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}

