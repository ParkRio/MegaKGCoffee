package com.kgitbank.megakgcoffee.Model.DAO.HomeView;

import com.kgitbank.megakgcoffee.Connection.ConnectionFactory;
import com.kgitbank.megakgcoffee.Connection.ConnectionMaker;
import com.kgitbank.megakgcoffee.Model.DTO.HomeView.HomeViewDTO;
import com.kgitbank.megakgcoffee.Model.DTO.Test.TestDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HomeViewDAO {

    private ConnectionMaker connectionMaker = ConnectionFactory.getOracleInstance();
    Connection connection;

    {
        try {
            connection = connectionMaker.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }






//    public String Nickname(HomeViewDTO homeViewDTO) {
//
//        String NicknameSQL = "SELECT test_id FROM test_tb_Coffee where test_id=?";
//        PreparedStatement ps = null;
//        ResultSet rs = null;
//        String nick = null;
//        try {
//            ps= connection.prepareStatement(NicknameSQL);
//            System.out.println("쿼리문"+homeViewDTO.getTestId());
//            ps.setString(1, homeViewDTO.getTestId());
//            rs = ps.executeQuery();
//            if(rs.next()) {
//                nick = rs.getString("nick");
//            }
//            ps.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return nick;
//    }
}
