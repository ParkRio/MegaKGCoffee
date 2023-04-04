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








}
