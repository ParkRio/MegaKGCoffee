package com.kgitbank.megakgcoffee.Model.DAO.Test;

import com.kgitbank.megakgcoffee.Connection.ConnectionFactory;
import com.kgitbank.megakgcoffee.Connection.ConnectionMaker;
import com.kgitbank.megakgcoffee.Model.DTO.Test.TestDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ITestDAO implements TestDAO{

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
    public void insert(TestDTO testDTO) {

        String insertSQL = "INSERT INTO test_tb_Coffee(test_seq, test_id, test_password)" +
                " VALUES (test_Coffee_seq.NEXTVAL,?,?)";

        try {
            PreparedStatement ps = connection.prepareStatement(insertSQL);
            ps.setString(1, testDTO.getTest_id());
            ps.setString(2, testDTO.getTest_password());
            ps.executeQuery();

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
