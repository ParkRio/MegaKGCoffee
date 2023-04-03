package com.kgitbank.megakgcoffee.Model.DAO.Register;

import com.kgitbank.megakgcoffee.Connection.ConnectionFactory;
import com.kgitbank.megakgcoffee.Connection.ConnectionMaker;
import com.kgitbank.megakgcoffee.Model.DTO.HomeView.HomeViewDTO;
import com.kgitbank.megakgcoffee.Model.DTO.Register.RegisterDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        PreparedStatement ps = null;
        String sql = "INSERT INTO tb_register(reg_seq, reg_name, reg_id, reg_nick, reg_pwd, reg_tel, reg_birth) VALUES(register_seq.NEXTVAL,?,?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, reg.getReg_name());
            ps.setString(2, reg.getReg_id());
            ps.setString(3, reg.getReg_nick());
            ps.setString(4, reg.getReg_pwd());
            ps.setString(5, reg.getReg_tel());
            ps.setString(6, reg.getReg_birth());
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


}
