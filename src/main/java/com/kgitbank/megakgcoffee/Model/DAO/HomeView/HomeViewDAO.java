package com.kgitbank.megakgcoffee.Model.DAO.HomeView;

import com.kgitbank.megakgcoffee.Connection.ConnectionFactory;
import com.kgitbank.megakgcoffee.Connection.ConnectionMaker;
import com.kgitbank.megakgcoffee.Model.DTO.HomeView.HomeViewDTO;
import com.kgitbank.megakgcoffee.Model.DTO.Test.TestDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HomeViewDAO {

//데이터베이스 송신

    private ConnectionMaker connectionMaker = ConnectionFactory.getOracleInstance();
    Connection connection;

    {
        try {
            connection = connectionMaker.getConnection();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }






//    public void insert(HomeViewDTO homeViewDTO) {
//
//        String insertSQL = "INSERT INTO test_tb_Coffee(test_seq, test_id, test_password)" +
//                " VALUES (test_Coffee_seq.NEXTVAL,?,?)";
//        try {
//            PreparedStatement ps = connection.prepareStatement(insertSQL);
//            ps.setString(1, homeViewDTO.g);
//            ps.setString(2, homeViewDTO.getTest_password());
//            ps.executeQuery();
//            ps.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
