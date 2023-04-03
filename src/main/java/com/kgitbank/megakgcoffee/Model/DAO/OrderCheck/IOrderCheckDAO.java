package com.kgitbank.megakgcoffee.Model.DAO.OrderCheck;

import com.kgitbank.megakgcoffee.Connection.ConnectionFactory;
import com.kgitbank.megakgcoffee.Connection.ConnectionMaker;
import com.kgitbank.megakgcoffee.Model.DTO.OrderCheck.OrderCheckDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IOrderCheckDAO implements OrderCheckDAO{

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
    public void createOrderCheck(OrderCheckDTO orderCheckDTO) {

        String createOrderCheckSQL = "INSERT INTO tb_orderCheck(check_seq, checkItem_seq, checkReg_seq, checkOrder)" +
                " VALUES(orderCheck_seq.NEXTVAL, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(createOrderCheckSQL);
            ps.setInt(1, orderCheckDTO.getCheckItem_seq());
            ps.setInt(2, orderCheckDTO.getCheckReg_seq());
            ps.setInt(3, orderCheckDTO.getCheckOrder());
            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int howManyInTheCart(OrderCheckDTO orderCheckDTO) {

        String howManyInTheCartSQL = "SELECT COUNT(*) cnt FROM tb_orderCheck" +
                " WHERE checkReg_seq = ? AND checkOrder = 0";

        try {
            PreparedStatement ps = connection.prepareStatement(howManyInTheCartSQL);
            ps.setInt(1, orderCheckDTO.getCheckReg_seq());
            ResultSet rs= ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("cnt");
            }
            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void deleteOrderCheck(int check_seq) {

        String deleteOrderCheckSQL = "UPDATE tb_orderCheck SET checkOrder = 3" +
                " WHERE check_seq = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(deleteOrderCheckSQL);
            ps.setInt(1, check_seq);
            ps.executeUpdate();

            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
