package com.kgitbank.megakgcoffee.Model.DAO.Member;

import com.kgitbank.megakgcoffee.Connection.ConnectionFactory;
import com.kgitbank.megakgcoffee.Connection.ConnectionMaker;
import com.kgitbank.megakgcoffee.Model.DTO.OrderCheck.OrderCheckDTO;
import com.kgitbank.megakgcoffee.Model.DTO.Register.RegisterDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

    private ConnectionMaker connectionMaker = ConnectionFactory.getOracleInstance();
    Connection connection;

    {
        try {
            connection = connectionMaker.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void MemberInfo(RegisterDTO registerDTO) {

        String memberInfoCheckSQL = "SELECT reg_nick, reg_birth, reg_tel FROM tb_register" +
                " WHERE reg_id = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = connection.prepareStatement(memberInfoCheckSQL);
            ps.setString(1, registerDTO.getReg_id());
            rs = ps.executeQuery();
            if (rs.next()){
                return;
            }
            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
