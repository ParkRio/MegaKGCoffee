package com.kgitbank.megakgcoffee.Model.DAO.Register;

import com.kgitbank.megakgcoffee.Connection.ConnectionFactory;
import com.kgitbank.megakgcoffee.Connection.ConnectionMaker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ILoginDAO implements LoginDAO {
    private ConnectionMaker connectionMaker = ConnectionFactory.getOracleInstance();

    Connection connection;

    {
        try {
            connection = connectionMaker.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
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

    @Override
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

    @Override
    public String loginCheck(String reg_id) {
        String sql = "SELECT reg_login FROM tb_register WHERE reg_id=?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        String regLogin = null;
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, reg_id);
            rs = ps.executeQuery();
            if(rs.next()) {
                regLogin = rs.getString("reg_login");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regLogin;
    }
}
