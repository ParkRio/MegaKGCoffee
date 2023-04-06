package com.kgitbank.megakgcoffee.Model.DAO.Find;

import com.kgitbank.megakgcoffee.Connection.ConnectionFactory;
import com.kgitbank.megakgcoffee.Connection.ConnectionMaker;
import com.kgitbank.megakgcoffee.Model.DTO.Register.ResponseRegDTO;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class IFindDAO implements FindDAO{

    private ConnectionMaker connectionMaker = ConnectionFactory.getOracleInstance();

    Connection connection;

    {
        try {
            connection = connectionMaker.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResponseRegDTO findId(String name, String phone) {
        String findIdSQL = "SELECT reg_id, reg_admin FROM tb_register" +
                " WHERE reg_name = ? AND reg_tel = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(findIdSQL);
            ps.setString(1, name);
            ps.setString(2, phone);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                if (rs.getString("reg_admin").equals("N"))  {
                    return ResponseRegDTO.FindId(rs.getString("reg_id"));
                } else {
                    return ResponseRegDTO.FindId("직원은 관리팀으로 문의해주세요");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // todo :: return 반환 말고 다른 걸로 반환되게 추후 수정

    }

    @Override
    public String findPwd(String id, String Phone, String BirthDay) {

        LocalDate myDate = LocalDate.parse(BirthDay);
        Date birthday = Date.valueOf(myDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

        String findPwdSQL = "SELECT reg_pwd, reg_admin FROM tb_register" +
                " WHERE reg_id = ? AND reg_tel =? AND reg_birth =?";

        try {
            PreparedStatement ps = connection.prepareStatement(findPwdSQL);
            ps.setString(1, id);
            ps.setString(2, Phone);
            ps.setDate(3, birthday);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                if (rs.getString("reg_admin").equals("N")) {
                    return rs.getString("reg_pwd");
                } else {
                    return "직원은 관리팀으로 문의해주세요.";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
