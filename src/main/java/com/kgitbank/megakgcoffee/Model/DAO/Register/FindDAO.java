package com.kgitbank.megakgcoffee.Model.DAO.Register;

import com.kgitbank.megakgcoffee.Connection.ConnectionFactory;
import com.kgitbank.megakgcoffee.Connection.ConnectionMaker;
import com.kgitbank.megakgcoffee.Model.DTO.Register.RegisterDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindDAO {
    private ConnectionMaker connectionMaker = ConnectionFactory.getOracleInstance();
    Connection connection;

    {
        try {
            connection = connectionMaker.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public String findProc(RegisterDTO registerDTO) {

        String findSQL = "SELECT reg_pwd FROM tb_register where reg_id = ? and reg_name = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        String reg_pwd = null;
        try {
            ps= connection.prepareStatement(findSQL);
            ps.setString(1, registerDTO.getReg_id());
            ps.setString(2, registerDTO.getReg_name());
            rs = ps.executeQuery();
            if(rs.next()) {
                reg_pwd = rs.getString("reg_pwd");
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reg_pwd;
    }

}
