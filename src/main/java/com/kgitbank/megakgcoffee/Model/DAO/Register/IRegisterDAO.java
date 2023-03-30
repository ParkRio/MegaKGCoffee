package com.kgitbank.megakgcoffee.Model.DAO.Register;

import com.kgitbank.megakgcoffee.Connection.ConnectionFactory;
import com.kgitbank.megakgcoffee.Connection.ConnectionMaker;
import com.kgitbank.megakgcoffee.Model.DTO.Register.RegisterDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class IRegisterDAO implements RegisterDAO {
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
    public void regProc(RegisterDTO registerDTO) {
        PreparedStatement ps = null;
        String sql = "INSERT INTO tb_register VALUES(?,?,?,?,?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, registerDTO.getReg_id());
            ps.setString(2, registerDTO.getReg_nick());
            ps.setString(3, registerDTO.getReg_pwd());
            ps.setString(4, registerDTO.getReg_tel());
            ps.setString(5, registerDTO.getReg_birth());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
